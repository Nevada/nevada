package com.nevada.nevada;

import com.nevada.nevada.Employee;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect EmployeeDataOnDemand_Roo_DataOnDemand {
    
    declare @type: EmployeeDataOnDemand: @Component;
    
    private Random EmployeeDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Employee> EmployeeDataOnDemand.data;
    
    public Employee EmployeeDataOnDemand.getNewTransientEmployee(int index) {
        com.nevada.nevada.Employee obj = new com.nevada.nevada.Employee();
        obj.setDepartment("department_" + index);
        obj.setUserName(null);
        return obj;
    }
    
    public Employee EmployeeDataOnDemand.getSpecificEmployee(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Employee obj = data.get(index);
        return Employee.findEmployee(obj.getId());
    }
    
    public Employee EmployeeDataOnDemand.getRandomEmployee() {
        init();
        Employee obj = data.get(rnd.nextInt(data.size()));
        return Employee.findEmployee(obj.getId());
    }
    
    public boolean EmployeeDataOnDemand.modifyEmployee(Employee obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void EmployeeDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.nevada.nevada.Employee.findEmployeeEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Employee' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.nevada.nevada.Employee>();
        for (int i = 0; i < 10; i++) {
            com.nevada.nevada.Employee obj = getNewTransientEmployee(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
