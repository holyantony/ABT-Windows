package com.example.gkaakash;
 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.gkaakash.controller.Report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class Help extends Activity {
	Report report;
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.help);
		WebView engine = (WebView)findViewById(R.id.webView1);
		
		loadURL(engine);

	} 

	public void loadURL(WebView engine) {
		// webview for chelp
		System.out.println(MainActivity.IPaddr_value);
		report = new Report(MainActivity.IPaddr_value);
		WebSettings webSettings = engine.getSettings();
		// java script enabled
		webSettings.setJavaScriptEnabled(true);
		// cache problem removed
		webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
		webSettings.setAppCacheEnabled(false);
		
		// scroll bars disabled in webview
		engine.setVerticalScrollBarEnabled(false);
		engine.setHorizontalScrollBarEnabled(false);
		engine.getSettings().setBuiltInZoomControls(true);
		
		File doc_path= new File("/data/local/doc/_build/html/user/user_guide.html");
		if(!doc_path.exists()){
			System.out.println("in if");
			report.copyDocs();
		}
		
		// address of html file in ch root
		//engine.loadUrl("http://10.102.152.127/html/doc/_build/html/index.html"); //uncomment for remote server
		engine.loadUrl("file:///data/local/doc/_build/html/user/user_guide.html"); //comment for remote server
		// enabling all pop ups in web view
	}

}
