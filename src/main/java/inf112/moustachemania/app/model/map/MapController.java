package inf112.moustachemania.app.model.map;

import inf112.moustachemania.app.utils.Constants;

import java.awt.*;
import java.util.HashMap;

public class MapController {

    private final String[] mapPaths;
    private String currentMapPath;
    private Map currentMap;
    private HashMap<String, Map> mapDictionary;
    private static MapController instance;

    public MapController(String[] mapPaths) {
        this.mapPaths = mapPaths;
        this.currentMapPath = mapPaths[0];
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
        for (String mapPath : mapPaths) {
            mapDictionary.put(mapPath, new Map(mapPath));
        }
    }

    private void changeMap(String mapPath){
        // for å endre på vilket map som vises
    }

    /*public boolean isTiledBlocked(Point point){
        for å se om de går mot et collison layer eller ikke
        bør lage en methode i map, som hånterer om den er blokert
    }*/

    public Point getMapDimensions() {
        return currentMap.getMapDimensions();
    }

    public String getTiledMapPath() {
        return currentMapPath;
    }

    /*public boolean isExit(Point playerPos){
        lager en methode i map som skal hentes her
        skal skjekke om det er exit på slutten av spilelt
        om spiller er i mål
    }*/
}
