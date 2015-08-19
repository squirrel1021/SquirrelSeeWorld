package com.linyuxing.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.linyuxing.Constants;
import com.linyuxing.R;
import com.linyuxing.adapter.ImageAdapter;
import com.linyuxing.base.AnimateFirstDisplayListener;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class MainMineFragment extends Fragment {

	ListView lv;
	private View mView;
	private BaseAdapter imageAdapter;
	private DisplayImageOptions options;
	private List<String>list=new ArrayList<String>();
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
	private static final String[] IMAGE_URLS = Constants.IMAGES;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mView = inflater.inflate(R.layout.main_mine_fg, null);
		lv = (ListView) mView.findViewById(R.id.listView1);
		setAdapter();
		createImageCatch();
		return mView;
	}

	private void createImageCatch() {
		options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.bg2).showImageForEmptyUri(R.drawable.ic_empty).showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true).displayer(new RoundedBitmapDisplayer(20)).build();
	}

	private void setAdapter() {
		imageAdapter = new ImageAdapter(getActivity(),list) {

			
			@Override
			public int getCount() {
				return 10;
			}

			@Override
			public View inflate(int position, View convertView, ViewGroup parent) {
				View view = View.inflate(getActivity(), R.layout.main_vacation_listview_item, null);
				ImageView image = (ImageView) view.findViewById(R.id.item_bg);
				ImageLoader.getInstance().displayImage(IMAGE_URLS[position], image, options, animateFirstListener);
				return view;
			}
		};
		lv.setAdapter(imageAdapter);
	}
}
