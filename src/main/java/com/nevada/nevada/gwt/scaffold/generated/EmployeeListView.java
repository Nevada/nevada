package com.nevada.nevada.gwt.scaffold.generated;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.valuestore.ui.AbstractRecordListView;
import com.google.gwt.valuestore.ui.PropertyColumn;
import com.google.gwt.app.util.DateTimeFormatRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.app.util.Renderer;
import com.nevada.nevada.gwt.request.EmployeeRecord;

import java.util.ArrayList;
import java.util.List;


/**
 * {@link AbstractRecordListView} specialized to {@link EmployeeKey}} values.
 */
public class EmployeeListView extends AbstractRecordListView<EmployeeRecord> {
  interface Binder extends UiBinder<HTMLPanel, EmployeeListView> {
  }

  private static final Binder BINDER = GWT.create(Binder.class);

  @UiField CellTable<EmployeeRecord> table;
  @UiField Button newButton;
  
  public EmployeeListView() {
    init(BINDER.createAndBindUi(this), table, newButton, getColumns());
  }

  protected List<PropertyColumn<EmployeeRecord, ?>> getColumns() {
    // TODO These should be <g:col> elements in a <g:table> in the ui.xml file

    List<PropertyColumn<EmployeeRecord, ?>> columns = new ArrayList<PropertyColumn<EmployeeRecord, ?>>();
    columns.add(new PropertyColumn<EmployeeRecord, java.lang.String>(EmployeeRecord.department, new Renderer<java.lang.String>() {
      public String render(java.lang.String obj) {
        return String.valueOf(obj);
      }    
}));  
    columns.add(new PropertyColumn<EmployeeRecord, java.lang.String>(EmployeeRecord.userName, new Renderer<java.lang.String>() {
      public String render(java.lang.String obj) {
        return String.valueOf(obj);
      }    
}));  
    return columns;
  }
}
