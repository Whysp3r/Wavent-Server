package com.wavent.bean;

import org.springframework.data.annotation.Id;

/**
 * Created by arnaud on 26/10/16.
 */

public class Event {

    @Id
    private String id;

    private String name;
    private String Description;
    private String pictureEvent;

    public Event() {

    }

    public Event(String name, String description) {
        this.name = name;
        Description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPictureEvent() {
        return pictureEvent;
    }

    public void setPictureEvent(String pictureEvent) {
        this.pictureEvent = pictureEvent;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
