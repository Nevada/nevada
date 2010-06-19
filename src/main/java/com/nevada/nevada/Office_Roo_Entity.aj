package com.nevada.nevada;

import com.nevada.nevada.Office;
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

privileged aspect Office_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Office.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Office.id;
    
    @Version
    @Column(name = "version")
    private Integer Office.version;
    
    public Long Office.getId() {
        return this.id;
    }
    
    public void Office.setId(Long id) {
        this.id = id;
    }
    
    public Integer Office.getVersion() {
        return this.version;
    }
    
    public void Office.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Office.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Office.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Office attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Office.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Office Office.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Office merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Office.entityManager() {
        EntityManager em = new Office().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Office.countOffices() {
        return ((Number) entityManager().createQuery("select count(o) from Office o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Office> Office.findAllOffices() {
        return entityManager().createQuery("select o from Office o").getResultList();
    }
    
    public static Office Office.findOffice(Long id) {
        if (id == null) return null;
        return entityManager().find(Office.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Office> Office.findOfficeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Office o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
