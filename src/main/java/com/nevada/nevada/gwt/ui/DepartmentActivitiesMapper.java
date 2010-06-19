package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.nevada.nevada.gwt.request.DepartmentRecord;
import com.nevada.nevada.gwt.scaffold.place.DepartmentScaffoldPlace;
import com.nevada.nevada.gwt.ui.DepartmentDetailsActivity;
import com.nevada.nevada.gwt.ui.DepartmentEditActivity;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;

/**
 * Maps {@link ${entity.detailsPlace} instances to the {@link Activity} to run.
 */
public class DepartmentActivitiesMapper implements
    ActivityMapper<DepartmentScaffoldPlace> {
  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  public DepartmentActivitiesMapper(ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this.requests = requests;
    this.placeController = placeController;
  }

  public Activity getActivity(DepartmentScaffoldPlace place) {
    switch (place.getOperation()) {
      case DETAILS:
        return new DepartmentDetailsActivity(place.getId(), requests, placeController);

      case EDIT:
        return new DepartmentEditActivity(place.getId(), requests,
            placeController);
    }

    throw new IllegalArgumentException("Unknown operation "
        + place.getOperation());
  }
}
