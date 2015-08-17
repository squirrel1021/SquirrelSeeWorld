package com.linyuxing.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import com.linyuxing.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.linyuxing.adapter.TestFragmentAdapter;
import com.viewpagerindicator.TitlePageIndicator;

@ContentView(R.layout.carnest_activity_main)
public class MainActivity extends FragmentActivity {
 
	@ViewInject(R.id.pager)
	ViewPager mPager;
	@ViewInject(R.id.indicator)
	TitlePageIndicator mIndicator;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		ViewUtils.inject(this);
		setAdapter(); 
	}
	private void setAdapter() {
		TestFragmentAdapter mAdapter = new TestFragmentAdapter(getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		mIndicator.setViewPager(mPager);
		final float density = getResources().getDisplayMetrics().density;
		mIndicator.setFooterIndicatorHeight(3 * density); //3dp
		mIndicator.setFooterLineHeight(density*0);
        mIndicator.setSelectedColor(Color.WHITE);
        mIndicator.setFooterColor(Color.WHITE);
        mIndicator.setSelectedBold(true);
	}


}
