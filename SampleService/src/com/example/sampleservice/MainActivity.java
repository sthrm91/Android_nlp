package com.example.sampleservice;



import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

  private TextView textView,txtvw;
  EditText et1,et2;
  Button button1;
  private BroadcastReceiver receiver = new BroadcastReceiver() {

    @Override
    public void onReceive(Context context, Intent intent) {
      Bundle bundle = intent.getExtras();
      if (bundle != null) {
         
        int resultCode = bundle.getInt("result");
        if (resultCode == RESULT_OK) {
          Toast.makeText(MainActivity.this,
              "the result of processing:" + bundle.getString(new String("outputPath")),
              Toast.LENGTH_LONG).show();
          txtvw.setText("Is that a suffix : "+bundle.getString(new String("outputPath")));
        } else {
          Toast.makeText(MainActivity.this, "Download failed",
              Toast.LENGTH_LONG).show();
          txtvw.setText("Lowercase word: ");
        }
      }
    }
  };

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = (TextView) findViewById(R.id.status);
    txtvw= (TextView) findViewById(R.id.status2);
    et1 = (EditText) findViewById(R.id.input1);
	et2 = (EditText) findViewById(R.id.input2);
	button1 = (Button) findViewById(R.id.button1);
	button1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			 Intent intent = new Intent(getApplicationContext(), DownloadService.class);
		
			    String a = et1.getText().toString();
				String b = et2.getText().toString();
				Bundle bund = new Bundle();
				bund.putString("key1", a);
				bund.putString("key2", b);
			    intent.putExtras(bund);
			    startService(intent);
			    textView.setText("Service started");
			
		}
	});    

  }

  @Override
  protected void onResume() {
    super.onResume();
    registerReceiver(receiver, new IntentFilter(DownloadService.NOTIFICATION));
  }
  @Override
  protected void onPause() {
    super.onPause();
    unregisterReceiver(receiver);
  }

} 
