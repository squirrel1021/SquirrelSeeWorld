package com.linyuxing.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.linyuxing.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

@ContentView(R.layout.carnest_service_violation_activity)
public class WebViewTest extends Activity {

	@ViewInject(R.id.web_view)
	WebView webView;
	

	private String travelUrl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		ViewUtils.inject(this);
		getUrl();
//		initView();
		
	}

	private void getUrl() {
		// TODO Auto-generated method stub
		if (null != getIntent()) {
			travelUrl = getIntent().getStringExtra("tag_url");
			System.out.println(travelUrl);
			initView();
		}
	}

	private void initView() {
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(travelUrl);
		webView.getSettings().setUseWideViewPort(false); // 将图片调整到适合webview的大小
		webView.getSettings().setSupportZoom(true); // 支持缩放
		webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN); // 支持内容重新布局
		webView.getSettings().supportMultipleWindows(); // 多窗口
		webView.getSettings().setCacheMode(
				webView.getSettings().LOAD_CACHE_ELSE_NETWORK); // 关闭webview中缓存
		webView.getSettings().setAllowFileAccess(true); // 设置可以访问文件
		webView.getSettings().setNeedInitialFocus(true); // 当webview调用requestFocus时为webview设置节点
		webView.getSettings().setBuiltInZoomControls(true); // 设置支持缩放
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); // 支持通过JS打开新窗口
		webView.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
		webView.getSettings().setLoadsImagesAutomatically(true); // 支持自动加载图片
		webView.getSettings().setUseWideViewPort(true);// 设置此属性，可任意比例缩放
		webView.getSettings().setSupportZoom(true);
		webView.requestFocusFromTouch();
		
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
				view.loadUrl(url);
				return true;
			}
		});
	}
	
	public boolean onKeyDown(int keyCode ,KeyEvent event) {       
        if ((keyCode == KeyEvent.KEYCODE_BACK) &&   webView .canGoBack()) {       
        	webView.goBack();       
                   return true;       
        }       
        return super.onKeyDown(keyCode, event);       
    }
}
