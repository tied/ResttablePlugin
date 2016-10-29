package com.teamlead.secondtask.core;

import net.java.ao.Entity;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Pavel on 27.10.2016.
 */
public interface IItemEntity extends Entity, IItem {
    public void setCreatedDate(Date date);
    public Date getCreatedDate();
}
