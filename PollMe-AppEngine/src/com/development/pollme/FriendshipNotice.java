package com.development.pollme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

//utilizzata per le amicizie
@Entity
public class FriendshipNotice {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key keyN;
	private String senderN;
	private String receiverN;
	//read può essere s/n (norifica letta o no?)
	private char read;
	//type può essere richiesta/risposta
	private String type;
	
	   public Key getKeyN() {
	        return keyN;
	    }

	    public String getSenderN() {
	        return senderN;
	    }
	    public void setSenderN(String send) {
	        this.senderN = send;
	    }

	    public String getReceiverN() {
	        return receiverN;
	    }
	    public void setReceiverN(String receive) {
	        this.receiverN = receive;
	    }

	    public char getRead() {
	        return read;
	    }
	    public void setRead(char r) {
	        read = r;
	    }
	    
	    public String getType() {
	        return type;
	    }
	    public void setType(String t) {
	        this.type = t;
	    }
}
