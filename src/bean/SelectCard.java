package bean;

import utils.GetImage;

import java.awt.*;

/**
 * Created by gw on 2017/6/20.
 */
public class SelectCard {

    private int state;//是否被选中 0 没有 1 选中
    private int useable;//0可用 1 不可用
    private String plantName;
    private int position;//植物在带选区的位置
    private int consume;//使用的阳光

    public SelectCard(String plantName, int position) {
        this.plantName = plantName;
        this.position = position;
        useable = 0;
        state = 0;

        if(plantName.equals("射手")){
            consume = 100;
        }else if(plantName.equals("向日葵")){
            consume = 50;
        }else if(plantName.equals("坚果")){
            consume = 50;
        }else if(plantName.equals("南瓜")){
            consume = 125;
        }else if(plantName.equals("阳光蘑菇")){
            consume = 25;
        }else if(plantName.equals("火炬")){
            consume = 175;
        }

    }

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUseable() {
        return useable;
    }

    public void setUseable(int useable) {
        this.useable = useable;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * 绘制植物对应的图片
     * @param g
     */
    public void paint(Graphics g){
        Image image = GetImage.getImage("卡片/卡片图/"+plantName+useable+".png");
        g.drawImage(image,95+54*position,8,null);
    }


    /**
     * 判断点击的点是否在图片范围内
     * @param x
     * @param y
     * @return
     */
    public boolean isClick(int x,int y){
        if(new Rectangle(95+54*position,8,52,72).contains(x,y)){
            System.out.println("被选中");
            return true;
        }else {
            return false;
        }
    }

}
