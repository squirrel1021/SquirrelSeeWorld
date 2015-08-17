package com.linyuxing.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.linyuxing.R;
import com.linyuxing.ui.fragment.MainLocationFragment;
import com.linyuxing.ui.fragment.MainMineFragment;
import com.linyuxing.ui.fragment.MainVacationFragment;
import com.linyuxing.ui.fragment.TestFragment;
import com.viewpagerindicator.IconPagerAdapter;

public class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
	protected static final String[] CONTENT = new String[] { "行走", "吃喝玩乐", "我的", };
	private MainLocationFragment mainLocationFg = new MainLocationFragment();
	private MainMineFragment mainMineFg = new MainMineFragment();
	private MainVacationFragment mainVacationFg = new MainVacationFragment();
	protected static final int[] ICONS = new int[] { R.drawable.perm_group_calendar, R.drawable.perm_group_camera, R.drawable.perm_group_device_alarms,
			R.drawable.perm_group_location };

	private int mCount = CONTENT.length;

	public TestFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	Fragment fg[] = { mainVacationFg, mainLocationFg, mainMineFg };

	@Override
	public Fragment getItem(int position) {
		// return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
		return fg[position];
	}

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return TestFragmentAdapter.CONTENT[position % CONTENT.length];
	}

	@Override
	public int getIconResId(int index) {
		return ICONS[index % ICONS.length];
	}

	public void setCount(int count) {
		if (count > 0 && count <= 10) {
			mCount = count;
			notifyDataSetChanged();
		}
	}
}
