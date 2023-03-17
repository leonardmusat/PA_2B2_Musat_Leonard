package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Programmer extends Person {

    private List<String> programmingLanguage = new ArrayList<>();
    public Programmer(String name, String date) {
        super(name, date);

    }

    public Programmer(){

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
