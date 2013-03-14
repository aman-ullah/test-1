package com.janina.riya;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class soundstuff extends Activity implements OnClickListener{

	int explotion=0;
	SoundPool sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View v= new View(this);
		v.setOnClickListener(this);
		setContentView(v);
	    sp=new SoundPool(5,AudioManager.STREAM_MUSIC,0);
		//explotion=sp.load(this, R.id.explotion, 1);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(explotion!=0)
		sp.play(explotion, 1, 1, 0,0,1);
	}
	

}
