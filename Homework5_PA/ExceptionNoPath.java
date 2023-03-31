package org.example;

public class ExceptionNoPath extends Exception{
    private String str;

    public ExceptionNoPath(String str){
        this.str=str;
    }
    public String toString() {
        return str;
    }

}
