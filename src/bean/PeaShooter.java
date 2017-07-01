package bean;

import utils.GetImage;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/20.
 */
public class PeaShooter extends Shooter{

    //private int x;
    //private int y;
    //private int life;
    //private int action;//1 摇摆 2 攻击 3 清除
    private int imagePos;//


    public PeaShooter(int x, int y) {
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

    public void actionSwing(){
        action = 1;
    }

    /**
     * 摇摆
     * @param g
     */
    private void swing(Graphics g){
        Image image = GetImage.getImage("植物/豆瓣/Peashooter/Frame0.png");
        g.drawImage(image,34+x,85+y,null);
    }


    protected void addEnergy(){
        energy++;
    }

    public void attack(Graphics g,List<Bullet> peaList,int peaNumber){
        Image image = GetImage.getImage("植物/豆瓣/Peashooter.gif");
        g.drawImage(image,34+x,85+y,null);
        addEnergy();
        if(energy >= 1600){
            for(int i = 0;i < peaNumber;i++){
                Pea pea = new Pea(x+30+i*30,y);
                peaList.add(pea);
            }

            energy = 0;
        }

    }


    @Override
    public void paint(Graphics g, List<Bullet> peaList,List<Sun> sunList){
        if(action == 1){
            swing(g);
            //System.out.println("绘制植物");
        }

        if(action == 2){
            //System.out.println("植物绘制攻击");
            attack(g,peaList,1);

        }
    }

    public boolean isSeeZombie(java.util.List<Zombie> zombieList){
        for(Zombie z : zombieList){
            if(new Rectangle(x+80,y+50,720-x,30).intersects(z.getX(),z.getY(),80,100)){
                return true;
            }

        }
        return false;
    }

}
