package bean;

import utils.GetImage;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by gw on 2017/6/23.
 */
public abstract class Plant {

    protected int x;
    protected int y;
    protected int life;
    protected int action;//1 摇摆 2 攻击 3 清除

    public Plant() {

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






    public abstract void paint(Graphics g, java.util.List<Bullet> peaList, java.util.List<Sun> sunList);

}
