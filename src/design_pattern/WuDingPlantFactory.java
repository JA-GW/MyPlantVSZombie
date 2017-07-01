package design_pattern;

import bean.*;

/**
 * Created by gw on 2017/6/30.
 */
public class WuDingPlantFactory extends AbstractPlantFactory {
    //返回卷心菜射手
    @Override
    public Shooter createShooter1(int x, int y) {
        return null;
    }

    //返回玉米射手
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
        return null;
    }

    @Override
    public SunShroom createSunShroom(int x, int y) {
        return null;
    }

    @Override
    public FireWood createFireWood(int x, int y) {
        return null;
    }
}
