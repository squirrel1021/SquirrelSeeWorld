package com.linyuxing.ui.widget;


import java.util.ArrayList;
import java.util.List;


import com.lidroid.xutils.BitmapUtils;
import com.linyuxing.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HeadAdView {
	protected Context context;
	/**
	 * @Fields imgUrls : 图片地址的集合
	*/
	protected List<String> imgUrls;
	/**
	 * @Fields viewPager : viewPager对象
	*/
	protected ViewPager viewPager;
	/**
	 * @Fields dotList : 圆点控件的集合
	*/
	protected List<ImageView> dotList;
	private int pagePosition;
	private List<View> views;

	public HeadAdView(Context context, List<String> imgUrls, ViewPager viewPager, List<ImageView> dotList) {
		this.context = context;
		this.imgUrls = imgUrls;
		this.viewPager = viewPager;
		this.dotList = dotList;
	}

	public void setHeadAd() {
		views = new ArrayList<View>();
		addView(3);//为了达到循环的目的需要在第一个页面前面添加最后一页
		for (int index = 0; index < imgUrls.size(); index++) {
			addView(index);
		}
		addView(0);//为了达到循环的目的需要在最后一个页面后面添加第一页
		setViewPager();
		movePage();
	}

	/** 
	 * @Description: 每次切换的时候重置圆点的状态，再根据页面使对应的圆点显示为亮色
	 * @param selectedPagePosition void 返回类型  
	 * @throws:throws
	*/ 
	
	private void initDotsState(int selectedPagePosition) {
		for (ImageView img : dotList) {
			img.setImageResource(R.drawable.carnest_dot_unselected);
		}
		//由于ViewPager前后各添加了一个多余的页面，所以需要减1
		dotList.get(selectedPagePosition - 1).setImageResource(R.drawable.carnest_dot_selected);
	}

	/** 
	 * @Description: 添加需要滑动的View到List集合中
	 * @param index void 返回类型  
	 * @throws:throws
	*/

	private void addView(int index) {
		View view = LayoutInflater.from(context).inflate(R.layout.main_vacation_head_ad, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.head_ad);
		BitmapUtils bitmapUtils = new BitmapUtils(context);
		setBitmapUtilsConfigure(bitmapUtils);
		bitmapUtils.display(imageView, imgUrls.get(index));
		views.add(view);
	}

	/** 
	 * @Description: 设置BitmapUtils配置
	 * @param bitmapUtils void 返回类型  
	 * @throws:throws
	*/

	private void setBitmapUtilsConfigure(BitmapUtils bitmapUtils) {
//		bitmapUtils.configDefaultLoadFailedImage(R.drawable.weather_car);//加载失败图片
		bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);//设置图片压缩类型
	}

	/** 
	 * @Description: 设置viewpager的Adapter和页面切换监听事件 void 返回类型  
	 * @throws:throws
	*/

	private void setViewPager() {
		viewPager.setAdapter(setPagerAdapter());
		//		viewPager.setCurrentItem(1);
		viewPager.setOnPageChangeListener(setPagerChangeListener());
	}

	private PagerAdapter setPagerAdapter() {
		return new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView(views.get(position));// 删除页卡
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(views.get(position));
				return views.get(position);
			}
		};
	}

	private OnPageChangeListener setPagerChangeListener() {
		return new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				setPagerCycle(arg0);
			}

			/** 
			 * @Description: 当滑动到第一个页面的前一个页面就设置viewPager当前页面为最后一个页面，反之则设置当前页面为第一个页面
			 * @param arg0 void 返回类型  
			 * @throws:throws
			*/

			private void setPagerCycle(int arg0) {
				if (0 < arg0 && arg0 < 5) {
					pagePosition = arg0;
					initDotsState(pagePosition);
				} else if (arg0 == 0) {
					viewPager.setCurrentItem(4);
				} else {
					viewPager.setCurrentItem(1);
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		};
	}

	/**
	 * @Fields viewHandler : 线程启动，每5秒自动切换一次广告栏页面
	*/
	private final Handler viewHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 5) {
				pagePosition = 1;
				initDotsState(pagePosition);
				viewPager.setCurrentItem(pagePosition);
			} else {
				viewPager.setCurrentItem(msg.what);
			}
			super.handleMessage(msg);
		}
	};

	private void movePage() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						pagePosition++;
						viewHandler.sendEmptyMessage(pagePosition);
						Thread.sleep(5000);
					}
				} catch (InterruptedException e) {

				}
			}
		}).start();
	}
}

