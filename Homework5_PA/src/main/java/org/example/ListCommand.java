package org.example;

public class ListCommand implements Command {
    private String documentation = "This command print all the objects";

    public void list(Catalog cat) throws ExceptionNullList{
        if(cat.getList().isEmpty())
            throw new ExceptionNullList("List is empty");
        System.out.println("Lista de documente este: " + cat.getList());
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
        return "ListCommand{" +
                "documentation='" + documentation + '\'' +
                '}';
    }
}
