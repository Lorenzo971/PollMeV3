package com.development.pollme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

//questa entity indica l'immagine scelta x ogni poll e x ogni utente
@Entity
public class Results {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key keyR;
	private Key pollK;
	private Key imgK;
	private String user;
	
	   public Key getKeyR() {
	        return keyR;
	    }

	    public Key getPollKey() {
	        return pollK;
	    }
	    public void setPollKey(Key key) {
	        this.pollK = key;
	    }

	    public Key getImgKey() {
	        return imgK;
	    }
	    public void setImgK(Key key) {
	        this.imgK = key;
	    }

	    public String getUser() {
	        return user;
	    }
	    public void setUser(String userResult) {
	        user = userResult;
	    }

}
