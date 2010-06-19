package com.nevada.nevada.gwt.request;
import com.google.gwt.requestfactory.shared.RequestFactory;
public interface ApplicationRequestFactory extends RequestFactory {
    OfficeRequest officeRequest();
    EmployeeRequest employeeRequest();
    DepartmentRequest departmentRequest();
}
