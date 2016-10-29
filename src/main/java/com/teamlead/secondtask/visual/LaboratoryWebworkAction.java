package com.teamlead.secondtask.visual;

import com.atlassian.jira.project.Project;
import com.teamlead.secondtask.core.DAO.DAOFactory;
import com.teamlead.secondtask.core.IItem;
import com.teamlead.secondtask.core.IItemEntity;
import com.teamlead.secondtask.core.impl.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import webwork.action.ServletActionContext;

public class LaboratoryWebworkAction extends JiraWebActionSupport
{
    private Project project;
    private IItemEntity[] items;
    private static final Logger log = LoggerFactory.getLogger(LaboratoryWebworkAction.class);

    @Override
    public String execute() throws Exception {
        project = getSelectedProjectObject();
        getHttpRequest().setAttribute("com.atlassian.jira.projectconfig.util.ServletRequestProjectConfigRequestCache:project",project);
        items = DAOFactory.getInstance().getItemDAO().getItems();
        return super.execute(); //returns SUCCESS
    }
    public String add() throws Exception {
        String name = getHttpRequest().getParameterValues("name")[0];
        String description = getHttpRequest().getParameterValues("description")[0];
        IItem item = new Item(name,description);
        DAOFactory.getInstance().getItemDAO().addItem(item);
        ServletActionContext.getResponse().sendRedirect("/secure/LaboratoryWebworkAction.jspa");
        return NONE;
    }
}
