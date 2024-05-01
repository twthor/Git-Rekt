package inf112.moustachmania.app.model;

import inf112.moustachmania.app.model.entities.IEntity;
import inf112.moustachmania.app.model.entities.Monster;

public interface IModel {

    
    /**
     * Update the model.
     * @param deltaTime the time since the last update
     */
    void update(float deltaTime);
}
