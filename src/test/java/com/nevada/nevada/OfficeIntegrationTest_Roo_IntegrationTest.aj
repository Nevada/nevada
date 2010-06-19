package com.nevada.nevada;

import com.nevada.nevada.OfficeDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect OfficeIntegrationTest_Roo_IntegrationTest {
    
    declare @type: OfficeIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: OfficeIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private OfficeDataOnDemand OfficeIntegrationTest.dod;
    
    @Test
    public void OfficeIntegrationTest.testCountOffices() {
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to initialize correctly", dod.getRandomOffice());
        long count = com.nevada.nevada.Office.countOffices();
        org.junit.Assert.assertTrue("Counter for 'Office' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void OfficeIntegrationTest.testFindOffice() {
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to initialize correctly", dod.getRandomOffice());
        java.lang.Long id = dod.getRandomOffice().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to provide an identifier", id);
        com.nevada.nevada.Office obj = com.nevada.nevada.Office.findOffice(id);
        org.junit.Assert.assertNotNull("Find method for 'Office' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Office' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void OfficeIntegrationTest.testFindAllOffices() {
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to initialize correctly", dod.getRandomOffice());
        long count = com.nevada.nevada.Office.countOffices();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Office', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.nevada.nevada.Office> result = com.nevada.nevada.Office.findAllOffices();
        org.junit.Assert.assertNotNull("Find all method for 'Office' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'Office' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void OfficeIntegrationTest.testFindOfficeEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to initialize correctly", dod.getRandomOffice());
        long count = com.nevada.nevada.Office.countOffices();
        if (count > 20) count = 20;
        java.util.List<com.nevada.nevada.Office> result = com.nevada.nevada.Office.findOfficeEntries(0, (int)count);
        org.junit.Assert.assertNotNull("Find entries method for 'Office' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'Office' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void OfficeIntegrationTest.testFlush() {
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to initialize correctly", dod.getRandomOffice());
        java.lang.Long id = dod.getRandomOffice().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to provide an identifier", id);
        com.nevada.nevada.Office obj = com.nevada.nevada.Office.findOffice(id);
        org.junit.Assert.assertNotNull("Find method for 'Office' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyOffice(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Office' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void OfficeIntegrationTest.testMerge() {
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to initialize correctly", dod.getRandomOffice());
        java.lang.Long id = dod.getRandomOffice().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to provide an identifier", id);
        com.nevada.nevada.Office obj = com.nevada.nevada.Office.findOffice(id);
        org.junit.Assert.assertNotNull("Find method for 'Office' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyOffice(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Office' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void OfficeIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to initialize correctly", dod.getRandomOffice());
        com.nevada.nevada.Office obj = dod.getNewTransientOffice(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Office' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Office' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void OfficeIntegrationTest.testRemove() {
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to initialize correctly", dod.getRandomOffice());
        java.lang.Long id = dod.getRandomOffice().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Office' failed to provide an identifier", id);
        com.nevada.nevada.Office obj = com.nevada.nevada.Office.findOffice(id);
        org.junit.Assert.assertNotNull("Find method for 'Office' illegally returned null for id '" + id + "'", obj);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'Office' with identifier '" + id + "'", com.nevada.nevada.Office.findOffice(id));
    }
    
}
