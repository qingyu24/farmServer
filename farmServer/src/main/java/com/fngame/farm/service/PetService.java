package com.fngame.farm.service;

import com.fngame.farm.configer.Pets;
import com.fngame.farm.configer.skill;
import com.fngame.farm.etypes.EPetGetType;
import com.fngame.farm.etypes.EPetSkillType;
import com.fngame.farm.etypes.EPetStatueType;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.Building;
import com.fngame.farm.model.CraftProduce;
import com.fngame.farm.model.PetData;
import com.fngame.farm.model.User;
import com.fngame.farm.service.baseService.BaseServiceImpl;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import com.fngame.farm.util.BeanTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * The type Pet service.
 */
@Service
@Transactional
public class PetService implements BaseServiceImpl<PetData> {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * The Player manager.
     */
    @Autowired
    PlayerManager playerManager;
    /**
     * The Config manager.
     */
    @Resource
    ConfigManager configManager;

    @Override
    public Boolean add(ResultInfo resultInfo, PetData PetData) {
        Integer gettype = PetData.getGettype();
        PlayerInfo player = playerManager.getPlayer(PetData.getUserid());
        List<PetData> pets = player.getPets();
        if (pets.size() >= 30) {
            resultInfo.setResp_code("111002");
            return false;
        }
        for (PetData pet : pets) {
            Integer gettype1 = pet.getGettype();
            if (gettype == EPetGetType.GIFT.ID() && gettype1 == EPetGetType.GIFT.ID()) {
                resultInfo.setResp_code("111001");
                return false;
            }
            if (pet.getBaseid().intValue() == PetData.getBaseid().intValue()) {
                resultInfo.setResp_code("110015");
                return false;
            }
        }

        if (gettype == EPetGetType.GOLD.ID()) {
            Integer money = player.getUser().getMoney();
            if (money >= PetData.getBaseid()) ;//判断金币是否足够
        } else if (gettype == EPetGetType.PROPS.ID()) {//判断道具是否足够 并减掉

        }
        PetData.setBegintime(new Date());
        player.addPet(PetData);
        return true;
    }

    @Override
    public Boolean modify(ResultInfo resultInfo, PetData PetData) {
        return null;
    }

    @Override
    public Boolean remove(ResultInfo resultInfo, PetData PetData) {

        return true;
    }

    @Override
    public Boolean get(ResultInfo resultInfo, PetData PetData) {
        PlayerInfo player = playerManager.getPlayer(PetData.getUserid());
        List<PetData> pets = player.getPets();
        for (com.fngame.farm.model.PetData pet : pets) {
            long lefttime = this.getLefttime(pet);
            pet.setLefttime(lefttime);
        }
        HashMap<String, Object> data = resultInfo.getData();
        data.put("pets", pets);
        return true;
    }

    private ArrayList<PetData> r_lists;

    private ArrayList<PetData> toResult(List<PetData> pets) {
        if (r_lists == null) r_lists = new ArrayList<>();
        r_lists.clear();

        for (PetData pet : pets) {
            r_lists.add((PetData) pet);

        }
        return r_lists;
    }


    /**
     * Activity boolean.
     *
     * @param resultInfo the result info
     * @param PetData    the pet data
     * @return the boolean
     */
    public boolean activity(ResultInfo resultInfo, PetData PetData) {
        PlayerInfo player = playerManager.getPlayer(PetData.getUserid());
        List<PetData> pets = player.getPets();
        PetData DBPetData = null;
        int i = 0;

        for (PetData pet : pets) {
            long lefttime = this.getLefttime(pet);
            pet.setLefttime(lefttime);
            Integer status = pet.getStatus();
            if (status != EPetStatueType.PACKSACK.ID() && status == EPetStatueType.HOUSE.ID()) {
                i++;
                if (i >= 6) {
                    resultInfo.setResp_code("111003");
                    return false;
                }
            }
            if (PetData.getId() == pet.getId()) {
                DBPetData = pet;
            }
        }

        if (DBPetData == null) {
            resultInfo.setResp_code("111004");
            return false;
        }
        if (PetData.getStatus() == EPetStatueType.HOUSE.ID()) {

        } else if (PetData.getStatus() == EPetStatueType.PACKSACK.ID()) {

        } else if (PetData.getStatus() == EPetStatueType.SKILING.ID()) {
            //判断宠物是否在院子
            if (DBPetData.getStatus() != EPetStatueType.HOUSE.ID()) {
                resultInfo.setResp_code("111010");
                return false;
            }
            Pets petsConfig = configManager.getPetsConfig(DBPetData.getBaseid());
            String[] skill1 = petsConfig.skill.split("|");
            boolean flag = false;
            for (String s : skill1) {
                if (s.equals(String.valueOf(PetData.getSkillid()))) {
                    flag = true;
                }
            }
            if (!flag) {
                resultInfo.setResp_code("110016");
                return false;
            }
            //判断该宠物是否有该技能


            //释放技能扣除金币
            skill skill = configManager.getSkill(PetData.getSkillid());
            String[] split = skill.Price.split("_");
            Integer price = Integer.parseInt(split[1]);
            User user = player.getUser();
            Integer money = user.getMoney();
            if (money < price) {
                resultInfo.setResp_code("111011");
                return false;
            }
            user.setMoney(money - price);
            player.updateUser(user);
            //开始释放技能
            boolean trick = true;
            //开始执行技能
            if (PetData.getSkillstatus() == EPetSkillType.TRICK.ID()) {
                trick = this.trick(resultInfo, DBPetData, PetData);
            } else if (PetData.getSkillstatus() == EPetSkillType.SEARCH.ID()) {
                trick = this.search(resultInfo, DBPetData, skill, PetData.getPropsid());
            } else if (PetData.getSkillstatus() == EPetSkillType.STEAL.ID()) {
                trick = this.steal(resultInfo, DBPetData, skill);
            } else {
                resultInfo.setfalse();
            }
            if (!trick) {
                return false;
            }
        }


        DBPetData.setStatus(PetData.getStatus());
        player.updatePet(PetData);
        ArrayList<com.fngame.farm.model.PetData> petData = new ArrayList<>();
        petData.add(DBPetData);
        resultInfo.getData().put("pets", petData);
        return true;
    }

    private boolean search(ResultInfo resultInfo, PetData PetData, skill skill, Integer propsid) {
        PetData.setPropscount(this.getRomdomSize(skill));
        PetData.setSkillid(skill.SkillID);
        PetData.setStatus(EPetStatueType.SKILING.ID());
        PetData.setStatus(EPetSkillType.SEARCH.ID());
        PetData.setBegintime(new Date());
        PetData.setPropsid(propsid);
        return true;

    }

    //#todo 捣乱
    private boolean trick(ResultInfo resultInfo, PetData DB_PetData, PetData petData) {
        PlayerInfo player = playerManager.getPlayer(petData.getTargetid());
        if (player == null) {
            resultInfo.setResp_code("000005");
            return false;
        }
        Building building = new Building();
        building.setBaseid(899);
        building.setBeginTime(new Date());
        building.setXpos(-1);
        building.setYpos(-1);
        building.setDir(0);
        building.setUserid(player.getId());
        player.addBuilding(building);
        return true;

    }

    private int getRomdomSize(skill skill) {
        String[] split = skill.Range.split("_");
        int min = Integer.parseInt(split[0]);
        int max = Integer.parseInt(split[1]);
        int v = (int) Math.random() * (max - min + 1) + min;
        return v;
    }

    private boolean steal(ResultInfo resultInfo, PetData PetData, skill skill) {
        PlayerInfo player = playerManager.getPlayer(PetData.getUserid());
        PlayerInfo tarplayer = playerManager.getPlayer(PetData.getTargetid());
        //todo 获取成熟的列表
        List<CraftProduce> craftProduces = tarplayer.getCraftProduces();
        String[] split = skill.Range.split("_");
        int min = Integer.parseInt(split[0]);
        int max = Integer.parseInt(split[1]);

        for (CraftProduce craftProduce : craftProduces) {
            Integer size = craftProduce.getSize();

            if (size > min) {
                max = Math.min(max, size);
                int count = (int) (Math.random() * (max - min) + min);
                craftProduce.setSize(size - count);
                PetData.setPropsid(craftProduce.getProductbaseid());
                PetData.setPropscount(count);
                player.updatePet(PetData);
                tarplayer.updateCraft(craftProduce);
            }
        }
        resultInfo.setResp_code("110012");
        return false;
    }


    /**
     * Gets lefttime.所有作物的倒计时
     *
     * @param petData the pet data
     * @return the lefttime
     */
    public long getLefttime(PetData petData) {
        long lefttime = 0;
        long skillCD = 0;
        long waitCD = 0;
        if (petData.getSkillstatus() != 0) {
            com.fngame.farm.configer.skill skill = ConfigManager.getInstance().getSkill(petData.getSkillid());
            if (skill != null) {
                skillCD = skill.CostTime * 1000;
            }
        }
        Pets petsConfig = ConfigManager.getInstance().getPetsConfig(petData.getBaseid());
        if (petsConfig != null) waitCD = petsConfig.PublicCD * 1000;

        long time = petData.getBegintime().getTime() + skillCD - System.currentTimeMillis();
        if (time > 0) {
            if (petData.getSkillstatus() != 0 && petData.getStatus() == EPetStatueType.SKILING.ID()) return time;
            else {

                logger.error("返回时间是出现未知错误");
                return time;
            }
        } else {
            //如果时间到了而且没有换状态
            if (petData.getStatus() == EPetStatueType.SKILING.ID()) {
                petData.setStatus(EPetStatueType.STATUSCD.ID());
                this.update(petData);
            }
            lefttime = petData.getBegintime().getTime() + skillCD + waitCD - System.currentTimeMillis();
            lefttime = Math.max(lefttime, 0);
            if (lefttime == 0 && petData.getStatus() == EPetStatueType.STATUSCD.ID()) {
                petData.setStatus(EPetStatueType.HOUSE.ID());
                this.update(petData);
            }
        }
        return lefttime;
    }

    /**
     * Update.
     *
     * @param petData the pet data
     */
    public void update(PetData petData) {
        PlayerManager manager = (PlayerManager) BeanTools.getBean(PlayerManager.class);
        PlayerInfo player = manager.getPlayer(petData.getUserid());
        player.updatePet(petData);
    }


    /**
     * Petharvest boolean.
     * 玩家点击确认 返回收获产物
     *
     * @param resultInfo the result info
     * @param petData    the pet data
     * @return the boolean
     */
    public boolean petharvest(ResultInfo resultInfo, PetData petData) {
        PlayerInfo player = playerManager.getPlayer(petData.getUserid());
        PetData pet = player.getPet(petData.getId());
        this.getLefttime(pet);
        if (pet.getStatus() == EPetStatueType.SKILING.ID() || pet.getStatus() == EPetStatueType.PACKSACK.ID()) {
            resultInfo.setResp_code("111005");
            return false;
        }
    /*    if (pet.getLefttime() != 0) {
            resultInfo.setResp_code("111006");
            return false;
        }*/
        petData.setPropsid(pet.getPropsid());
        petData.setPropscount(pet.getPropscount());
        if (pet.getPropsid() != 0) {
            player.addProp(pet.getPropsid(), pet.getPropscount());
            pet.setPropscount(0);
            pet.setPropsid(0);
            player.updatePet(pet);
        }

        ArrayList<PetData> pets = new ArrayList<>(1);
        boolean add = pets.add(petData);
        HashMap<String, Object> data = resultInfo.getData();
  /*      Integer skillstatus = pet.getSkillstatus();
        //todo 添加不同技能的收获产物
        if (skillstatus == EPetSkillType.SEARCH.ID()) {
            data.put("pets", pets);
        } else if (skillstatus == EPetSkillType.STEAL.ID()) {
            data.put("pets", pets);
        } else if (skillstatus == EPetSkillType.TRICK.ID()) {
            data.put("pets", pets);
        }
*/
        data.put("pets", pets);
        return true;
    }


    public boolean clean(ResultInfo resultInfo, Long userid, Long rubbishid, Long targetid) {
        PlayerInfo player = playerManager.getPlayer(targetid);
        Building oneBuilding = player.getOneBuilding(rubbishid);
        if (oneBuilding == null) {
            resultInfo.setResp_code("110013");
            return false;
        }
        if (oneBuilding.getOwnerid() == userid) {
            resultInfo.setResp_code("100014");
            return false;
        }
        player.removeBuilding(oneBuilding);
        //todo 增加友情点
        HashMap<String, Object> data = resultInfo.getData();
        ArrayList<Building> buildings = new ArrayList<>(1);
        buildings.add(oneBuilding);
        data.put("buildings", buildings);
        return true;
    }

    public boolean getOnePet(ResultInfo resultInfo, PetData petData) {
        PlayerInfo player = playerManager.getPlayer(petData.getUserid());
        PetData pet = player.getPet(petData.getId());
        if (pet == null) {
            resultInfo.setResp_code("110004");
            return false;
        }
        ArrayList<PetData> petData1 = new ArrayList<>(1);
        petData1.add(pet);
        resultInfo.getData().put("pets", petData1);
        return true;
    }
}
