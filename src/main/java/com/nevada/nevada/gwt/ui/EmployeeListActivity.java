package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.PlaceController;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.valuestore.ui.AbstractRecordListActivity;
import com.google.gwt.valuestore.ui.RecordListView;
import com.google.gwt.view.client.Range;

import com.nevada.nevada.gwt.request.EmployeeRecord;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.nevada.gwt.scaffold.place.EmployeeScaffoldPlace;
import com.nevada.nevada.gwt.scaffold.generated.EmployeeListView;
import com.nevada.nevada.gwt.request.EmployeeRecordChanged;
import com.nevada.nevada.gwt.request.EmployeeChangedHandler;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace.Operation;

/**
 * Activity that requests and displays all {EmployeeRecord}
 * records.
 */
public class EmployeeListActivity extends
    AbstractRecordListActivity<EmployeeRecord> {

  private static RecordListView<EmployeeRecord> defaultView;

  private static RecordListView<EmployeeRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new EmployeeListView();
    }
    return defaultView;
  }

  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;
  private final HandlerManager eventBus;
  private HandlerRegistration registration;

  /**
   * Creates an activity that uses the default singleton view instance.
   */
  public EmployeeListActivity(HandlerManager eventBus,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(eventBus, requests, getDefaultView(), placeController);
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public EmployeeListActivity(HandlerManager eventBus,
      ApplicationRequestFactory requests, RecordListView<EmployeeRecord> view,
      PlaceController<ApplicationPlace> placeController) {
    super(view);
    this.eventBus = eventBus;
    this.requests = requests;
    this.placeController = placeController;
  }

  public void createClicked() {
    placeController.goTo(new EmployeeScaffoldPlace("", Operation.EDIT));
  }

  public void onStop() {
    registration.removeHandler();
  }

  public void showDetails(EmployeeRecord record) {
    placeController.goTo(new EmployeeScaffoldPlace(record, Operation.DETAILS));
  }

  public void start(Display display) {
    this.registration = eventBus.addHandler(EmployeeRecordChanged.TYPE,
        new EmployeeChangedHandler() {
          public void onEmployeeChanged(EmployeeRecordChanged event) {
            update(event.getWriteOperation(), event.getRecord());
          }
        });
    super.start(display);
  }

  protected RecordListRequest<EmployeeRecord> createRangeRequest(Range range) {
    return requests.employeeRequest().findEmployeeEntries(range.getStart(),
        range.getLength());
  }

  protected void fireCountRequest(Receiver<Long> callback) {
    requests.employeeRequest().countEmployees().to(callback).fire();
  }
}
