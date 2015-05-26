package com.example.androidproject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.bean.Person;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DateAndWeather extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_date_and_weather);
		returnToMain();
	}
	
	private void returnToMain()
	{
		Button btnReturn = (Button) findViewById(R.id.btnReturnDate);
		btnReturn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(DateAndWeather.this, MainActivity.class);
				DateAndWeather.this.startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void getCurrentDate(View source) {
		TextView tv = (TextView) findViewById(R.id.show);  

		String s = getIntent().getExtras().getString("keyString");
		Person p = (Person) getIntent().getExtras().getSerializable("keyObject");  

		tv.setText("keyString:"+s+" object:"+String.valueOf(p.getAge()) + "：当前时间:" + new java.util.Date());
	}

	TextView response;
	HttpClient httClient;

	public void getWuHanWeather(View source) {
		this.httClient = new DefaultHttpClient();
		this.response = (TextView) findViewById(R.id.show);

		getWeather(source);
	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0x123) {
				response.setText("");
				response.setText(msg.obj.toString() + "\n");
			}
		}
	};

	public void getWeather(View v) {
		String type = "";
		int inputValue=Integer.parseInt(((EditText) findViewById(R.id.editText1)).getText().toString());
		if (inputValue== 1) {
			type = "101200101";
		} else {
			type = "101200401";
		}

		final String cityId = type;
		new Thread() {
			@Override
			public void run() {
				// 创建一个HttpGet对象
				String url = "http://www.weather.com.cn/adat/sk/" + cityId
						+ ".html";
				HttpGet get = new HttpGet(url);

				// HttpGet get = new HttpGet(
				// "http://www.weather.com.cn/adat/sk/101200101.html");
				try {
					// 发送GET请求
					HttpResponse httpResponse = httClient.execute(get);
					String json = EntityUtils.toString(
							httpResponse.getEntity(), "UTF-8");

					Message msg = new Message();
					msg.what = 0x123;
					msg.obj = json;
					handler.sendMessage(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
