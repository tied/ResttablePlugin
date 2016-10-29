package com.teamlead.secondtask.core;

/**
 * Created by Pavel on 27.10.2016.
 */
public interface IItemDAO {
    public IItemEntity addItem(IItem item) throws Exception;
    public IItemEntity[] getItems() throws Exception;
}
