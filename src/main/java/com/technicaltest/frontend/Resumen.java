package com.technicaltest.frontend;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Resumen {
   String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
