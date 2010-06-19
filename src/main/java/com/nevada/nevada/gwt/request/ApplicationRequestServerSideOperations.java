package com.nevada.nevada.gwt.request;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.google.gwt.requestfactory.shared.RequestFactory.Config;
import com.google.gwt.requestfactory.shared.RequestFactory.RequestDefinition;
import com.google.gwt.valuestore.shared.Record;
public class ApplicationRequestServerSideOperations implements Config {
    private final Map<String, RequestDefinition> map;
    public Map<String, RequestDefinition> requestDefinitions() {
        return map;
    }
    private static void putAll(RequestDefinition[] values, Map<String, RequestDefinition> newMap) {
        for (RequestDefinition def : values) {
            newMap.put(def.name(), def);
        }
    }
    public ApplicationRequestServerSideOperations() {
        Map<String, RequestDefinition> newMap = new HashMap<String, RequestDefinition>();
        putAll(OfficeRequestServerSideOperations.values(), newMap);
        putAll(EmployeeRequestServerSideOperations.values(), newMap);
        putAll(DepartmentRequestServerSideOperations.values(), newMap);
        map = Collections.unmodifiableMap(newMap);
    }
    public Set<Class<? extends Record>> recordTypes() {
        Set<Class<? extends Record>> records = new HashSet<Class<? extends Record>>();
        records.add(OfficeRecord.class);
        records.add(EmployeeRecord.class);
        records.add(DepartmentRecord.class);
        return records;
    }
}
