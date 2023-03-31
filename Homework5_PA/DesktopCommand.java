package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DesktopCommand implements Command {

    private String documentation = "This command open a decument";
    public void desktop(File file) throws IOException {
        Desktop desk = Desktop.getDesktop();
        if(file.exists()) desk.open(file);
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
        return "DesktopCommand{" +
                "documentation='" + documentation + '\'' +
                '}';
    }
}
