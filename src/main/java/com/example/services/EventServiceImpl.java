package com.example.services;

import com.example.bean.Event;
import com.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */
@Service(value = "EventService")
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository repository;

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }
}
