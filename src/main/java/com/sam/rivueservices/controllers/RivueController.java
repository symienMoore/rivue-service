package com.sam.rivueservices.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rivues")
public class RivueController {

    @GetMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity("this is a test", HttpStatus.OK);
    }
}
