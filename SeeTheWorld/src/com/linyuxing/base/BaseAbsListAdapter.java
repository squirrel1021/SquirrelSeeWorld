package com.linyuxing.base;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @ClassName: BaseAbsListAdapter
 * @Description: list 适配器基类
 * @author Kevinliu 
 * @date 2015年2月26日 上午9:43:09
 * 
*/

public abstract class BaseAbsListAdapter extends BaseAdapter {

	protected List<?> list;
	protected Context context;
	protected LayoutInflater layoutInflater;

	public BaseAbsListAdapter(Context context, List<?> list) {
		super();
		this.context = context;
		this.list = list;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return (list != null && list.size() > 0) ? list.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return (list != null && list.size() > 0) ? list.get(position) : 0;
	}

	@Override
	public long getItemId(int position) {
		return (list != null && list.size() > 0) ? position : 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		return inflate(position,convertView,parent);
	}

	public abstract View inflate(final int position, View convertView, ViewGroup parent);
}
