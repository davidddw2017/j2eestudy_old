package org.cloud.jsfDemo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class LoginBean {
    String username;
    String password;

    public LoginBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if (username.equals("admin") && password.equals("admin")) {

            return "success";
        } else {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("Invalid Username and/or password,try again!");
            ctx.addMessage("loginForm", msg);
            return "failure";
        }
    }
}
