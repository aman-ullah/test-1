package com.janina.riya;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{
    MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle riyatravis) {
		// TODO Auto-generated method stub
		super.onCreate(riyatravis);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this,R.raw.splash_sound);
		SharedPreferences getpref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music= getpref.getBoolean("checkbox", true);
		if(music==true) ourSong.start();
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					
					Intent openStartingPoint = new Intent("com.janina.riya.MENU");
					startActivity(openStartingPoint);
				}
				
			}
		};
		timer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
    


}
