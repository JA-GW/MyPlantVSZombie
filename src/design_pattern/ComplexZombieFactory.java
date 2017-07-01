package design_pattern;

import bean.Zombie;

/**
 * Created by gw on 2017/6/23.
 */
public class ComplexZombieFactory extends AbstractZombieFactory {
    @Override
    public Zombie createWalkZombie(int x, int y) {
        return null;
    }

    @Override
    public Zombie createFlyZombie(int x, int y) {
        return null;
    }

    @Override
    public Zombie createDriverZombie(int x, int y) {
        return null;
    }
}
