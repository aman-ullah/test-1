package com.janina.riya;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SqlLiteExample extends Activity implements OnClickListener {

	Button sqlupdate, sqlview;
	TextView sqlname, sqlhotness;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlliteexample);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		sqlhotness = (TextView) findViewById(R.id.tvhotness);
		sqlname = (TextView) findViewById(R.id.tvname);
		sqlupdate = (Button) findViewById(R.id.bSqlUpdate);
		sqlview = (Button) findViewById(R.id.bSqlOpenView);
		sqlview.setOnClickListener(this);
		sqlupdate.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSqlOpenView:
			//Intent i = new Intent("com.janina.riya.SQLVIEW");
			//startActivity(i);
			break;
		case R.id.bSqlUpdate:

			boolean diditwork = true;
			try {
				String name = sqlname.getText().toString();
				String hotness = sqlhotness.getText().toString();
				HotOrNot entry = new HotOrNot(SqlLiteExample.this);
				entry.open();
				entry.createEntry(name, hotness);
				entry.close();
			} catch (Exception e) {
				diditwork = false;
			} finally {
				Dialog d = new Dialog(this);
				d.setTitle("heck yeah!");
				TextView tv = new TextView(this);
				tv.setText("succcess");
				d.setContentView(tv);
				d.show();

			}
			break;

		}

	}

}
