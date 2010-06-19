package com.nevada.nevada;

import java.lang.String;

privileged aspect Employee_Roo_JavaBean {
    
    public String Employee.getUserName() {
        return this.userName;
    }
    
    public void Employee.setUserName(String userName) {
        this.userName = userName;
    }
    
    public String Employee.getDepartment() {
        return this.department;
    }
    
    public void Employee.setDepartment(String department) {
        this.department = department;
    }
    
}
