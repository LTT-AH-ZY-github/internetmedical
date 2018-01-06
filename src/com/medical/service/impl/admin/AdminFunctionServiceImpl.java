package com.medical.service.impl.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.AdminexamineMapper;
import com.medical.mapper.AdminlogininfoMapper;
import com.medical.mapper.DoctoraddressMapper;
import com.medical.mapper.DoctoraddressMapperCustom;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.FamilyinfoMapperCustom;
import com.medical.mapper.FeedbackMapper;
import com.medical.mapper.FeedbackMapperCustom;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.po.Adminexamine;
import com.medical.po.Adminlogininfo;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Familyinfo;
import com.medical.po.Feedback;
import com.medical.po.Hospitaldept;
import com.medical.po.Hosplogininfo;
import com.medical.po.Userinfo;
import com.medical.po.Userlogininfo;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.admin.AdminFunctionService;
import com.medical.utils.result.DataResult;
import net.sf.json.JSONObject;




/**
 * @ClassName:     AdminFunctionServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月19日 下午9:08:24 
 */
public class AdminFunctionServiceImpl implements AdminFunctionService{
	@Autowired
	private AdminlogininfoMapper adminlogininfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private HosplogininfoMapper hosplogininfoMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private HospitaldeptMapper hospitaldeptMapper;
	@Autowired
	private SenderNotificationService senderNotificationService;
	@Autowired
	private FamilyinfoMapperCustom familyinfoMapperCustom;
	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private DoctoraddressMapper doctoraddressMapper;
	@Autowired
	private DoctoraddressMapperCustom doctoraddressMapperCustom;
	@Autowired
	private AdminexamineMapper adminexamineMapper;
	@Autowired
	private FeedbackMapperCustom feedbackMapperCustom;
	@Autowired
	private FeedbackMapper feedbackMapper;
	
	//管理员根据用户账号类型查询用户 
	@Override
	public String listUser(Integer adminloginid,Integer limit,Integer offset,Integer type) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1; 
		if (offset!=0) {
			pageNo =  offset/limit+1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = userinfoMapperCustom.selectByUserLoginTypeInAdmin(type,0);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			//总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取成功", data);
		}else {
			return DataResult.success("获取成功", null);
		}
	}
	
	//获取用户详细信息
	@Override
	public String getUserDetail(Integer adminloginid, Integer userloginid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Map<String, Object> map = userinfoMapperCustom.selectInfoByLoginIdInAdmin(userloginid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取成功", map);
		}else {
			return DataResult.error("该用户不存在");
		}
	}
	
	//用户审核
	@Override
	public String updateUserType(Integer adminloginid, Integer userloginid, Boolean type,String idea) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("用户账号不存在");
		}
		int userlogintype = userlogininfo.getUserlogintype();
		if (userlogintype==1) {
			return DataResult.error("用户账号未提交审核");
		}
		if (userlogintype==3) {
			return DataResult.error("用户账号已通过审核");
		}
		if (userlogintype==4) {
			return DataResult.error("用户账号处于未通过审核状态");
		}
		Userlogininfo record = new Userlogininfo();
		record.setUserloginid(userloginid);
		if (type) {
			List<Familyinfo> list = familyinfoMapperCustom.selectByUserLoginIdAndType(userloginid, 1);
			if (list==null || list.size() == 0) {
				Familyinfo familyinfo = new Familyinfo();
				familyinfo.setUserloginid(userloginid);
				familyinfo.setFamilyname(userinfo.getUsername());
				familyinfo.setFamilyage(userinfo.getUserage());
				familyinfo.setFamilymale(userinfo.getUsermale());
				familyinfo.setFamilytype(true);
				// 插入到亲属信息表
				int result = familyinfoMapper.insertSelective(familyinfo);
				if (result<=0) {
					return DataResult.error("审核失败");
				}
			}
			//通过审核
			record.setUserlogintype(3);
		} else {
			//未通过审核
			record.setUserlogintype(4);
		}
		Adminexamine adminexamine = new Adminexamine();
		adminexamine.setExamineideas(idea);
		adminexamine.setExamineresult(type);
		adminexamine.setExaminetargetid(userloginid);
		//1为审核用户
		adminexamine.setExaminetype(1);
		adminexamine.setExaminetime(new Date());
		boolean examineresult = adminexamineMapper.insertSelective(adminexamine)>0;
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result && examineresult) {
			JSONObject jsonCustormCont = new JSONObject();
			String words = "已通过审核申请";
			if (!type) {
				words="未通过审核申请";
				if (StringUtils.isNotBlank(idea)) {
					words+=","+idea;
				}
				
			}
			senderNotificationService.createMsgAdminToUser(adminloginid, userloginid, "消息通知", words, jsonCustormCont);
			return DataResult.success("审核成功");
		} else {
			return DataResult.error("审核失败");
		}
	}

	// 管理员根据用户账号类型查询医生
	@Override
	public String listDoctor(Integer adminloginid, Integer limit, Integer offset, Integer type) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo == null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = doctorinfoMapperCustom.selectByDocLoginTypeInAdmin(type,0);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.success("获取成功", null);
		}
	}
	
	// 管理员获取医生详情
	@Override
	public String getDoctorDetail(Integer adminloginid, Integer docloginid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Map<String, Object> map = doctorinfoMapperCustom.selectInfoByDocLoginIdInAdmin(docloginid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取成功", map);
		}else {
			return DataResult.success("获取成功", null);
		}
	}
	//审核医生
	@Override
	public String updateDoctorType(Integer adminloginid, Integer docloginid, Boolean type,String idea) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("医生账号不存在");
		}
		int doclogintype = doctorlogininfo.getDoclogintype();
		if (doclogintype==1) {
			return DataResult.error("医生账号未提交审核");
		}
		if (doclogintype==3) {
			return DataResult.error("医生账号已通过审核");
		}
		if (doclogintype==4) {
			return DataResult.error("医生账号处于未通过审核状态");
		}
		Doctorlogininfo record = new Doctorlogininfo();
		record.setDocloginid(docloginid);
		if (type) {
			List<Doctoraddress> address = doctoraddressMapperCustom.selectByDocloginidAndType(docloginid, 1);
			if (address==null || address.size()==0) {
				Doctoraddress doctoraddress = new Doctoraddress();
				doctoraddress.setDocaddresslocation(doctorinfo.getDochosp());;
				doctoraddress.setDocaddressprovince(doctorinfo.getDochospprovince());
				doctoraddress.setDocaddressarea(doctorinfo.getDochosparea());
				doctoraddress.setDocaddresscity(doctorinfo.getDochospcity());
				doctoraddress.setDocaddressother(doctorinfo.getDochospother());
				doctoraddress.setDocaddresslat(doctorinfo.getDochosplat());
				doctoraddress.setDocaddresslon(doctorinfo.getDochosplon());
				doctoraddress.setDocloginid(docloginid);
				doctoraddress.setDocaddresstype(true);
				doctoraddress.setDocaddresschecked(false);
				int result = doctoraddressMapper.insertSelective(doctoraddress);
				if (result<=0) {
					return DataResult.error("审核失败");
				}
			}
			record.setDoclogintype(3);
			
		} else {
			record.setDoclogintype(4);
		}
		Adminexamine adminexamine = new Adminexamine();
		adminexamine.setExamineideas(idea);
		adminexamine.setExamineresult(type);
		adminexamine.setExaminetargetid(docloginid);
		//2为审核医生
		adminexamine.setExaminetype(2);
		adminexamine.setExaminetime(new Date());
		boolean examineresult = adminexamineMapper.insertSelective(adminexamine)>0;
		boolean result = doctorlogininfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result&&examineresult) {
			JSONObject jsonCustormCont = new JSONObject();
			String words = "已通过审核申请";
			if (!type) {
				words="未通过审核申请";
				if (StringUtils.isNotBlank(idea)) {
					words+=","+idea;
				}
				
			}
			senderNotificationService.createMsgAdminToDoctor(adminloginid, docloginid, "消息通知", words, jsonCustormCont);
			return DataResult.success("审核成功");
		} else {
			return DataResult.error("审核失败");
		}
	}
	
	//获取医院列表信息
	@Override
	public String listHospital(Integer adminloginid, Integer limit, Integer offset, Integer type) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo == null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hospinfoMapperCustom.selectByHospTypeInAdmin(type,0);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	
	//获取医院详细信息
	@Override
	public String getHospitalDetail(Integer adminloginid, Integer hosploginid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Map<String, Object> map = hospinfoMapperCustom.selectInfoByHospLoginIdInAdmin(hosploginid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取成功", map);
		}else {
			return DataResult.success("获取成功", null);
		}
	}
	//审核医院
	@Override
	public String updateHospitalType(Integer adminloginid, Integer hosploginid, Boolean type,String idea) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo == null) {
			return DataResult.error("医院账号不存在");
		}
		int hosplogintype = hosplogininfo.getHosplogintype();
		if (hosplogintype==1) {
			return DataResult.error("医院账号未提交审核");
		}
		if (hosplogintype==3) {
			return DataResult.error("医院账号已通过审核");
		}
		if (hosplogintype==4) {
			return DataResult.error("医院账号处于未通过审核状态");
		}
		Hosplogininfo record = new Hosplogininfo();
		record.setHosploginid(hosploginid);
		if (type) {
			record.setHosplogintype(3);
		} else {
			record.setHosplogintype(4);
		}
		Adminexamine adminexamine = new Adminexamine();
		adminexamine.setExamineideas(idea);
		adminexamine.setExamineresult(type);
		adminexamine.setExaminetargetid(hosploginid);
		//3为审核医院
		adminexamine.setExaminetype(3);
		adminexamine.setExaminetime(new Date());
		boolean examineresult = adminexamineMapper.insertSelective(adminexamine)>0;
		boolean result = hosplogininfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result && examineresult ) {
			JSONObject jsonCustormCont = new JSONObject();
			String words = "已通过审核申请";
			if (!type) {
				words="未通过审核申请";
				if (StringUtils.isNotBlank(idea)) {
					words+=","+idea;
				}
				
			}
			senderNotificationService.createMsgAdminToHospital(adminloginid, hosploginid, "消息通知", words, jsonCustormCont);
			return DataResult.success("审核成功");
		} else {
			return DataResult.error("审核失败");
		}
	}

	
	@Override
	public String listDept(Integer adminloginid, Integer limit, Integer offset,Integer check) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hospitaldeptMapperCustom.selectByCheck(check,1);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			System.out.println("数据"+pageInfo.getList());
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.success("获取成功", null);
		}
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.admin.AdminFunctionService#checkDept(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String checkDept(Integer adminloginid, Integer hospdeptid, Integer hospdeptfatherid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		//审核为一级部门
		if (hospdeptfatherid==0) {
			Hospitaldept record = new Hospitaldept();
			record.setHospdeptid(hospdeptid);
			record.setHospdeptfatherid(0);
			//2为审核
			record.setHospdeptischeck(2);
			boolean result = hospitaldeptMapper.updateByPrimaryKeySelective(record)>0;
			if (result) {
				return DataResult.success("审核成功");
			} else {
				return DataResult.error("审核失败");
			}
		}else {
			Hospitaldept hospitaldept = hospitaldeptMapper.selectByPrimaryKey(hospdeptfatherid);
			if (hospitaldept == null) {
				return DataResult.error("该一级部门不存在");
			}
			int check = hospitaldept.getHospdeptischeck();
			if (check==1) {
				return DataResult.error("该一级部门未审核");
			}
			Hospitaldept record = new Hospitaldept();
			record.setHospdeptid(hospdeptid);
			record.setHospdeptfatherid(hospdeptfatherid);
			//2为审核
			record.setHospdeptischeck(2);
			boolean result = hospitaldeptMapper.updateByPrimaryKeySelective(record)>0;
			if (result) {
				return DataResult.success("审核成功");
			} else {
				return DataResult.error("审核失败");
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.admin.AdminFunctionService#listFirstDept(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String listFirstDept(Integer adminloginid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		List<Map<String, Object>> list = hospitaldeptMapperCustom.selectFirstDept();
		return DataResult.success("获取成功", list);
	}

	/* (非 Javadoc)  
	* <p>Title: listFeedBack</p>  
	* <p>Description: </p>  
	* @param adminloginid
	* @param type
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.admin.AdminFunctionService#listFeedBack(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listFeedBack(Integer adminloginid,  Boolean check, Integer type, Integer limit, Integer offset) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("check", check);
		List<Feedback> list = 	feedbackMapperCustom.selectByTypeAndCheck(map);
		PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.success("获取成功", null);
		}
	}

	@Override
	public String updateFeedBackToCheck(Integer adminloginid, Integer feedbackid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Feedback feedback = new Feedback();
		feedback.setFeedbackid(feedbackid);
		feedback.setFeedbackischeck(true);
		feedback.setFeedbackchecktime(new Date());
		boolean result = feedbackMapper.updateByPrimaryKeySelective(feedback)>0;
		if (result) {
			return DataResult.success("操作成功");
		} else {
			return DataResult.error("操作失败");
		}
			
		
	}

	

}
