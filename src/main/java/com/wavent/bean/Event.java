package com.wavent.bean;

import org.springframework.data.annotation.Id;

/**
 * Created by arnaud on 26/10/16.
 */

public class Event {

    @Id
    private String id;

    private String name;
    private String subject;
    private String pictureEvent;
    private String creator;

    public Event() {

    }

    public Event(String name, String subject) {
        this.name = name;
        this.subject = subject;
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

    public String getPictureEvent() {
        return pictureEvent;
    }

    public void setPictureEvent(String pictureEvent) {
        this.pictureEvent = pictureEvent;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Description='" + subject + '\'' +
                '}';
    }
}
