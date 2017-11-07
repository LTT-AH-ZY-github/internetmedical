package com.baidu.yun.push.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.medical.mapper.CityMapperCustom;
import com.medical.mapper.DoctorcommentMapper;
import com.medical.mapper.DoctorcommentMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.mapper.DoctorskdMapperCustom;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.FamilyinfoMapperCustom;
import com.medical.mapper.HospitalcommentMapper;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogMapper;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Familyinfo;
import com.medical.po.Usersick;
import com.medical.service.iface.user.UserSickService;

import net.sf.json.JSONObject;

public class PushByTypeInAndroid {
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private static UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private static UserlogininfoMapperCustom userlogininfoMapperCustom;
	@Autowired
	private UserlogMapper userlogMapper;
	@Autowired
	private static FamilyinfoMapper familyinfoMapper;
	@Autowired
	private FamilyinfoMapperCustom familyinfoMapperCustom;
	@Autowired
	private CityMapperCustom cityMapperCustom;
	@Autowired
	private static UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private static DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private static DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorskdMapperCustom doctorskdMapperCustom;
	@Autowired
	private DoctorskdMapper doctorskdMapper;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	@Autowired
	private DoctorcommentMapper doctorcommentMapper;
	@Autowired
	private HospitalcommentMapper hospitalcommentMapper;
	@Autowired
	private DoctorcommentMapperCustom doctorcommentMapperCustom;
	
	// 申请病情
	public static void pushMsgToApply(Integer userloginid, Integer docloginid, Integer usersickid)
			throws PushClientException, PushServerException {
		JSONObject jsonCustormCont = new JSONObject();
		jsonCustormCont.put("docloginid", docloginid);
		jsonCustormCont.put("usersickid", usersickid);
		// 1为 申请病情
		jsonCustormCont.put("type", 1);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		
		String msg = doctorinfo.getDocname() + "医生申请了您的病情";
		String channelid = userlogininfoMapper.selectByPrimaryKey(userloginid).getUserloginchannelid();
		PushToAndroid.pushMsgToSingleDevice(channelid, "等待确认", msg, jsonCustormCont);

	}
	//选择医生
	public static void pushMsgToChoseDoctor(Integer userloginid,Integer docloginid,Integer userorderid,Integer familyid) throws PushClientException, PushServerException {
		JSONObject jsonCustormCont = new JSONObject();
		jsonCustormCont.put("userloginid", userloginid);
		jsonCustormCont.put("userorderid", userorderid);
		//2为选择医生
		jsonCustormCont.put("type", 2);
		Familyinfo familyinfo = familyinfoMapper.selectByPrimaryKey(familyid);
		String msg = familyinfo.getFamilyname()+"选择您就诊";
		String channelid = doctorlogininfoMapper.selectByPrimaryKey(docloginid).getDocloginchannelid();
		PushToAndroid.pushMsgToSingleDevice(channelid, "等待确认订单", msg, jsonCustormCont);

	}
	//选择医生
	public static void pushMsgToacceptDoctor(Integer userloginid,Integer docloginid,Integer userorderid,Integer familyid) throws PushClientException, PushServerException {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("userloginid", userloginid);
			jsonCustormCont.put("userorderid", userorderid);
			//2为选择医生
			jsonCustormCont.put("type", 2);
			Familyinfo familyinfo = familyinfoMapper.selectByPrimaryKey(familyid);
			String msg = familyinfo.getFamilyname()+"选择您就诊";
			String channelid = doctorlogininfoMapper.selectByPrimaryKey(docloginid).getDocloginchannelid();
			PushToAndroid.pushMsgToSingleDevice(channelid, "等待确认订单", msg, jsonCustormCont);

		}
}
