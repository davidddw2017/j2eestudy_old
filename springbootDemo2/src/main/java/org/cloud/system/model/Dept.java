package org.cloud.system.model;

import java.io.Serializable;

public class Dept implements Serializable {

    private static final long serialVersionUID = 3270682253504566850L;
    private Long id;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dept() {
        super();
    }

    public Dept(Long id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dept [id=" + id + ", title=" + title + ", description=" + description + "]";
    }

}
