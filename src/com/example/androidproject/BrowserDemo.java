package com.example.androidproject;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser_demo);
		
	/*	 WebChromeClient wvcc = new WebChromeClient() {  
	            @Override  
	            public void onReceivedTitle(WebView view, String title) {  
	                super.onReceivedTitle(view, title);  
	            }  
	        };  */
	        
		init();
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void init() {
		WebView webView = (WebView)findViewById(R.id.webView);
		/*WebSettings settings=webView.getSettings();
		settings.setJavaScriptEnabled(true);*/
		
		WebSettings webSettings = webView.getSettings();
        //webSettings.setPluginsEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

		//webView.loadUrl("http://www.baidu.com/");
		//webView.loadUrl("http://192.168.1.95:60002/shopInfo/ShopIndex?bid=10015");
	    webView.loadUrl("http://192.168.1.95:60002/content/ShopMng/html/shopLogin.html");
		
		//µ÷ÓÃAndroidÄÚÖÃä¯ÀÀÆ÷
		webView.setWebViewClient(new MyWebViewClient());  
	}
	
	private class MyWebViewClient extends WebViewClient {  
        public boolean shouldOverrideUrlLoading(WebView view, String url) {  
            view.loadUrl(url);  
            return true;  
        }  
    }  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.browser_demo, menu);
		return true;
	}

}
