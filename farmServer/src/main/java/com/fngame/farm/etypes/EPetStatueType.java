package com.fngame.farm.etypes;

/**宠物状态
 * The enum E pet statue type.
 */
public enum EPetStatueType {
    /**在背包 默认
     * Packsack e pet statue type.
     */
    PACKSACK,
    /**在家园
     * House e pet statue type.
     */
    HOUSE,
    /**
     * Props e pet statue type.使用技能中
     */
    SKILING,
    /**
     * Other e pet statue type.等待CD
     */
    STATUSCD;

    /**
     * Id int.
     *
     * @return the int
     */
    public int ID(){
        switch (this){
            case PACKSACK: return  0;
            case SKILING:return 2;
            case STATUSCD:return 3;
            case HOUSE:return 1;
        }

        return 0;
    }

}
