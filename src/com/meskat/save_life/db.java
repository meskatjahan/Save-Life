
package com.meskat.save_life;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class db {
	
	public static final String id="_id";
	public static final String name="Name";
	public static final String address="Adress";
	public static final String bloodgp="Blood_Group";
	public static final String area="Area";
	public static final String phonenb="Phone Number";
	public static final String Td="Total Donation";
	public static final String ld="last Donation";
	private static final String dbname="SaveLife";
	private static final String dbtable="Profile";
	private static final int dbVersion= 1;
	private DbHelper myhelper;
	private final Context myContext;
	private SQLiteDatabase mydb;
	
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context,dbname , null, dbVersion);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase arg0) {
			// TODO Auto-generated method stub
			
			arg0.execSQL("CREATE TABLE "+dbtable+" ("+
			id + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
					name+" TEXT NOT NULL, "+
					bloodgp+" TEXT NOT NULL, "+
					address+" TEXT NOT NULL, "+
					area+" TEXT NOT NULL, "+
					phonenb+" TEXT NOT NULL, "
					+ Td+" INTEGER NOT NULL, "+
					ld+" TEXT NOT NULL);"
					);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			arg0.execSQL("DROP TABLE IF EXITS"+dbtable);
			onCreate(arg0);
			
			
		}
		
		
	}
	
	 
	public db(Context c){
		myContext = c;
	}
	public db open() throws SQLException {
		myhelper = new DbHelper(myContext);
		mydb = myhelper.getReadableDatabase();
		return this;
	}

	public void close(){
		myhelper.close();
	}
	public Long createEntry(String name1, String bloodgroup1, String eaddress1,
			String etarea1, String etPhone1, String etTD1, String etLd1) {
				
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(name, name1);
		cv.put(bloodgp, bloodgroup1);
		cv.put(address, eaddress1);
		cv.put(area, etarea1);
		cv.put(phonenb,etPhone1);
		cv.put(Td, etTD1);
		cv.put(ld, etLd1);
		return mydb.insert(dbtable, null, cv);
		
		
		
	}
	public String getData() {
		// TODO Auto-generated method stub
		String[] column = new String[]{id,name,bloodgp,address,area,phonenb,Td,ld};
		Cursor c = mydb.query(dbtable, column,null, null, null, null,null);
		String result = "";
		int iRow = c.getColumnIndex(id);
		int iName = c.getColumnIndex(name);
		int ibloodgp = c.getColumnIndex(bloodgp);
		int iaddress = c.getColumnIndex(address);
		int iarea = c.getColumnIndex(area);
		int iphonenb = c.getColumnIndex(phonenb);
		int itd = c.getColumnIndex(Td);
		int ild = c.getColumnIndex(ld);
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			
			result = result+" "+c.getString(iRow)+" "+c.getString(iName)+" "+c.getString(ibloodgp)+" "+c.getString(iaddress)+" "+c.getString(iarea)+" "+c.getString(iphonenb)+" "+c.getString(itd)+" "+c.getString(ild)+"\n";
			
		}
		
		
		return result;
	}
	public String getName(String s) {
		// TODO Auto-generated method stub
		
		String[] column = new String[]{id,name,bloodgp,address,area,phonenb,Td,ld};
		Cursor c = mydb.query(dbtable, column,bloodgp+"-"+s, null, null, null,null);
		if(c!=null){
			c.moveToFirst();
			String nameo = c.getString(1);
			return nameo;
		}
		return null;
	}
	public String getBl(String s) {
		// TODO Auto-generated method stub
		String[] column = new String[]{id,name,bloodgp,address,area,phonenb,Td,ld};
		Cursor c = mydb.query(dbtable, column,bloodgp+"-"+s, null, null, null,null);
		if(c!=null){
			c.moveToFirst();
			String bl = c.getString(2);
			return bl;
		}
		return null;
	}
	public String getPhone(String s) {
		// TODO Auto-generated method stub
		String[] column = new String[]{id,name,bloodgp,address,area,phonenb,Td,ld};
		Cursor c = mydb.query(dbtable, column,bloodgp+"-"+s, null, null, null,null);
		if(c!=null){
			c.moveToFirst();
			String phone = c.getString(5);
			return phone;
		}
		
		return null;
	}
}
