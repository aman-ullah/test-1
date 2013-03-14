package com.janina.riya;

import java.sql.SQLException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLview extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView tv = (TextView) findViewById(R.id.tvsqlInfo);
		HotOrNot info = new HotOrNot(this);

		try {
			info.open();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data = info.getData();
		info.close();
		tv.setText(data);
	}

}
