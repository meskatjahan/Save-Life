package com.meskat.save_life;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddProfile extends Activity implements OnClickListener{

	Button addinfo;
	EditText name,bloodgroup,etLd,eaddress,etTD,etPhone,etarea;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_profile);
		
		Button addInfo =(Button) findViewById(R.id.btnAdded);
		addInfo.setOnClickListener(this);
		
		name = (EditText) findViewById(R.id.name);
		name.setOnClickListener(this);
		
		bloodgroup= (EditText) findViewById(R.id.bloodgroup);
		bloodgroup.setOnClickListener(this);
		
		eaddress = (EditText)findViewById(R.id.etaddress);
		eaddress.setOnClickListener(this);
		
		etLd = (EditText) findViewById(R.id.etLd);
		etLd.setOnClickListener(this);
		
		etTD= (EditText) findViewById(R.id.etTD);
		etTD.setOnClickListener(this);
		
		etPhone = (EditText) findViewById(R.id.etPhone);
		etPhone.setOnClickListener(this);
		
		etarea = (EditText) findViewById(R.id.etarea);
		etarea.setOnClickListener(this);
		
	}
	
	public AddProfile() {
		// TODO Auto-generated constructor stub
		
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId()) {
		case R.id.btnAdded:      
											boolean workornot= true;
										try{
											String name1 =name.getText().toString();
											String bloodgroup1 =bloodgroup.getText().toString();
											String eaddress1 =eaddress.getText().toString();
											String etLd1 =etLd.getText().toString();
											String etTD1 = etTD.getText().toString();
											String etPhone1 =etPhone.getText().toString();
											String etarea1 =etarea.getText().toString();
											
											db entry = new db(AddProfile.this);
											entry.open();
											
											entry.createEntry(name1,bloodgroup1,eaddress1,etarea1,etPhone1,etTD1,etLd1);
											
											entry.close();
											
											
										}
										catch(Exception e){
											
											workornot = false;
												String error = e.toString();
												Dialog d = new Dialog(this);
												d.setTitle("Ohh no...");
												TextView tv = new TextView(this);
												tv.setText(error);
												d.setContentView(tv);
												d.show();
												
										}
										finally{
											if(workornot){
												Dialog d = new Dialog(this);
												d.setTitle("Works");
												TextView tv = new TextView(this);
												tv.setText("Success");
												d.setContentView(tv);
												d.show();
												
												
												
											}
										}
										break;
		case R.id.btnhome: 
			               Intent i = new Intent(AddProfile.this,MainActivity.class);
			               startActivity(i);
			               break;
		
	}
		
	}									
		
	
}

