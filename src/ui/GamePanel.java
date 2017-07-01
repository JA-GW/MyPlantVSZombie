package ui;

import bean.Zombie;
import design_pattern.DayPlantFactory;
import design_pattern.CommonZombieFactory;
import design_pattern.NightPlantFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by gw on 2017/6/20.
 */
public class GamePanel extends JPanel implements MouseListener{

    private AbstractGame game;
    //private Game game;
    private int state = 0;
    private SelectPanel panel;

    public GamePanel(int mode,SelectPanel panel){
        if(mode == 1){
            game = new Game();
            game.setGamePanel(this);
            game.init(new DayPlantFactory());
        }else if(mode == 2){
            game = new NightGame();
            game.setGamePanel(this);
            game.init(new NightPlantFactory());
        }
        this.panel = panel;
        this.addMouseListener(this);
        setLayout(null);
        this.setBounds(0,0,5 * 2 + 800, 600 + 2 * 5 + 25);
        //this.setPreferredSize(new Dimension(5 * 2 + 800, 600 + 2 * 5 + 25));
        new Thread(new Runnable() {
            @Override
            public void run() {
                //game.createZomb();
                //repaint();
                //int i = 1;
                while(true){
                    try {

                        game.createZomb(new CommonZombieFactory());
                        //System.out.println("生产僵尸线程");
                        repaint();
                        Thread.sleep(4000+3000*new Random().nextInt(1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }
        }).start();
        if(mode == 1){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            Thread.sleep(2000+new Random().nextInt(3000));
                            game.createSun();
                            repaint();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {

                        Thread.sleep(1000);

                        for(Zombie z : game.getZombieList()){
                            if(z.getX() < -10){
                                state = 1;
                                Thread.sleep(2000);
                                state = 0;
                                game.clearAll();
                                panel.restart();
                                break;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {

        if(state == 0)
        game.paint(g);
        else if(state == 1){
            g.setColor(Color.RED);
            g.setFont(new Font("宋体",0,80));
            g.drawString("GameOver",100,300);
        }



        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击事件");
        game.mouseClick(e.getX(),e.getY());

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
