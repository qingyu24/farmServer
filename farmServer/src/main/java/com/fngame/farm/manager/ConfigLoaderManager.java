package com.fngame.farm.manager;

import com.fngame.farm.configer.*;
import com.fngame.farm.model.Animal;
import com.fngame.farm.model.Building;
import com.fngame.farm.util.XlsReader;
import com.sun.tools.javac.jvm.Items;
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
    private ArrayList<Actor> Actorloader = new ArrayList<Actor>(20);
    private ArrayList<AddQueue> AddQueueloader = new ArrayList<AddQueue>(20);
    private ArrayList<Animal> Animalloader = new ArrayList<Animal>(20);

    private ArrayList<Car> Carloader = new ArrayList<Car>(20);
    private ArrayList<Craft> Craftloader = new ArrayList<Craft>(20);
    private ArrayList<Crafting> Craftingloader = new ArrayList<Crafting>(20);
    private ArrayList<Crop> Croploader = new ArrayList<Crop>(20);
    private ArrayList<Entity> Entityloader = new ArrayList<Entity>(20);
    private ArrayList<fruiter> fruiterloader = new ArrayList<fruiter>(20);
    private ArrayList<Item> Itemloader = new ArrayList<Item>(20);
    private ArrayList<Items> Itemsloader = new ArrayList<Items>(20);
    private ArrayList<Level> Levelloader = new ArrayList<Level>(20);
    private ArrayList<Obstacle> Obstacleloader = new ArrayList<Obstacle>(20);
    private ArrayList<Order> Orderloader = new ArrayList<Order>(20);
    private ArrayList<OrnamentScore> OrnamentScoreloader = new ArrayList<OrnamentScore>(20);
    private ArrayList<Pet> Petloader = new ArrayList<Pet>(20);
    private ArrayList<Storehouse> Storehouseloader = new ArrayList<Storehouse>(20);
    private ArrayList<Structure> Structureloader = new ArrayList<Structure>(20);
    private ArrayList<StructureUpgrade> StructureUpgradeloader = new ArrayList<StructureUpgrade>(20);
    private ArrayList<Tags> Tagsloader = new ArrayList<Tags>(20);
    private ArrayList<Test> Testloader = new ArrayList<Test>(20);
 private ArrayList<Resp> Resploader = new ArrayList<Resp>(20);


    public void loaderAll() {

        loades.clear();
        loades.put("Actor", Actorloader);
        loades.put("AddQueue", AddQueueloader);
        loades.put("Animal", Animalloader);

        loades.put("Car", Carloader);
        loades.put("Craft", Craftloader);
        loades.put("Crafting", Craftingloader);
        loades.put("Crop", Croploader);
        loades.put("Entity", Entityloader);
        loades.put("fruiter", fruiterloader);
        loades.put("Item", Itemloader);
        loades.put("Items", Itemsloader);
        loades.put("Level", Levelloader);
        loades.put("Obstacle", Obstacleloader);
        loades.put("Order", Orderloader);
        loades.put("OrnamentScore", OrnamentScoreloader);
        loades.put("Pet", Petloader);
        loades.put("Storehouse", Storehouseloader);
        loades.put("Structure", Structureloader);
        loades.put("StructureUpgrade", StructureUpgradeloader);
        loades.put("Tags", Tagsloader);
        loades.put("Test", Testloader);
        loades.put("Resp",Resploader);


        XlsReader.getInstance().loaderAll(loades);
    }

    public HashMap<String, ArrayList> getLoaders() {
        return loades;
    }

}
