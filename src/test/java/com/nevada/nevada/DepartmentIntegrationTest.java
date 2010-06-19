package com.nevada.nevada;

import org.springframework.roo.addon.test.RooIntegrationTest;
import com.nevada.nevada.Department;
import org.junit.Test;

@RooIntegrationTest(entity = Department.class)
public class DepartmentIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
