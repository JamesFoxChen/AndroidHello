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
		// ��ȡ�����ļ��е�LinearLayout����
		LinearLayout root = (LinearLayout) findViewById(R.id.root);
		// ����DrawView���
		final DrawView draw = new DrawView(this);
		// �����Զ������������ȡ��߶�
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
