package com.nevada.nevada.gwt.request;

import com.google.gwt.valuestore.shared.Record;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Employee;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.valuestore.shared.Property;

@RooGwtMirroredFrom(Employee.class)
@ServerType(type = Employee.class)
public interface EmployeeRecord extends Record {

    public String TOKEN = "EmployeeRecord";

    Property<java.lang.String> department = new com.google.gwt.valuestore.shared.Property<java.lang.String>("department", "Department", java.lang.String.class);

    Property<java.lang.String> userName = new com.google.gwt.valuestore.shared.Property<java.lang.String>("userName", "User Name", java.lang.String.class);

    abstract String getDepartment();

    abstract String getUserName();
}
