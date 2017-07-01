package bean;

import utils.GetImage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/23.
 */
public class Nut extends Plant {

    public Nut(int x,int y){
        this.x = x;
        this.y = y;
        life = 25;
    }




    @Override
    public void paint(Graphics g, List<Bullet> peaList, List<Sun> sunList) {
        Image image = null;
        if(life > 15){
            image = GetImage.getImage("植物/坚果/WallNut.gif");
        }else if(life >7){
            //System.out.println("坚果形态2");
            image = GetImage.getImage("植物/坚果/WallNut_cracked1.gif");
        }else{
            image = GetImage.getImage("植物/坚果/WallNut_cracked2.gif");
        }

        g.drawImage(image,x+34,y+85,null);
    }
}
