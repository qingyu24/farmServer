package com.fngame.farm.etypes;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Created by zhuzhengqing on 2017/12/18.
        */
public enum  EPropType {
    CROPS,
    PROPS;
   public int ID(){
       switch (this){
           case PROPS:return 2;
           case CROPS:return 1;
       }
       return 0;
   }

}
