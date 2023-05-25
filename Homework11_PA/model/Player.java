package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    private String name;

    public Player(@JsonProperty("name") String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }

}
