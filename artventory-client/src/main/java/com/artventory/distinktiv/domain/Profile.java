package com.artventory.distinktiv.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Profile {

    private Long id;

    private String name;

    public Profile() {}

    public Profile(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profile) {
            Profile p = (Profile) obj;
            return getName().equals(p.getName());
        } else {
            return false;
        }
    }
}
