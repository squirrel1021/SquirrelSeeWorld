package com.linyuxing.entity;

import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;

/**
 * @description: EventBus包装类，用来处理不同tag的EventBus。
 * @author kevin
 *
 */
public class EventBusByTag extends EventBus {

	private static Map<String, EventBus> eventBusMap = new HashMap<String, EventBus>();

	private EventBusByTag(String TAG) {
		super();
		eventBusMap.put(TAG, this);
	}

	/**
	 * @param TAG
	 * @return bind TAG
	 */
	public static EventBus getEventByTag(String TAG) {

		return null == eventBusMap.get(TAG) ? new EventBusByTag(TAG) : eventBusMap.get(TAG);
	}

	/**
	 * @param TAG
	 * @return unBind TAG
	 */
	public static EventBus removeEventByTag(String TAG) {
		return eventBusMap.remove(TAG);
	}

	public synchronized void unregister(Object obj, String TAG) {
		removeEventByTag(TAG);
		super.unregister(obj);
	}

}
