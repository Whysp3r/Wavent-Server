package com.wavent.servicesImpl;

import com.wavent.bean.Event;
import com.wavent.repository.EventRepository;
import com.wavent.services.EventService;
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
