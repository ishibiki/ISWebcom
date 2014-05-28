package com.ishibiki.iswebcom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Webcom1 extends Activity {
	private TextView mView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webcom1);
		mView=(TextView)findViewById(R.id.view);
		//mView.setText(new String(httpGet("http://www.yahoo.co.jp")));
		mView.setText(new String(httpGet(createURL())));
	}
	public String createURL() {
		String apiURL="http://news.yahooapis.jp/NewsWebService/V2/topics?";
		String appid="xIKkJiWxg67Q6xX1bxyKFokTS8cEMPsvdG1PCyo6jz5K1yYsC5toV3vqkYP061Q2";
		String category = "top";
		return String.format("%sappid=%s&pickupcategory=%s", apiURL, appid,category);
	}


	public static String httpGet(String strURL){
		try {
			URL url = new URL(strURL);
			URLConnection connection = url.openConnection();
			connection.setDoInput(true);
			InputStream stream = connection.getInputStream();
			BufferedReader input=new BufferedReader(new InputStreamReader(stream));
			String data = "";
			String tmp = "";
			while((tmp=input.readLine())!=null){
				data+=tmp;
			}
			stream.close();
			input.close();
			return data;
		}
		catch (Exception e){
			return e.toString();
		}
	}

}