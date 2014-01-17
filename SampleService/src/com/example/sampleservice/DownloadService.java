package com.example.sampleservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public class DownloadService extends IntentService {

  private int result = Activity.RESULT_CANCELED;
  public static final String URL = "urlpath";
  public static final String FILENAME = "filename";
  public String stringsuf = "Not a suffix";
  public static final String RESULT = "result";
  public static final String NOTIFICATION = "com.example.sampleservice";

  public DownloadService() {
    super("DownloadService");
  }

  // will be called asynchronously by Android
  @Override
  protected void onHandleIntent(Intent intent) {
	 
  /*  String urlPath = intent.getStringExtra(URL);
    String fileName = intent.getStringExtra(FILENAME);
    File output = new File(Environment.getExternalStorageDirectory(),
        fileName);
    if (output.exists()) {
      output.delete();
    }

    InputStream stream = null;
    FileOutputStream fos = null;
    try {

      URL url = new URL(urlPath);
      stream = url.openConnection().getInputStream();
      InputStreamReader reader = new InputStreamReader(stream);
      fos = new FileOutputStream(output.getPath());
      int next = -1;
      while ((next = reader.read()) != -1) {
        fos.write(next);
      }
      // successfully finished */
      result = Activity.RESULT_OK;
/*
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (stream != null) {
        try {
          stream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }*/
    Bundle bund=intent.getExtras();
    if(bund.getString("key1").endsWith(bund.getString("key2"))) {this.stringsuf="Yes it is a suffix"; }
    publishResults(new String("Publishing results"), result);
  }

  private void publishResults(String outputPath, int result) {
    Intent intent = new Intent(NOTIFICATION);
    Bundle bund=new Bundle();
    bund.putString(new String("outputPath"), this.stringsuf);
    bund.putInt("result", result);
    intent.putExtras(bund);
    sendBroadcast(intent);
  }
} 