package bean;

import java.awt.*;
import java.util.*;

/**
 * Created by gw on 2017/6/30.
 */
public abstract class Shooter extends Plant{

    protected int energy=2000;

    protected abstract void addEnergy();

    public abstract void attack(Graphics g, java.util.List<Bullet> peaList, int peaNumber);
}
