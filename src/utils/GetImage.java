package utils;

import java.awt.*;

/**
 * Created by gw on 2017/6/20.
 */
public class GetImage {

    private static Toolkit toolkit = Toolkit.getDefaultToolkit();


    public static Image getImage(String path){
        path = "F:/IntelliJIDEAWorkspace/PlantsVSZombie/image/pvzimage/"+path;
        return toolkit.getImage(path);
    }
}
