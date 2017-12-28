package com.fngame.farm.etypes;

/**
 * Created by zhuzhengqing on 2017/12/18.
 */
public enum EItemType {
    CROP,
    PROPS,
    ANIMALE;
    public int ID() {
        switch (this) {

            case CROP:
                return 1;
            case PROPS:
                return 2;
            case ANIMALE:
                return 3;

        }
        return 0;
    }
}
