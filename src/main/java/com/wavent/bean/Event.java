package com.wavent.bean;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by arnaud on 26/10/16.
 */

public class Event {

    @Id
    private String id;

    private String name;
    private String subject;
    private String address;
    private Date date;
    private String pictureEvent;
    private String creator;
    private List<User> participants = new ArrayList<User>();
    private List<Message> messages = new ArrayList<Message>();
    private int nbParticipantsMax;
    private boolean finished;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public void addParticipant(User user){
        this.participants.add(user);
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getNbParticipantsMax() {
        return nbParticipantsMax;
    }

    public void setNbParticipantsMax(int nbParticipantsMax) {
        this.nbParticipantsMax = nbParticipantsMax;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date.toGMTString() +
                ", pictureEvent='" + pictureEvent + '\'' +
                ", creator='" + creator + '\'' +
                ", participants=" + participants.toString() +
                ", finished=" + finished +
                '}';
    }
}
