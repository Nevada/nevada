package com.nevada.nevada;

import java.lang.String;

privileged aspect Office_Roo_JavaBean {
    
    public String Office.getName() {
        return this.name;
    }
    
    public void Office.setName(String name) {
        this.name = name;
    }
    
    public String Office.getLocation() {
        return this.location;
    }
    
    public void Office.setLocation(String location) {
        this.location = location;
    }
    
}
