package inf112.moustachmania.app.model.map;

import java.awt.*;

public class Map {
    private final String mapPath;
    //private final boolean[][] collisionLayer;
    //private final Point mapDimensions;

    public Map(String mapPath) {
        this.mapPath = mapPath;
        // legge inn get collison fra klassen Constants
        //legge in getMapDimensions fra Controller
    }


    public Point getMapDimensions() {
        return null;
    }

   /*public boolean isTiledBlocked(Point point){
    }
    public boolean isExit(Point playerPosition) {
    }*/
}
