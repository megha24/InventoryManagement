package com.megs.services;


import com.megs.models.Supplier;

import java.sql.SQLDataException;
import java.util.List;

public interface ISupplierService {
    public List<Supplier> getAll();

    void saveSupplier(Supplier supplier) throws SQLDataException;
}
