package design_pattern;

import bean.Bullet;
import bean.Pea;
import bean.Zombie;
import utils.GetImage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/28.
 */
public class FireDecorator extends DecoratorBullet {

    public void fire(Graphics g){
        Image image = GetImage.getImage("炮弹/PB10.gif");
        g.drawImage(image,x+34,y+80,null);
        bullet.setAggressivity(2);
    }



    @Override
    public void paint(Graphics g, List<Zombie> zombieList, List<Bullet> peaList) {
//        //super.paint(g, zombieList, peaList);
//        //fire();
//        Image image = GetImage.getImage("炮弹/PB10.gif");
//        bullet.setImage(image);
//        bullet.setAggressivity(2);
//        bullet.setX(x);
//        bullet.setY(y);
//
//        boolean meet = false;
//        Zombie meetZombie = null;
//        for(Zombie zombie :zombieList){
//            if(isMeetZombie(zombie)){
//                meet = true;
//                meetZombie = zombie;
//                break;
//            }
//        }
//        if(!meet){
//
//            bullet.setImage(GetImage.getImage("炮弹/PB10.gif"));//image = GetImage.getImage("炮弹/PB10.gif");
//
//            bullet.fly(g);
//        }else{
//            bullet.setImage(GetImage.getImage("炮弹/炮弹爆炸.png"));
//            bullet.bomb(g);
//            bullet.destory(peaList,meetZombie);
//            peaList.remove(this);
//        }
    }


}
