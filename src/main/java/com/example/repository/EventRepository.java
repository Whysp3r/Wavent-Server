package com.example.repository;

import com.example.bean.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */
@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    public Event findEventByName(String name);

}
