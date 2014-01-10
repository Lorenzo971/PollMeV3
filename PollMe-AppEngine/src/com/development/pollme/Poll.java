package com.development.pollme;

import java.util.Date;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.Persistent;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key keyPoll;
	private String title;
	private String creator;
	private Date creationDate;
	private char close;
    
    public Key getKeyPoll() {
        return keyPoll;
    }

    public String getTitle() {
        return title;
    }
    
    public String getCreator() {
        return creator;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }
    
    public char getClose() {
        return close;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setCreationDate(Date date) {
        creationDate = date;
    }
}