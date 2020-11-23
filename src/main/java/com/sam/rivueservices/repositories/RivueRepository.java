package com.sam.rivueservices.repositories;

import com.sam.rivueservices.entities.Rivue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RivueRepository extends MongoRepository<Rivue, String> {

    Rivue findRivueByTitle(String title);
}
