package com.example.androidproject;

import com.example.bean.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
