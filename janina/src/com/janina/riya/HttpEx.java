package com.janina.riya;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HttpEx extends Activity {
	TextView httpStuff;
	HttpClient client;
	final static String URL = "http://api.twitter.com/1/statuses/user_timeline.json";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		httpStuff = (TextView) findViewById(R.id.tvHttp);
		client = new DefaultHttpClient();
	}

	public JSONObject lasttweet(String username)
			throws ClientProtocolException, IOException, JSONException {
		StringBuilder url = new StringBuilder(URL);
		HttpGet get = new HttpGet(url.toString());
		HttpResponse r=client.execute(get);
		int status=r.getStatusLine().getStatusCode();
		if(status==200){
			HttpEntity e= r.getEntity();
			String data= EntityUtils.toString(e);
			JSONArray timeline= new JSONArray(data);
			JSONObject last=timeline.getJSONObject(0);
			return last;
		}else{
			Toast.makeText(HttpEx.this, "error",Toast.LENGTH_LONG);
			return null;
		}

		/*
		 * GetMethodEx test=new GetMethodEx(); String returned; try { returned =
		 * test.GetInternetData(); httpStuff.setText(returned); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}

}
