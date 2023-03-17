package org.example;

import java.util.Date;

public class Designer extends Person{

    private int imaginationLevel;

    public Designer(String name, String date) {
        super(name, date);
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
