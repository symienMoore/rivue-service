package com.sam.rivueservices.controllers;

import com.sam.rivueservices.entities.Rivue;
import com.sam.rivueservices.repositories.RivueRepository;
import com.sam.rivueservices.services.RivueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rivues")
public class RivueController {

    @Autowired
    private RivueRepository rivueRepo;

    @Autowired
    private RivueService service;

    @GetMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity("this is a test", HttpStatus.OK);
    }

    // TODO: create a path to add a rivue and ensure it is being saved correctly
    @PostMapping("/new")
    public void addRivue(@RequestBody Rivue rivue) {
        service.addRivue(rivue);
    }
}
