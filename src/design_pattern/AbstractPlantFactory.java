package design_pattern;

import bean.*;

/**
 * Created by gw on 2017/6/23.
 */
public abstract class AbstractPlantFactory {

    public abstract Shooter createShooter1(int x,int y);

    public abstract Shooter createShooter2(int x,int y);

    public abstract SunFlower createSunFlower(int x,int y);

    public abstract Nut createNut(int x,int y);

    public abstract SunShroom createSunShroom(int x,int y);

    public abstract FireWood createFireWood(int x,int y);


}
