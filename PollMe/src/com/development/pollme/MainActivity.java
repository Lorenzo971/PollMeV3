package com.development.pollme;

/* Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.development.pollme.checkinendpoint.Checkinendpoint;
import com.development.pollme.checkinendpoint.model.CheckIn;
import com.development.pollme.pollendpoint.Pollendpoint;
import com.development.pollme.pollendpoint.model.Poll;
import com.development.pollme.DisplayMessageActivity;
import com.development.pollme.ImageServe;
import com.development.pollme.PhotoActivity;
import com.development.pollme.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends Activity implements OnClickListener{

	// specifico costante pubblica = nome per il messaggio mandato all'altra
		// attività (identificativo)
		public final static String NOME_INTENT = "MESSAGE";
		public final static int imageCode = 100;

		private String imageKey;
		private String imagePath;
		
		private ImageView imageView;
		
		final public int imageServeCode = 101;
		
		private TextView resultsList;
	
	
  @Override
  protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		getActionBar().setDisplayHomeAsUpEnabled(true);

		imageView = (ImageView) findViewById(R.id.imageView1);
		//mImageView2 = (ImageView) findViewById(R.id.imageView3);	

		Button button = (Button) findViewById(R.id.take_photo);
		button.setOnClickListener(this);

		new CheckInTask().execute();
		new PollTask().execute();

  }
  
	// Implement the OnClickListener callback
	public void onClick(View v) {
		// do something when the button is clicked
		//takePhoto(actionCode);
		Intent intent = new Intent(this, PhotoActivity.class);

		startActivityForResult(intent, imageCode);
	}

	// Crea il menù con tutte le opzioni
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

  /**
   * AsyncTask for calling Mobile Assistant API for checking into a place (e.g., a store)
   */
  private class CheckInTask extends AsyncTask<Void, Void, Void> {

    /**
     * Calls appropriate CloudEndpoint to indicate that user checked into a place.
     *
     * @param params the place where the user is checking in.
     */
    @Override
    protected Void doInBackground(Void... params) {
    	
      CheckIn checkin = new CheckIn();
      
      // Set the ID of the store where the user is. 
      // This would be replaced by the actual ID in the final version of the code. 
      checkin.setPlaceId("StoreNo123");

      Checkinendpoint.Builder builder = new Checkinendpoint.Builder(
          AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
          null);
          
      builder = CloudEndpointUtils.updateBuilder(builder);

      Checkinendpoint endpoint = builder.build();
      

      try {
        endpoint.insertCheckIn(checkin).execute();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      return null;
    }
  }
  
  
  private class PollTask extends AsyncTask<Void, Void, Void> {

	    /**
	     * Calls appropriate CloudEndpoint to indicate that user checked into a place.
	     *
	     * @param params the place where the user is checking in.
	     */
	    @Override
	    protected Void doInBackground(Void... params) {
	    	
	      Poll poll = new Poll();
	      
	      // Set the ID of the store where the user is. 
	      // This would be replaced by the actual ID in the final version of the code. 
	      poll.setCreator("pippo");
	      poll.setCreationDate(new DateTime(System.currentTimeMillis()));
	      poll.setTitle("Lorenzo è gay");

	      Pollendpoint.Builder builder = new Pollendpoint.Builder(
	          AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
	          null);
	          
	      builder = CloudEndpointUtils.updateBuilder(builder);

	      Pollendpoint endpoint = builder.build();
	      

	      try {
	        endpoint.insertPoll(poll).execute();
	      } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }

	      return null;
	    }
	  }
  
  
//Risponde alla pressione di un pulsante sul menù
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_search:
	            System.out.println("Premuto Cerca");
	            return true;
	        case R.id.action_settings:
	        	System.out.println("Premuto Settings");
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	
	/**
	 * Called when the user clicks the Send button - Importo elemento View
	 * perchè un bottone è un oggetto view ed è proprio quello che lancia il
	 * click
	 */
	public void sendMessage(View view) { 
		//Do something in response to button

		// intent = messaggio (contesto di appartenenza, a chi devo inviare il
		// messaggio);
		Intent intent = new Intent(this, DisplayMessageActivity.class);

		// importo con findViewById(R.id.edit_message); una determinata risorsa
		// con certo ID
		EditText editText = (EditText) findViewById(R.id.edit_message);

		// lo metto in stringa
		String message = editText.getText().toString();

		// The putExtra() method takes the key name in the first parameter
		// and the value in the second parameter. La prossima applicazione userà
		// il nome
		// NOME_INTENT che è una costante
		intent.putExtra(NOME_INTENT, message);

		// Con questo metodo lancio semplicemente una nuova attività, non dico
		// quale
		// l'intent preso come argomento può essere implicito e dunque lancia
		// un'app generica
		// oppure esplicito, come in questo caso, e sa già quale attività
		// lanciare
		startActivity(intent);

	}


	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		  if (requestCode == 100) {

		     if(resultCode == RESULT_OK){      
		         
		    	 imageKey=data.getStringExtra("imageKey");   
		    	 imagePath=data.getStringExtra("localImagePath");
		    	 
		    	 Intent intent = new Intent(this, ImageServe.class);
		    	 
		    	 intent.putExtra("imageKey", imageKey);

		    	 startActivityForResult(intent, imageServeCode);
		    	 
		     }
		     if (resultCode == RESULT_CANCELED) {    
		         //Write your code if there's no result
		     }
		  } else  if (requestCode == 101){
			  
			  byte[] byteArray = data.getByteArrayExtra("byteArrayImage");
			  Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
			  
			  imageView.setImageBitmap(bitmap);

			  imageView.setVisibility(View.VISIBLE);
			  
		  }
		}//onActivityResult
	

  
  
  
  
}