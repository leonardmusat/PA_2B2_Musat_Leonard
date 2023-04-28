package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Class Cell represents a cell from the map
 * It contains a list of tokens
 */
public class Cell {
    List<Token> list = new ArrayList<>();

    public Cell(){
        Token tok = new Token(-1);
        list.add(tok);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "list=" + list +
                '}';
    }

    List<Token> getList(){
        return list;
    }
    void setList(List<Token> temp){
        list = temp;
    }

}
