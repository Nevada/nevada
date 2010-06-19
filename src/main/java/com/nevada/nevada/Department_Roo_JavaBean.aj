package com.nevada.nevada;

import java.lang.String;

privileged aspect Department_Roo_JavaBean {
    
    public String Department.getName() {
        return this.name;
    }
    
    public void Department.setName(String name) {
        this.name = name;
    }
    
}
