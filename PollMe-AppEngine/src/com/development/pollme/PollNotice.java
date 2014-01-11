package com.development.pollme;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

//Notifica di poll
@Entity
public class PollNotice {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Key keyPN;
	 private Key pollK;
	 private String senderP;
	 private String receiverP;
	 private Date noticeDate;
	 //il poll è stato letto dall'utente? s/n
	 private char readP;
	 //TODO: il creatore è da mettere?
	 
	 public Key getKeyPN() {
	        return keyPN;
	    }

	    public Key getPollK() {
	        return pollK;
	    }
	    public void setPollK(Key key) {
	        this.pollK = key;
	    }

	    public String getSenderP() {
	        return senderP;
	    }
	    public void setSenderP(String send) {
	        this.senderP = send;
	    }
	    
	    public String getReceiverP() {
	        return receiverP;
	    }
	    public void setReceiverP(String receive) {
	        this.receiverP = receive;
	    }

	    public Date getNoticeDate() {
	        return noticeDate;
	    }
	    
	    public void setNoticeDate(Date date) {
	        noticeDate = date;
	    }
	 
	    public char getReadP(){
	    	return readP;
	    }
	    
	    public void setReadP(char r){
	    	this.readP = r;
	    }
}
