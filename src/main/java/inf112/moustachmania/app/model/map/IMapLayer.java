package inf112.moustachmania.app.model.map;

import java.awt.*;

public interface IMapLayer {

    /**
     * Get the layer of the map
     * @param layerName the name of the layer
     * @param mapPath the path to the map
     * @return a 2D boolean array of the layer
     */
    boolean [][] getLayer(String layerName, String mapPath);

    /**
     * Get the dimensions of the map
     * @param mapPath the path to the map
     * @return the dimensions of the map
     */
    Point getMapDimensions(String mapPath);

}
