package com.janina.riya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {
	EditText personEmail, Intro, personName, stupidThings, HatefulAction,
			Outro;
	String emailAdd, begining, name, stupidThing, hatefulAct, Out;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializer();
		sendEmail.setOnClickListener(this);
	}

	private void initializer() {
		// TODO Auto-generated method stub
		personEmail = (EditText) findViewById(R.id.et1);
		Intro = (EditText) findViewById(R.id.et2);
		personName = (EditText) findViewById(R.id.et3);
		stupidThings = (EditText) findViewById(R.id.et4);
		HatefulAction = (EditText) findViewById(R.id.et5);
		Outro = (EditText) findViewById(R.id.et6);

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		convertEditTextIntoString();
		String EmailAddress[]={emailAdd};
		String message="Well hello" +name + "i just wanted to say"
		+ begining + "not only that but i hate you when" 
				+ stupidThing + ",that just really makes me crazy.I just want to make you"
				+ hatefulAct +"well, thats all i wanted to chitchatter about oh and" + Out ;
		Intent emailIntent=new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailAdd );
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "i hate you");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		
		
	}

	private void convertEditTextIntoString() {
		// TODO Auto-generated method stub
		emailAdd = personEmail.getText().toString();
		begining= Intro.getText().toString();
		name=personName.getText().toString();
		stupidThing=stupidThings.getText().toString();
		hatefulAct =HatefulAction.getText().toString();
		Out=Outro.getText().toString();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}
