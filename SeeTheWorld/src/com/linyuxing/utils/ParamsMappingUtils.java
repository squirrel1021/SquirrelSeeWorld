package com.linyuxing.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linyuxing.config.GlobalParams;


/**
 * @ClassName: ParamsMappingUtils
 * @Description: TODO
 * @author ouyanglin
 * @date 2015年2月27日 下午4:03:57
 * 
 */

public class ParamsMappingUtils {

	public static <K, V> Map<K, V> getMap() {
		return new HashMap<K, V>();
	}

	public static Map<String, Object> getLoginMap(String ownerTel, String userPassword) {
		Map<String, Object> map = getMap();
		map.put("ownerTel", ownerTel);
		map.put("userPassword", userPassword);
		return map;
	}

	public static Map<String, Object> getLogoutMap(String ownerTel) {
		Map<String, Object> map = getMap();
		map.put("ownerTel", ownerTel);
		return map;
	}

	public static Map<String, Object> getRegistMap(String ownerTel, String mobileValidatecode, String userPassword, Integer ownerFlag, String ownerName) {
		Map<String, Object> map = getMap();
		map.put("ownerTel", ownerTel);
		map.put("mobileValidatecode", mobileValidatecode);
		map.put("userPassword", userPassword);
		map.put("ownerFlag", ownerFlag);
		map.put("ownerName", ownerName);
		return map;
	}

	public static Map<String, Object> createParkOrder(Integer virtualGoodsSeq, double payMoney, Integer carOwnerSeq, String rechargeObject, double rechargeTotal, double careggDiscount,
			int rechargeQuantity, int rechargePrice) {
		Map<String, Object> map = getMap();
		map.put("virtualGoodsSeq", virtualGoodsSeq);
		map.put("payMoney", payMoney);
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("rechargeObject", rechargeObject);
		map.put("rechargeTotal", rechargeTotal);
		map.put("careggDiscount", careggDiscount);
		map.put("rechargeQuantity", rechargeQuantity);
		map.put("rechargePrice", rechargePrice);
		return map;
	}

	public static Map<String, Object> createPhoneOrder(Integer virtualGoodsSeq, double payMoney, Integer carOwnerSeq, String rechargeObject, double rechargeTotal, double careggDiscount) {
		Map<String, Object> map = getMap();
		map.put("virtualGoodsSeq", virtualGoodsSeq);
		map.put("payMoney", payMoney);
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("rechargeObject", rechargeObject);
		map.put("rechargeTotal", rechargeTotal);
		map.put("careggDiscount", careggDiscount);
		return map;
	}

	public static Map<String, Object> getForgetPwdMap(String ownerTel, String mobileValidatecode, String userPassword) {
		Map<String, Object> map = getMap();
		map.put("ownerTel", ownerTel);
		map.put("userPassword", userPassword);
		map.put("mobileValidatecode", mobileValidatecode);
		return map;
	}

	/**
	 * 短信验证码
	 * 
	 * @Description: 消息类型：1.注册，2.登录，3.忘记密码；
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getRegistMsgMap(String telephoneNo, String messageType, String requestTime) {
		Map<String, Object> map = getMap();
		map.put("telephoneNo", telephoneNo);
		map.put("messageType", messageType);
		map.put("requestTime", requestTime);
		return map;
	}

	/**
	 * @Description: 获取市区信息
	 * @param sysDictCode
	 *            系统字典编码（固定值：CITY）
	 * @param sysDictItemSeq
	 *            省份字典id
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCityInfoMap(String sysDictCode, String sysDictItemSeq) {
		Map<String, Object> map = getMap();
		map.put("sysDictCode", sysDictCode);
		map.put("sysDictItemSeq", sysDictItemSeq);
		return map;
	}

	/**
	 * @Description: 获取省份信息
	 * @param sysDictCode
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getProvinceInfoMap(String sysDictCode) {
		Map<String, Object> map = getMap();
		map.put("sysDictCode", sysDictCode);
		return map;
	}

	public static Map<String, Object> getOrderAppointmentMap(String ownerTel, String bookingWay, String submitPic, String sendName, Integer addrProvice, Integer addrCity, String addrDetail) {
		Map<String, Object> map = getMap();
		map.put("ownerTel", ownerTel);
		map.put("bookingWay", bookingWay);
		map.put("submitPic", submitPic);
		map.put("sendName", sendName);
		map.put("addrProvice", addrProvice);
		map.put("addrCity", addrCity);
		map.put("addrDetail", addrDetail);
		return map;
	}

	/**
	 * @Description: 根据类别查询服务商品列表(洗车,美容,维修,维保) 获取我的商家类别接口(美容改装，维修保养)
	 *               车主序号；carOwnerSeq=0 查询所有商家服务
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getProductList(Integer page, Integer rows, String baseEO, Double LA, Double LO, Integer carOwnerSeq, Integer serviceTypeSeq, String group) {
		Map<String, Object> map = getMap();
		Map<String, Object> baseEOMap = getMap();
		baseEOMap.put("LA", LA);
		baseEOMap.put("LO", LO);
		baseEOMap.put("carOwnerSeq", carOwnerSeq);
		baseEOMap.put("serviceTypeSeq", serviceTypeSeq);
		baseEOMap.put("group", group);

		map.put("page", page);
		map.put("rows", rows);
		map.put("baseEO", baseEOMap);
		return map;
	}

	/**
	 * @Description: 违章处理接口
	 * @param carOwnerSeq
	 * @param status
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCarEndorsementMap(Integer carOwnerSeq, Integer status) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("status", status);
		return map;
	}

	/**
	 * @Description: 车辆保险/确认订单
	 * @param carOwnerSeq
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCarInsuranceAndOrderMap(Integer carOwnerSeq) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		return map;
	}

	/**
	 * @Description: 支付订单
	 * @param serviceOrderSeq
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getPayOrderMap(String serviceOrderSeq) {
		Map<String, Object> map = getMap();
		map.put("serviceOrderSeq", serviceOrderSeq);
		return map;
	}

	/**
	 * @Description: 套餐详情
	 * @param insurancePackageSeq
	 *            保险套餐序号；
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getInsurancePackageDetailMap(String insurancePackageSeq) {
		Map<String, Object> map = getMap();
		map.put("insurancePackageSeq", insurancePackageSeq);
		return map;
	}

	/**
	 * @Description: 全部，待付款，待评价订单列表接口
	 * @param page
	 * @param rows
	 * @param carOwnerSeq
	 * @param status
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getServiceOrderMap(Integer page, Integer rows, Integer carOwnerSeq, Integer status) {
		Map<String, Object> map = getMap();
		Map<String, Object> where = getMap();
		where.put("carOwnerSeq", carOwnerSeq);
		where.put("status", status);
		map.put("page", page);
		map.put("rows", rows);
		map.put("where", where);
		return map;
	}

	/**
	 * @Description: 保险订单详情
	 * @param insurancePackageSeq
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getInsuranceAndOrderDetailMap(String insurancePackageSeq) {
		Map<String, Object> map = getMap();
		map.put("insurancePackageSeq", insurancePackageSeq);
		return map;
	}

	public static Map<String, Object> getSOSMap(String telephoneNo, String messageType, String requestTime, Integer virityWay) {
		Map<String, Object> map = getMap();
		map.put("telephoneNo", telephoneNo);
		map.put("messageType", messageType);
		map.put("requestTime", requestTime);
		map.put("virityWay", virityWay);
		return map;
	}

	/**
	 * @Description: 添加评论接口
	 * @param insurancePackageSeq
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCommentMap(Integer carOwnerSeq, Integer careggServiceSeq, Integer serviceCommentType, Integer upServiceCommentSeq, Integer serviceCommentValue,
			Integer serviceCommentContent) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("careggServiceSeq", carOwnerSeq);
		map.put("serviceCommentType", carOwnerSeq);
		map.put("upServiceCommentSeq", carOwnerSeq);
		map.put("serviceCommentValue", carOwnerSeq);
		map.put("serviceCommentContent", serviceCommentContent);
		return map;
	}

	/**
	 * @Description: 消息是否已读
	 * @param noticeInfoSeq
	 *            消息信息编号
	 * @param noticeInfoStatus
	 *            消息状态 0.未读，1.已读
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getMessageNoticeInfoMap(Integer noticeInfoSeq, String noticeInfoStatus) {
		Map<String, Object> map = getMap();
		map.put("noticeInfoSeq", noticeInfoSeq);
		map.put("noticeInfoStatus", noticeInfoStatus);
		return map;
	};

	public static Map<String, Integer> getFindCareggServiceByType(Integer id) {
		Map<String, Integer> map = getMap();
		map.put("id", id);
		return map;
	};

	/**
	 * @Description: 消息查询
	 * @param page
	 *            当前页
	 * @param rows
	 *            页大小
	 * @param carOwnerSeq
	 *            车主编号
	 * @param noticeTypeCode
	 *            消息类型代码,APPMESSAGE1(车辆信息)，APPMESSAGE2(服务器信息)，APPMESSAGE3(钱包)，
	 *            APPMESSAGE4(活动消息)
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getMessageNoticeInfoMap(Integer page, Integer rows, Integer carOwnerSeq, String noticeTypeCode) {
		Map<String, Object> map = getMap();
		map.put("page", page);
		map.put("rows", rows);
		Map<String, Object> where = getMap();
		where.put("carOwnerSeq", carOwnerSeq);
		where.put("noticeTypeCode", noticeTypeCode);
		map.put("where", where);
		return map;
	};

	/**
	 * @Description: 余额查询
	 * @param carOwnerSeq
	 *            车主序号；
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getWalletMap(String carOwnerSeq) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		return map;
	};

	/**
	 * @Description: 修改头像
	 * @param carOwnerSeq
	 *            车主编号；
	 * @param carOwnerPic
	 *            车主头像（字节流）
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 * 
	 *                暂时没有对字节流进行处理
	 */

	public static Map<String, Object> getCarOwnerHeaderPic(Integer carOwnerSeq, String carOwnerPic) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carOwnerPic", carOwnerPic);
		return map;
	};

	/**
	 * @Description: 修改手机号
	 * @param carOwnerSeq
	 *            车主编号；
	 * @param ownerTel
	 *            手机号
	 * @param mobileValidatecode
	 *            手机验证码
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCarOwnerOwnerTel(Integer carOwnerSeq, String ownerTel, String mobileValidatecode) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("ownerTel", ownerTel);
		map.put("mobileValidatecode", mobileValidatecode);
		return map;
	};

	/**
	 * @Description: 修改昵称
	 * @param carOwnerSeq
	 *            车主编号；
	 * @param ownerNickName
	 *            用户昵称;
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCarOwnerNickName(Integer carOwnerSeq, String ownerNickName) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("ownerNickName", ownerNickName);
		return map;
	};

	/**
	 * @Description: 修改密码
	 * @param carOwnerSeq
	 *            车主编号
	 * @param userPassword
	 *            用户旧密码
	 * @param newPassword
	 *            用户新密码
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCarOwnerPassword(Integer carOwnerSeq, String userPassword, String newPassword) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("userPassword", userPassword);
		map.put("newPassword", newPassword);
		return map;
	};

	public static Map<String, Object> getCarFuelType(Integer carInfoSeq, Integer param, String defaultFuel) {
		Map<String, Object> map = getMap();
		map.put("carInfoSeq", carInfoSeq);
		map.put("param", param);
		map.put("defaultFuel", defaultFuel);
		return map;
	}

	public static Map<String, Object> getCarMileType(Integer carInfoSeq, Integer param, String defaultFuel) {
		Map<String, Object> map = getMap();
		map.put("carInfoSeq", carInfoSeq);
		map.put("param", param);
		map.put("carDistance", defaultFuel);
		return map;
	}

	public static Map<String, Object> getCarPriceType(Integer carInfoSeq, Integer param, String defaultFuel) {
		Map<String, Object> map = getMap();
		map.put("carInfoSeq", carInfoSeq);
		map.put("param", param);
		map.put("carPrice", defaultFuel);
		return map;
	}

	/**
	 * @Description: 保存车主与维保商家绑定信息
	 * @param serviceBindSeq
	 *            服务绑定序号(主键自增长)
	 * @param carOwnerSeq
	 *            车主序号
	 * @param serviceOrgSeq
	 *            服务序号（暂不使用）
	 * @param serviceBindType
	 *            服务绑定类型
	 * @param serviceBindName
	 *            服务绑定名称
	 * @param serviceBindPara1
	 *            服务绑定参数
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCarOwnerServiceSetupMap(Integer serviceBindSeq, Integer carOwnerSeq, String serviceBindType, String serviceBindName, String serviceBindPara1) {
		Map<String, Object> map = getMap();
		map.put("serviceBindSeq", serviceBindSeq);
		map.put("carOwnerSeq", carOwnerSeq);
		/* map.put("serviceOrgSeq", serviceOrgSeq); */
		map.put("serviceBindType", serviceBindType);
		map.put("serviceBindName", serviceBindName);
		map.put("serviceBindPara1", serviceBindPara1);
		return map;
	};

	/**
	 * @Description: 商品列表
	 * @param page
	 *            当前页
	 * @param row
	 *            页数
	 * @param LA
	 *            纬度(保留5位小数点);
	 * @param LO
	 *            经度(保留5位小数点)；
	 * @param carOwnerSeq
	 *            车主序号；carOwnerSeq=0 查询所有商家服务
	 * @param serviceTypeSeq
	 *            服务类别序号；
	 * @param group
	 *            排序方式；
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getFindByCarIdAndGPSMap(Integer page, Integer rows, Double LA, Double LO, Integer carOwnerSeq, Integer serviceTypeSeq, String group) {
		Map<String, Object> map = getMap();
		map.put("page", page);
		map.put("rows", rows);
		Map<String, Object> where = getMap();
		where.put("LA", Double.valueOf(StringUtils.getTwoDecimal(LA)));
		where.put("LO", Double.valueOf(StringUtils.getTwoDecimal(LO)));
		where.put("carOwnerSeq", carOwnerSeq);
		where.put("serviceTypeSeq", serviceTypeSeq);
		where.put("group", group);
		map.put("where", where);
		return map;
	};

	/**
	 * @Description: 违章处理接口
	 * @param page
	 * @param rows
	 * @param carOwnerSeq
	 *            车主序号
	 * @param status
	 *            状态码 10未处理，30处理中
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getFindCarEndorsementPage(Integer page, Integer rows, Integer carOwnerSeq, Integer status) {
		Map<String, Object> map = getMap();
		Map<String, Object> where = getMap();
		map.put("page", page);
		map.put("rows", rows);
		where.put("carOwnerSeq", carOwnerSeq);
		where.put("status", status);
		map.put("where", where);
		return map;
	};

	/**
	 * @Description: 车辆保险
	 * @param carOwnerSeq
	 *            商品订单序号
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getCarInsurance(Integer carOwnerSeq) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		return map;
	};

	/**
	 * @Description: 支付订单
	 * @param serviceOrderSeq
	 *            商品订单序号
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getPayOrder(Integer serviceOrderSeq) {
		Map<String, Object> map = getMap();
		map.put("serviceOrderSeq", serviceOrderSeq);
		return map;
	};

	/**
	 * @Description: 全部，待付款，待评价订单列表接口
	 * @param page
	 *            当前页；
	 * @param carOwnerSeq
	 *            车主编号；
	 * @param rows
	 *            每页数据数；
	 * @param status
	 *            说明:status=1查询所有订单，status=2查询待付款订单，status=3查询待评价订单；
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getfindServiceOrder(Integer page, Integer carOwnerSeq, Integer rows, Integer status) {
		Map<String, Object> map = getMap();
		map.put("page", page);
		Map<String, Object> where = getMap();
		where.put("carOwnerSeq", carOwnerSeq);
		where.put("status", status);
		map.put("rows", rows);
		map.put("where", where);
		return map;
	};

	/**
	 * @Description: 保险订单详情
	 * @param serviceOrderSeq
	 *            订单序号
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getInsuranceOrderDetail(Integer serviceOrderSeq) {
		Map<String, Object> map = getMap();
		map.put("serviceOrderSeq", serviceOrderSeq);
		return map;
	};

	/**
	 * @Description: SOS商家服务列表接口
	 * @param LA
	 *            纬度
	 * @param LO
	 *            经度
	 * @param serviceTypeSeq
	 *            服务类别序号
	 * @param group
	 *            排序方式(money 按价格排序,pingjia按评价排序,为空默认按距离排序)
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> getfindSOSGPS(Integer page, Integer rows, Double LA, Double LO, Integer serviceTypeSeq, String group) {
		Map<String, Object> map = getMap();
		map.put("page", page);
		map.put("rows", rows);
		Map<String, Object> where = getMap();
		where.put("LA", Double.valueOf(StringUtils.getTwoDecimal(LA)));
		where.put("LO", Double.valueOf(StringUtils.getTwoDecimal(LO)));
		where.put("serviceTypeSeq", serviceTypeSeq);
		where.put("group", group);
		map.put("where", where);
		return map;
	};

	/**
	 * @Description: 违章新增车辆
	 * @param carOwnerSeq
	 *            车主序号
	 * @param carAddType
	 *            1.预约车蛋新增 2.查询违章新增
	 * @param carId
	 *            车牌号
	 * @param carVin
	 *            车架号
	 * @param carEngine
	 *            发动机号
	 * @param carStatus
	 *            车辆状态：1 正常0 预录入-1 删除
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> addViolationCarId(Integer carOwnerSeq, Integer carAddType, String carId, String carVin, String carEngine, Integer carStatus) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carAddType", carAddType);
		map.put("carId", carId);
		map.put("carVin", carVin);
		map.put("carEngine", carEngine);
		map.put("carStatus", carStatus);

		return map;
	}

	/**
	 * @Description: 一键检测
	 * @param carInfoSeq
	 *            车辆信息序号
	 * @return Map<String,Object> 返回类型
	 * @throws:throws
	 */

	/*
	 * public static Map<String,Object> getfaultNoticeCheck(Integer carInfoSeq){
	 * Map<String, Object> map = getMap(); map.put("carInfoSeq", carInfoSeq);
	 * return map; };
	 */

	public static List<Map<String, Object>> getAvailableSeller(Integer carOwnerSeq, Integer carPrice, Integer insurSeq, Integer maxCompensation) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = getMap();
		Map<String, Object> map1 = getMap();
		Map<String, Object> map2 = getMap();

		map0.put("carOwnerSeq", carOwnerSeq);

		map1.put("carPrice", carPrice);

		map2.put("insurSeq", insurSeq);
		map2.put("maxCompensation", maxCompensation);

		list.add(map0);
		list.add(map1);
		list.add(map2);
		return list;
	}

	public static Map<String, Object> getCarModifyPic(Integer carOwnerSeq, String carModifyPic) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carModifyPic", carModifyPic);
		return map;
	}

	// 修改车辆信息
	public static Map<String, Object> modifyCarInfo(Integer carOwnerSeq, Integer carAddType, String carId, String carVin, String carEngine, Integer carStatus, Integer defaultFuel, double carDistance,
			Integer carTypeSeq, int lbsFlag) {
		Map<String, Object> map = getMap();
		Map<String, Object> map1 = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carAddType", carAddType);
		map.put("carId", carId);
		map.put("carVin", carVin);
		map.put("carEngine", carEngine);
		map.put("carStatus", carStatus);
		map1.put("carDistance", carDistance);
		map1.put("defaultFuel", defaultFuel);
		map1.put("carTypeSeq", carTypeSeq);
		map1.put("lbsFlag", lbsFlag);
		map.put("carInfoDetail", map1);
		return map;
	}

	public static Map<String, Object> getUploadCarOwnerHeader(Integer carOwnerSeq, String carOwnerPic) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carOwnerPic", carOwnerPic);
		return map;
	}

	public static Map<String, Object> getActiveCarEgg(Integer carOwnerSeq, Integer carInfoSeq, String careggSn, String verifyCode, String carDistance) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carInfoSeq", carInfoSeq);
		map.put("careggSn", careggSn);
		map.put("verifyCode", verifyCode);
		map.put("carDistance", carDistance);
		return map;

	}

	/**
	 * @author FH
	 * @Description: 意见反馈
	 * @date 2015年3月12日 下午4:47:20
	 * @version V1.0
	 * @param feedbackContent
	 *            用户反馈内容
	 * @param feedbackId
	 *            联系方式
	 * @return Map<String,Object>
	 * @throws:throws
	 */

	public static Map<String, Object> getFeedback(String feedbackContent, String feedbackId, Integer carOwnerSeq) {
		Map<String, Object> map = getMap();
		map.put("feedbackContent", feedbackContent);
		map.put("feedbackId", feedbackId);
		map.put("carOwnerSeq", carOwnerSeq);
		return map;
	};

	@Deprecated
	public static List<Map<String, Object>> getAllMessageStatus(List<Integer> noticeInfoSeq, Integer noticeInfoStatus) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < noticeInfoSeq.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("noticeInfoSeq", noticeInfoSeq.get(i));
			map.put("noticeInfoStatus", noticeInfoStatus);
			list.add(map);
		}
		return list;
	}

	public static Map<String, Object> getAllMessageStatus(Integer carOwnerSeq, Integer noticeInfoStatus) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("noticeInfoStatus", noticeInfoStatus);
		return map;
	}

	public static Map<String, Object> getPushSettingsParams(Integer carOwnerSeq, String ownerNoticeType, Integer configValue) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("ownerNoticeType", ownerNoticeType);
		map.put("configValue", configValue);
		return map;
	}

	public static Map<String, Object> activateCaregg(Integer carOwnerSeq, Integer carAddType, String carId, Integer carStatus, double carDistance, Integer carTypeSeq, String careggSn,
			String verifyCode) {
		Map<String, Object> map = getMap();
		Map<String, Object> map1 = getMap();
		Map<String, Object> map2 = getMap();
		Map<String, Object> map3 = getMap();

		map3.put("carId", carId);
		map3.put("carAddType", carAddType);
		map3.put("carOwnerSeq", carOwnerSeq);
		map3.put("carStatus", carStatus);
		map3.put("carInfoDetail", map1);

		map1.put("carDistance", carDistance);
		map1.put("carTypeSeq", carTypeSeq);

		map2.put("careggSn", careggSn);
		map2.put("verifyCode", verifyCode);

		map.put("carInfo", map3);
		map.put("careggInfo", map2);

		return map;

	}

	/**
	 * @Description: 用一句话描述该文件做什么 void 返回类型
	 * @throws:throws
	 */

	public static Map<String, Object> deleteViolationCar(Integer carInfoSeq) {
		Map<String, Object> map = getMap();
		map.put("carInfoSeq", carInfoSeq);
		return map;
	}


	public static Map<String, Object> confirmMoney(Integer balance, Integer carOwnerSeq, int[] listID) {
		Map<String, Object> map = getMap();
		map.put("balance", balance);
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("listID", listID);
		return map;
	}

	public static Map<String, Object> confirmMoney(Integer carOwnerSeq, String engineNo, String mobileNo, Double maxMoney, Double payMoney, Integer payInfParaSeq, String careggRechargeNo,
			Integer carInfoSeq, Double serviceReturnProfit, String lastestValidcode, Integer balance, List<Map<String, Object>> listID) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("engineNo", engineNo);
		map.put("mobileNo", mobileNo);
		map.put("maxMoney", maxMoney);
		map.put("payMoney", payMoney);
		map.put("payInfParaSeq", payInfParaSeq);
		map.put("careggRechargeNo", careggRechargeNo);
		map.put("carInfoSeq", carInfoSeq);
		map.put("serviceReturnProfit", serviceReturnProfit);
		map.put("lastestValidcode", lastestValidcode);
		map.put("balance", balance);
		map.put("listID", listID);
		return map;
	}

	public static Map<String, Object> confirmMoneyListMap(String endorsementId, Double totalFee, String reqNo, Double arrdv, Integer carEndorsementSeq) {
		Map<String, Object> map = getMap();
		map.put("endorsementId", endorsementId);
		map.put("totalFee", totalFee);
		map.put("reqNo", reqNo);
		map.put("arrdv", arrdv);
		map.put("carEndorsementSeq", carEndorsementSeq);
		return map;
	}

	// public static Map<String, Object> paymentMoneyCallBackIfZero(Integer
	// carOwnerSeq, Double maxMoney, Double payMoney,
	// int[] listID, Integer carInfoSeq, Double serviceReturnProfit, String
	// lastestValidcode, Integer balance) {
	// Map<String, Object> map = getMap();
	// map.put("carOwnerSeq", carOwnerSeq);
	// map.put("maxMoney", maxMoney);
	// map.put("payMoney", payMoney);
	// map.put("listID", listID);
	// map.put("carInfoSeq", carInfoSeq);
	// map.put("serviceReturnProfit", serviceReturnProfit);
	// map.put("lastestValidcode", lastestValidcode);
	// map.put("balance", balance);
	// return map;
	// }


	public static Map<String, Object> paymentMoneyCallBackIfNoZero(Integer carOwnerSeq, String engineNo, String mobileNo, Double maxMoney, Double payMoney, Integer payInfParaSeq,
			String careggRechargeNo, Integer carInfoSeq, Double serviceReturnProfit, String lastestValidcode, Integer balance, int[] listID) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("engineNo", engineNo);
		map.put("mobileNo", mobileNo);
		map.put("maxMoney", maxMoney);
		map.put("payMoney", payMoney);
		map.put("payInfParaSeq", payInfParaSeq);
		map.put("careggRechargeNo", careggRechargeNo);

		map.put("carInfoSeq", carInfoSeq);
		map.put("serviceReturnProfit", serviceReturnProfit);
		map.put("lastestValidcode", lastestValidcode);
		map.put("balance", balance);
		map.put("listID", listID);
		return map;
	}

	// public static Map<String, Object> paymentMoneyCallBack(Integer
	// carOwnerSeq, Double maxMoney, Double payMoney, int[] listID, Integer
	// carInfoSeq, Double serviceReturnProfit,
	// String lastestValidcode, Integer balance) {
	// Map<String, Object> map = getMap();
	// map.put("carOwnerSeq", carOwnerSeq);
	// map.put("maxMoney", maxMoney);
	// map.put("payMoney", payMoney);
	// map.put("listID", listID);
	// map.put("carInfoSeq", carInfoSeq);
	// map.put("serviceReturnProfit", serviceReturnProfit);
	// map.put("lastestValidcode", lastestValidcode);
	// map.put("balance", balance);
	// return map;
	// }

	public static Map<String, Object> paymentMoneyCallBackIfNoZero(int carOwnerSeq, double maxMoney, double payMoney, int payInfParaSeq, String careggRechargeNo, int balance,
			int virtualGoodsOrderSeq, String rechargeDesc) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("maxMoney", maxMoney);
		map.put("payMoney", payMoney);
		map.put("payInfParaSeq", payInfParaSeq);
		map.put("careggRechargeNo", careggRechargeNo);
		map.put("balance", balance);
		map.put("virtualGoodsOrderSeq", virtualGoodsOrderSeq);
		map.put("rechargeDesc", rechargeDesc);
		return map;
	}

	public static Map<String, Object> paymentMoneyCallBack(Integer carOwnerSeq, Double maxMoney, Double payMoney, int[] listID, Integer carInfoSeq, Double serviceReturnProfit,
			String lastestValidcode, Integer balance) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("maxMoney", maxMoney);
		map.put("payMoney", payMoney);
		map.put("listID", listID);
		map.put("carInfoSeq", carInfoSeq);
		map.put("serviceReturnProfit", serviceReturnProfit);
		map.put("lastestValidcode", lastestValidcode);
		map.put("balance", balance);
		return map;
	}

	public static Map<String, Object> getViolationList(Integer endorsementStatus, Integer carOwnerSeq, String carId, String engineNo, String frameNo) {
		Map<String, Object> map = getMap();
		map.put("endorsementStatus", endorsementStatus);
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("engineNo", engineNo);
		map.put("carId", carId);
		map.put("frameNo", frameNo);
		return map;
	}

	public static Map<String, Object> getViolationList(Integer endorsementStatus, Integer carOwnerSeq, Integer carAddType) {
		Map<String, Object> map = getMap();
		map.put("endorsementStatus", endorsementStatus);
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carAddType", carAddType);
		return map;
	}

	public static Map<String, Object> putIdentificationCode(String identifyCode, String identifyTypeVersion, String identifyType) {
		Map<String, Object> map = getMap();
		map.put("identifyCode", identifyCode);
		map.put("identifyTypeVersion", identifyTypeVersion);
		map.put("identifyType", identifyType);
		return map;
	}

	public static Map<String, Object> readyPay(String device_info, String body, String detail, String attach, String out_trade_no, String fee_type, String total_fee, String spbill_create_ip,
			String goods_tag, String trade_type, String product_id, String openid) {
		Map<String, Object> map = getMap();
		map.put("device_info", device_info);
		map.put("body", body);
		map.put("detail", detail);
		map.put("attach", attach);
		map.put("out_trade_no", out_trade_no);
		map.put("fee_type", fee_type);
		map.put("total_fee", total_fee);
		map.put("spbill_create_ip", spbill_create_ip);
		map.put("goods_tag", goods_tag);
		map.put("trade_type", trade_type);
		map.put("product_id", product_id);
		map.put("openid", openid);
		return map;
	}

	public static Map<String, Object> getHistoryViolationCars(Integer carOwnerSeq, String carId) {
		Map<String, Object> map = getMap();
		map.put("endorsementStatus", 30);
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carId", carId);
		return map;
	}

	public static Map<String, Object> creatOrderMessage(Integer carOwnerSeq, List<Map<String, Integer>> carEndorsementSeqList, double virtualGoodsOrderAmount) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carEndorsementSeqList", carEndorsementSeqList);
		map.put("virtualGoodsOrderAmount", virtualGoodsOrderAmount);
		return map;
	}

	public static Map<String, Object> creatRefund(Integer carOwnerSeq, Integer carEndorsementSeq, Integer endorsementStatus, Integer virtualGoodsOrderSeq) {
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", carOwnerSeq);
		map.put("carEndorsementSeq", carEndorsementSeq);
		map.put("endorsementStatus", endorsementStatus);
		map.put("virtualGoodsOrderSeq", virtualGoodsOrderSeq);
		return map;
	}

	/**
	 * @author FH
	 * @Description: TODO 门户登录
	 * @param ownerTel
	 *            车主手机
	 * @param password
	 *            密码
	 * @return Map<String,String>
	 * @throws:throws
	 */

	public static Map<String, String> portalLogin(String ownerTel, String password) {
		Map<String, String> map = getMap();
		map.put("ownerTel", ownerTel);
		map.put("userPassword", password);
		return map;
	}

	public static Map<String, String> getAliPayParams(String subject, String body, String out_trade_no, String total_fee, String pay_business) {
		Map<String, String> map = getMap();
		map.put("subject", subject);
		map.put("body", body);
		map.put("out_trade_no", out_trade_no);
		map.put("total_fee", total_fee);
		map.put("pay_business", pay_business);

		return map;
	}

	public static Map<String,Object> readAllNews(String messageTypeCode){
		Map<String, Object> map = getMap();
		map.put("carOwnerSeq", GlobalParams.carOwnerSeq);
		map.put("noticeTypeName", messageTypeCode);
		return map;
	}
	
}
