package com.nevada.nevada;

import java.lang.String;

privileged aspect Office_Roo_ToString {
    
    public String Office.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Location: ").append(getLocation());
        return sb.toString();
    }
    
}
