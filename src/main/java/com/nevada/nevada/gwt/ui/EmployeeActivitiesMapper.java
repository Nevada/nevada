package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.nevada.nevada.gwt.request.EmployeeRecord;
import com.nevada.nevada.gwt.scaffold.place.EmployeeScaffoldPlace;
import com.nevada.nevada.gwt.ui.EmployeeDetailsActivity;
import com.nevada.nevada.gwt.ui.EmployeeEditActivity;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;

/**
 * Maps {@link ${entity.detailsPlace} instances to the {@link Activity} to run.
 */
public class EmployeeActivitiesMapper implements
    ActivityMapper<EmployeeScaffoldPlace> {
  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  public EmployeeActivitiesMapper(ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this.requests = requests;
    this.placeController = placeController;
  }

  public Activity getActivity(EmployeeScaffoldPlace place) {
    switch (place.getOperation()) {
      case DETAILS:
        return new EmployeeDetailsActivity(place.getId(), requests, placeController);

      case EDIT:
        return new EmployeeEditActivity(place.getId(), requests,
            placeController);
    }

    throw new IllegalArgumentException("Unknown operation "
        + place.getOperation());
  }
}
