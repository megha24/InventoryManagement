package com.megs.dao;

import com.megs.models.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class ItemDaoImpl implements ItemDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void insertItem(Item item) {
        entityManager.persist(item);
    }

    @Override
    public List<Item> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> cq = builder.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }
}
