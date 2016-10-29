package com.teamlead.secondtask.core.DAO;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.teamlead.secondtask.core.IItemDAO;
import com.teamlead.secondtask.core.impl.ItemDAO;

/**
 * Created by Pavel on 27.10.2016.
 */
public class DAOFactory {
    private static IItemDAO itemDAO = null;
    private static DAOFactory instance = null;
    private static ActiveObjects activeObjects;

    public DAOFactory(ActiveObjects activeObjects) {
        this.activeObjects=activeObjects;
    }

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory(activeObjects);
        }
        return instance;
    }
    public IItemDAO getItemDAO() {
        if (itemDAO == null) {
            itemDAO = new ItemDAO(activeObjects);
        }
        return itemDAO;
    }
}
