package ru.isupden.weblab3.dao;


import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import ru.isupden.weblab3.model.Hit;

import java.io.Serializable;
import java.util.List;

@Named("HitDao")
public class HitDao implements Serializable {
    @PersistenceContext(unitName = "hits")
    EntityManager entityManager;

    @Transactional
    public void saveHit(Hit hit) {
        entityManager.persist(hit);
    }

    public List<Hit> getHits() {
        return entityManager.createQuery("from Hit", Hit.class).getResultList();
    }

    @Transactional
    public void clear() {
        entityManager.createQuery("DELETE FROM Hit").executeUpdate();
    }
}
