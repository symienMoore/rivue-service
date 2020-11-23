package com.sam.rivueservices.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rivue {
    private String title;
    private String body;
    private int rating;
    private User user;
}
