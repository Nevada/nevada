package com.nevada.nevada;

import org.springframework.roo.addon.test.RooIntegrationTest;
import com.nevada.nevada.Employee;
import org.junit.Test;

@RooIntegrationTest(entity = Employee.class)
public class EmployeeIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
