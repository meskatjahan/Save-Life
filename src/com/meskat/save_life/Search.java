package com.meskat.save_life;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Search extends Activity implements OnClickListener{

	
	Button btnSearch;
	EditText etbl;
	
	TextView rebl,tvph,tvRe;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		
		btnSearch = (Button) findViewById(R.id.btnSearch);
		btnSearch.setOnClickListener(this);
		
	
		
		etbl = (EditText) findViewById(R.id.etbl);
		etbl.setOnClickListener(this);
		rebl = (TextView)findViewById(R.id.rebl);
		tvph =  (TextView)findViewById(R.id.tvph);
		tvRe = (TextView) findViewById(R.id.tvRe);
		
	
	}
	public Search() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getId()== R.id.btnSearch){
			
			String s = etbl.getText().toString();
			db t = new db(this);
			t.open();
			String returnName =t.getName(s);
			String returnBl = t.getBl(s);
			String returnph = t.getPhone(s);
			
			t.close();
			
			tvRe.setText(returnName);
			rebl.setText(returnBl);
			tvph.setText(returnph);
			
			
		}
		
	}

}
