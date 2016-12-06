package com.wavent.services;

import com.wavent.bean.Event;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */
public interface EventService {

    Event createEvent(Event event);

    Event findEventById(String id);

    List<Event> getAllEvents();

    List<Event> getEventsByCreator(String creator);

    List<Event> getEventsByParticipants(ObjectId participant);

}
