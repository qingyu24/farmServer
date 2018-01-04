package com.fngame.farm.etypes;

/**
 * Created by qingyu on 2017/12/24 /11:22
 */
public enum EFriendType {
    APPLY,//发起请求
    AGREE,//同意
    WAIT,//待同意
    Nearby;//附近的人p


    public int ID() {
        switch (this) {

            case APPLY:
                return 0;
            case WAIT:
                return 1;
            case AGREE:
                return 2;
            case Nearby:
                return 3;
           /* case     */
        }
        return 0;
    }
}
