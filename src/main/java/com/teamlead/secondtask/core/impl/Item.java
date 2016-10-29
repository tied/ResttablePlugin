package com.teamlead.secondtask.core.impl;

import com.teamlead.secondtask.core.IItem;

/**
 * Created by Pavel on 27.10.2016.
 */
public class Item implements IItem{
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
