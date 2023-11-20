package com.technicaltest.frontend;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Resumen {
    
    public void CreatePolicy() {
        System.out.println("este es el metodo que creara la poliza");
    }
}
