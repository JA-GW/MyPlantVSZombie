package design_pattern;

import bean.*;
import utils.GetImage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/23.
 */
public class ProtectPlantDecorator extends DecoraorPS{


    public ProtectPlantDecorator(){
        life = 20;
    }

    @Override
    public void setPlant(Plant plant) {
        super.setPlant(plant);
        plant.setLife(plant.getLife()+20);
    }

    public void paint(Graphics g, java.util.List<Bullet> peaList, List<Sun> sunList, List<DecoraorPS> decoraors){
        addBehavior(g,decoraors);
        super.paint(g,peaList,sunList);

    }

    private void addBehavior(Graphics g,List<DecoraorPS> decoraors){
        //plant.setLife(plant.getLife() + 20);
        Image image = null;
        int beginLife;
        if(plant instanceof Nut)
            beginLife = 25;
        else
            beginLife = 5;
        if(plant.getLife() > beginLife+13)
            image = GetImage.getImage("植物/PumpkinHead/PumpkinHead.gif");
        else if(plant.getLife() > beginLife+5){
            image = GetImage.getImage("植物/PumpkinHead/pumpkin_damage1.gif");
        }else if(plant.getLife()>beginLife){
            image = GetImage.getImage("植物/PumpkinHead/Pumpkin_damage1.gif");
        }else{
            decoraors.remove(this);
        }
        if(image != null){
            g.drawImage(image,plant.getX()+20,plant.getY()+100,null);
        }


    }

}
