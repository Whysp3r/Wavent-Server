package com.wavent.controllers;

import com.wavent.bean.Event;
import com.wavent.services.EventService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */

@RestController @RequestMapping(value="/events")
public class EventController {

    @Resource
    private EventService eventService;

    @RequestMapping(method =  RequestMethod.POST)
    public Event createEvent(@RequestBody Event event){
        this.eventService.createEvent(event);
        return this.eventService.findEventById(event.getId());
    }

    @RequestMapping(method =  RequestMethod.GET)
    public List<Event> getAllEvents(){
        return this.eventService.getAllEvents();
    }

    @RequestMapping(value = "/user/{id}", method =  RequestMethod.GET)
    public List<Event> getEventsByUser(@PathVariable String id){
        return this.eventService.getAllEventForSpecificUser(id);
    }


}
