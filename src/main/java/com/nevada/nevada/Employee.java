package com.nevada.nevada;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.Size;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Employee {

    @Size(min = 3, max = 30)
    private String userName;

    private String department;
}
