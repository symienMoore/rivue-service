package com.sam.rivueservices.services;

import com.sam.rivueservices.entities.Rivue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sam.rivueservices.repositories.RivueRepository;

@Service
public class RivueService {

    @Autowired
    private RivueRepository rivueRepo;
    private Rivue rivue;

    public void addRivue(Rivue rivue) {
        rivueRepo.save(rivue);
    }
}
