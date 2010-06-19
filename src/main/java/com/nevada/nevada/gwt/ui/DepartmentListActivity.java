package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.PlaceController;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.valuestore.ui.AbstractRecordListActivity;
import com.google.gwt.valuestore.ui.RecordListView;
import com.google.gwt.view.client.Range;

import com.nevada.nevada.gwt.request.DepartmentRecord;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.nevada.gwt.scaffold.place.DepartmentScaffoldPlace;
import com.nevada.nevada.gwt.scaffold.generated.DepartmentListView;
import com.nevada.nevada.gwt.request.DepartmentRecordChanged;
import com.nevada.nevada.gwt.request.DepartmentChangedHandler;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace.Operation;

/**
 * Activity that requests and displays all {DepartmentRecord}
 * records.
 */
public class DepartmentListActivity extends
    AbstractRecordListActivity<DepartmentRecord> {

  private static RecordListView<DepartmentRecord> defaultView;

  private static RecordListView<DepartmentRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new DepartmentListView();
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
  public DepartmentListActivity(HandlerManager eventBus,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(eventBus, requests, getDefaultView(), placeController);
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public DepartmentListActivity(HandlerManager eventBus,
      ApplicationRequestFactory requests, RecordListView<DepartmentRecord> view,
      PlaceController<ApplicationPlace> placeController) {
    super(view);
    this.eventBus = eventBus;
    this.requests = requests;
    this.placeController = placeController;
  }

  public void createClicked() {
    placeController.goTo(new DepartmentScaffoldPlace("", Operation.EDIT));
  }

  public void onStop() {
    registration.removeHandler();
  }

  public void showDetails(DepartmentRecord record) {
    placeController.goTo(new DepartmentScaffoldPlace(record, Operation.DETAILS));
  }

  public void start(Display display) {
    this.registration = eventBus.addHandler(DepartmentRecordChanged.TYPE,
        new DepartmentChangedHandler() {
          public void onDepartmentChanged(DepartmentRecordChanged event) {
            update(event.getWriteOperation(), event.getRecord());
          }
        });
    super.start(display);
  }

  protected RecordListRequest<DepartmentRecord> createRangeRequest(Range range) {
    return requests.departmentRequest().findDepartmentEntries(range.getStart(),
        range.getLength());
  }

  protected void fireCountRequest(Receiver<Long> callback) {
    requests.departmentRequest().countDepartments().to(callback).fire();
  }
}
