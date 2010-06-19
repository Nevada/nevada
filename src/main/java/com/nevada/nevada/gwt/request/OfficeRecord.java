package com.nevada.nevada.gwt.request;

import com.google.gwt.valuestore.shared.Record;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Office;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.valuestore.shared.Property;

@RooGwtMirroredFrom(Office.class)
@ServerType(type = Office.class)
public interface OfficeRecord extends Record {

    public String TOKEN = "OfficeRecord";

    Property<java.lang.String> location = new com.google.gwt.valuestore.shared.Property<java.lang.String>("location", "Location", java.lang.String.class);

    Property<java.lang.String> name = new com.google.gwt.valuestore.shared.Property<java.lang.String>("name", "Name", java.lang.String.class);

    abstract String getLocation();

    abstract String getName();
}
