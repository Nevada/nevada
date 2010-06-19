package com.nevada.nevada.gwt.scaffold.place;

import com.nevada.nevada.gwt.request.OfficeRecord;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlaceFilter;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlaceProcessor;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace;

/**
 * A place in the scaffold app for working with an OfficeRecord.
 */
public class OfficeScaffoldPlace extends ApplicationRecordPlace {

  public OfficeScaffoldPlace(OfficeRecord record, Operation operation) {
    super(record.getId(), operation);
  }

  public OfficeScaffoldPlace(String id, Operation operation) {
    super(id, operation);
  }

  @Override
  public void accept(ApplicationPlaceProcessor visitor) {
    visitor.process(this);
  }

  @Override
  public <T> T acceptFilter(ApplicationPlaceFilter<T> filter) {
    return filter.filter(this);
  }
}
