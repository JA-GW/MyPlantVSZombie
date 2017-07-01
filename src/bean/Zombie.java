package bean;

import utils.GetImage;

import java.awt.*;
import java.util.List;

/**
 * Created by gw on 2017/6/21.
 */
public class Zombie {

    private int life;
    private int speed = 3;
    private int x;
    private int y;
    private int state;//1 前进  2 吃  3 死亡
    private int counter = 0;//僵尸死亡动画时间
    private int counterPlant = 0;//植物生命值简易时间

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
        life = 5;
        state = 1;

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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }



    private void walk(Graphics g){
        Image image = GetImage.getImage("僵尸/普通僵尸/Zombiep.gif");
        g.drawImage(image,x,y,null);

    }


    private void eat(Graphics g, Plant plant){

        Image image = GetImage.getImage("僵尸/普通僵尸/ZombieAttackp.gif");
        g.drawImage(image,x,y,null);
        counterPlant++;
        if(counterPlant>=800 && plant!=null){
            plant.setLife(plant.getLife()-1);
            counterPlant = 0;
        }
        if(plant != null &&plant.getLife() <= 0){
            //System.out.println("吃完了");
            state = 1;
        }


    }

    private void dead(Graphics g, List<Zombie> zombieList,Score score){
        Image image = GetImage.getImage("僵尸/普通僵尸/ZombieDiep.gif");
        g.drawImage(image,x-60,y+40,null);

        //Image image1 = GetImage.getImage("僵尸/普通僵尸/ZombieHead.gif");
        //g.drawImage(image,x+50,y,null);
        if(counter == 0){
            score.addDefen();
        }
        counter++;
        if(counter >=260){
            zombieList.remove(this);

        }

    }

    private void active(Graphics g, Plant[][] plants, java.util.List<Zombie> zombieList,Score score){

        if(life<= 0 || state ==3){
            state = 3;
            dead(g,zombieList,score);

            return;
        }

        //for(int i = 0;i < 5;i++){
        int i = y/100;
            boolean find = false;
            Plant plant = null;
            for(Plant p : plants[i]){
                if(isMeetPlant(p)){
                    this.state = 2;
                    plant = p;

                    find = true;
                    break;
                }
            }
            if(find){
                eat(g,plant);
                //System.out.println("eat====");

            }else{
                state = 1;
                walk(g);
                //System.out.println("walk++++");
            }
        //}

    }

    public void paint(Graphics g, Plant[][] plants, List<Zombie> zombieList,Score score){
        active(g,plants,zombieList,score);
    }

    public boolean isMeetPlant(Plant plant){
        if(plant != null && new Rectangle(x+34,y+85,40,100).intersects(plant.getX()+34,plant.getY()+85,80,100)&&plant.getY()/100 ==y/100){
            return true;
        }
        return false;
    }




}
