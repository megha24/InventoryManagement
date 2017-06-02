package com.megs.dao;

import com.megs.models.Supplier;
import org.apache.log4j.Logger;
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
public class SupplierDaoImpl implements SupplierDao {
    @PersistenceContext
    EntityManager entityManager;
    private static final Logger logger  = Logger.getLogger(SupplierDaoImpl.class);

    @Override
    public List<Supplier> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Supplier> cq = builder.createQuery(Supplier.class);
        Root<Supplier> root = cq.from(Supplier.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public void saveSupplier(Supplier supplier) throws SQLDataException {
        try{
            entityManager.persist(supplier);
        }catch (Exception ex){
            throw new SQLDataException();
        }
    }
}
