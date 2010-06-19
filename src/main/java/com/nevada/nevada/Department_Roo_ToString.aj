package com.nevada.nevada;

import java.lang.String;

privileged aspect Department_Roo_ToString {
    
    public String Department.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName());
        return sb.toString();
    }
    
}
