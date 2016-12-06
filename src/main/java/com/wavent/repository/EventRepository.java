package com.wavent.repository;

import com.wavent.bean.Event;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */
@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findByCreator(String creator);

    @Query("{'participants._id' : ?0 }")
    List<Event> findByParticipantsId(ObjectId id);

}
