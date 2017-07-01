package bean;

import utils.GetImage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/28.
 */
public class SunShroom extends Plant {

    private int energy=0;

    public SunShroom(int x, int y) {
        life = 5;
        this.x = x;
        this.y = y;
        action = 1;
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }



    /**
     * 摇摆
     * @param g
     */
    private void swing(Graphics g){
        Image image = GetImage.getImage("植物/SunShroom/SunShroom.gif");
        g.drawImage(image,34+x,85+y,null);
    }


    private void addEnergy(){
        energy++;
    }

    private void produce(java.util.List<Sun> sunList){

        addEnergy();
        if(energy >= 1000){
            Sun sun = new Sun(x,y);
            sun.setOrigin(1);
            sunList.add(sun);
            energy = 0;
        }

    }

    @Override
    public void paint(Graphics g, java.util.List<Bullet> peaList, java.util.List<Sun> sunList){

        swing(g);
        produce(sunList);

    }



}
