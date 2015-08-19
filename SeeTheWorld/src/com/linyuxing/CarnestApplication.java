package com.linyuxing;

import android.app.Application;
import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class CarnestApplication extends Application {

	public static String TOKEN;

	public static Context mContext;

	public static HttpUtils mHttpUtils;
	
	public static DbUtils mDao;

	@Override
	public void onCreate() {
		mContext = this;
		mHttpUtils = new HttpUtils(this);
		mHttpUtils.sHttpCache.setEnabled(HttpMethod.GET, false);
		initImageLoader(getApplicationContext());
		super.onCreate();
	}

	private void initImageLoader(Context applicationContext) {
		ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(applicationContext);
		config.threadPriority(Thread.NORM_PRIORITY - 2);
		config.denyCacheImageMultipleSizesInMemory();
		config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
		config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
		config.tasksProcessingOrder(QueueProcessingType.LIFO);
		config.writeDebugLogs(); // Remove for release app

		ImageLoader.getInstance().init(config.build());
	}

}
