package bean;

import utils.GetImage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/22.
 */
public class Pea extends Bullet{


    public Pea(int x, int y) {
        this.x = x;
        this.y = y;
        state = 1;
    }

    public void paint(Graphics g, List<Zombie> zombieList,List<Bullet> peaList){
        boolean meet = false;
        Zombie meetZombie = null;
        for(Zombie zombie :zombieList){
            if(isMeetZombie(zombie)){
                meet = true;
                meetZombie = zombie;
                break;
            }
        }
        if(!meet){
            if(state == 3){
                image = GetImage.getImage("炮弹/PB10.gif");
            }else
                image = GetImage.getImage("炮弹/PB00.png");
            fly(g);
        }else{
            image = GetImage.getImage("炮弹/炮弹爆炸.png");
            bomb(g);
            destory(peaList,meetZombie);
        }
    }



}
