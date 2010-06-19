package com.nevada.nevada.gwt.request;

import com.google.gwt.valuestore.shared.RecordChangedEvent;
import com.nevada.nevada.gwt.request.EmployeeRecord;
import com.nevada.nevada.gwt.request.EmployeeChangedHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Employee;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.requestfactory.shared.RequestFactory.WriteOperation;

@RooGwtMirroredFrom(Employee.class)
@ServerType(type = Employee.class)
public class EmployeeRecordChanged extends RecordChangedEvent<EmployeeRecord, EmployeeChangedHandler> {

    public static final Type<com.nevada.nevada.gwt.request.EmployeeChangedHandler> TYPE = new com.google.gwt.event.shared.GwtEvent.Type<com.nevada.nevada.gwt.request.EmployeeChangedHandler>();

    public EmployeeRecordChanged(EmployeeRecord record, WriteOperation writeOperation) {
        super(record, writeOperation);
    }

    public Type<com.nevada.nevada.gwt.request.EmployeeChangedHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(EmployeeChangedHandler handler) {
        handler.onEmployeeChanged(this);
    }
}
