package model.entity;

import java.io.Serializable;

/**
 * Class that represents a simple entity, which should extends each entity
 * implements @{@link Serializable} and @{@link Cloneable}
 *
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class Entity implements Serializable, Cloneable {

    private int id;

    /**
     * Constructor for creating a new object without parameters
     * @see Entity#Entity()
     */
    Entity() {
    }

    /**
     * Constructor for creating a new object
     * @param id - id
     * @see Entity#Entity(int)
     */
    Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
