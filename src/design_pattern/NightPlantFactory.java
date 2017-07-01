package design_pattern;

import bean.*;

/**
 * Created by gw on 2017/6/23.
 */
public class NightPlantFactory extends AbstractPlantFactory {
    //返回小蘑菇射手
    @Override
    public Shooter createShooter1(int x, int y) {
        return new PeaShooter(x,y);
    }

    //返回大蘑菇射手
    @Override
    public Shooter createShooter2(int x, int y) {
        return null;
    }

    @Override
    public SunFlower createSunFlower(int x, int y) {
        return null;
    }

    @Override
    public Nut createNut(int x, int y) {
        return new Nut(x,y);
    }

    @Override
    public SunShroom createSunShroom(int x, int y) {
        return new SunShroom(x,y);
    }

    @Override
    public FireWood createFireWood(int x, int y) {
        return new FireWood(x,y);
    }
}
