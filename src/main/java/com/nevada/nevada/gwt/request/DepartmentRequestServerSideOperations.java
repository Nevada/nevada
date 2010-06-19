package com.nevada.nevada.gwt.request;

import com.google.gwt.requestfactory.shared.RequestFactory.RequestDefinition;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Department;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(Department.class)
@ServerType(type = Department.class)
public enum DepartmentRequestServerSideOperations implements RequestDefinition {

    FIND_ALL_DEPARTMENTS, FIND_DEPARTMENT, COUNT_DEPARTMENTS, FIND_DEPARTMENT_ENTRIES;

    public String getDomainClassName() {
        return "com.nevada.nevada.Department";
    }

    public String getDomainMethodName() {
        switch(this) {
            case FIND_ALL_DEPARTMENTS:
                return "findAllDepartments";
            case FIND_DEPARTMENT:
                return "findDepartment";
            case COUNT_DEPARTMENTS:
                return "countDepartments";
            case FIND_DEPARTMENT_ENTRIES:
                return "findDepartmentEntries";
            default:
                throw new IllegalStateException();
        }
    }

    public boolean isReturnTypeList() {
        switch(this) {
            case FIND_ALL_DEPARTMENTS:
                return true;
            case FIND_DEPARTMENT:
                return false;
            case COUNT_DEPARTMENTS:
                return false;
            case FIND_DEPARTMENT_ENTRIES:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?> getReturnType() {
        switch(this) {
            case FIND_ALL_DEPARTMENTS:
                return com.nevada.nevada.gwt.request.DepartmentRecord.class;
            case FIND_DEPARTMENT:
                return com.nevada.nevada.gwt.request.DepartmentRecord.class;
            case COUNT_DEPARTMENTS:
                return java.lang.Long.class;
            case FIND_DEPARTMENT_ENTRIES:
                return com.nevada.nevada.gwt.request.DepartmentRecord.class;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?>[] getParameterTypes() {
        switch(this) {
            case FIND_ALL_DEPARTMENTS:
                return null;
            case FIND_DEPARTMENT:
                return new Class[] { java.lang.Long.class };
            case COUNT_DEPARTMENTS:
                return null;
            case FIND_DEPARTMENT_ENTRIES:
                return new Class[] { int.class, int.class };
            default:
                throw new IllegalStateException();
        }
    }
}
