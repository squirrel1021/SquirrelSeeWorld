package com.linyuxing.callback;

import org.json.JSONException;
import org.json.JSONObject;


import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.util.LogUtils;
import com.linyuxing.utils.StringUtils;

/**
 * @ClassName: BaseStringRequestCallBack
 * @Description: 请求回调包装类
 * @author Kevinliu
 * @date 2015年1月31日 下午4:03:57
 * 
 * @param <T>
 */

public abstract class BaseAbstractRequestCallBack<T> extends RequestCallBack<T> {

	private String TAG = "json onSuccess: ";

	public void setTAG(String TAG) {
		this.TAG = TAG;
	}

	@Override
	public void onSuccess(ResponseInfo<T> responseInfo) {
		LogUtils.d(TAG + responseInfo.result);
		try {
			JSONObject jsonObject = new JSONObject(responseInfo.result.toString());
			Integer state = (Integer) jsonObject.get("state");
			if (state != 0) {
				// onSuccess(jsonObject.getString("message"));
				if (StringUtils.isEmpty(jsonObject.getString("data"))
						&& !StringUtils.isEmpty(jsonObject.getString("message"))) {
					onSuccess(jsonObject.getString("message"));
					return;
				}
				onSuccess(jsonObject.getString("data"));
			} else {
				// responseInfo.result 进行errorCode处理
				onFailure(jsonObject.getString("message"));
			}

		} catch (JSONException e) {
			onFailure("JSON 解析异常！");
			e.printStackTrace();
		}

	}

	@Override
	public void onFailure(HttpException error, String msg) {
		// java.util.concurrent.TimeoutException
		if (!StringUtils.isEmpty(msg) && (msg.contains("Bad Gateway") || msg.contains("Not Found")))
			msg = "服务器连接失败！";
		onFailure(msg);

	}

	public abstract void onSuccess(String result);

	public abstract void onFailure(String failureMsg);

}
