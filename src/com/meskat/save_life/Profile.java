package com.meskat.save_life;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Profile extends Activity {

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
		
		TextView view = (TextView) findViewById(R.id.view);
		db info = new db(this);
		info.open();
		String data = info.getData();
		info.close();
		view.setText(data);
		
		
	
	}
	public Profile() {
		// TODO Auto-generated constructor stub
	}

}
