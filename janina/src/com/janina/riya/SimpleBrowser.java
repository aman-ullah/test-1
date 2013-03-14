package com.janina.riya;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class SimpleBrowser extends  Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		WebView ourbrow= (WebView)findViewById(R.id.wvBrowser);
		ourbrow.loadUrl("http://www.google.com");
	}

}
