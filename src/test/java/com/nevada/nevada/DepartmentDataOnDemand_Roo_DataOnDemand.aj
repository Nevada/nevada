package com.nevada.nevada;

import com.nevada.nevada.Department;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DepartmentDataOnDemand_Roo_DataOnDemand {
    
    declare @type: DepartmentDataOnDemand: @Component;
    
    private Random DepartmentDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Department> DepartmentDataOnDemand.data;
    
    public Department DepartmentDataOnDemand.getNewTransientDepartment(int index) {
        com.nevada.nevada.Department obj = new com.nevada.nevada.Department();
        obj.setName("name_" + index);
        return obj;
    }
    
    public Department DepartmentDataOnDemand.getSpecificDepartment(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Department obj = data.get(index);
        return Department.findDepartment(obj.getId());
    }
    
    public Department DepartmentDataOnDemand.getRandomDepartment() {
        init();
        Department obj = data.get(rnd.nextInt(data.size()));
        return Department.findDepartment(obj.getId());
    }
    
    public boolean DepartmentDataOnDemand.modifyDepartment(Department obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void DepartmentDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.nevada.nevada.Department.findDepartmentEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Department' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.nevada.nevada.Department>();
        for (int i = 0; i < 10; i++) {
            com.nevada.nevada.Department obj = getNewTransientDepartment(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
