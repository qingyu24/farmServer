package com.fngame.farm.service;

import com.fngame.farm.etypes.EPetGetType;
import com.fngame.farm.etypes.EPetStatueType;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.PetData;
import com.fngame.farm.service.baseService.BaseServiceImpl;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * The type Pet service.
 */
@Service
public class PetService implements BaseServiceImpl<PetData> {


    @Autowired
    PlayerManager playerManager;


    @Override
    public Boolean add(ResultInfo resultInfo, PetData petData) {
        Integer gettype = petData.getGettype();
        PlayerInfo player = playerManager.getPlayer(petData.getUserid());
        List<PetData> pets = player.getPets();
        if (pets.size() >= 30) {
            resultInfo.setResp_code("100002");
        }
        if (gettype == EPetGetType.GIFT.ID()) {
            for (PetData pet : pets) {
                Integer gettype1 = pet.getGettype();
                if (gettype1 == EPetGetType.GIFT.ID()) {
                    resultInfo.setResp_code("100001");
                    return false;
                }
            }
        } else if (gettype == EPetGetType.GOLD.ID()) {
            Integer money = player.getUser().getMoney();
            if (money >= petData.getBaseid()) ;//判断金币是否足够
        } else if (gettype == EPetGetType.PROPS.ID()) {//判断道具是否足够 并减掉

        }
        petData.setBegintime(new Date());
        player.addPet(petData);
        return true;
    }

    @Override
    public Boolean modify(ResultInfo resultInfo, PetData petData) {
        return null;
    }

    @Override
    public Boolean remove(ResultInfo resultInfo, PetData petData) {
        return null;
    }

    @Override
    public Boolean get(ResultInfo resultInfo, PetData petData) {
        PlayerInfo player = playerManager.getPlayer(petData.getUserid());
        List<PetData> pets = player.getPets();
        HashMap<String, Object> data = resultInfo.getData();
        data.put("pets", pets);
        return true;
    }


    public boolean activity(ResultInfo resultInfo, PetData petData) {
        PlayerInfo player = playerManager.getPlayer(petData.getUserid());
        List<PetData> pets = player.getPets();
        PetData DBpetData = null;
        int i = 0;

        for (PetData pet : pets) {
            Integer status = pet.getStatus();
            if (status != EPetStatueType.PACKSACK.ID() && status == EPetStatueType.HOUSE.ID()) {
                i++;
            }
            if (petData.getId() == pet.getId()) {
                DBpetData = pet;
            }
            if (i >= 6) {
                resultInfo.setResp_code("100003");
                return false;
            }
        }
        if (DBpetData == null) {
            resultInfo.setResp_code("100004");
        }

        DBpetData.setStatus(petData.getStatus());
        player.updatePet(petData);
        return true;
    }

    private void find(ResultInfo resultInfo, PetData petData) {

    }


}
