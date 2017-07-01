package design_pattern;

import bean.Zombie;

/**
 * Created by gw on 2017/6/23.
 */
public abstract class AbstractZombieFactory {

    public abstract Zombie createWalkZombie(int x,int y);

    public abstract Zombie createFlyZombie(int x,int y);

    public abstract Zombie createDriverZombie(int x,int y);

}
