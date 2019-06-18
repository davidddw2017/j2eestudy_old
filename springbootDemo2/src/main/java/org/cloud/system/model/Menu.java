package org.cloud.system.model;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {

    private static final long serialVersionUID = 8782740134636936348L;

    private Integer menuId;

    private String menuName;

    private String url;

    private String icon;

    private List<Menu> children;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(int menuId, String menuName, String url, String icon, List<Menu> children) {
        super();
        this.menuId = menuId;
        this.menuName = menuName;
        this.url = url;
        this.icon = icon;
        this.children = children;
    }

    public Menu() {
        super();
    }

}
