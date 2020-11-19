package com.sam.rivueservices.repositories;

import com.sam.rivueservices.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUsername(String username);
}
