package com.wavent.controllers;

import com.wavent.bean.Event;
import com.wavent.bean.User;
import com.wavent.services.EventService;
import org.bson.types.ObjectId;
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

    @RequestMapping(value = "/creator/{id}", method =  RequestMethod.GET)
    public List<Event> getEventsByCreator(@PathVariable String id){
        return this.eventService.getEventsByCreator(id);
    }

    @RequestMapping(value = "/participant/{id}", method =  RequestMethod.GET)
    public List<Event> getEventsByParticipant(@PathVariable String id){
        ObjectId objId = new ObjectId(id);
        return this.eventService.getEventsByParticipants(objId);
    }

    @RequestMapping(value = "/addParticipantTo/{eventId}",method =  RequestMethod.POST)
    public Event addParticipant(@PathVariable String eventId,@RequestBody User user){
        Event eventToAdd = this.eventService.findEventById(eventId);
        if(eventToAdd.getParticipants().size()<eventToAdd.getNbParticipantsMax()){
            eventToAdd.addParticipant(user);
            this.eventService.createEvent(eventToAdd);
            return this.eventService.findEventById(eventToAdd.getId());
        } else {
            throw new IllegalArgumentException("event full");
        }
    }



}
