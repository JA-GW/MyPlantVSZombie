package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gw on 2017/6/28.
 */
public class SelectPanel extends JPanel implements ActionListener{
    JButton button1,button2;
    Container container;
    SelectPanel(Container container){
        this.container = container;
        button1 = new JButton("白天");
        button1.addActionListener(this);
        button2 = new JButton("夜间");
        button2.addActionListener(this);
        this.add(button1);
        this.add(button2);
        this.setVisible(true);
    }

    public void restart(){
        container.removeAll();

        container.add(this);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button1)){
            container.removeAll();
            container.remove(this);
            container.add(new GamePanel(1,this));
        }else if(e.getSource().equals(button2)){
            container.removeAll();
            container.remove(this);
            container.add(new GamePanel(2,this));
        }
    }
}
