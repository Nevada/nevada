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
import com.nevada.nevada.gwt.request.DepartmentRecord;

import java.util.ArrayList;
import java.util.List;


/**
 * {@link AbstractRecordListView} specialized to {@link DepartmentKey}} values.
 */
public class DepartmentListView extends AbstractRecordListView<DepartmentRecord> {
  interface Binder extends UiBinder<HTMLPanel, DepartmentListView> {
  }

  private static final Binder BINDER = GWT.create(Binder.class);

  @UiField CellTable<DepartmentRecord> table;
  @UiField Button newButton;
  
  public DepartmentListView() {
    init(BINDER.createAndBindUi(this), table, newButton, getColumns());
  }

  protected List<PropertyColumn<DepartmentRecord, ?>> getColumns() {
    // TODO These should be <g:col> elements in a <g:table> in the ui.xml file

    List<PropertyColumn<DepartmentRecord, ?>> columns = new ArrayList<PropertyColumn<DepartmentRecord, ?>>();
    columns.add(new PropertyColumn<DepartmentRecord, java.lang.String>(DepartmentRecord.name, new Renderer<java.lang.String>() {
      public String render(java.lang.String obj) {
        return String.valueOf(obj);
      }    
}));  
    return columns;
  }
}
