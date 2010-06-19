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
import com.nevada.nevada.gwt.request.OfficeRecord;

import java.util.ArrayList;
import java.util.List;


/**
 * {@link AbstractRecordListView} specialized to {@link OfficeKey}} values.
 */
public class OfficeListView extends AbstractRecordListView<OfficeRecord> {
  interface Binder extends UiBinder<HTMLPanel, OfficeListView> {
  }

  private static final Binder BINDER = GWT.create(Binder.class);

  @UiField CellTable<OfficeRecord> table;
  @UiField Button newButton;
  
  public OfficeListView() {
    init(BINDER.createAndBindUi(this), table, newButton, getColumns());
  }

  protected List<PropertyColumn<OfficeRecord, ?>> getColumns() {
    // TODO These should be <g:col> elements in a <g:table> in the ui.xml file

    List<PropertyColumn<OfficeRecord, ?>> columns = new ArrayList<PropertyColumn<OfficeRecord, ?>>();
    columns.add(new PropertyColumn<OfficeRecord, java.lang.String>(OfficeRecord.location, new Renderer<java.lang.String>() {
      public String render(java.lang.String obj) {
        return String.valueOf(obj);
      }    
}));  
    columns.add(new PropertyColumn<OfficeRecord, java.lang.String>(OfficeRecord.name, new Renderer<java.lang.String>() {
      public String render(java.lang.String obj) {
        return String.valueOf(obj);
      }    
}));  
    return columns;
  }
}
