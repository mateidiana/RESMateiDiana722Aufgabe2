package org.example.model;

import java.io.Serializable;

public abstract class EntityByString implements Serializable {
    private String id;

    public EntityByString(String id)
    {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Id: " + id;
    }
}

