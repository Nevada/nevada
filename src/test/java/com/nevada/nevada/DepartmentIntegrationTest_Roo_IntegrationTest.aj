package com.nevada.nevada;

import com.nevada.nevada.DepartmentDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DepartmentIntegrationTest_Roo_IntegrationTest {
    
    declare @type: DepartmentIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: DepartmentIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private DepartmentDataOnDemand DepartmentIntegrationTest.dod;
    
    @Test
    public void DepartmentIntegrationTest.testCountDepartments() {
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to initialize correctly", dod.getRandomDepartment());
        long count = com.nevada.nevada.Department.countDepartments();
        org.junit.Assert.assertTrue("Counter for 'Department' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void DepartmentIntegrationTest.testFindDepartment() {
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to initialize correctly", dod.getRandomDepartment());
        java.lang.Long id = dod.getRandomDepartment().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to provide an identifier", id);
        com.nevada.nevada.Department obj = com.nevada.nevada.Department.findDepartment(id);
        org.junit.Assert.assertNotNull("Find method for 'Department' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Department' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void DepartmentIntegrationTest.testFindAllDepartments() {
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to initialize correctly", dod.getRandomDepartment());
        long count = com.nevada.nevada.Department.countDepartments();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Department', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.nevada.nevada.Department> result = com.nevada.nevada.Department.findAllDepartments();
        org.junit.Assert.assertNotNull("Find all method for 'Department' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'Department' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void DepartmentIntegrationTest.testFindDepartmentEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to initialize correctly", dod.getRandomDepartment());
        long count = com.nevada.nevada.Department.countDepartments();
        if (count > 20) count = 20;
        java.util.List<com.nevada.nevada.Department> result = com.nevada.nevada.Department.findDepartmentEntries(0, (int)count);
        org.junit.Assert.assertNotNull("Find entries method for 'Department' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'Department' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void DepartmentIntegrationTest.testFlush() {
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to initialize correctly", dod.getRandomDepartment());
        java.lang.Long id = dod.getRandomDepartment().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to provide an identifier", id);
        com.nevada.nevada.Department obj = com.nevada.nevada.Department.findDepartment(id);
        org.junit.Assert.assertNotNull("Find method for 'Department' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyDepartment(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Department' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void DepartmentIntegrationTest.testMerge() {
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to initialize correctly", dod.getRandomDepartment());
        java.lang.Long id = dod.getRandomDepartment().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to provide an identifier", id);
        com.nevada.nevada.Department obj = com.nevada.nevada.Department.findDepartment(id);
        org.junit.Assert.assertNotNull("Find method for 'Department' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyDepartment(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Department' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void DepartmentIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to initialize correctly", dod.getRandomDepartment());
        com.nevada.nevada.Department obj = dod.getNewTransientDepartment(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Department' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Department' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void DepartmentIntegrationTest.testRemove() {
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to initialize correctly", dod.getRandomDepartment());
        java.lang.Long id = dod.getRandomDepartment().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Department' failed to provide an identifier", id);
        com.nevada.nevada.Department obj = com.nevada.nevada.Department.findDepartment(id);
        org.junit.Assert.assertNotNull("Find method for 'Department' illegally returned null for id '" + id + "'", obj);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'Department' with identifier '" + id + "'", com.nevada.nevada.Department.findDepartment(id));
    }
    
}
