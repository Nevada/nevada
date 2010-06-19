package com.nevada.nevada.gwt.scaffold.place;

import com.google.gwt.valuestore.shared.Record;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlaceFilter;
import com.nevada.nevada.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.nevada.gwt.scaffold.place.EmployeeScaffoldPlace;
import com.nevada.nevada.gwt.request.EmployeeRecord;

/**
 * Filters an {@link ApplicationPlace} to the corresponding record
 * type.
 */
public final class ApplicationPlaceToRecordType implements
    ApplicationPlaceFilter<Class<? extends Record>> {

  public Class<? extends Record> filter(EmployeeScaffoldPlace place) {
    return EmployeeRecord.class;
  }

  public Class<? extends Record> filter(ApplicationListPlace place) {
    return place.getType();
  }
}