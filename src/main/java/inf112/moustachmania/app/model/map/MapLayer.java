package inf112.moustachmania.app.model.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.awt.*;
import java.util.HashMap;

public class MapLayer implements IMapLayer {

    private final HashMap<String, TiledMap> tiledMapHashMap;

    public MapLayer(){
        tiledMapHashMap = new HashMap<>();
    }
    @Override
    public boolean[][] getLayer(String layerName, String mapPath) {
        TiledMap tiledMap;
        if(tiledMapHashMap.containsKey(mapPath)){
            tiledMap = tiledMapHashMap.get(mapPath);
        }else{
            tiledMap = new TmxMapLoader().load(mapPath);
            tiledMapHashMap.put(mapPath, tiledMap);
        }

        TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(layerName);
        if (layer == null) {
            throw new IllegalArgumentException("Layer not found: " + layerName);
            //Point mapDimensions = getMapDimensions(mapPath);
            //return new boolean[mapDimensions.x][mapDimensions.y];
        }

        /*boolean[][] mapLayerData = new boolean[layer.getWidth()][layer.getHeight()];
        for (int x = 0; x < layer.getWidth(); x++) {
            for (int y = 0; y < layer.getHeight(); y++) {
                mapLayerData[x][y] = layer.getCell(x, y) != null;
            }
        }

        return mapLayerData;*/
        return null;
    }

    @Override
    public Point getMapDimensions(String mapPath) {
        // hente ut dimensjonene til mapet
        //mapPath hente ut pathen til mapet
        //returnere dimensjonene til mapet, som en Point
        return null;
    }
}
