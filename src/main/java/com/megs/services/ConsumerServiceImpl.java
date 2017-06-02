package com.megs.services;

import com.megs.dao.ConsumerDao;
import com.megs.models.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class ConsumerServiceImpl implements IConsumerService {
    @Autowired
    ConsumerDao consumerDao;
    @Override
    public List<Consumer> getAll() {
        return consumerDao.getAll();
    }

    @Override
    public void saveConsumer(Consumer consumer) throws SQLDataException {
        consumerDao.saveConsumer(consumer);
    }
}
