package com.fngame.farm.manager;

import com.fngame.farm.configer.*;
import com.fngame.farm.util.XlsReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class ConfigLoaderManager {
    public static ConfigLoaderManager instance;

    public static ConfigLoaderManager getInstance() {
        if (instance == null) {
            instance = new ConfigLoaderManager();
        }
        return instance;
    }

    private HashMap<String, ArrayList> loades = new HashMap<>(20);
    private ArrayList<Cars> Carsloader = new ArrayList<Cars>(20);
    private ArrayList<Craft> Craftloader = new ArrayList<Craft>(20);
    private ArrayList<Entity> Entityloader = new ArrayList<Entity>(20);
    private ArrayList<Item> Itemloader = new ArrayList<Item>(20);
    private ArrayList<Order> Orderloader = new ArrayList<Order>(20);
    private ArrayList<Pets> Petsloader = new ArrayList<Pets>(20);
    private ArrayList<Resp> Resploader = new ArrayList<Resp>(20);
    private ArrayList<skill> skillloader = new ArrayList<skill>(20);
    private ArrayList<Tags> Tagsloader = new ArrayList<Tags>(20);
    private ArrayList<TagsDec> TagsDecloader = new ArrayList<TagsDec>(20);




    public void loaderAll() {

        loades.clear();
        loades.put("Cars",Carsloader);
        loades.put("Craft",Craftloader);
        loades.put("Entity",Entityloader);
        loades.put("Item",Itemloader);
        loades.put("Order",Orderloader);
        loades.put("Pets",Petsloader);
        loades.put("Resp",Resploader);
        loades.put("skill",skillloader);
        loades.put("Tags",Tagsloader);
        loades.put("TagsDec",TagsDecloader);



        XlsReader.getInstance().loaderAll(loades);
    }
  public HashMap<String,ArrayList> getLoaders() {
        return loades;
    }

}
