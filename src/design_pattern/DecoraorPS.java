package design_pattern;

import bean.Bullet;
import bean.Pea;
import bean.Plant;
import bean.Sun;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/23.
 */
public abstract class DecoraorPS extends Plant{

    protected Plant plant;

    public void setPlant(Plant plant){
        this.plant = plant;
    }
    public Plant getPlant(){return plant;}


    @Override
    public void paint(Graphics g, List<Bullet> peaList, List<Sun> sunList) {
        plant.paint(g,peaList,sunList);
    }

    public void paint(Graphics g, List<Bullet> peaList, List<Sun> sunList,List<DecoraorPS> decoraors) {
        paint(g,peaList,sunList);
    }


}
