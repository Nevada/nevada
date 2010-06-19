package com.nevada.nevada.gwt.request;

import com.google.gwt.valuestore.shared.Record;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Department;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.valuestore.shared.Property;

@RooGwtMirroredFrom(Department.class)
@ServerType(type = Department.class)
public interface DepartmentRecord extends Record {

    public String TOKEN = "DepartmentRecord";

    Property<java.lang.String> name = new com.google.gwt.valuestore.shared.Property<java.lang.String>("name", "Name", java.lang.String.class);

    abstract String getName();
}
