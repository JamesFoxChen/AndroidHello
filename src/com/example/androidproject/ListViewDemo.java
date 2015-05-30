package com.example.androidproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.example.bean.ListViewItemData;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViewDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_demo);

		ListView mListView = (ListView) this.findViewById(R.id.listview);

		// ������������SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, this.getItem(),
				//itemId��ΪHashMap�е�keyֵ
				R.layout.listviewitem, new String[] {"itemId","itemTitle", "itemPhoto",
						"itemSummary", "itemAuthor", "itemPublishtime" },
				//R.id.id��listviewitem.xml�Ŀؼ�Id
				new int[] {R.id.id,R.id.title, R.id.photograph, R.id.summary,
						R.id.author, R.id.publishtime });

		// ����SimpleAdapter��ListView��
		mListView.setAdapter(simpleAdapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
				
				////parent����ListView��view��ʾItem��ͼ��position��ʾ�������� (���λ��)
				ListView lv = (ListView)parent;  
		        HashMap<String,String> item = (HashMap<String,String>)lv.getItemAtPosition(position);//SimpleAdapter����Map 
		        
				AlertDialog.Builder builder = new AlertDialog.Builder(ListViewDemo.this); 
				builder.setTitle(item.get("itemId"));  
			    builder.setMessage(item.get("itemPublishtime"));
			    builder.show(); 
			}
		});
	}

	public ArrayList<HashMap<String, String>> getItem() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		ArrayList<ListViewItemData> lstData = new ArrayList<ListViewItemData>();
		for (int i = 1; i <= 5; i++) {
			ListViewItemData data = new ListViewItemData();
			data.setId("�������:" + Integer.toString(i));
			data.setTitle("title:" + Integer.toString(i));
			data.setPhotoResId("photoResId:" + Integer.toString(i));
			data.setSummary("summary" + Integer.toString(i));
			data.setAuthor("author:" + Integer.toString(i));
			data.setPublishtime("publishtime:" + Integer.toString(i)
					+ df.format(new Date()));
			

			lstData.add(data);
		}

		ArrayList<HashMap<String, String>> item = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < lstData.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("itemId", lstData.get(i).getId());
			map.put("itemTitle", lstData.get(i).getTitle());
			map.put("itemPhoto", lstData.get(i).getPhotoResId());
			map.put("itemSummary", lstData.get(i).getSummary());
			map.put("itemAuthor", lstData.get(i).getAuthor());
			map.put("itemPublishtime", lstData.get(i).getPublishtime());
			item.add(map);
		}
		return item;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view_demo, menu);
		return true;
	}

}
