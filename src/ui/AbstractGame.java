package ui;

import bean.*;
import design_pattern.*;
import utils.GetImage;
import utils.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by gw on 2017/6/28.
 */
public abstract class AbstractGame  {

    Score score;

    protected Song song;

    protected JPanel gamePanel;

    protected ArrayList<SelectCard> cards;
    protected CopyOnWriteArrayList<Zombie> zombieList;
    protected Plant[][] plants;
    protected CopyOnWriteArrayList<Bullet> bulletList;
    protected CopyOnWriteArrayList<Sun> sunList;
    protected CopyOnWriteArrayList<DecoraorPS> decoraores;

    protected CopyOnWriteArrayList<Car> carList;
    protected CopyOnWriteArrayList<FireWood> fireWoodList;

    protected int sunNumber = 100;
    protected boolean isDelete =false;

    protected AbstractPlantFactory plantFactory;

    //protected CopyOnWriteArrayList<DecoratorBullet> decorBulletList;


    public List<Zombie> getZombieList(){
        return zombieList;
    }

    public void setGamePanel(JPanel gamePanel){
        this.gamePanel = gamePanel;
    }

    //公共数据初始化
    public void commonInit(){
        score = new Score();
        song = new Song("声音/Faster.wav");
        decoraores = new CopyOnWriteArrayList<>();
        zombieList = new CopyOnWriteArrayList<>();
        plants = new Plant[5][9];
        cards = new ArrayList<>();
        bulletList = new CopyOnWriteArrayList<>();
        sunList = new CopyOnWriteArrayList<>();
        carList = new CopyOnWriteArrayList<>();
        fireWoodList = new CopyOnWriteArrayList<>();

        carList.add(new Car(-50,0));
        carList.add(new Car(-50,100));
        carList.add(new Car(-50,200));
        carList.add(new Car(-50,300));
        carList.add(new Car(-50,400));
    }

    public abstract void init(AbstractPlantFactory abstractPlantFactory);

    //线程操作，在这里调用子线程
    protected abstract void threadOperation();

    public abstract void paint(Graphics g);

    public  void mouseClick(int x,int y){
        for(Sun sun:sunList){
            if(sun.isClick(x,y)){
                isDelete = false;
                defaultCursor();
                sun.setState(2);
                sunNumber+=50;
                //sun.setState(2);
                sunList.remove(sun);
                return;
            }
        }

        if(isDelete == true){
            defaultCursor();
            int row = (y - 85)/100;
            int colum = (x - 34)/80;
            for(DecoraorPS decoraorPS:decoraores){
                if(plants[row][colum].equals(decoraorPS.getPlant())){
                    decoraores.remove(decoraorPS);
                }
            }
            if(plants[row][colum] != null){
                if(fireWoodList.contains(plants[row][colum])){
                    fireWoodList.remove(plants[row][colum]);
                }
                plants[row][colum] = null;
                isDelete = false;
                return;
            }

        }

        if(new Rectangle(460,0,80,80).contains(x,y)){
            isDelete = true;
            setCursor("卡片/卡片选择/小铲子.png");

            return;
        }

        for(SelectCard card : cards){
            if(card.getState() == 1){
                defaultCursor();//鼠标复原
                isDelete = false;
                System.out.println("种植植物");
                int row = (y - 85)/100;
                int colum = (x - 34)/80;
                if(row >= 5 ||colum >= 9){
                    break;
                }
                addPlant(card, colum, row);
                return;

            }

            if(card.isClick(x,y)  &&card.getUseable()==0){
                isDelete = false;
                defaultCursor();
                for(SelectCard c : cards){
                    if(!c.equals(card)){
                        c.setState(0);
                    }
                }
                System.out.println("选中植物");
                selectPlant(card);
                return;
            }
        }

    }


    //卡片选择,用于卡片被点击后
    protected void selectPlant(SelectCard card) {
        card.setUseable(1);
        card.setState(1);
        String imagePath = "";
        if(card.getPlantName().equals("射手")){
            imagePath = "植物/豆瓣/Peashooter/Frame0.png";
        }else if(card.getPlantName().equals("向日葵")){
            imagePath = "植物/向日葵/SunFlower/Frame2.png";
        }else if(card.getPlantName().equals("坚果")){
            imagePath = "植物/坚果/WallNut/Frame0.png";
        }else if(card.getPlantName().equals("南瓜")){
            imagePath = "植物/PumpkinHead/Pumpkin_front.png";
        }else if(card.getPlantName().equals("火炬")){
            imagePath = "植物/Torchwood/Torchwood.png";
        }else if(card.getPlantName().equals("阳光蘑菇")){
            imagePath = "植物/SunShroom/SunShroom.png";
        }
        setCursor(imagePath);
    }

    //鼠标形状
    protected void setCursor(String imagePath){
        Image image = GetImage.getImage(imagePath);
        gamePanel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image,new Point(0,0),""));
    }
    protected void defaultCursor(){
        gamePanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }


    //    public abstract void createZomb(AbstractZombieFactory zombieFactory);
//
//    public abstract void createSun();
    public void createZomb(AbstractZombieFactory zombieFactory){
        int  x = 800;
        int  y = 100*new Random().nextInt(5)+40;
        Zombie zombie = zombieFactory.createWalkZombie(x,y);
        zombieList.add(zombie);
    }

    public void createSun(){
        Sun sun = new Sun();
        sunList.add(sun);
    }


    //种植植物
    protected void addPlant(SelectCard card, int colum, int row) {
        if(plants[row][colum] != null && card.getPlantName().equals("南瓜")){
            sunNumber -= 125;
            ProtectPlantDecorator decorator = new ProtectPlantDecorator();
            decorator.setPlant(plants[row][colum]);
            decoraores.add(decorator);
            card.setUseable(0);

            card.setState(0);
            return;
        }
        if(plants[row][colum] != null){
            return;
        }
        Plant plant = null;
        if(card.getPlantName().equals("射手")){
            plant  = plantFactory.createShooter1(colum*80,row*100);
            sunNumber -= 100;
        }else if(card.getPlantName().equals("阳光蘑菇")){
            plant = plantFactory.createSunShroom(colum*80,row*100);
            System.out.println("产生蘑菇对象");
            sunNumber -= 25;
        }else if(card.getPlantName().equals("坚果")){
            plant = plantFactory.createNut(colum*80,row*100);
            sunNumber -= 50;
        }else if(card.getPlantName().equals("向日葵")){
            plant = plantFactory.createSunFlower(colum*80,row*100);
            sunNumber -= 50;
        }else if(card.getPlantName().equals("火炬")){
            plant = plantFactory.createFireWood(colum*80,row*100);
            fireWoodList.add((FireWood) plant);
            sunNumber -= 175;
        }

        plants[row][colum]  = plant;

        card.setUseable(0);

        card.setState(0);
        return;
    }

    //子弹移动线程
    public void bulletMoveThread(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(100);
                        for(Bullet pea:bulletList){
                            for(FireWood wood :fireWoodList){
                                if(wood.isMeetPea(pea)){
                                    pea.setState(3);
                                    pea.setAggressivity(2);
                                    break;
                                }
                            }
                            pea.setX(pea.getX()+10);

                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();
    }

    //僵尸移动线程以及植物判断是否攻击
    public void zombieMoveThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    for(int i = 0;i < 5;i++){
                        for(int j = 0;j < 9;j++){
                            if(plants[i][j] != null && plants[i][j].getLife()<=0){
                                plants[i][j] = null;
                            }
                            if(plants[i][j] != null && plants[i][j] instanceof PeaShooter && ((PeaShooter)plants[i][j]).isSeeZombie(zombieList)){
                                //System.out.println("攻击");
                                plants[i][j].setAction(2);
                            }else if(plants[i][j]!=null){
                                plants[i][j].setAction(1);
                            }
                        }
                    }
                    try {
                        if(song != null && song.getState()!=3)
                        song.play();
                        Thread.sleep(200);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for(Zombie z : zombieList){


                        if(z.getState() == 1){

                            z.setX(z.getX()-3);

                        }

                        else if(z.getState()== 2){
                            //System.out.println("状态二");

                        }
                    }
                }
            }
        }).start();
    }

    //判断小车是否撞到僵尸线程
    public void isCarMeetZombieThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(50);
                        for(Car car:carList){
                            if(car.isMeetZombie(zombieList) || car.getState() == 2){
                                //car.setState(2);//car.setX(car.getX()+1);
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //小车移动线程
    public void carMoveThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(100);
                        for(Car car : carList){
                            if(car.getState() == 2){
                                car.setX(car.getX()+10);
                            }
                            if(car.getX() > 1000+34){
                                carList.remove(car);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    public void clearAll(){
        sunNumber = 100;
        isDelete = false;
        zombieList.clear();
        bulletList.clear();
        sunList.clear();
        decoraores.clear();
        carList.clear();
        fireWoodList.clear();
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 9;j++){
                plants[i][j] = null;
            }
        }

        carList.add(new Car(-50,0));
        carList.add(new Car(-50,100));
        carList.add(new Car(-50,200));
        carList.add(new Car(-50,300));
        carList.add(new Car(-50,400));
        song.stop();
        song = null;

    }
}
