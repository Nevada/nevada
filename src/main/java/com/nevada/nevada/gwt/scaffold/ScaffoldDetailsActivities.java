package com.nevada.nevada.gwt.scaffold;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;
import com.nevada.nevada.gwt.scaffold.place.BasePlaceFilter;
import com.nevada.nevada.gwt.ui.OfficeActivitiesMapper;
import com.nevada.nevada.gwt.scaffold.place.OfficeScaffoldPlace;
import com.nevada.nevada.gwt.ui.EmployeeActivitiesMapper;
import com.nevada.nevada.gwt.scaffold.place.EmployeeScaffoldPlace;
import com.nevada.nevada.gwt.ui.DepartmentActivitiesMapper;
import com.nevada.nevada.gwt.scaffold.place.DepartmentScaffoldPlace;

/**
 * Finds the activity to run for a particular {@link ScaffoldPlace} in the bottom
 * half of the {@link ScaffoldShell}.
 */
public final class ScaffoldDetailsActivities implements
    ActivityMapper<ApplicationPlace> {

  private final ActivityMapper<OfficeScaffoldPlace> officeActivities;
  private final ActivityMapper<EmployeeScaffoldPlace> employeeActivities;
  private final ActivityMapper<DepartmentScaffoldPlace> departmentActivities;
  public ScaffoldDetailsActivities(ApplicationRequestFactory requestFactory,
      PlaceController<ApplicationPlace> placeController) {
    this.officeActivities = new OfficeActivitiesMapper(
        requestFactory, placeController); 
    this.employeeActivities = new EmployeeActivitiesMapper(
        requestFactory, placeController); 
    this.departmentActivities = new DepartmentActivitiesMapper(
        requestFactory, placeController); 
  }

  public Activity getActivity(ApplicationPlace place) {
    return place.acceptFilter(new BasePlaceFilter<Activity>(null) {
      public Activity filter(OfficeScaffoldPlace place) {
        return officeActivities.getActivity(place);
      }
      public Activity filter(EmployeeScaffoldPlace place) {
        return employeeActivities.getActivity(place);
      }
      public Activity filter(DepartmentScaffoldPlace place) {
        return departmentActivities.getActivity(place);
      }
    });
  }
}
