package org.example;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String title;
    private String location; //file name or Web page

    public Document() {
    }

    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    private Map<String, Object> tags = new HashMap<>();

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", tags= " + tags +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

}
