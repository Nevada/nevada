package com.nevada.nevada;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Employee_Roo_Configurable {
    
    declare @type: Employee: @Configurable;
    
}
