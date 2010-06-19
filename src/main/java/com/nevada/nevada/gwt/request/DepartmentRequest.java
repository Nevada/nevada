package com.nevada.nevada.gwt.request;

import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Department;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.requestfactory.shared.ServerOperation;
import com.google.gwt.requestfactory.shared.RecordRequest;
import com.google.gwt.valuestore.shared.PropertyReference;
import com.google.gwt.requestfactory.shared.RequestFactory.RequestObject;

@RooGwtMirroredFrom(Department.class)
@ServerType(type = Department.class)
public interface DepartmentRequest {

    @ServerOperation("FIND_ALL_DEPARTMENTS")
    abstract RecordListRequest<com.nevada.nevada.gwt.request.DepartmentRecord> findAllDepartments();

    @ServerOperation("FIND_DEPARTMENT")
    abstract RecordRequest<com.nevada.nevada.gwt.request.DepartmentRecord> findDepartment(PropertyReference<String> id);

    @ServerOperation("COUNT_DEPARTMENTS")
    abstract RequestObject<java.lang.Long> countDepartments();

    @ServerOperation("FIND_DEPARTMENT_ENTRIES")
    abstract RecordListRequest<com.nevada.nevada.gwt.request.DepartmentRecord> findDepartmentEntries(int firstResult, int maxResults);
}
