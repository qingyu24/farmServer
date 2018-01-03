package com.fngame.farm.etypes;

/**
 * Created by zhuzhengqing on 2017/12/18.
 */
public enum EPetGetType {
    /**
     * Gift e pet type.升级赠送
     */
    GIFT,
    /**
     * Gold e pet type.金币购买
     */
    GOLD,
    /**
     * Props e pet type.道具兑换
     */
    PROPS,
    /**
     * Other e pet type.其他
     */
    OTHER;

    /**
     * Id int.
     *
     * @return the int
     */
    public int ID(){
        switch (this){
            case GIFT: return  1;
            case GOLD:return 2;
            case PROPS:return 3;
            case OTHER:return 4;
        }

        return 0;
    }

}
