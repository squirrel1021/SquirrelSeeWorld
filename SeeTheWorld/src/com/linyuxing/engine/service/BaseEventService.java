package com.linyuxing.engine.service;

import android.app.IntentService;
import android.content.Intent;

import com.lidroid.xutils.util.LogUtils;

import de.greenrobot.event.EventBus;

public class BaseEventService extends IntentService {

	public BaseEventService() {
		super("BaseEventService");
	}

	public BaseEventService(String name) {
		super(name);
	}

	private EventBus eventBus;

	@Override
	public void onCreate() {
		eventBus = EventBus.getDefault();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		LogUtils.e("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		LogUtils.e("onHandleIntent");
	}

}
