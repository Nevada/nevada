package com.nevada.nevada.gwt.request;

import com.google.gwt.valuestore.shared.RecordChangedEvent;
import com.nevada.nevada.gwt.request.DepartmentRecord;
import com.nevada.nevada.gwt.request.DepartmentChangedHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Department;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.requestfactory.shared.RequestFactory.WriteOperation;

@RooGwtMirroredFrom(Department.class)
@ServerType(type = Department.class)
public class DepartmentRecordChanged extends RecordChangedEvent<DepartmentRecord, DepartmentChangedHandler> {

    public static final Type<com.nevada.nevada.gwt.request.DepartmentChangedHandler> TYPE = new com.google.gwt.event.shared.GwtEvent.Type<com.nevada.nevada.gwt.request.DepartmentChangedHandler>();

    public DepartmentRecordChanged(DepartmentRecord record, WriteOperation writeOperation) {
        super(record, writeOperation);
    }

    public Type<com.nevada.nevada.gwt.request.DepartmentChangedHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(DepartmentChangedHandler handler) {
        handler.onDepartmentChanged(this);
    }
}
