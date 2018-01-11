package com.medical.service.impl.doctor;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.AccounttypeMapper;
import com.medical.mapper.AdminexamineMapperCustom;
import com.medical.mapper.DoctoraddressMapper;
import com.medical.mapper.DoctoraddressMapperCustom;
import com.medical.mapper.DoctorcalendarMapper;
import com.medical.mapper.DoctorcalendarMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.po.Accounttype;
import com.medical.po.Adminexamine;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.custom.CalendarParmas;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.doctor.DoctorInfoService;
import com.medical.utils.PictureTool;
import com.medical.utils.TimeUtil;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.DataResult2;
import com.sun.org.apache.xpath.internal.operations.Lt;

import net.sf.json.JSONObject;

/**
 * @ClassName: DoctorInfoServiceImpl.java
 * @Description: 医生个人信息接口实现类
 * @author xyh
 * @version V1.0
 * @Date 2017年12月9日 下午5:04:20
 */
/**
 * @ClassName:     DoctorInfoServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月27日 下午9:03:26 
 */
public class DoctorInfoServiceImpl implements DoctorInfoService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctoraddressMapper doctoraddressMapper;
	@Autowired
	private DoctoraddressMapperCustom doctoraddressMapperCustom;
	@Autowired
	private DoctorcalendarMapper doctorcalendarMapper;
	@Autowired
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;
	@Autowired 
	private SenderNotificationService senderNotificationService;
	@Autowired 
	private  AccounttypeMapper accounttypeMapper;
	@Autowired
	private AdminexamineMapperCustom adminexamineMapperCustom;
 
	/*
	 * (非 Javadoc) <p>Title: updatePix</p> <p>Description: 修改头像</p>
	 * 
	 * @param docloginid
	 * 
	 * @param picture
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see com.medical.service.iface.doctor.DoctorInfoService#updatePix(java.lang.
	 * Integer, org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public String updatePix(Integer docloginid, MultipartFile picture) throws Exception {
		Doctorlogininfo doctor = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctor == null) {
			return DataResult.error("账号不存在");
		}
		Doctorlogininfo doctorlogininfo = new Doctorlogininfo();
		String path = PictureTool.SaveOnePicture(picture);
		doctorlogininfo.setDocloginid(docloginid);
		doctorlogininfo.setDocloginpix(path);
		int result = doctorlogininfoMapper.updateByPrimaryKeySelective(doctorlogininfo);
		if (result > 0) {
			return DataResult.success("修改成功", path);
		} else {
			return DataResult.error("修改失败");
		}
	}

	/*
	 * (非 Javadoc) <p>Title: getAbsAndExpert</p> <p>Description: 获取我的介绍和我的擅长</p>
	 * 
	 * @param docloginid
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#getAbsAndExpert(java.lang.
	 * Integer)
	 */
	@Override
	public String getAbsAndExpert(Integer docloginid) throws Exception {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo != null) {
			Map<String, Object> map = new HashMap<>(16);
			map.put("docexpert", doctorinfo.getDocexpert());
			map.put("docabs", doctorinfo.getDocabs());
			return DataResult.success("获取成功", map);
		} else {
			return DataResult.error("账号不存在");
		}

	}

	/*
	 * (非 Javadoc) <p>Title: updateAbsAndExpert</p> <p>Description: 更新我的介绍和我的擅长</p>
	 * 
	 * @param docloginid
	 * 
	 * @param docexpert
	 * 
	 * @param docabs
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#updateAbsAndExpert(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public String updateAbsAndExpert(Integer docloginid, String docexpert, String docabs) throws Exception {
		Doctorinfo doctor = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctor == null) {
			return DataResult.error("账号不存在");
		}
		Doctorinfo doctorinfo = new Doctorinfo();
		doctorinfo.setDocid(doctor.getDocid());
		doctorinfo.setDocabs(docabs);
		doctorinfo.setDocexpert(docexpert);
		boolean result = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo) > 0;
		if (result) {
			return DataResult.success("更新数据成功");
		} else {
			return DataResult.error("更新数据失败");
		}
	}

	/*
	 * (非 Javadoc) <p>Title: getInfo</p> <p>Description: 获取个人信息</p>
	 * 
	 * @param docLoginId
	 * 
	 * @param flag
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#getInfo(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public String getInfo(Integer docloginid, Integer flag) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账号不存在");
		}
		if (flag == 1) {
			Map<String, Object> doctorinfo = doctorinfoMapperCustom.selectFirstInfoByDocLoginId(docloginid);
			return DataResult.success("获取成功", doctorinfo);
		} else {
			Map<String, Object> doctorinfo = doctorinfoMapperCustom.selectSecondInfoByDocLoginId(docloginid);
			// 身份证照片 职称 行医资格证 工作证 其他照片
			return DataResult.success("获取成功", doctorinfo);
		}
	}

	/*
	 * (非 Javadoc) <p>Title: updateSomePicture</p> <p>Description: 更新不同类型图片</p>
	 * 
	 * @param docloginid
	 * 
	 * @param type
	 * 
	 * @param oldpicture
	 * 
	 * @param picture
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#updateSomePicture(java.
	 * lang.Integer, java.lang.Integer, java.lang.String,
	 * org.springframework.web.multipart.MultipartFile[])
	 */
	@Override
	public String updateSomePicture(Integer docloginid, Integer type, String oldpicture, MultipartFile[] picture)
			throws Exception {

		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo info = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorlogininfo == null || info == null) {
			return DataResult.error("账号不存在");
		}

		//int doclogintype = doctorlogininfo.getDoclogintype();
//		if (doclogintype == 2) {
//			return DataResult.error("已提交审核,个人信息无法修改");
//		}
//		if (doclogintype == 3) {
//			return DataResult.error("已被审核,个人信息无法修改");
//		}
		String cardPhotoPath = PictureTool.SavePictures(picture);
		if (StringUtils.isNotBlank(oldpicture)) {
			if (StringUtils.isNotBlank(cardPhotoPath)) {
				oldpicture = oldpicture + "," + cardPhotoPath;
			}
		} else {
			oldpicture = cardPhotoPath;
		}
		Doctorinfo doctorinfo = new Doctorinfo();
		doctorinfo.setDocid(info.getDocid());
		if (type == 1) {
			doctorinfo.setDoccardphoto(oldpicture);
		} else if (type == 2) {
			doctorinfo.setDoctitlephoto(oldpicture);
		} else if (type == 3) {
			doctorinfo.setDocqualphoto(oldpicture);
		} else if (type == 4) {
			doctorinfo.setDocworkcardphoto(oldpicture);
		} else {
			doctorinfo.setDocotherphoto(oldpicture);
		}
		int result = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo);
		if (result > 0) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}

	}

	/*
	 * (非 Javadoc) <p>Title: updateNormalInfo</p> <p>Description: 更新医生信息 </p>
	 * 
	 * @param doctor
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see com.medical.service.iface.doctor.DoctorInfoService#updateNormalInfo(com.
	 * medical.po.Doctorinfo)
	 */
	@Override
	public String updateNormalInfo(Doctorinfo doctor) throws Exception {

		Integer docloginid = doctor.getDocloginid();
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo info = doctorinfoMapperCustom.selectByDocLoginId(doctor.getDocloginid());
		if (doctorlogininfo == null || info == null) {
			return DataResult.error("账号不存在");
		}
		int type = doctorlogininfo.getDoclogintype();
		if (type == 2) {
			return DataResult.error("已提交审核,个人信息无法修改");
		}
		if (type == 3) {
			return DataResult.error("已被审核,个人信息无法修改");
		}
		Doctorinfo doctorinfo = new Doctorinfo();
		doctor.setDocloginid(doctor.getDocloginid());
		doctorinfo.setDocname(doctor.getDocname());
		doctorinfo.setDoccardnum(doctor.getDoccardnum());
		doctorinfo.setDocmale(doctor.getDocmale());
		doctorinfo.setDocage(doctor.getDocage());
		doctorinfo.setDochosp(doctor.getDochosp());
		doctorinfo.setHosplevel(doctor.getHosplevel());

		doctorinfo.setDochospprovince(doctor.getDochospprovince());
		doctorinfo.setDochospcity(doctor.getDochospcity());
		doctorinfo.setDochosparea(doctor.getDochosparea());
		doctorinfo.setDochospother(doctor.getDochospother());
		doctorinfo.setDochosplat(doctor.getDochosplat());
		doctorinfo.setDochosplon(doctor.getDochosplon());
		// 将医生医生位置设置其接诊地
		doctorinfo.setDocaddresslocation(doctor.getDochosp());
		doctorinfo.setDocaddressprovince(doctor.getDochospprovince());
		doctorinfo.setDocaddresscity(doctor.getDochospcity());
		doctorinfo.setDocaddressarea(doctor.getDocaddressarea());
		doctorinfo.setDocaddresscity(doctor.getDochospother());
		doctorinfo.setDocaddresslat(doctor.getDochosplat());
		doctorinfo.setDocaddresslon(doctor.getDochosplon());

		doctorinfo.setDocprimarydept(doctor.getDocprimarydept());
		doctorinfo.setDocseconddept(doctor.getDocseconddept());
		doctorinfo.setDocallday(doctor.getDocallday());
		doctorinfo.setDoctitle(doctor.getDoctitle());
		// 个人信息id
		doctorinfo.setDocid(info.getDocid());
		boolean result = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo) > 0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}

	}

	/*
	 * (非 Javadoc) <p>Title: listAddress</p> <p>Description: 获取常用地址(有分页)</p>
	 * 
	 * @param docloginid
	 * 
	 * @param page
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#listAddress(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public String listAddress(Integer docloginid, Integer page) throws Exception {
		PageHelper.startPage(page, 5);
		List<Doctoraddress> result = doctoraddressMapperCustom.selectByDocloginid(docloginid);
		PageInfo<Doctoraddress> pageInfo = new PageInfo<Doctoraddress>(result);
		return DataResult.success("获取成功", pageInfo.getList());
	}
	//

	/*
	 * (非 Javadoc) <p>Title: listAllAddress</p> <p>Description: 获取全部常用地址(无分页)</p>
	 * 
	 * @param docloginid
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#listAllAddress(java.lang.
	 * Integer)
	 */
	@Override
	public String listAllAddress(Integer docloginid) throws Exception {
		List<Doctoraddress> result = doctoraddressMapperCustom.selectByDocloginid(docloginid);
		return DataResult.success("获取成功", result);
	}

	/*
	 * (非 Javadoc) <p>Title: addAddress</p> <p>Description: 添加常用地址</p>
	 * 
	 * @param doctoraddress
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#addAddress(com.medical.po.
	 * Doctoraddress)
	 */
	@Override
	public String addAddress(Doctoraddress doctoraddress) throws Exception {
		int docloginid = doctoraddress.getDocloginid();
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账号不存在");
		}
		// 非默认医院地址
		doctoraddress.setDocaddresstype(false);
		// 非当前使用地址
		doctoraddress.setDocaddresschecked(false);
		int result = doctoraddressMapper.insertSelective(doctoraddress);
		if (result > 0) {
			return DataResult.success("新增成功");
		} else {
			return DataResult.error("新增失败");
		}

	}

	/*
	 * (非 Javadoc) <p>Title: updateAddress</p> <p>Description: 修改常用地址</p>
	 * 
	 * @param doctoraddress
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#updateAddress(com.medical.
	 * po.Doctoraddress)
	 */
	@Override
	public String updateAddress(Doctoraddress doctoraddress) throws Exception {
		int docloginid = doctoraddress.getDocloginid();
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账号不存在");
		}
		int docaddressid = doctoraddress.getDocaddressid();
		Doctoraddress address = doctoraddressMapper.selectByPrimaryKey(docaddressid);
		if (address == null) {
			return DataResult.error("该地址不存在");
		}
		int loginid = address.getDocloginid();
		if (docloginid != loginid) {
			return DataResult.error("账号信息不匹配");
		}
		boolean type = address.getDocaddresstype();
		if (type) {
			return DataResult.error("默认地址不可修改");
		}
		int result = doctoraddressMapper.updateByPrimaryKeySelective(doctoraddress);
		if (result > 0) {
			return DataResult.success("修改成功");
		} else {
			return DataResult.error("修改失败");
		}
	}

	/*
	 * (非 Javadoc) <p>Title: delAddress</p> <p>Description: 删除常用地址</p>
	 * 
	 * @param docloginid
	 * 
	 * @param docaddressid
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see com.medical.service.iface.doctor.DoctorInfoService#delAddress(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public String delAddress(Integer docloginid, Integer docaddressid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账号不存在");
		}
		Doctoraddress address = doctoraddressMapper.selectByPrimaryKey(docaddressid);
		if (address == null) {
			return DataResult.error("该地址不存在");
		}
		List<Doctorcalendar> list = doctorcalendarMapperCustom.selectByDocCalendarAdressId(docaddressid);
		if (list!=null && list.size()>0) {
			return DataResult.error("该地址已在日程中使用");
		}
		int loginid = address.getDocloginid();
		if (docloginid != loginid) {
			return DataResult.error("账号信息不匹配");
		}
		boolean type = address.getDocaddresstype();
		if (type) {
			return DataResult.error("默认地址不可删除");
		}
		boolean checked = address.getDocaddresschecked();
		if (checked) {
			return DataResult.error("该地址正在使用");
		}
		int result = doctoraddressMapper.deleteByPrimaryKey(docaddressid);
		if (result > 0) {
			return DataResult.success("删除成功");
		} else {
			return DataResult.error("删除失败");
		}

	}

	/*
	 * (非 Javadoc) <p>Title: updateAddressToCheck</p> <p>Description: 设置接诊地址</p>
	 * 
	 * @param docloginid
	 * 
	 * @param docaddressid
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#updateAddressToCheck(java.
	 * lang.Integer, java.lang.Integer)
	 */
	@Override
	public String updateAddressToCheck(Integer docloginid, Integer docaddressid) throws Exception {
		Doctorinfo doctorallinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorallinfo == null) {
			return DataResult.error("账号不存在");
		}
		Doctoraddress doctoraddress = doctoraddressMapper.selectByPrimaryKey(docaddressid);
		if (doctoraddress == null) {
			return DataResult.error("该地址不存在");
		}
		int doctor = doctoraddress.getDocloginid();
		if (docloginid != doctor) {
			return DataResult.error("账号信息不匹配");
		}
		boolean checked = doctoraddress.getDocaddresschecked();
		if (checked) {
			return DataResult.error("该地址已被设置为接诊地");
		}
		// 将所有设置为未选择
		doctoraddressMapperCustom.updateCheckedByDocLoginId(docloginid, 0);
		Doctoraddress address = new Doctoraddress();
		address.setDocaddressid(docaddressid);
		address.setDocaddresschecked(true);
		// 设置当前位置为选中
		int upResult = doctoraddressMapper.updateByPrimaryKeySelective(address);

		Doctorinfo doctorinfo = new Doctorinfo();
		doctorinfo.setDocaddressprovince(doctoraddress.getDocaddressprovince());
		doctorinfo.setDocaddresscity(doctoraddress.getDocaddresscity());
		doctorinfo.setDocaddressarea(doctoraddress.getDocaddressarea());
		doctorinfo.setDocaddressother(doctoraddress.getDocaddressother());
		doctorinfo.setDocaddresslat(doctoraddress.getDocaddresslat());
		doctorinfo.setDocaddresslon(doctoraddress.getDocaddresslon());
		doctorinfo.setDocaddresslocation(doctoraddress.getDocaddresslocation());
		doctorinfo.setDocid(doctorallinfo.getDocid());
		// 更新用户信息表
		int infoResult = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo);
		if (upResult > 0 && infoResult > 0) {
			return DataResult.success("设置成功");
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("设置失败");
		}

	}

	/*
	 * (非 Javadoc) <p>Title: listCalendars</p> <p>Description: 获取全部日程</p>
	 * 
	 * @param docloginid
	 * 
	 * @param page
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#listCalendars(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public String listCalendars(Integer docloginid, Integer page) throws Exception {
		Doctorinfo doctor = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctor == null) {
			return DataResult.error("账号不存在");
		}
		PageHelper.startPage(page, 5);
		CalendarParmas calendarParmas = new CalendarParmas();
		calendarParmas.setId(docloginid);
		List<Map<String, Object>> result = doctorcalendarMapperCustom.selectAllInfoByDocloginid(calendarParmas);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(result);
		return DataResult2.success("获取成功", pageInfo.getList());
	}

	/*
	 * (非 Javadoc) <p>Title: getCalendarByMonth</p> <p>Description: 按月份获取日程</p>
	 * 
	 * @param docloginid
	 * 
	 * @param year
	 * 
	 * @param month
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#getCalendarByMonth(java.
	 * lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public String listCalendarsByMonth(Integer docloginid, String year, String month) throws Exception {
		Doctorinfo doctor = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctor == null) {
			return DataResult.error("账号不存在");
		}
		CalendarParmas calendarParmas = new CalendarParmas();
		calendarParmas.setId(docloginid);
		if (month.length() == 1) {
			month = "0" + month;
		}
		calendarParmas.setTime(year + "-" + month);
		List<Map<String, Object>> result = doctorcalendarMapperCustom.selectAllInfoByDocloginid(calendarParmas);
		return DataResult2.success("获取数据成功", result);
	}

	/*
	 * (非 Javadoc) <p>Title: addCalendar</p> <p>Description: 新增日程</p>
	 * 
	 * @param doctorcalendar
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#addCalendar(com.medical.po
	 * .Doctorcalendar)
	 */
	@Override
	public String addCalendar(Integer docloginid, Date[] doccalendarday,BigDecimal doccalendarprice, String doccalendaraffair,
			Integer doccalendaradressid, String doccalendarmorning, String doccalendarafternoon,
			String doccalendarnight) throws Exception {
		// 医生是否存在
		System.out.println("进入");
		Doctorinfo doctor = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctor == null) {
			return DataResult.error("账号不存在");
		}
		Doctoraddress doctoraddress = doctoraddressMapper.selectByPrimaryKey(doccalendaradressid);
		if (doctoraddress == null) {
			return DataResult.error("该地址不存在");
		}
		for (Date date : doccalendarday) {
			String date2 = TimeUtil.dateToStrLong(date);
			System.out.println("日期"+date);
			int  timeResult =TimeUtil.compareDate(date,new Date());
			if (timeResult==-1) {
				return DataResult.error("不可设置历史日程"+date2);
			}
			//当前时段
			String dateTime = TimeUtil.getDateSx();
			CalendarParmas calendarParmas = new CalendarParmas();
			calendarParmas.setId(docloginid);
			calendarParmas.setTime(TimeUtil.dateToStrLong(date));
			if (StringUtils.isNotBlank(doccalendarmorning)) {
				if (timeResult==0 &&( "下午".equals(dateTime)|| "晚上".equals(dateTime))) {
					   return DataResult.error("不可设置历史日程"+date2+"上午 "+doccalendarmorning);
				}
				calendarParmas.setKey("上午");
				List<Doctorcalendar> lists = doctorcalendarMapperCustom.selectByDocloginidAndDayAndTimeInDoc(calendarParmas);
				if (lists!=null && lists.size()>0) {
					return DataResult.error(date2+" 下午 "+doccalendarmorning+"该时间段已添加日程");
				}
			}
			if (StringUtils.isNotBlank(doccalendarafternoon)) {
				if (timeResult==0 && "晚上".equals(dateTime)) {
					return DataResult.error("不可设置历史日程"+date2+" "+doccalendarafternoon);
				}
				calendarParmas.setKey("下午");
				List<Doctorcalendar> lists = doctorcalendarMapperCustom.selectByDocloginidAndDayAndTimeInDoc(calendarParmas);
				if (lists!=null && lists.size()>0) {
					return DataResult.error(date2+" 下午 "+doccalendarafternoon+"该时间段已添加日程");
				}
			}
			if (StringUtils.isNotBlank(doccalendarnight)) {
				calendarParmas.setKey("晚上");
				List<Doctorcalendar> lists = doctorcalendarMapperCustom.selectByDocloginidAndDayAndTimeInDoc(calendarParmas);
				if (lists!=null && lists.size()>0) {
					return DataResult.error(date2+" 晚上 "+doccalendarnight+"该时间段已添加日程");
				}
			}
			
		}
		for (Date date : doccalendarday) {
			int mooning = 0;
			int afternoon = 0;
			int night = 0;
			Doctorcalendar record = new Doctorcalendar();
			record.setDocloginid(docloginid);
			record.setDocaddresslocation(doctoraddress.getDocaddresslocation());
			record.setDocaddressprovince(doctoraddress.getDocaddressprovince());
			record.setDocaddresscity(doctoraddress.getDocaddresscity());
			record.setDocaddressarea(doctoraddress.getDocaddressarea());
			record.setDocaddressother(doctoraddress.getDocaddressother());
			record.setDocaddresslat(doctoraddress.getDocaddresslat());
			record.setDocaddresslon(doctoraddress.getDocaddresslon());
			record.setDoccalendaradressid(doccalendaradressid);
			record.setDoccalendaraffair(doccalendaraffair);
			record.setDoccalendarprice(doccalendarprice);
			record.setDoccalendarday(date);
			if (StringUtils.isNotBlank(doccalendarmorning)) {
				record.setDoccalendartime("上午");
				record.setDoccalendartimeinterval(doccalendarmorning);
				record.setDoccalendarischeck(false);
				int result =doctorcalendarMapperCustom.insertSelectiveReturnId(record);
				mooning = record.getDoccalendarid();
				record.setDoccalendarid(null);
				if (result<=0) {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return DataResult.error("添加失败");
				}
			}
			if (StringUtils.isNotBlank(doccalendarafternoon)) {
				record.setDoccalendartime("下午");
				record.setDoccalendartimeinterval(doccalendarafternoon);
				record.setDoccalendarischeck(false);
				int result =doctorcalendarMapperCustom.insertSelectiveReturnId(record);
				afternoon = record.getDoccalendarid();
				record.setDoccalendarid(null);
				if (result<=0) {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return DataResult.error("添加失败");
				}
			}
			if (StringUtils.isNotBlank(doccalendarnight)) {
				record.setDoccalendartime("晚上");
				record.setDoccalendartimeinterval(doccalendarnight);
				record.setDoccalendarischeck(false);
				int result =doctorcalendarMapperCustom.insertSelectiveReturnId(record);
				night = record.getDoccalendarid();
				record.setDoccalendarid(null);
				if (result<=0) {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return DataResult.error("添加失败");
				}
			}
			//当天日程需修改定位
			int  timeResult =TimeUtil.compareDate(date,new Date());
			if (timeResult==0) {
				//当前时段
				String dateTime = TimeUtil.getDateSx();
				if ("上午".equals(dateTime)) {
					if (mooning!=0) {
						Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(mooning);
						boolean calendar = updateCalenderToCheck(doctorcalendar);
						if (!calendar) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							return DataResult.error("添加失败");
						}
					}
				}
				if ("下午".equals(dateTime)) {
					if (afternoon!=0) {
						Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(afternoon);
						boolean calendar = updateCalenderToCheck(doctorcalendar);
						if (!calendar) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							return DataResult.error("添加失败");
						}
					}				
				}
				if ("晚上".equals(dateTime)) {
					if (night!=0) {
						Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(night);
						boolean calendar = updateCalenderToCheck(doctorcalendar);
						if (!calendar) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							return DataResult.error("添加失败");
						}
					}	
				}
			}
		}
		return DataResult.success("新增成功");
	}
	
//	@Override
//	public String addCalendar(Doctorcalendar doctorcalendar) throws Exception {
//		
//		// 地址是否存在
//		int docaddressid = doctorcalendar.getDoccalendaradressid();
//		Doctoraddress doctoraddress = doctoraddressMapper.selectByPrimaryKey(docaddressid);
//		if (doctoraddress == null) {
//			return DataResult.error("该地址不存在");
//		}
//		Date day = doctorcalendar.getDoccalendarday();
//		String time = doctorcalendar.getDoccalendartime();
//		CalendarParmas calendarParmas = new CalendarParmas();
//		calendarParmas.setId(docloginid);
//		calendarParmas.setTime(TimeUtil.dateToStrLong(day));
//		calendarParmas.setKey(time);
//		List<Doctorcalendar> lists = doctorcalendarMapperCustom.selectByDocloginidAndDayAndTimeInDoc(calendarParmas);
//		if (lists!=null && lists.size()>0) {
//			return DataResult.error("该时间段已添加日程");
//		}
//		
//		
//		
//		doctorcalendar.setDocaddresslocation(doctoraddress.getDocaddresslocation());
//		doctorcalendar.setDocaddressprovince(doctoraddress.getDocaddressprovince());
//		doctorcalendar.setDocaddresscity(doctoraddress.getDocaddresscity());
//		doctorcalendar.setDocaddressarea(doctoraddress.getDocaddressarea());
//		doctorcalendar.setDocaddressother(doctoraddress.getDocaddressother());
//		doctorcalendar.setDocaddresslat(doctoraddress.getDocaddresslat());
//		doctorcalendar.setDocaddresslon(doctoraddress.getDocaddresslon());
//		boolean result = doctorcalendarMapperCustom.insertSelectiveReturnId(doctorcalendar) > 0;
//		if (check) {
//			boolean calendar = updateCalenderToCheck(doctorcalendar);
//			if (!calendar) {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("新增失败");
//			}
//		}
//		if (result) {
//				Map<String, Object> map = doctorcalendarMapperCustom
//						.selectAllInfoByDocCalendarId(doctorcalendar.getDoccalendarid());
//				return DataResult2.success("新增成功", map);
//		} else {
//				return DataResult.error("新增失败");
//		}
//		
//
//	}

	/*
	 * (非 Javadoc) <p>Title: updateCalendar</p> <p>Description: 修改日程</p>
	 * 
	 * @param doctorcalendar
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#updateCalendar(com.medical
	 * .po.Doctorcalendar)
	 */
	@Override
	public String updateCalendar(Doctorcalendar doctorcalendar) throws Exception {
		int docloginid = doctorcalendar.getDocloginid();
		Doctorinfo doctor = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctor == null) {
			return DataResult.error("账号不存在");
		}
		int doccalendarid = doctorcalendar.getDoccalendarid();
		Doctorcalendar calendar = doctorcalendarMapper.selectByPrimaryKey(doccalendarid);
		if (calendar == null) {
			return DataResult2.error("该日程不存在");
		}
		boolean check = calendar.getDoccalendarischeck();
		int doctorid = calendar.getDocloginid();
		if (docloginid != doctorid) {
			return DataResult2.error("账号信息不匹配");
		}
		// 地址是否存在
		Integer docaddressid = doctorcalendar.getDoccalendaradressid();
		if (docaddressid!=null) {
			Doctoraddress doctoraddress = doctoraddressMapper.selectByPrimaryKey(docaddressid);
			if (doctoraddress == null) {
				return DataResult.error("该地址不存在");
			}
			doctorcalendar.setDocaddresslocation(doctoraddress.getDocaddresslocation());
			doctorcalendar.setDocaddressprovince(doctoraddress.getDocaddressprovince());
			doctorcalendar.setDocaddresscity(doctoraddress.getDocaddresscity());
			doctorcalendar.setDocaddressarea(doctoraddress.getDocaddressarea());
			doctorcalendar.setDocaddressother(doctoraddress.getDocaddressother());
			doctorcalendar.setDocaddresslat(doctoraddress.getDocaddresslat());
			doctorcalendar.setDocaddresslon(doctoraddress.getDocaddresslon());
		}
		int result = doctorcalendarMapper.updateByPrimaryKeySelective(doctorcalendar);
		if (check) {
			boolean calender = updateCalenderToCheck(doctorcalendar);
			if (!calender) {
				return DataResult2.error("修改失败");
			}
		}
		if (result > 0) {
			Map<String, Object> map = doctorcalendarMapperCustom.selectAllInfoByDocCalendarId(doccalendarid);
			return DataResult2.success("修改成功", map);
		} else {
			return DataResult2.error("修改失败");
		}

	}

	/*
	 * (非 Javadoc) <p>Title: deleteCalendar</p> <p>Description: 删除日程</p>
	 * 
	 * @param doccalendarid
	 * 
	 * @param docloginid
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.doctor.DoctorInfoService#deleteCalendar(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public String deleteCalendar(Integer doccalendarid, Integer docloginid) throws Exception {
		Doctorinfo doctor = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctor == null) {
			return DataResult.error("账号不存在");
		}
		Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(doccalendarid);
		if (doctorcalendar == null) {
			return DataResult.error("日程不存在");
		}
		Integer doctorid = doctorcalendar.getDocloginid();
		if (docloginid != doctorid) {
			return DataResult.error("账号信息不匹配");
		}
		boolean check = doctorcalendar.getDoccalendarischeck();
		if (check) {
			Doctorinfo info = new Doctorinfo();
			// 修改医生定位
			Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
			info.setDocid(doctorinfo.getDocid());
			info.setDocaddressprovince("");
			info.setDocaddresscity("");
			info.setDocaddressarea("");
			info.setDocaddressother("");
			info.setDocaddresslocation("");
			info.setDocaddresslon(doctorinfo.getDochosplon());
			info.setDocaddresslat(doctorinfo.getDochosplat());
			int result = doctorinfoMapperCustom.updateInfoByPrimaryKey(info);
			if (result <= 0) {
				return DataResult.error("删除失败");
			}
		}
		int result = doctorcalendarMapper.deleteByPrimaryKey(doccalendarid);
		if (result > 0) {
			return DataResult.success("删除成功");
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("删除失败");
		}
	}

	/* (非 Javadoc)  
	* <p>Title: updateChannelId</p>  
	* <p>Description: 更新百度云ChannelId</p>  
	* @param docloginid
	* @param channelid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorInfoService#updateChannelId(java.lang.Integer, java.lang.String)  
	*/  
	@Override
	public String updateChannelId(Integer docloginid, String channelid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账号不存在");
		}
		Doctorlogininfo record = new Doctorlogininfo();
		record.setDocloginid(docloginid);
		record.setDocloginchannelid(channelid);
		boolean result = doctorlogininfoMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}

	}

	// 提交审核
	@Override
	public String updateInfoToReview(Integer docloginid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账号不存在");
		}
		int type = doctorlogininfo.getDoclogintype();
		if (type == 2) {
			return DataResult.error("已提交审核");
		}
		if (type == 3) {
			return DataResult.error("已通过审核");
		}
		Doctorlogininfo record = new Doctorlogininfo();
		record.setDocloginid(docloginid);
		record.setDocloginsubchecktime(new Date());
		// 等待审核
		record.setDoclogintype(2);
		boolean result = doctorlogininfoMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("type", "7");
			senderNotificationService.createMsgDoctorToAdmin(docloginid, 1, "消息通知", "提交审核", jsonCustormCont);
			return DataResult.success("提交审核成功");
		} else {
			return DataResult.error("提交审核失败");
		}
	}

	// 撤销审核
	@Override
	public String updateInfoToCancelReview(Integer docloginid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账号不存在");
		}
		int type = doctorlogininfo.getDoclogintype();
		if (type == 1) {
			return DataResult.error("未提交审核");
		}
		if (type == 3) {
			return DataResult.error("已通过审核");
		}
		if (type == 4) {
			return DataResult.error("未通过审核");
		}
		Doctorlogininfo record = new Doctorlogininfo();
		record.setDocloginid(docloginid);
		record.setDocloginsubchecktime(new Date());
		// 等待审核
		record.setDoclogintype(1);
		boolean result = doctorlogininfoMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("提交审核成功");
		} else {
			return DataResult.error("提交审核失败");
		}
	}
	
	@Override
	public String updateLocation(String time) throws Exception {
		Calendar current = Calendar.getInstance();
		Calendar day = Calendar.getInstance();
		day.set(Calendar.YEAR, current.get(Calendar.YEAR));
		day.set(Calendar.MONTH, current.get(Calendar.MONTH));
		day.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
		day.set(Calendar.HOUR_OF_DAY, 0);
		day.set(Calendar.MINUTE, 0);
		day.set(Calendar.SECOND, 0);
		Date day2 = day.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time2 = df.format(day2);
		System.out.println("时间" + time2);
		List<Doctorcalendar> list = doctorcalendarMapperCustom.selectByDayAndTime(time2, time);
		if (list.size() != 0) {
			for (Doctorcalendar doctorcalendar : list) {
				boolean result = updateCalenderToCheck(doctorcalendar);
				if (!result) {
					return "fail";
				}
			}
		}
		return "success";
	}
	
	/**
	 *设置当前日程
	 * */
	@Transactional(rollbackFor = Exception.class)
	public boolean updateCalenderToCheck(Doctorcalendar calendar) throws Exception {
		int docloginid = calendar.getDocloginid();
		int doccalendarid = calendar.getDoccalendarid();
		List<Doctorcalendar> list = doctorcalendarMapperCustom.selectByDocloginid(docloginid);
		for (Doctorcalendar doctorcalendar : list) {
			boolean check = doctorcalendar.getDoccalendarischeck();
			if (check) {
				doctorcalendar.setDoccalendarischeck(false);
				int canlendar = doctorcalendarMapper.updateByPrimaryKeySelective(doctorcalendar);
				if (canlendar<=0) {
					return false;
				}
			}
		}
		Doctorcalendar record = new Doctorcalendar();
		record.setDoccalendarid(doccalendarid);
		record.setDoccalendarischeck(true);
		int result =doctorcalendarMapper.updateByPrimaryKeySelective(record);
		if (result <=0) {
			return false;
		}
		boolean upResult = updateAddressToCheck2(calendar);
		if (upResult) {
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
		
	}
	/**
	 *设置当前地址
	 * */
	@Transactional(rollbackFor = Exception.class)
	public boolean updateAddressToCheck2(Doctorcalendar doctorcalendar) throws Exception {
		int docloginid = doctorcalendar.getDocloginid();
		Doctorinfo doctorallinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		
		// 将所有设置为未选择
		doctoraddressMapperCustom.updateCheckedByDocLoginId(docloginid, 0);
		Doctoraddress address = new Doctoraddress();
		int docaddressid = doctorcalendar.getDoccalendaradressid();
		Doctoraddress doctoraddress = doctoraddressMapper.selectByPrimaryKey(docaddressid);
		if (doctoraddress!=null ) {
			address.setDocaddressid(docaddressid);
			address.setDocaddresschecked(true);
			// 设置当前位置为选中
			int upResult = doctoraddressMapper.updateByPrimaryKeySelective(address);
			if (upResult<=0) {
				return false;
			}
		}
		Doctorinfo doctorinfo = new Doctorinfo();
		doctorinfo.setDocaddressprovince(doctorcalendar.getDocaddressprovince());
		doctorinfo.setDocaddresscity(doctorcalendar.getDocaddresscity());
		doctorinfo.setDocaddressarea(doctorcalendar.getDocaddressarea());
		doctorinfo.setDocaddressother(doctorcalendar.getDocaddressother());
		doctorinfo.setDocaddresslat(doctorcalendar.getDocaddresslat());
		doctorinfo.setDocaddresslon(doctorcalendar.getDocaddresslon());
		doctorinfo.setDocaddresslocation(doctorcalendar.getDocaddresslocation());
		doctorinfo.setDocid(doctorallinfo.getDocid());
		// 更新用户信息表
		int infoResult = doctorinfoMapperCustom.updateInfoByPrimaryKey(doctorinfo);
		if (infoResult > 0) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}

	}
	
	/* (非 Javadoc)  
	* <p>Title: getReviewInfo</p>  
	* <p>Description: </p>  
	* @param docloginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorInfoService#getReviewInfo(java.lang.Integer)  
	*/  
	@Override
	public String getReviewInfo(Integer docloginid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
			if (doctorlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		int userlogintype =  doctorlogininfo.getDoclogintype();
		Accounttype accounttype = accounttypeMapper.selectByPrimaryKey(userlogintype);
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", userlogintype);
		map.put("typename", accounttype.getAccounttypename());
		if (userlogintype==3 || userlogintype== 4) {
			List<Adminexamine> list = adminexamineMapperCustom.selectByExamineTargetIdAndTypeOrderByTime(docloginid, 2);
			if (list!=null && list.size()>0) {
				map.put("msg", list.get(0).getExamineideas());
			}else {
				map.put("msg", "");
			}
		}else {
			map.put("msg", "");
		}
		return DataResult.success("获取成功", map);
	}

	/* (非 Javadoc)  
	* <p>Title: updateFee</p>  
	* <p>Description: </p>  
	* @param docloginid
	* @param docfee
	* @return  
	* @see com.medical.service.iface.doctor.DoctorInfoService#updateFee(java.lang.Integer, java.math.BigDecimal)  
	*/  
	@Override
	public String updateFee(Integer docloginid, BigDecimal docprice) throws Exception{
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo==null) {
			return DataResult.error("账户不存在");
		}
		Doctorinfo record = new Doctorinfo();
		record.setDocid(doctorinfo.getDocid());
		record.setDocprice(docprice);;
		boolean result = doctorinfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("设置成功");
		}else {
			return DataResult.error("设置失败");
		}
		
	}

	/* (非 Javadoc)  
	* <p>Title: getFee</p>  
	* <p>Description: </p>  
	* @param docloginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorInfoService#getFee(java.lang.Integer)  
	*/  
	@Override
	public String getFee(Integer docloginid) throws Exception {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo==null) {
			return DataResult.error("账户不存在");
		}
		return DataResult.success("获取成功", doctorinfo.getDocprice());
	}

	
	

}
