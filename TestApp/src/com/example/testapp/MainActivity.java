package com.example.testapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv1;
	EditText et1,et2;
	Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.addButton);
		et1 = (EditText) findViewById(R.id.input1);
		et2 = (EditText) findViewById(R.id.input2);
		tv1 = (TextView) findViewById(R.id.text1);
		
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int a = Integer.parseInt(et1.getText().toString());
				int b = Integer.parseInt(et2.getText().toString());
				Log.i("hello", Integer.toString(a));
				int c=a+b;
				Bundle bund = new Bundle();
				bund.putInt("zxc", c);
				
				Intent i = new Intent(getApplicationContext(),SecondScreen.class);
				i.putExtras(bund);
				startActivity(i);
				
				
				tv1.setText(Integer.toString(a+b));
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
