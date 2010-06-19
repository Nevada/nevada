package com.nevada.nevada.gwt.request;

import com.google.gwt.event.shared.EventHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Employee;
import com.google.gwt.requestfactory.shared.ServerType;
import com.nevada.nevada.gwt.request.EmployeeRecordChanged;

@RooGwtMirroredFrom(Employee.class)
@ServerType(type = Employee.class)
public interface EmployeeChangedHandler extends EventHandler {

    abstract void onEmployeeChanged(EmployeeRecordChanged event);
}
