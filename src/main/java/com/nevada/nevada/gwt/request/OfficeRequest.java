package com.nevada.nevada.gwt.request;

import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.nevada.Office;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.requestfactory.shared.ServerOperation;
import com.google.gwt.requestfactory.shared.RecordRequest;
import com.google.gwt.valuestore.shared.PropertyReference;
import com.google.gwt.requestfactory.shared.RequestFactory.RequestObject;

@RooGwtMirroredFrom(Office.class)
@ServerType(type = Office.class)
public interface OfficeRequest {

    @ServerOperation("FIND_ALL_OFFICES")
    abstract RecordListRequest<com.nevada.nevada.gwt.request.OfficeRecord> findAllOffices();

    @ServerOperation("FIND_OFFICE")
    abstract RecordRequest<com.nevada.nevada.gwt.request.OfficeRecord> findOffice(PropertyReference<String> id);

    @ServerOperation("COUNT_OFFICES")
    abstract RequestObject<java.lang.Long> countOffices();

    @ServerOperation("FIND_OFFICE_ENTRIES")
    abstract RecordListRequest<com.nevada.nevada.gwt.request.OfficeRecord> findOfficeEntries(int firstResult, int maxResults);
}
