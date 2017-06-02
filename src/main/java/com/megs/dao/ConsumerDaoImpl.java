package com.megs.dao;

import com.megs.models.Consumer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLDataException;
import java.util.List;

@Repository
@Transactional
public class ConsumerDaoImpl implements ConsumerDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Consumer> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Consumer> cq = builder.createQuery(Consumer.class);
        Root<Consumer> root = cq.from(Consumer.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
        }

    @Override
    public void saveConsumer(Consumer consumer) throws SQLDataException {
        try {

            entityManager.persist(consumer);
        }catch (Exception ex){
            throw new SQLDataException("can not be inserted");
        }
    }
}
