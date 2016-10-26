package com.wavent.repository;

import com.wavent.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arnaud on 26/10/16.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

        public User findUserByMail(String name);

        public User findUserById(String id);

}
