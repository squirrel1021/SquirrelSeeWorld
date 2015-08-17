package com.linyuxing.ui.fragment;

import com.linyuxing.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainLocationFragment extends Fragment{
	private View mView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mView=inflater.inflate(R.layout.main_location_fg, null);
		// TODO Auto-generated method stub
		return mView;
	}

}
