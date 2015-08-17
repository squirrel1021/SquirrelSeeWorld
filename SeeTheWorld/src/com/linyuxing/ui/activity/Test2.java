package com.linyuxing.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.linyuxing.config.EventTagConfig;
import com.linyuxing.engine.task.VacationTask;
import com.linyuxing.entity.EventByTag;
import com.linyuxing.utils.EventUtils;
import com.linyuxing.R;
import de.greenrobot.event.EventBus;

@ContentView(R.layout.carnest_activity_splash)
public class Test2 extends Activity {
//	@ViewInject(R.id.login)
//	BootstrapButton mBootstrapButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		EventBus.getDefault().registerSticky(this);
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		new VacationTask().queryView();

//		 new AccountTask().getBillData();
//		new AccountTask().getWalletMoney();
//		new AccountTask().getPhoneDiscount("13633095391");
//		new AccountTask().createPhoneOrder(1, 99.55, GlobalParams.carOwnerSeq, "13633095391", 100.0, 1.0);
//		new AccountTask().getQQBusinessDiscount(7);
//		 new AccountTask().getIncomeDetail();
//		 new CarTask().getDriveDetail();
//		 new CarTask().weather();
	}

	@SuppressWarnings("unchecked")
	public void onEventMainThread(EventByTag eventByTag) {
		if (EventUtils.isValid(eventByTag, EventTagConfig.TAG_WALLET, null)) {
			//TODO
			System.out.println(eventByTag.getObj());
		}
		if (EventUtils.isValid(eventByTag, EventTagConfig.TAG_CHECK_CAR, null)) {
			//TODO
		}
		if(EventUtils.isValid(eventByTag, EventTagConfig.TAG_PHONE_DISCOUNT, null)){
			System.out.println(eventByTag.getObj());
		}
		if(EventUtils.isValid(eventByTag, EventTagConfig.TAG_CREATE_PHONE_ORDER, null)){
			System.out.println(eventByTag.getObj());
		}
		if(EventUtils.isValid(eventByTag, EventTagConfig.TAG_GET_QQBUSINESS_DISCOUNT, null)){
			System.out.println(eventByTag.getObj());
		}

	}
}
