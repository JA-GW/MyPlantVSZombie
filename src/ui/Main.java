package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gw on 2017/6/20.
 */
public class Main extends JFrame {

    //private Game game;
    Container container;

    JButton button1,button2;
    public Main(){

        //game = new Game();
        //game.init();
        //this.setLayout(null);
        this.setTitle("植物大战僵尸");
        container = getContentPane();
        container.add(new SelectPanel(container));
        //container.add(new GamePanel());
        this.setBounds(100,100,5 * 2 + 800, 600 + 2 * 5 + 25);

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



    public static void main(String args[]){

        Main main = new Main();

    }


}
