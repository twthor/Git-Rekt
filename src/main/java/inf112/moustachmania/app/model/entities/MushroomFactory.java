package inf112.moustachmania.app.model.entities;

public class MushroomFactory implements MonsterFactory {

    
    @Override
    public Monster createMonster() {
        return new Monster();
    }
}
