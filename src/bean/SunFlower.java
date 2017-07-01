package bean;

import utils.GetImage;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by gw on 2017/6/23.
 */
public class SunFlower extends Plant{

    //private int x;
    //private int y;
    //private int life;
    //private int action;//1 摇摆 2 生产 3 清除
    //private int imagePos;//
    private int energy=0;

    public SunFlower(int x, int y) {
        life = 5;
        this.x = x;
        this.y = y;
        //action = 1;
    }






    /**
     * 摇摆
     * @param g
     */
    private void swing(Graphics g){
        Image image = GetImage.getImage("植物/向日葵/SunFlower.gif");
        g.drawImage(image,34+x,85+y,null);
    }


    private void addEnergy(){
        energy++;
    }

    private void produce(java.util.List<Sun> sunList){
        //Image image = GetImage.getImage("植物/豆瓣/Peashooter/Frame3.png");
        //g.drawImage(image,34+x,85+y,null);
        addEnergy();
        if(energy >= 5000){
            Sun sun = new Sun(x,y);
            sun.setOrigin(1);
            sunList.add(sun);
            energy = 0;
        }

    }

    @Override
    public void paint(Graphics g, java.util.List<Bullet> peaList, java.util.List<Sun> sunList){
        //if(action == 1){
            swing(g);
            produce(sunList);
            //System.out.println("绘制植物");
        //}

//        if(action == 2){
//            //System.out.println("植物绘制攻击");
//            //attack(g,peaList);
//
//        }
    }




}
