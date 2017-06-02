package com.megs.dao;

import com.megs.models.Supplier;

import java.sql.SQLDataException;
import java.util.List;

public interface SupplierDao {
    public List<Supplier> getAll();

    void saveSupplier(Supplier supplier) throws SQLDataException;
}
