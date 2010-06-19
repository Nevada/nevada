package com.nevada.nevada.gwt.request;

import com.google.gwt.valuestore.shared.RecordChangedEvent;
import com.nevada.nevada.gwt.request.OfficeRecord;
import com.nevada.nevada.gwt.request.OfficeChangedHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Office;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.requestfactory.shared.RequestFactory.WriteOperation;

@RooGwtMirroredFrom(Office.class)
@ServerType(type = Office.class)
public class OfficeRecordChanged extends RecordChangedEvent<OfficeRecord, OfficeChangedHandler> {

    public static final Type<com.nevada.nevada.gwt.request.OfficeChangedHandler> TYPE = new com.google.gwt.event.shared.GwtEvent.Type<com.nevada.nevada.gwt.request.OfficeChangedHandler>();

    public OfficeRecordChanged(OfficeRecord record, WriteOperation writeOperation) {
        super(record, writeOperation);
    }

    public Type<com.nevada.nevada.gwt.request.OfficeChangedHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(OfficeChangedHandler handler) {
        handler.onOfficeChanged(this);
    }
}
