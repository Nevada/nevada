package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.valuestore.shared.Value;
import com.google.gwt.valuestore.ui.AbstractRecordEditActivity;
import com.google.gwt.valuestore.ui.RecordEditView;
import com.nevada.nevada.gwt.request.OfficeRecord;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.nevada.gwt.scaffold.place.OfficeScaffoldPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.nevada.gwt.scaffold.generated.OfficeEditView;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace.Operation;


/**
 * An activity that requests all info on an Office, allows the user to edit
 * it, and persists the results.
 */
public class OfficeEditActivity extends
    AbstractRecordEditActivity<OfficeRecord> {
  private static RecordEditView<OfficeRecord> defaultView;

  private static RecordEditView<OfficeRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new OfficeEditView();
    }
    return defaultView;
  }

  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  /**
   * Creates an activity that uses the default singleton view instance.
   */
  public OfficeEditActivity(String id, ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(id, getDefaultView(), requests, placeController);
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public OfficeEditActivity(String id, RecordEditView<OfficeRecord> view,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    super(view, id, requests);
    this.requests = requests;
    this.placeController = placeController;
  }


  protected void exit() {
    placeController.goTo(new OfficeScaffoldPlace(getId(), Operation.DETAILS));
  }

  protected void fireFindRequest(Value<String> id,
      Receiver<OfficeRecord> callback) {
    requests.officeRequest().findOffice(id).to(callback).fire();
  }

  protected String getRecordToken() {
    return OfficeRecord.TOKEN;
  }
}
