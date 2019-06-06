package org.cloud.struts2Demo.action;

import org.cloud.struts2Demo.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<User> {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() throws Exception {
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            ActionContext.getContext().getSession().put("user", user.getUsername());
            return "success";
        }
        return "error";
    }

    @Override
    public User getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

}
