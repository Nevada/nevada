package com.nevada.nevada;

import com.nevada.nevada.Office;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect OfficeDataOnDemand_Roo_DataOnDemand {
    
    declare @type: OfficeDataOnDemand: @Component;
    
    private Random OfficeDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Office> OfficeDataOnDemand.data;
    
    public Office OfficeDataOnDemand.getNewTransientOffice(int index) {
        com.nevada.nevada.Office obj = new com.nevada.nevada.Office();
        obj.setLocation("location_" + index);
        obj.setName("name_" + index);
        return obj;
    }
    
    public Office OfficeDataOnDemand.getSpecificOffice(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Office obj = data.get(index);
        return Office.findOffice(obj.getId());
    }
    
    public Office OfficeDataOnDemand.getRandomOffice() {
        init();
        Office obj = data.get(rnd.nextInt(data.size()));
        return Office.findOffice(obj.getId());
    }
    
    public boolean OfficeDataOnDemand.modifyOffice(Office obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void OfficeDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.nevada.nevada.Office.findOfficeEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Office' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.nevada.nevada.Office>();
        for (int i = 0; i < 10; i++) {
            com.nevada.nevada.Office obj = getNewTransientOffice(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
