package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.valuestore.shared.Value;
import com.google.gwt.valuestore.ui.AbstractRecordEditActivity;
import com.google.gwt.valuestore.ui.RecordEditView;
import com.nevada.nevada.gwt.request.EmployeeRecord;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.nevada.gwt.scaffold.place.EmployeeScaffoldPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.nevada.gwt.scaffold.generated.EmployeeEditView;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace.Operation;


/**
 * An activity that requests all info on an Employee, allows the user to edit
 * it, and persists the results.
 */
public class EmployeeEditActivity extends
    AbstractRecordEditActivity<EmployeeRecord> {
  private static RecordEditView<EmployeeRecord> defaultView;

  private static RecordEditView<EmployeeRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new EmployeeEditView();
    }
    return defaultView;
  }

  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  /**
   * Creates an activity that uses the default singleton view instance.
   */
  public EmployeeEditActivity(String id, ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(id, getDefaultView(), requests, placeController);
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public EmployeeEditActivity(String id, RecordEditView<EmployeeRecord> view,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    super(view, id, requests);
    this.requests = requests;
    this.placeController = placeController;
  }


  protected void exit() {
    placeController.goTo(new EmployeeScaffoldPlace(getId(), Operation.DETAILS));
  }

  protected void fireFindRequest(Value<String> id,
      Receiver<EmployeeRecord> callback) {
    requests.employeeRequest().findEmployee(id).to(callback).fire();
  }

  protected String getRecordToken() {
    return EmployeeRecord.TOKEN;
  }
}
