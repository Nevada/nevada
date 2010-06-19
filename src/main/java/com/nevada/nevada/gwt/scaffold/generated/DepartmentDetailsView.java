package com.nevada.nevada.gwt.scaffold.generated;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.valuestore.ui.RecordDetailsView;

import com.nevada.nevada.gwt.request.DepartmentRecord;

/**
 * Details view for Department records.
 */
public class DepartmentDetailsView extends Composite implements
    RecordDetailsView<DepartmentRecord> {
  interface Binder extends UiBinder<HTMLPanel, DepartmentDetailsView> {
  }

  private static final Binder BINDER = GWT.create(Binder.class);

  DepartmentRecord record;
  @UiField
  SpanElement name;
  @UiField
  SpanElement idSpan;
  @UiField
  SpanElement versionSpan;
  @UiField
  HasClickHandlers edit;
  @UiField
  HasClickHandlers delete;

  private Delegate delegate;

  public DepartmentDetailsView() {
    initWidget(BINDER.createAndBindUi(this));
  }

  public Widget asWidget() {
    return this;
  }
  
  public boolean confirm(String msg) {
    return Window.confirm(msg);
  }

  public DepartmentRecord getValue() {
    return record;
  }

  @UiHandler("delete")
  public void onDeleteClicked(@SuppressWarnings("unused") ClickEvent e) {
    delegate.deleteClicked();
  }

  @UiHandler("edit")
  public void onEditClicked(@SuppressWarnings("unused") ClickEvent e) {
    delegate.editClicked();
  }

  public void setDelegate(Delegate delegate) {
    this.delegate = delegate;
  }

  public void setValue(DepartmentRecord record) {
    this.record = record;
    name.setInnerText(String.valueOf(record.getName()));
    idSpan.setInnerText(record.getId());
    versionSpan.setInnerText(record.getVersion().toString());
  }
}
