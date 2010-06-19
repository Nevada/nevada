package com.nevada.nevada.gwt.request;

import com.google.gwt.requestfactory.shared.RequestFactory.RequestDefinition;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Employee;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(Employee.class)
@ServerType(type = Employee.class)
public enum EmployeeRequestServerSideOperations implements RequestDefinition {

    FIND_ALL_EMPLOYEES, FIND_EMPLOYEE, COUNT_EMPLOYEES, FIND_EMPLOYEE_ENTRIES;

    public String getDomainClassName() {
        return "com.nevada.nevada.Employee";
    }

    public String getDomainMethodName() {
        switch(this) {
            case FIND_ALL_EMPLOYEES:
                return "findAllEmployees";
            case FIND_EMPLOYEE:
                return "findEmployee";
            case COUNT_EMPLOYEES:
                return "countEmployees";
            case FIND_EMPLOYEE_ENTRIES:
                return "findEmployeeEntries";
            default:
                throw new IllegalStateException();
        }
    }

    public boolean isReturnTypeList() {
        switch(this) {
            case FIND_ALL_EMPLOYEES:
                return true;
            case FIND_EMPLOYEE:
                return false;
            case COUNT_EMPLOYEES:
                return false;
            case FIND_EMPLOYEE_ENTRIES:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?> getReturnType() {
        switch(this) {
            case FIND_ALL_EMPLOYEES:
                return com.nevada.nevada.gwt.request.EmployeeRecord.class;
            case FIND_EMPLOYEE:
                return com.nevada.nevada.gwt.request.EmployeeRecord.class;
            case COUNT_EMPLOYEES:
                return java.lang.Long.class;
            case FIND_EMPLOYEE_ENTRIES:
                return com.nevada.nevada.gwt.request.EmployeeRecord.class;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?>[] getParameterTypes() {
        switch(this) {
            case FIND_ALL_EMPLOYEES:
                return null;
            case FIND_EMPLOYEE:
                return new Class[] { java.lang.Long.class };
            case COUNT_EMPLOYEES:
                return null;
            case FIND_EMPLOYEE_ENTRIES:
                return new Class[] { int.class, int.class };
            default:
                throw new IllegalStateException();
        }
    }
}
