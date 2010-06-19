package com.nevada.nevada;

import com.nevada.nevada.EmployeeDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect EmployeeIntegrationTest_Roo_IntegrationTest {
    
    declare @type: EmployeeIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: EmployeeIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private EmployeeDataOnDemand EmployeeIntegrationTest.dod;
    
    @Test
    public void EmployeeIntegrationTest.testCountEmployees() {
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to initialize correctly", dod.getRandomEmployee());
        long count = com.nevada.nevada.Employee.countEmployees();
        org.junit.Assert.assertTrue("Counter for 'Employee' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void EmployeeIntegrationTest.testFindEmployee() {
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to initialize correctly", dod.getRandomEmployee());
        java.lang.Long id = dod.getRandomEmployee().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to provide an identifier", id);
        com.nevada.nevada.Employee obj = com.nevada.nevada.Employee.findEmployee(id);
        org.junit.Assert.assertNotNull("Find method for 'Employee' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Employee' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void EmployeeIntegrationTest.testFindAllEmployees() {
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to initialize correctly", dod.getRandomEmployee());
        long count = com.nevada.nevada.Employee.countEmployees();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Employee', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.nevada.nevada.Employee> result = com.nevada.nevada.Employee.findAllEmployees();
        org.junit.Assert.assertNotNull("Find all method for 'Employee' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'Employee' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void EmployeeIntegrationTest.testFindEmployeeEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to initialize correctly", dod.getRandomEmployee());
        long count = com.nevada.nevada.Employee.countEmployees();
        if (count > 20) count = 20;
        java.util.List<com.nevada.nevada.Employee> result = com.nevada.nevada.Employee.findEmployeeEntries(0, (int)count);
        org.junit.Assert.assertNotNull("Find entries method for 'Employee' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'Employee' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void EmployeeIntegrationTest.testFlush() {
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to initialize correctly", dod.getRandomEmployee());
        java.lang.Long id = dod.getRandomEmployee().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to provide an identifier", id);
        com.nevada.nevada.Employee obj = com.nevada.nevada.Employee.findEmployee(id);
        org.junit.Assert.assertNotNull("Find method for 'Employee' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyEmployee(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Employee' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void EmployeeIntegrationTest.testMerge() {
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to initialize correctly", dod.getRandomEmployee());
        java.lang.Long id = dod.getRandomEmployee().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to provide an identifier", id);
        com.nevada.nevada.Employee obj = com.nevada.nevada.Employee.findEmployee(id);
        org.junit.Assert.assertNotNull("Find method for 'Employee' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyEmployee(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Employee' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void EmployeeIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to initialize correctly", dod.getRandomEmployee());
        com.nevada.nevada.Employee obj = dod.getNewTransientEmployee(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Employee' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Employee' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void EmployeeIntegrationTest.testRemove() {
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to initialize correctly", dod.getRandomEmployee());
        java.lang.Long id = dod.getRandomEmployee().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Employee' failed to provide an identifier", id);
        com.nevada.nevada.Employee obj = com.nevada.nevada.Employee.findEmployee(id);
        org.junit.Assert.assertNotNull("Find method for 'Employee' illegally returned null for id '" + id + "'", obj);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'Employee' with identifier '" + id + "'", com.nevada.nevada.Employee.findEmployee(id));
    }
    
}
