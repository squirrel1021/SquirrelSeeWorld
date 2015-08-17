package com.linyuxing.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.linyuxing.R;
import com.linyuxing.adapter.BaseAbsListAdapter;
import com.linyuxing.config.RequestInterfaces;
import com.linyuxing.engine.handler.BaseRequestHandler;
import com.linyuxing.engine.parser.GsonParser;
import com.linyuxing.entity.Empty;
import com.linyuxing.entity.TravelList;
import com.linyuxing.ui.activity.WebViewTest;
import com.linyuxing.ui.widget.HeadAdView;
import com.linyuxing.utils.ActivityStartUtil;
import com.linyuxing.utils.ListUtils;
import com.linyuxing.utils.StringUtils;

import android.app.Activity;
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
import android.widget.Toast;

public class MainVacationFragment extends Fragment {

	private View mView;
	private List<TravelList> list1 = new ArrayList<TravelList>();
	private BaseAbsListAdapter adapter;
	private final int REQUEST_CODE = 1;
	

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
		setHeadAdView();
		setRecommendView();
		getTravelList();
		return mView;
	}

	private void getTravelList() {
		new BaseRequestHandler().send(RequestInterfaces.GET_TRAVEL_LIST.toString()+"?"+"page=1", HttpMethod.GET, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				System.out.println(arg1+arg0);
			}

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				try {
					JSONObject jsonObject=new JSONObject(responseInfo.result);
					String errmsg=jsonObject.getString("errmsg");
					if(StringUtils.isEquals(errmsg, "success")){
						JSONObject date=jsonObject.getJSONObject("data");
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

	protected void setDate(JSONObject jsonObject) {
		try {
			String travelList=jsonObject.getString("books");
			list1=GsonParser.parseList(travelList, new TypeToken<List<TravelList>>(){});
			setAdapter(list1);
			setOnItemClickListener();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
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

	private void setAdapter(List<TravelList> TravelList) {
		adapter = new BaseAbsListAdapter(getActivity(), TravelList) {
			

			@Override
			public View inflate(int position, View convertView, ViewGroup parent) {
				View view = View.inflate(getActivity(), R.layout.main_vacation_listview_item, null);
				BitmapUtils bitmapUtils = new BitmapUtils(getActivity());
				bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);// 设置图片压缩类型
				if(!ListUtils.isEmpty(list1)){
					((TextView)view.findViewById(R.id.item_name)).setText(""+list1.get(position).getTitle());
					((TextView)view.findViewById(R.id.user_name)).setText(""+list1.get(position).getUserName());
					((TextView)view.findViewById(R.id.travel_data)).setText(""+list1.get(position).getStartTime());
					bitmapUtils.display(((ImageView)view.findViewById(R.id.item_bg)),list1.get(position).getHeadImage());
//					bitmapUtils.display(((ImageView)view.findViewById(R.id.user_headimg)),list1.get(position).getUserHeadImg());
				}
				return view;
			}
		};
		travelLv.setAdapter(adapter);
		ListUtils.setListViewHeightBasedOnChildren(travelLv);
	}
 
	private void setRecommendView() {
		BitmapUtils bitmapUtils = new BitmapUtils(getActivity());
		bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);// 设置图片压缩类型
		bitmapUtils.display(recommendImageOne,"http://img1.qunarzz.com/travel/d0/1408/28/ec37c21593f64f25ffffffffc8d65eac.jpg");
		bitmapUtils.display(recommendImageTwo,"http://img1.qunarzz.com/travel/d2/1502/58/01c9ce916fb59a.jpg");
		bitmapUtils.display(recommendImageThree,"http://img1.qunarzz.com/travel/d3/1505/2a/03a0c61daf13e6.jpg");
		bitmapUtils.display(recommendImageFour,"http://hiphotos.baidu.com/lvpics/pic/item/eac4b74543a9822607ab29f28a82b9014b90ebf9.jpg");
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
		imgUrls.add("http://img1.qunarzz.com/travel/d0/1408/28/ec37c21593f64f25ffffffffc8d65eac.jpg");
		imgUrls.add("http://img1.qunarzz.com/travel/d2/1502/58/01c9ce916fb59a.jpg");
		imgUrls.add("http://img1.qunarzz.com/travel/d3/1505/2a/03a0c61daf13e6.jpg");
		imgUrls.add("http://hiphotos.baidu.com/lvpics/pic/item/eac4b74543a9822607ab29f28a82b9014b90ebf9.jpg");
		return imgUrls;
	}

	int[] dotImgId = { R.id.dot_first, R.id.dot_second, R.id.dot_third, R.id.dot_fourth };
}
