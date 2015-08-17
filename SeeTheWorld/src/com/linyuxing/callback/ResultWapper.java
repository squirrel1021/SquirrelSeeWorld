package com.linyuxing.callback;

import java.util.List;


import com.google.gson.reflect.TypeToken;
import com.linyuxing.engine.parser.GsonParser;
import com.linyuxing.entity.Empty;
import com.linyuxing.entity.EventByTag;
import com.linyuxing.utils.ListUtils;
import com.linyuxing.utils.StringUtils;

import de.greenrobot.event.EventBus;

public class ResultWapper<T> extends BaseAbstractRequestCallBack<T> {

	public static final int SINGLE_PV = 0x02;

	public static final int LIST_PV = 0x03;

	public static final int COMPLEX_PV = 0x04;

	private int PARSE_TYPE;

	private Object reflectType;

	private String EVENT_TAG;

	public ResultWapper(Object reflectType, String EVENT_TAG) {
		this(SINGLE_PV, reflectType, EVENT_TAG);
	}

	/**
	 * @param PARSE_TYPE
	 * @param reflectType
	 *            : Class or TypeToken
	 */
	public ResultWapper(int PARSE_TYPE, Object reflectType, String EVENT_TAG) {
		this.PARSE_TYPE = PARSE_TYPE;
		this.reflectType = reflectType;
		this.EVENT_TAG = EVENT_TAG;
	}

	@Override
	public void onSuccess(String result) {
		Object resultObj = null;
		if (!StringUtils.isEmpty(result)) {
			if (PARSE_TYPE == SINGLE_PV) {
				resultObj = GsonParser.parseObject(result, (Class<?>) reflectType);
				if (null == resultObj)
					resultObj = new Empty();

			} else if (PARSE_TYPE == LIST_PV) {
				resultObj = GsonParser.parseList(result, (TypeToken<?>) reflectType);
				if (ListUtils.isEmpty((List<?>) resultObj))
					resultObj = new Empty();
			} else if (PARSE_TYPE == COMPLEX_PV) {
				resultObj = result;
			}
		} else {
			resultObj = new Empty();
		}
		EventBus.getDefault().post(EventByTag.getDefault(resultObj, EVENT_TAG));
	}

	@Override
	public void onFailure(String failureMsg) {
		// TODO 需要补充错误处理！
	}

}
