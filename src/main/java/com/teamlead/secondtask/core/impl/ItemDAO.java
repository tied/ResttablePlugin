package com.teamlead.secondtask.core.impl;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.sal.api.transaction.TransactionCallback;
import com.teamlead.secondtask.core.IItem;
import com.teamlead.secondtask.core.IItemDAO;
import com.teamlead.secondtask.core.IItemEntity;

import java.util.Date;

/**
 * Created by Pavel on 27.10.2016.
 */
public class ItemDAO implements IItemDAO {
    private ActiveObjects activeObjects;
    public ItemDAO(ActiveObjects activeObjects) {
        this.activeObjects = activeObjects;
    }

    @Override
    public IItemEntity addItem(final IItem item) throws Exception {
        return activeObjects.executeInTransaction(new TransactionCallback<IItemEntity>() {
            @Override
            public IItemEntity doInTransaction() {
                IItemEntity entity = activeObjects.create(IItemEntity.class);
                entity.setName(item.getName());
                entity.setDescription(item.getDescription());
                entity.setCreatedDate(new Date(System.currentTimeMillis()));
                entity.save();
                return entity;
            }
        });
    }

    @Override
    public IItemEntity[] getItems() throws Exception {
        return activeObjects.executeInTransaction(new TransactionCallback<IItemEntity[]>() {
            @Override
            public IItemEntity[] doInTransaction() {
                return activeObjects.find(IItemEntity.class);
            }
        });
    }
}
