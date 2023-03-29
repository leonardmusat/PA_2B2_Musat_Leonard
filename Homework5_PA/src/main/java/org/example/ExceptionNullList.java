package org.example;

public class ExceptionNullList extends Exception{
    private String str;

    public ExceptionNullList(String str){
        this.str=str;
    }
    public String toString() {
        return str;
    }
}
