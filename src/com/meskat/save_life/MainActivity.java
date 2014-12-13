package com.meskat.save_life;



import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener, android.view.View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnSearch = (Button) findViewById(R.id.btnSearch);
		btnSearch.setOnClickListener(this);
		
		
		Button btnDonate = (Button) findViewById(R.id.btnDonate);
		btnDonate.setOnClickListener(this);
		
		Button btnAddNewInfo =(Button) findViewById(R.id.btnAddNewInfo);
		btnAddNewInfo.setOnClickListener(this);
		
		Button btnView =(Button) findViewById(R.id.btnView);
		btnView.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getId()== R.id.btnSearch){
			
												 Intent intent = new Intent(MainActivity.this,Search.class);
												 startActivity(intent);
												}
		
		else if (arg0.getId()== R.id.btnDonate) {
												Intent intent = new Intent(MainActivity.this,Profile.class);
												startActivity(intent);
												}
		
		else if (arg0.getId()==R.id.btnAddNewInfo){
													Intent intent = new Intent(MainActivity.this,AddProfile.class);
													startActivity(intent);
												  }
		else if(arg0.getId()==R.id.btnView) {
			
			
			Intent intent = new Intent(MainActivity.this,Profile.class);
			startActivity(intent);
		}
		
	}

}
