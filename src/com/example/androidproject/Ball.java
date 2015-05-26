package com.example.androidproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Ball extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ball);
		// 获取布局文件中的LinearLayout容器
		LinearLayout root = (LinearLayout) findViewById(R.id.root);
		// 创建DrawView组件
		final DrawView draw = new DrawView(this);
		// 设置自定义组件的最大宽度、高度
		draw.setMinimumWidth(300);
		draw.setMinimumHeight(500);
		root.addView(draw);
		
		returnToMain();
	}
	
	private void returnToMain()
	{
		Button btnReturn = (Button) findViewById(R.id.btnReturnBall);
		btnReturn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Ball.this, MainActivity.class);
				Ball.this.startActivity(intent);
			}
		});
	}

}
