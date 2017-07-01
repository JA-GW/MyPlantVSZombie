package bean;

import utils.GetImage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/28.
 */
public class FireWood extends Plant {


    public FireWood(int x,int y) {
        this.x = x;
        this.y = y;
        life = 5;
    }

    public boolean isMeetPea(Bullet bullet){
        if(Math.abs(bullet.getX() - x-5) <= 5 && bullet.getY()/100 == y/100){
            return true;
        }
        return false;
    }

    @Override
    public void paint(Graphics g, List<Bullet> peaList, List<Sun> sunList) {
        Image image = GetImage.getImage("植物/TorchWood/TorchWood.gif");
        g.drawImage(image,x+34,y+85,null);
    }
}
