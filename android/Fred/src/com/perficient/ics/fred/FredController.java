package com.perficient.ics.fred;

import java.util.Locale;
 
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class FredController extends Activity implements TextToSpeech.OnInitListener {
  /** Called when the activity is first created. */

  private TextToSpeech tts;
  private Button btnSpeak;
  private EditText txtText;

  private String message;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    tts = new TextToSpeech(this, this);

    btnSpeak = (Button) findViewById(R.id.btnSpeak);

    txtText = (EditText) findViewById(R.id.txtText);

    // button on click event
    btnSpeak.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View arg0) {
        speakOut();
      }

    });

    String readTwitterFeed = readTwitterFeed();
    try {
      JSONArray jsonArray = new JSONArray(readTwitterFeed);
      Log.i(FredController.class.getName(),
          "Number of entries " + jsonArray.length());
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        Log.i(FredController.class.getName(), jsonObject.getString("text"));
        this.setMessage(jsonObject.getString("text"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onDestroy() {
    // Don't forget to shutdown tts!
    if (tts != null) {
      tts.stop();
      tts.shutdown();
    }
    super.onDestroy();
  }

  @Override
  public void onInit(int status) {

    if (status == TextToSpeech.SUCCESS) {
      int result = tts.setLanguage(Locale.US);

      if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
        Log.e("TTS", "This Language is not supported");
      } else {
        btnSpeak.setEnabled(true);
        speakOut();
      }

    } else {
      Log.e("TTS", "Initilization Failed!");
    }

  }

  private void speakOut() {
    //String text = txtText.getText().toString();
    String text = this.getMessage();
    tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
  }

  public String readTwitterFeed() {
    StringBuilder builder = new StringBuilder();
    HttpClient client = new DefaultHttpClient();
    HttpGet httpGet = new HttpGet("https://api.twitter.com/1/statuses/user_timeline.json?include_entities=true&include_rts=true&screen_name=YomDom&count=2");
    try {
      HttpResponse response = client.execute(httpGet);
      StatusLine statusLine = response.getStatusLine();
      int statusCode = statusLine.getStatusCode();
      if (statusCode == 200) {
        HttpEntity entity = response.getEntity();
        InputStream content = entity.getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
        String line;
        while ((line = reader.readLine()) != null) {
          builder.append(line);
        }
      } else {
        Log.e(FredController.class.toString(), "Failed to download file");
      }
    } catch (ClientProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return builder.toString();
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}
