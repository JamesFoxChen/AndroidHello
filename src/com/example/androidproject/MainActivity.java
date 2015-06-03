package com.example.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.example.bean.Person;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnTime = (Button) findViewById(R.id.btnTime);
		btnTime.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, DateAndWeather.class);

				Bundle b = new Bundle();
				b.putString("keyString", "Activity传递的值");

				Person p = new Person();
				p.setAge(11);
				p.setName("11Name");
				//传递对象，对象需继承于Serializable
				b.putSerializable("keyObject",p);

				intent.putExtras(b);

				MainActivity.this.startActivity(intent);
			}
		});

		Button btnBall = (Button) findViewById(R.id.btnBall);
		btnBall.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Ball.class);
				MainActivity.this.startActivity(intent);
			}
		});		
		
		btnListViewClick();
		btnDateTimeDemoClick();
	/*	avosCreate();*/
	}
    
	private void avosCreate()
	{
		AVOSCloud.initialize(this, "b8f9mag81ij216uespf0i6ne0joyqgyzd8z0m6l6ql1n1spm", "ca13nre9ymi7vna0ba9w3jteg9rxws9506i5qgex9edgwuae");	
		AVObject testObject = new AVObject("TestObject");
		testObject.put("foo", "bar");
		testObject.saveInBackground();
	}
	
	private void btnListViewClick() {
		Button btn = (Button) findViewById(R.id.btnListView);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ListViewDemo.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}
	
	private void btnDateTimeDemoClick()
	{
		Button btn = (Button) findViewById(R.id.btnDateTimeDemo);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, DateTimeDemo.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
