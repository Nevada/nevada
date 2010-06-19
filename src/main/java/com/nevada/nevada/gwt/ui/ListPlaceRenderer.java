package com.nevada.nevada.gwt.ui;
import com.google.gwt.app.util.Renderer;
import com.google.gwt.valuestore.shared.Record;
import com.nevada.nevada.gwt.scaffold.place.ApplicationListPlace;
public class ListPlaceRenderer implements Renderer<ApplicationListPlace> {
    public String render(ApplicationListPlace object) {
        Class<? extends Record> type = object.getType();
        if (type.equals(com.nevada.nevada.gwt.request.EmployeeRecord.class)) {
            return "Employees";
        }
        throw new IllegalArgumentException("Cannot render unknown type " + object);
    }
}
