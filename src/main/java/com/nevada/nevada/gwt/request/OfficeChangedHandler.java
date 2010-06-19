package com.nevada.nevada.gwt.request;

import com.google.gwt.event.shared.EventHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Office;
import com.google.gwt.requestfactory.shared.ServerType;
import com.nevada.nevada.gwt.request.OfficeRecordChanged;

@RooGwtMirroredFrom(Office.class)
@ServerType(type = Office.class)
public interface OfficeChangedHandler extends EventHandler {

    abstract void onOfficeChanged(OfficeRecordChanged event);
}
