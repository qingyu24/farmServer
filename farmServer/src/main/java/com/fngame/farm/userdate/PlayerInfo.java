package com.fngame.farm.userdate;

import com.fngame.farm.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qingyu on 2017/12/20.
 */
@Component
public class PlayerInfo {
    private long id;
    private User user;
    private List<Building> buildings;
    private List<Animal> animals;
    private List<Crops> crops;
    private List<UserOrder> orders;
    private List<Props> propss;


    public long getId() {

        if (user != null) {
            id = user.getUserid();
        } else id = 0;
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Props> getPropss() {
        return propss;
    }

    public void setPropss(List<Props> propss) {
        this.propss = propss;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Crops> getCrops() {
        return crops;
    }

    public void setCrops(List<Crops> crops) {
        this.crops = crops;
    }

    public List<UserOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrder> orders) {
        this.orders = orders;
    }
}
