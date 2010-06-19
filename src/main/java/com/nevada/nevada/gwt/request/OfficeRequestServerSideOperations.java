package com.nevada.nevada.gwt.request;

import com.google.gwt.requestfactory.shared.RequestFactory.RequestDefinition;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Office;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(Office.class)
@ServerType(type = Office.class)
public enum OfficeRequestServerSideOperations implements RequestDefinition {

    FIND_ALL_OFFICES, FIND_OFFICE, COUNT_OFFICES, FIND_OFFICE_ENTRIES;

    public String getDomainClassName() {
        return "com.nevada.nevada.Office";
    }

    public String getDomainMethodName() {
        switch(this) {
            case FIND_ALL_OFFICES:
                return "findAllOffices";
            case FIND_OFFICE:
                return "findOffice";
            case COUNT_OFFICES:
                return "countOffices";
            case FIND_OFFICE_ENTRIES:
                return "findOfficeEntries";
            default:
                throw new IllegalStateException();
        }
    }

    public boolean isReturnTypeList() {
        switch(this) {
            case FIND_ALL_OFFICES:
                return true;
            case FIND_OFFICE:
                return false;
            case COUNT_OFFICES:
                return false;
            case FIND_OFFICE_ENTRIES:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?> getReturnType() {
        switch(this) {
            case FIND_ALL_OFFICES:
                return com.nevada.nevada.gwt.request.OfficeRecord.class;
            case FIND_OFFICE:
                return com.nevada.nevada.gwt.request.OfficeRecord.class;
            case COUNT_OFFICES:
                return java.lang.Long.class;
            case FIND_OFFICE_ENTRIES:
                return com.nevada.nevada.gwt.request.OfficeRecord.class;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?>[] getParameterTypes() {
        switch(this) {
            case FIND_ALL_OFFICES:
                return null;
            case FIND_OFFICE:
                return new Class[] { java.lang.Long.class };
            case COUNT_OFFICES:
                return null;
            case FIND_OFFICE_ENTRIES:
                return new Class[] { int.class, int.class };
            default:
                throw new IllegalStateException();
        }
    }
}
