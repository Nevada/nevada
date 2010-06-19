package com.nevada.nevada.gwt.request;

import com.google.gwt.event.shared.EventHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Department;
import com.google.gwt.requestfactory.shared.ServerType;
import com.nevada.nevada.gwt.request.DepartmentRecordChanged;

@RooGwtMirroredFrom(Department.class)
@ServerType(type = Department.class)
public interface DepartmentChangedHandler extends EventHandler {

    abstract void onDepartmentChanged(DepartmentRecordChanged event);
}
