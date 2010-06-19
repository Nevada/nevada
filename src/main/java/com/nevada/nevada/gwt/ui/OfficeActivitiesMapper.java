package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.nevada.nevada.gwt.request.OfficeRecord;
import com.nevada.nevada.gwt.scaffold.place.OfficeScaffoldPlace;
import com.nevada.nevada.gwt.ui.OfficeDetailsActivity;
import com.nevada.nevada.gwt.ui.OfficeEditActivity;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;

/**
 * Maps {@link ${entity.detailsPlace} instances to the {@link Activity} to run.
 */
public class OfficeActivitiesMapper implements
    ActivityMapper<OfficeScaffoldPlace> {
  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  public OfficeActivitiesMapper(ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this.requests = requests;
    this.placeController = placeController;
  }

  public Activity getActivity(OfficeScaffoldPlace place) {
    switch (place.getOperation()) {
      case DETAILS:
        return new OfficeDetailsActivity(place.getId(), requests, placeController);

      case EDIT:
        return new OfficeEditActivity(place.getId(), requests,
            placeController);
    }

    throw new IllegalArgumentException("Unknown operation "
        + place.getOperation());
  }
}
