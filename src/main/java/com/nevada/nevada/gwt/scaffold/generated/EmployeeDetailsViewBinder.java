package com.nevada.nevada.gwt.scaffold.generated;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.nevada.nevada.gwt.scaffold.generated.EmployeeDetailsView;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Employee;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(Employee.class)
@ServerType(type = Employee.class)
public interface EmployeeDetailsViewBinder extends UiBinder<HTMLPanel, EmployeeDetailsView> {
}
