package com.nevada.nevada.gwt.scaffold.place;
public interface ApplicationPlaceProcessor {
    void process(ApplicationListPlace object);
    void process(OfficeScaffoldPlace place);
    void process(EmployeeScaffoldPlace place);
    void process(DepartmentScaffoldPlace place);
}
