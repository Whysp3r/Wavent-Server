package com.example.controllers;

import com.example.bean.Event;
import com.example.services.EventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */

@RestController @RequestMapping(value="/events")
public class EventController {

    @Resource
    private EventService eventService;

    @RequestMapping(method =  RequestMethod.GET)
    public List<Event> getAllEvents(){
        return this.eventService.getAllEvents();
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
