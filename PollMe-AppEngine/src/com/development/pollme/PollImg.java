package com.development.pollme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

//memorizza le chiavi di tutte le immagini utilizzate nei polls
@Entity
public class PollImg {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Key keyPI;
	   private Key imgK;
	   private Key pollK;
	   //descrizione dell'imagine, facoltativa
	   private String description;
	   
	    public Key getKeyPI() {
	        return keyPI;
	    }

	    public Key getImageK() {
	        return imgK;
	    }
	    public void setImageK(Key key) {
	        this.imgK = key;
	    }

	    public Key getPollK() {
	        return pollK;
	    }
	    public void setPollK(Key key) {
	        this.pollK = key;
	    }

	    public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String desc) {
	        description = desc;
	    }
	   
}
