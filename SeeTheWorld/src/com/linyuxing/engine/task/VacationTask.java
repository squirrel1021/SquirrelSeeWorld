package com.linyuxing.engine.task;


import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.linyuxing.callback.BaseAbstractRequestCallBack;
import com.linyuxing.config.RequestInterfaces;
import com.linyuxing.engine.handler.BaseRequestHandler;

public class VacationTask {
	public void weather(){
		new BaseRequestHandler().send(RequestInterfaces.WEATHER_CITY.toString()+"?"+"citypinyin=beijing", HttpMethod.GET, new BaseAbstractRequestCallBack<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFailure(String failureMsg) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void queryView(){
		new BaseRequestHandler().send(RequestInterfaces.SCENIC_SPOT_INQUIRY.toString()+"?"+"id=yiheyuan&output=json", HttpMethod.GET, new BaseAbstractRequestCallBack<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFailure(String failureMsg) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
