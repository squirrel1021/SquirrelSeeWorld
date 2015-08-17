package com.linyuxing.config;

import android.content.Context;

import com.lidroid.xutils.DbUtils.DaoConfig;

public class CarnestDaoConfig extends DaoConfig {

	public CarnestDaoConfig(String dbName, Context context) {
		super(context);
		init(dbName);
	}

	private void init(String dbName) {
		GlobalParams.DB_NAME = dbName;
		setDbName(dbName);
		setDbVersion(GlobalParams.DB_VERSION);
	}
}
