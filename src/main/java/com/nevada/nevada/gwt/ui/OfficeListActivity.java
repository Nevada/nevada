package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.PlaceController;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.valuestore.ui.AbstractRecordListActivity;
import com.google.gwt.valuestore.ui.RecordListView;
import com.google.gwt.view.client.Range;

import com.nevada.nevada.gwt.request.OfficeRecord;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.nevada.gwt.scaffold.place.OfficeScaffoldPlace;
import com.nevada.nevada.gwt.scaffold.generated.OfficeListView;
import com.nevada.nevada.gwt.request.OfficeRecordChanged;
import com.nevada.nevada.gwt.request.OfficeChangedHandler;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace.Operation;

/**
 * Activity that requests and displays all {OfficeRecord}
 * records.
 */
public class OfficeListActivity extends
    AbstractRecordListActivity<OfficeRecord> {

  private static RecordListView<OfficeRecord> defaultView;

  private static RecordListView<OfficeRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new OfficeListView();
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
  public OfficeListActivity(HandlerManager eventBus,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(eventBus, requests, getDefaultView(), placeController);
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public OfficeListActivity(HandlerManager eventBus,
      ApplicationRequestFactory requests, RecordListView<OfficeRecord> view,
      PlaceController<ApplicationPlace> placeController) {
    super(view);
    this.eventBus = eventBus;
    this.requests = requests;
    this.placeController = placeController;
  }

  public void createClicked() {
    placeController.goTo(new OfficeScaffoldPlace("", Operation.EDIT));
  }

  public void onStop() {
    registration.removeHandler();
  }

  public void showDetails(OfficeRecord record) {
    placeController.goTo(new OfficeScaffoldPlace(record, Operation.DETAILS));
  }

  public void start(Display display) {
    this.registration = eventBus.addHandler(OfficeRecordChanged.TYPE,
        new OfficeChangedHandler() {
          public void onOfficeChanged(OfficeRecordChanged event) {
            update(event.getWriteOperation(), event.getRecord());
          }
        });
    super.start(display);
  }

  protected RecordListRequest<OfficeRecord> createRangeRequest(Range range) {
    return requests.officeRequest().findOfficeEntries(range.getStart(),
        range.getLength());
  }

  protected void fireCountRequest(Receiver<Long> callback) {
    requests.officeRequest().countOffices().to(callback).fire();
  }
}
