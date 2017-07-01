package design_pattern;

import bean.Bullet;
import bean.Pea;
import bean.Zombie;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gw on 2017/6/28.
 */
public abstract class DecoratorBullet extends Bullet {

    protected Bullet bullet;

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
        this.x = bullet.getX();
        this.y = bullet.getY();
    }



    @Override
    public void paint(Graphics g, List<Zombie> zombieList, List<Bullet> peaList) {
        bullet.paint(g,zombieList,peaList);
    }
}
