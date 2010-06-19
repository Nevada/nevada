package com.nevada.nevada;

import com.nevada.nevada.Department;
import java.lang.Integer;
import java.lang.Long;
import java.lang.SuppressWarnings;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Department_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Department.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Department.id;
    
    @Version
    @Column(name = "version")
    private Integer Department.version;
    
    public Long Department.getId() {
        return this.id;
    }
    
    public void Department.setId(Long id) {
        this.id = id;
    }
    
    public Integer Department.getVersion() {
        return this.version;
    }
    
    public void Department.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Department.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Department.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Department attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Department.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Department Department.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Department merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Department.entityManager() {
        EntityManager em = new Department().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Department.countDepartments() {
        return ((Number) entityManager().createQuery("select count(o) from Department o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Department> Department.findAllDepartments() {
        return entityManager().createQuery("select o from Department o").getResultList();
    }
    
    public static Department Department.findDepartment(Long id) {
        if (id == null) return null;
        return entityManager().find(Department.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Department> Department.findDepartmentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Department o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
