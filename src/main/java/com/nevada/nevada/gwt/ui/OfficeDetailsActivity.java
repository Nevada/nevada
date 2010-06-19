package com.nevada.nevada.gwt.ui;

import com.google.gwt.app.place.AbstractActivity;
import com.google.gwt.app.place.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.SyncResult;
import com.google.gwt.valuestore.shared.DeltaValueStore;
import com.google.gwt.valuestore.shared.Value;
import com.google.gwt.valuestore.ui.RecordDetailsView;
import com.nevada.nevada.gwt.request.OfficeRecord;
import com.nevada.nevada.gwt.request.ApplicationRequestFactory;
import com.nevada.nevada.gwt.scaffold.place.ApplicationPlace;
import com.nevada.nevada.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.nevada.gwt.scaffold.place.OfficeScaffoldPlace;
import com.nevada.nevada.gwt.scaffold.generated.OfficeDetailsView;
import com.nevada.nevada.gwt.scaffold.place.ApplicationRecordPlace.Operation;

import java.util.Set;

/**
 * An {@link com.google.gwt.app.place.Activity Activity} that requests and
 * displays detailed information on a given Office.
 */
public class OfficeDetailsActivity extends AbstractActivity implements
    RecordDetailsView.Delegate {
  private static RecordDetailsView<OfficeRecord> defaultView;

  private static RecordDetailsView<OfficeRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new OfficeDetailsView();
    }
    return defaultView;
  }

  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;
  private final RecordDetailsView<OfficeRecord> view;
  private String id;
  private Display display;

  /**
   * Creates an activity that uses the default singleton view instance.
   */
  public OfficeDetailsActivity(String id, ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(id, requests, placeController, getDefaultView());
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public OfficeDetailsActivity(String id, ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController,
      RecordDetailsView<OfficeRecord> view) {
    this.placeController = placeController;
    this.id = id;
    this.requests = requests;
    view.setDelegate(this);
    this.view = view;
  }

  public void deleteClicked() {
    if (!view.confirm("Really delete this record? You cannot undo this change.")) {
      return;
    }
    
    DeltaValueStore deltas = requests.getValueStore().spawnDeltaView();
    deltas.delete(view.getValue());
    requests.syncRequest(deltas).to(new Receiver<Set<SyncResult>>() {

      public void onSuccess(Set<SyncResult> response) {
        if (display == null) {
          // This activity is dead
          return;
        }
        
        display.showActivityWidget(null);
      }
    }).fire();
  }

  public void editClicked() {
    placeController.goTo(new OfficeScaffoldPlace(view.getValue(),
        Operation.EDIT));
  }

  public void onCancel() {
    onStop();
  }

  public void onStop() {
    display = null;
  }

  public void start(final Display display) {
    this.display = display;
    Receiver<OfficeRecord> callback = new Receiver<OfficeRecord>() {
      public void onSuccess(OfficeRecord record) {
        view.setValue(record);
        display.showActivityWidget(view);
      }
    };

    requests.officeRequest().findOffice(Value.of(id)).to(callback).fire();
  }
}
