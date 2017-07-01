package bean;

import utils.GetImage;

import java.awt.*;
import java.util.Random;

/**
 * Created by gw on 2017/6/21.
 */
public class Sun {

    private int x;
    private int y;
    private int maxY;
    private int state;
    private int counter = 0;//阳光持续时间
    private int origin = 0;// 0 随记生产  1 植物产生
    private int pos = 0;
    private int posStay = 0;

    public Sun(int x,int y){
        this.x = x+50;
        this.y = y;
        state = 1;

    }

    public Sun() {

        this.x = 80*new Random().nextInt(9);
        this.y = -80;
        this.maxY = 100*new Random().nextInt(5);
        state = 1;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void paint(Graphics g){
        if(state == 1){
            Image image = GetImage.getImage("阳光/Frame"+pos+".png");
            g.drawImage(image,x+34,y+85,null);
            posStay ++;
            if(posStay > 30){
                pos = (pos + 1)%21;
                posStay = 0;
            }

        }

    }

    public void down(){
        if(origin == 0 && y < maxY){
            y = y+5;
        }
        else{
            counter++;
            if(counter>=60){
                state = 2;
            }
        }
    }

    public boolean isClick(int cx,int cy){
        if(new Rectangle(x+34,y+85,80,80).contains(cx,cy)&&state!=2){
            //System.out.println("太阳被点击");
            return true;
        }
        return false;
    }

}
