package bean;

import utils.GetImage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/26.
 */
public class Car {

    private int x;
    private int y;
    private int state = 1; // 1 静止  2 开动
    public Car(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isMeetZombie(List<Zombie> zombieList){
        //boolean isMeet = false;
        for(Zombie zombie:zombieList){
            if(new Rectangle(x,y+81,71,50).intersects(zombie.getX(),zombie.getY()+81,80,100)&&y/100 == zombie.getY()/100){
                //isMeet = true;
                state = 2;
                zombie.setState(3);
                //return true;
            }

        }
        return false;

    }



    public void paint(Graphics g){

        Image image = GetImage.getImage("小车.png");
        g.drawImage(image,x+34,y+100,null);
    }
}
