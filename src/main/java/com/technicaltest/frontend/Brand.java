package com.technicaltest.frontend;

public class Brand {
    String label;
    String value;

   
    public Brand(String label, String value) {
        this.label = label;
        this.value = value;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
