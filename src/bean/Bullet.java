package bean;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by gw on 2017/6/28.
 */
public abstract class Bullet {
    protected int x;
    protected int y;
    protected int state;
    protected int counter = 0;
    protected int aggressivity = 1;
    protected Image image;


    //public  abstract void fly(Graphics g, java.util.List<Zombie> zombieList, java.util.List<Bullet> peaList);

    public abstract void paint(Graphics g, java.util.List<Zombie> zombieList, java.util.List<Bullet> peaList);

    //public abstract void destory(java.util.List<Bullet> peaList, Zombie zombie);

    public void bomb(Graphics g){

        g.drawImage(image,x+34,y+80,null);

    }

    public void fly(Graphics g){

        g.drawImage(image,x+34,y+80,null);

    }

    public void destory(java.util.List<Bullet> peaList, Zombie zombie){
        counter++;
        if(counter >= 100){
            peaList.remove(this);
            zombie.setLife(zombie.getLife()-aggressivity);
        }

    }


    public boolean isMeetZombie(Zombie zombie){
        if(zombie.getY()/100 == y/100 && zombie.getX() - x <=50){
            return true;
        }
        return false;
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getAggressivity() {
        return aggressivity;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }
}
