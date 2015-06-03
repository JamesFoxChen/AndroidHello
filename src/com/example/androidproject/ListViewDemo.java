package com.example.androidproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.bean.ListViewItemData;

public class ListViewDemo extends Activity {
    private ListView mListView;
    //private boolean scrollFlag = false;// 标记是否滑动
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_demo);

		 mListView = (ListView) this.findViewById(R.id.listview);

		// 创建简单适配器SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, this.getItem(),
				//itemId等为HashMap中的key值
				R.layout.listviewitem, new String[] {"itemId","itemTitle", "itemPhoto",
						"itemSummary", "itemAuthor", "itemPublishtime" },
				//R.id.id等listviewitem.xml的控件Id
				new int[] {R.id.id,R.id.title, R.id.photograph, R.id.summary,
						R.id.author, R.id.publishtime });

		// 加载SimpleAdapter到ListView中
		mListView.setAdapter(simpleAdapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
				
				////parent就是ListView，view表示Item视图，position表示数据索引 (相对位置)
				ListView lv = (ListView)parent;  
		        HashMap<String,String> item = (HashMap<String,String>)lv.getItemAtPosition(position);//SimpleAdapter返回Map 
		        
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
			data.setId("主键编号:" + Integer.toString(i));
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


/*mListView.setOnScrollListener(new OnScrollListener() {

@Override
public void onScrollStateChanged(AbsListView view, int scrollState) {
	// TODO Auto-generated method stub
	switch (scrollState) {
	// 当不滚动时
	case OnScrollListener.SCROLL_STATE_IDLE://是当屏幕停止滚动时
		scrollFlag = false;
		// 判断滚动到底部
		if (mListView.getLastVisiblePosition() == (mListView.getCount() - 1)) {
			//toTopBtn.setVisibility(View.VISIBLE);
		}
		// 判断滚动到顶部
		if (mListView.getFirstVisiblePosition() == 0) {
			//toTopBtn.setVisibility(View.GONE);
		}

		break;
	case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:// 滚动时
		scrollFlag = true;
		break;
	case OnScrollListener.SCROLL_STATE_FLING:// 是当用户由于之前划动屏幕并抬起手指，屏幕产生惯性滑动时
		scrollFlag = false;
		break;
	}
}

@Override
public void onScroll(AbsListView view, int firstVisibleItem,
		int visibleItemCount, int totalItemCount) {
	// TODO Auto-generated method stub
	
}
});*/
