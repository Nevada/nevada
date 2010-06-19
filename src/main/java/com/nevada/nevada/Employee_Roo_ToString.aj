package com.nevada.nevada;

import java.lang.String;

privileged aspect Employee_Roo_ToString {
    
    public String Employee.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("UserName: ").append(getUserName()).append(", ");
        sb.append("Department: ").append(getDepartment());
        return sb.toString();
    }
    
}
