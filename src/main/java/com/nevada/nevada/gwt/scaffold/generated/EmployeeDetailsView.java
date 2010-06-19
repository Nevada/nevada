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

import com.nevada.nevada.gwt.request.EmployeeRecord;

/**
 * Details view for Employee records.
 */
public class EmployeeDetailsView extends Composite implements
    RecordDetailsView<EmployeeRecord> {
  interface Binder extends UiBinder<HTMLPanel, EmployeeDetailsView> {
  }

  private static final Binder BINDER = GWT.create(Binder.class);

  EmployeeRecord record;
  @UiField
  SpanElement department;
  @UiField
  SpanElement userName;
  @UiField
  SpanElement idSpan;
  @UiField
  SpanElement versionSpan;
  @UiField
  HasClickHandlers edit;
  @UiField
  HasClickHandlers delete;

  private Delegate delegate;

  public EmployeeDetailsView() {
    initWidget(BINDER.createAndBindUi(this));
  }

  public Widget asWidget() {
    return this;
  }
  
  public boolean confirm(String msg) {
    return Window.confirm(msg);
  }

  public EmployeeRecord getValue() {
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

  public void setValue(EmployeeRecord record) {
    this.record = record;
    department.setInnerText(String.valueOf(record.getDepartment()));
    userName.setInnerText(String.valueOf(record.getUserName()));
    idSpan.setInnerText(record.getId());
    versionSpan.setInnerText(record.getVersion().toString());
  }
}
