package com.megs.services;

import com.megs.dao.SupplierDao;
import com.megs.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;
@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    SupplierDao supplierDao;
    @Override
    public List<Supplier> getAll() {
        return supplierDao.getAll();
    }

    @Override
    public void saveSupplier(Supplier supplier) throws SQLDataException {
        supplierDao.saveSupplier(supplier);
    }
}
