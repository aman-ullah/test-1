package com.janina.riya;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity{

	MyBringBack ourview;
	WakeLock wl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		PowerManager pM=(PowerManager)getSystemService(Context.POWER_SERVICE);
		wl= pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		wl.acquire();
		ourview=new MyBringBack(this);
		
		setContentView(ourview);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wl.release();
	}
	

}
