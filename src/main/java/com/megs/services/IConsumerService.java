package com.megs.services;

import com.megs.models.Consumer;

import java.sql.SQLDataException;
import java.util.List;

public interface IConsumerService {
    List<Consumer> getAll();

    void saveConsumer(Consumer consumer) throws SQLDataException;
}
