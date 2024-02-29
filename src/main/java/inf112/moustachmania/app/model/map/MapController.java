package inf112.moustachmania.app.model.map;

import inf112.moustachmania.app.utils.Constants;

import java.awt.*;
import java.util.HashMap;

public class MapController {

    private final String mapPaths;
    private String currentMapPath;
    private Map currentMap;
    private HashMap<String, Map> mapDictionary;
    private static MapController instance;

    public MapController(String mapPaths) {
        this.mapPaths = mapPaths;
        this.currentMapPath = mapPaths;
        loadMaps();
        this.currentMap = mapDictionary.get(currentMapPath);
    }

    public static MapController getInstance() {
        if (instance == null) {
            instance = new MapController(Constants.mapPaths);
        }
        return instance;
    }

    public String getTileMapPath() {
        return "";
    }

    private void loadMaps() {
        mapDictionary = new HashMap<>();
        mapDictionary.put(mapPaths, new Map(mapPaths));
    }

    public Point getMapDimensions() {
        return currentMap.getMapDimensions();
    }

    public String getTiledMapPath() {
        return currentMapPath;
    }
}
