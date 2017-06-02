package com.megs.dao;

import com.megs.models.Consumer;

import java.sql.SQLDataException;
import java.util.List;

public interface ConsumerDao {
    List<Consumer> getAll();

    void saveConsumer(Consumer consumer) throws SQLDataException;
}
