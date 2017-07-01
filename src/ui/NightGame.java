package ui;

import bean.*;
import design_pattern.*;
import utils.GetImage;
import utils.Song;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by gw on 2017/6/20.
 */
public class NightGame extends AbstractGame{





    public void init(AbstractPlantFactory abstractPlantFactory){

        commonInit();
        plantFactory = abstractPlantFactory;

        cards.add(new SelectCard("射手",0));
        cards.add(new SelectCard("阳光蘑菇",1));
        cards.add(new SelectCard("坚果",2));
        cards.add(new SelectCard("南瓜",3));
        cards.add(new SelectCard("火炬",4));

        threadOperation();

    }

    @Override
    protected void threadOperation() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {

                        Thread.sleep(70);
                        for (Sun sun : sunList) {
                            sun.down();
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        bulletMoveThread();


        zombieMoveThread();

        isCarMeetZombieThread();

        carMoveThread();
    }

    public void paint(Graphics g){
        Image image = GetImage.getImage("背景/background2.jpg");
        g.drawImage(image,-220,0,null);
        image = GetImage.getImage("卡片/卡片选择/植物选择区.png");
        g.drawImage(image,10,0,null);
        image = GetImage.getImage("卡片/卡片选择/ShovelBank.png");
        g.drawImage(image,460,0,null);
        image = GetImage.getImage("卡片/卡片选择/小铲子.png");
        g.drawImage(image,450,0,null);

        g.drawString(""+sunNumber,40,80);
        g.setColor(Color.WHITE);
        g.fillRect(600,0,150,50);
        //g.drawRect(600,0,100,50);
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体",0,30));
        g.drawString("得分："+score.getDefen(),600,30);

        for(SelectCard card : cards){
            if(sunNumber >= card.getConsume() && card.getState() == 0){
                card.setUseable(0);
            }else {
                card.setUseable(1);
            }
            card.paint(g);
        }

        for(Car car:carList){
            car.paint(g);

        }

        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 9;j++){
                if(plants[i][j] != null){
                    plants[i][j].paint(g,bulletList,sunList);
                }
            }
        }

        for(Zombie z : zombieList){

            z.paint(g,plants,zombieList,score);
        }

        for(Bullet pea:bulletList){
            pea.paint(g,zombieList,bulletList);
        }

        for(Sun sun : sunList){
            sun.paint(g);
        }

        for(DecoraorPS decoraorPS : decoraores){
            decoraorPS.paint(g,bulletList,sunList,decoraores);
        }



    }



}
