package com.development.pollme;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key keyF;
    private String sender;
    private String receiver;
    private Date requestDate;
    
    public Key getKeyF() {
        return keyF;
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String send) {
        this.sender = send;
    }

    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receive) {
        this.receiver = receive;
    }

    public Date getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(Date date) {
        requestDate = date;
    }
}
