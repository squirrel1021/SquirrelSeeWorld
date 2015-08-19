package com.linyuxing.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.linyuxing.Constants;
import com.linyuxing.R;
import com.linyuxing.adapter.BaseAbsListAdapter;
import com.linyuxing.adapter.ImageAdapter;
import com.linyuxing.base.AnimateFirstDisplayListener;
import com.linyuxing.config.RequestInterfaces;
import com.linyuxing.engine.handler.BaseRequestHandler;
import com.linyuxing.engine.parser.GsonParser;
import com.linyuxing.entity.TravelList;
import com.linyuxing.ui.activity.WebViewTest;
import com.linyuxing.ui.widget.HeadAdView;
import com.linyuxing.utils.ActivityStartUtil;
import com.linyuxing.utils.ListUtils;
import com.linyuxing.utils.StringUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class MainVacationFragment extends Fragment {

	private View mView;
	private List<TravelList> list1 = new ArrayList<TravelList>();
	private ImageAdapter adapter;
	private DisplayImageOptions options;
	private static final String[] IMAGE_URLS = Constants.RECOMMENDIMAGE;
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

	@ViewInject(R.id.head_view_pager)
	ViewPager headAdViewPager;
	@ViewInject(R.id.dot_views)
	ViewGroup dotsView;
	@ViewInject(R.id.recommend_one)
	ImageView recommendImageOne;
	@ViewInject(R.id.recommend_two)
	ImageView recommendImageTwo;
	@ViewInject(R.id.recommend_three)
	ImageView recommendImageThree;
	@ViewInject(R.id.recommend_four)
	ImageView recommendImageFour;
	List<View> views;
	@ViewInject(R.id.travel_lv)
	ListView travelLv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.main_vacation_fg, null);
		ViewUtils.inject(this, mView);
		createImageCatch();
		setHeadAdView();
		setRecommendView();
		getTravelList();
		return mView;
	}

	private void createImageCatch() {
		options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.bg2).showImageForEmptyUri(R.drawable.ic_empty).showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true).displayer(new RoundedBitmapDisplayer(20)).build();
	}

	private void getTravelList() {
		new BaseRequestHandler().send(RequestInterfaces.GET_TRAVEL_LIST.toString() + "?" + "page=1", HttpMethod.GET, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				System.out.println(arg1 + arg0);
			}

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				try {
					JSONObject jsonObject = new JSONObject(responseInfo.result);
					String errmsg = jsonObject.getString("errmsg");
					if (StringUtils.isEquals(errmsg, "success")) {
						JSONObject date = jsonObject.getJSONObject("data");
						System.out.println(date);
						setDate(date);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	List<String> imageList = new ArrayList<String>();
	private String[] imageUrl;

	protected void setDate(JSONObject jsonObject) {
		try {
			String travelList = jsonObject.getString("books");
			list1 = GsonParser.parseList(travelList, new TypeToken<List<TravelList>>() {
			});
			for (TravelList travel : list1) {
				imageList.add(travel.getHeadImage());
			}
			imageUrl = (String[]) imageList.toArray(new String[imageList.size()]);
			setAdapter();
			setOnItemClickListener();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void setOnItemClickListener() {
		travelLv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getActivity(), WebViewTest.class);
				intent.putExtra("tag_url", list1.get(position).getBookUrl());
				ActivityStartUtil.startActivityByIntent(getActivity(), WebViewTest.class, intent);
			}
		});
	}

	private void setAdapter() {
	
		adapter = new ImageAdapter(getActivity(),list1) {

			@Override
			public View inflate(int position, View convertView, ViewGroup parent) {
				View view = View.inflate(getActivity(), R.layout.main_vacation_listview_item, null);
				if (!ListUtils.isEmpty(list1)) {
					((TextView) view.findViewById(R.id.item_name)).setText("" + list1.get(position).getTitle());
					((TextView) view.findViewById(R.id.user_name)).setText("" + list1.get(position).getUserName());
					((TextView) view.findViewById(R.id.travel_data)).setText("" + list1.get(position).getStartTime());
				}
				ImageView image = (ImageView) view.findViewById(R.id.item_bg);
				ImageLoader.getInstance().displayImage(imageUrl[position], image, options, animateFirstListener);
				return view;
			}
		};
		travelLv.setAdapter(adapter);
		ListUtils.setListViewHeightBasedOnChildren(travelLv);
	}

	private void setRecommendView() {
		ImageView[]ig={recommendImageOne,recommendImageTwo,recommendImageThree,recommendImageFour};
		for(int i=0;i<IMAGE_URLS.length;i++){
			ImageLoader.getInstance().displayImage(IMAGE_URLS[i], ig[i], options, animateFirstListener);
		}
		
	}

	private void setHeadAdView() {
		new HeadAdView(getActivity(), getImgUrlList(), headAdViewPager, getDotList(dotsView)).setHeadAd();
	}

	/**
	 * @Description: 将圆点放入集合中
	 * @param viewGroup
	 *            void 返回类型
	 * @throws:throws
	 */

	private List<ImageView> getDotList(ViewGroup viewGroup) {
		List<ImageView> dotList = new ArrayList<ImageView>();
		for (int index = 0; index < dotImgId.length; index++) {
			dotList.add((ImageView) viewGroup.findViewById(dotImgId[index]));
		}
		return dotList;
	}

	private List<String> getImgUrlList() {
		List<String> imgUrls = new ArrayList<String>();
		for(int i=0;i<IMAGE_URLS.length;i++){
			imgUrls.add(IMAGE_URLS[i]);
		}
		return imgUrls;
	}

	int[] dotImgId = { R.id.dot_first, R.id.dot_second, R.id.dot_third, R.id.dot_fourth };
}
