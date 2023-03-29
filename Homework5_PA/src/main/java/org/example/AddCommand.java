package org.example;

import java.util.List;

public class AddCommand implements Command {

    private String documentation = "This Command add a new document in catalog";

    public void add(Document doc, List<Document> list) throws ExceptionNoPath, ExceptionUncompletedField{
        if (doc.getLocation() == null)
            throw new ExceptionNoPath("The path can not be null");
        else if (doc.getId() == null)
            throw new ExceptionUncompletedField("Id can t be null");
        else if (doc.getTitle() == null)
            throw new ExceptionUncompletedField("Title can not be null");
        list.add(doc) ;
    }

    @Override
    public String getDocumentation() {
        return documentation;
    }

    @Override
    public void setDocumentation(String str) {
       this.documentation = str;
    }

    @Override
    public String toString() {
        return "AddCommand{" +
                "documentation='" + documentation + '\'' +
                '}';
    }
}
