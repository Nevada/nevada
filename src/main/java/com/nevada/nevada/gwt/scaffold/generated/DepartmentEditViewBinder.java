package com.nevada.nevada.gwt.scaffold.generated;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.nevada.nevada.gwt.scaffold.generated.DepartmentEditView;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Department;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(Department.class)
@ServerType(type = Department.class)
public interface DepartmentEditViewBinder extends UiBinder<HTMLPanel, DepartmentEditView> {
}
