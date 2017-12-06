package com.medical.service.impl.doctor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctoraddressMapper;
import com.medical.mapper.DoctoraddressMapperCustom;
import com.medical.mapper.DoctorcalendarMapper;
import com.medical.mapper.DoctorcalendarMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Hospitaldept;
import com.medical.po.Userinfo;
import com.medical.po.custom.CalendarParmas;
import com.medical.service.iface.doctor.DoctorInfoService;
import com.medical.utils.PictureTool;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.DataResult2;

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
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;

	// 获取我的介绍和我的擅长
	@Override
	public String getNormalInfo(Integer docloginid) throws Exception{
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo != null) {
			Map<String, Object> map = new HashMap<>(16);
			map.put("docexpert", doctorinfo.getDocexpert());
			map.put("docabs", doctorinfo.getDocabs());
			return DataResult.success("获取数据成功", map);
		} else {
			return DataResult.success("获取数据为空", null);
		}

	}

	// 更新我的介绍和我的擅长
	@Override
	public String updateNormalInfo(Integer docloginid, String docexpert, String docabs) throws Exception{
		Doctorinfo doctor = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
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

	// 获取个人信息
	@Override
	public String getInfo(Integer docLoginId, Integer flag) throws Exception{
		if (flag == 1) {
			Map<String, Object> doctorinfo = doctorinfoMapperCustom.selectFirstInfoByDocLoginId(docLoginId);
			if (doctorinfo != null) {
				return DataResult.success("获取数据成功", doctorinfo);
			} else {
				return DataResult.success("获取数据为空", null);
			}
		} else {
			Map<String, Object> doctorinfo = doctorinfoMapperCustom.selectSecondInfoByDocLoginId(docLoginId);
			// 身份证照片 职称 行医资格证 工作证 其他照片
			if (doctorinfo != null) {
				return DataResult.success("获取数据成功", doctorinfo);
			} else {
				return DataResult.success("获取数据为空", null);
			}
		}
	}

	// 更新医生信息
	@Override
	public String updateFirstInfo(Doctorinfo doctor) throws Exception {

		Integer docloginid = doctor.getDocloginid();
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		// 该id对应的医生不为空
		if (doctorlogininfo == null) {
			return DataResult.error("用户不存在");
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
		Doctorinfo doctorinfo2 = doctorinfoMapperCustom.selectByDocLoginId(doctor.getDocloginid());
		if (doctorinfo2 == null) {
			return DataResult.error("用户不存在");
		}
		// 个人信息id
		doctorinfo.setDocid(doctorinfo2.getDocid());
		boolean result = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo) > 0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}

	}

	// 更新医生照片
	@Override
	public String updateSecondInfo(Integer docloginid, Integer type, String oldpicture, MultipartFile[] picture)
			throws Exception {

		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo info = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 该id对应的医生不为空
		if (doctorlogininfo == null || info == null) {
			return DataResult.error("用户不存在");
		}

		int doclogintype = doctorlogininfo.getDoclogintype();
		if (doclogintype == 2) {
			return DataResult.error("已提交审核,个人信息无法修改");
		}
		if (doclogintype == 3) {
			return DataResult.error("已被审核,个人信息无法修改");
		}
		String cardPhotoPath = PictureTool.SavePictures(picture);
		if (oldpicture != null) {
			if (cardPhotoPath != null) {
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
			// 更新成功
			return DataResult.success("更新成功");
		} else {
			// 更新失败
			return DataResult.error("更新失败");
		}

	}

	// 获取常用地址
	@Override
	public String getAddress(Integer docloginid, Integer page) throws Exception{
		PageHelper.startPage(page, 5);
		List<Doctoraddress> result = doctoraddressMapperCustom.selectByDocloginid(docloginid);
		PageInfo<Doctoraddress> pageInfo = new PageInfo<Doctoraddress>(result);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}

	// 添加常用地址
	@Override
	public String addAddress(Doctoraddress doctoraddress) throws Exception{

		int docloginid = doctoraddress.getDocloginid();
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("用户账号不存在");
		}
		doctoraddress.setDocaddresstype(false);
		doctoraddress.setDocaddresschecked(false);
		int result = doctoraddressMapper.insertSelective(doctoraddress);
		if (result > 0) {
			return DataResult.success("新增成功");
		} else {
			return DataResult.error("新增失败");
		}

	}

	// 修改常用地址
	@Override
	public String editAddress(Doctoraddress doctoraddress) throws Exception{

		int docloginid = doctoraddress.getDocloginid();
		int docaddressid = doctoraddress.getDocaddressid();
		Doctoraddress address = doctoraddressMapper.selectByPrimaryKey(docaddressid);
		if (address == null) {
			return DataResult.error("该地址不存在");
		}
		int loginid = address.getDocloginid();
		if (docloginid != loginid) {
			return DataResult.error("用户信息不匹配");
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

	// 删除常用地址
	@Override
	public String delAddress(Integer docloginid, Integer docaddressid) throws Exception{

		Doctoraddress address = doctoraddressMapper.selectByPrimaryKey(docaddressid);
		if (address == null) {
			return DataResult.error("该地址不存在");
		}
		int loginid = address.getDocloginid();
		if (docloginid != loginid) {
			return DataResult.error("用户信息不匹配");
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

	// 设置接诊地址
	@Override
	public String updateAddress(Integer docloginid, Integer docaddressid) throws Exception{
		Doctoraddress doctoraddress = doctoraddressMapper.selectByPrimaryKey(docaddressid);
		if (doctoraddress == null) {
			return DataResult.error("该地址不存在");
		}
		int doctor = doctoraddress.getDocloginid();
		if (docloginid != doctor) {
			return DataResult.error("用户信息不匹配");
		}
		boolean checked = doctoraddress.getDocaddresschecked();
		if (checked) {
			return DataResult.error("该地址已被设置为接诊地");
		}
		// 将所有设置为未选择
		int result = doctoraddressMapperCustom.updateCheckedByDocLoginId(docloginid, 0);
		System.out.println("更新的人数" + result);
		Doctoraddress address = new Doctoraddress();
		address.setDocaddressid(docaddressid);
		address.setDocaddresschecked(true);
		// 设置当前位置为选中
		int upResult = doctoraddressMapper.updateByPrimaryKeySelective(address);
		Doctorinfo doctorallinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
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

	// 获取全部日程
	@Override
	public String getCalendar(Integer docloginid, Integer page) throws Exception{
		PageHelper.startPage(page, 5);
		CalendarParmas calendarParmas = new CalendarParmas();
		calendarParmas.setId(docloginid);
		List<Map<String, Object>> result = doctorcalendarMapperCustom.selectAllInfoByDocloginid(calendarParmas);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(result);
		if (pageInfo != null && pageInfo.getSize() > 0) {
			return DataResult2.success("获取数据成功", pageInfo.getList());

		} else {
			return DataResult2.success("获取数据为空", null);
		}
	}

	// 按月份获取日程
	@Override
	public String getCalendarByMonth(Integer docloginid, String year, String month) throws Exception{
		CalendarParmas calendarParmas = new CalendarParmas();
		calendarParmas.setId(docloginid);
		if (month.length() == 1) {
			month = "0" + month;
		}
		calendarParmas.setTime(year + "-" + month);
		List<Map<String, Object>> result = doctorcalendarMapperCustom.selectAllInfoByDocloginid(calendarParmas);
		if (result != null && result.size() > 0) {
			return DataResult2.success("获取数据成功", result);
		} else {
			return DataResult2.success("获取数据为空", null);
		}
	}

	@Override
	public String addCalendar(Integer docloginid, Date doccalendarday, String doccalendartime, String doccalendaraffair,
			Integer doccalendaradressid) throws Exception{

		List<Doctorcalendar> lists = doctorcalendarMapperCustom.selectByDocloginid(docloginid);
		if (lists.size() == 0) {
			Doctorcalendar doctorcalendar = new Doctorcalendar();
			doctorcalendar.setDoccalendarday(doccalendarday);
			doctorcalendar.setDoccalendartime(doccalendartime);
			doctorcalendar.setDoccalendaraffair(doccalendaraffair);
			doctorcalendar.setDocloginid(docloginid);
			doctorcalendar.setDoccalendaradressid(doccalendaradressid);
			boolean result = doctorcalendarMapperCustom.insertSelectiveReturnId(doctorcalendar) > 0;
			if (result) {
				Map<String, Object> map = doctorcalendarMapperCustom
						.selectAllInfoByDocCalendarId(doctorcalendar.getDoccalendarid());
				return DataResult2.success("新增成功", map);
			} else {
				return DataResult.error("新增失败");
			}
		} else {
			boolean flag = true;
			for (Doctorcalendar doctorcalendar : lists) {
				if (doccalendarday.getTime() == doctorcalendar.getDoccalendarday().getTime()
						&& doccalendartime.equals(doctorcalendar.getDoccalendartime())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				Doctorcalendar doctorcalendar = new Doctorcalendar();
				doctorcalendar.setDoccalendarday(doccalendarday);
				doctorcalendar.setDoccalendartime(doccalendartime);
				doctorcalendar.setDoccalendaraffair(doccalendaraffair);
				doctorcalendar.setDocloginid(docloginid);
				doctorcalendar.setDoccalendaradressid(doccalendaradressid);
				boolean result = doctorcalendarMapperCustom.insertSelectiveReturnId(doctorcalendar) > 0;
				if (result) {
					Map<String, Object> map = doctorcalendarMapperCustom
							.selectAllInfoByDocCalendarId(doctorcalendar.getDoccalendarid());
					return DataResult2.success("新增成功", map);
				} else {
					return DataResult.error("新增失败");
				}
			} else {
				return DataResult.error("该时间段已添加日程");
			}
		}

	}

	// 修改日程
	@Override
	public String editCalendar(Integer doccalendarid, Integer docloginid, Date doccalendarday, String doccalendartime,
			String doccalendaraffair, Integer doccalendaradressid) throws Exception{

		Doctorcalendar calendar = doctorcalendarMapper.selectByPrimaryKey(doccalendarid);
		if (calendar == null) {
			return DataResult2.error("该日程不存在");
		}
		int doctor = calendar.getDocloginid();
		if (docloginid != doctor) {
			return DataResult2.error("该日程不属于该医生");
		}
		Doctorcalendar doctorcalendar = new Doctorcalendar();
		doctorcalendar.setDoccalendarday(doccalendarday);
		doctorcalendar.setDoccalendartime(doccalendartime);
		doctorcalendar.setDoccalendaraffair(doccalendaraffair);
		doctorcalendar.setDocloginid(docloginid);
		doctorcalendar.setDoccalendaradressid(doccalendaradressid);
		doctorcalendar.setDoccalendarid(doccalendarid);
		int result = doctorcalendarMapper.updateByPrimaryKeySelective(doctorcalendar);
		if (result > 0) {
			Map<String, Object> map = doctorcalendarMapperCustom.selectAllInfoByDocCalendarId(doccalendarid);
			return DataResult2.success("修改成功", map);

		} else {
			return DataResult2.error("修改失败");
		}

	}

	@Override
	public String deleteCalendar(Integer doccalendarid, Integer docloginid) throws Exception{
		Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(doccalendarid);
		if (doctorcalendar == null) {
			return DataResult.error("日程不存在");
		}
		Integer doctor = doctorcalendar.getDocloginid();
		if (docloginid != doctor) {
			return DataResult.error("账户信息不匹配");
		}
		Calendar current = Calendar.getInstance();
		// 今天
		Calendar today = Calendar.getInstance();
		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
		// Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		Date day = today.getTime();
		// 三天后的时间
		Calendar tridDay = Calendar.getInstance();
		tridDay.set(Calendar.YEAR, current.get(Calendar.YEAR));
		tridDay.set(Calendar.MONTH, current.get(Calendar.MONTH));
		tridDay.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) + 3);
		tridDay.set(Calendar.HOUR_OF_DAY, 0);
		tridDay.set(Calendar.MINUTE, 0);
		tridDay.set(Calendar.SECOND, 0);
		Date day3 = tridDay.getTime();
		// 日程时间
		Date time = doctorcalendar.getDoccalendarday();
		System.out.println("三天" + tridDay + "time" + time + "今天" + today);
		System.out.println("三天" + day3.getTime());
		System.out.println("某天" + time.getTime());
		System.out.println("今天" + day.getTime());
		System.out.println("结果" + (day3.getTime() > time.getTime() && time.getTime() > day.getTime()));
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(time);
		// 删除的为3天内的日程
		if (day3.getTime() > time.getTime() && time.getTime() > day.getTime()) {
			Doctorinfo info = new Doctorinfo();
			// 修改医生定位
			Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
			info.setDocid(doctorinfo.getDocid());
			Integer addressid = null;
			// 日程上下午
			String Am = doctorcalendar.getDoccalendartime();
			if ("下午".equals(Am)) {
				CalendarParmas calendarParmas = new CalendarParmas();
				calendarParmas.setId(docloginid);
				calendarParmas.setTime(dateString);
				calendarParmas.setKey("上午");
				List<Doctorcalendar> list = doctorcalendarMapperCustom
						.selectByDocloginidAndDayAndTimeInDoc(calendarParmas);
				if (list == null || list.size() > 0) {
					addressid = list.get(0).getDoccalendaradressid();
				} else {
					List<Doctorcalendar> list2 = doctorcalendarMapperCustom
							.selectByDocloginidAndDayInDoc(calendarParmas);
					if (list2 != null && !list2.isEmpty()) {
						addressid = list2.get(0).getDoccalendaradressid();
					}
				}
			} else {
				CalendarParmas calendarParmas = new CalendarParmas();
				calendarParmas.setId(docloginid);
				calendarParmas.setTime(dateString);
				List<Doctorcalendar> list = doctorcalendarMapperCustom.selectByDocloginidAndDayInDoc(calendarParmas);
				if (list != null && !list.isEmpty()) {
					addressid = list.get(0).getDoccalendaradressid();
				}
			}
			if (addressid == null) {
				List<Doctoraddress> address = doctoraddressMapperCustom.selectByDocloginidAndType(docloginid, 1);
				addressid = address.get(0).getDocaddressid();
			}
			Doctoraddress doctoraddress = doctoraddressMapper.selectByPrimaryKey(addressid);
			info.setDocaddressprovince(doctoraddress.getDocaddressprovince());
			info.setDocaddresscity(doctoraddress.getDocaddresscity());
			info.setDocaddressarea(doctoraddress.getDocaddressarea());
			info.setDocaddressother(doctoraddress.getDocaddressother());
			info.setDocaddresslocation(doctoraddress.getDocaddresslocation());
			info.setDocaddresslon(doctoraddress.getDocaddresslon());
			info.setDocaddresslat(doctoraddress.getDocaddresslat());

			int docResult = doctorinfoMapperCustom.updateInfoByPrimaryKey(info);
			int result = doctorcalendarMapper.deleteByPrimaryKey(doccalendarid);
			if (result > 0 && docResult > 0) {
				return DataResult.success("删除成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("删除失败");
			}

		} else {
			int result = doctorcalendarMapper.deleteByPrimaryKey(doccalendarid);
			if (result > 0) {
				return DataResult.success("删除成功");
			} else {
				return DataResult.error("删除失败");
			}
		}

	}

	/*
	 * public String deleteCalendar(Integer doccalendarid, Integer docloginid) {
	 * Doctorcalendar doctorcalendar =
	 * doctorcalendarMapper.selectByPrimaryKey(doccalendarid); if (doctorcalendar ==
	 * null) { return DataResult.error("日程不存在"); } Integer doctor =
	 * doctorcalendar.getDocloginid(); if (docloginid != doctor) { return
	 * DataResult.error("账户信息不匹配"); } Doctoraddress doctoraddress =
	 * doctoraddressMapper.selectByPrimaryKey(doctorcalendar.getDoccalendaradressid(
	 * )); if (doctoraddress == null) { return DataResult.error("地址不存在"); } boolean
	 * check = doctoraddress.getDocaddresschecked(); if (check) { return
	 * DataResult.error("当前日程位置已使用，如需"); }
	 * 
	 * Doctorinfo info = new Doctorinfo(); // 修改医生定位 Doctorinfo doctorinfo =
	 * doctorinfoMapperCustom.selectByDocLoginId(docloginid);
	 * info.setDocid(doctorinfo.getDocid());
	 * 
	 * info.setDocaddressprovince(null); info.setDocaddresscity(null);
	 * info.setDocaddressarea(null); info.setDocaddressother(null);
	 * info.setDocaddresslocation(null);
	 * info.setDocaddresslon(doctorinfo.getDochosplon());
	 * info.setDocaddresslat(doctorinfo.getDochosplat());
	 * 
	 * int docResult = doctorinfoMapperCustom.updateInfoByPrimaryKey(info); int
	 * result = doctorcalendarMapper.deleteByPrimaryKey(doccalendarid); if (result >
	 * 0 && docResult > 0) { return DataResult.success("删除成功"); } else {
	 * TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); return
	 * DataResult.error("删除失败"); }
	 * 
	 * } else { int result = doctorcalendarMapper.deleteByPrimaryKey(doccalendarid);
	 * if (result > 0) { return DataResult.success("删除成功"); } else { return
	 * DataResult.error("删除失败"); } }
	 * 
	 * 
	 * 
	 * }
	 */
	@Override
	public Map<String, Object> getDept() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Hospitaldept> list = hospitaldeptMapperCustom.selectAll();
		if (!list.isEmpty()) {
			// 一级单位及下级单位
			List<Map<String, Object>> data = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> dept = new HashMap<>();
				Hospitaldept hospitaldept = list.get(i);
				int fatherId = hospitaldept.getHospdeptfatherid();
				if (fatherId == 0) {
					dept.put("first", hospitaldept.getHospdeptname());
					int id = hospitaldept.getHospdeptid();
					List<String> sonDept = new ArrayList<>();
					for (int j = 0; j < list.size(); j++) {
						Hospitaldept hospitaldept2 = list.get(j);
						int fatherId2 = hospitaldept2.getHospdeptfatherid();
						System.out.println("id" + id + "......" + fatherId2);
						if (id == fatherId2) {
							sonDept.add(hospitaldept2.getHospdeptname());
						} else {
							continue;
						}
					}
					dept.put("second", sonDept);
					data.add(dept);
				} else {
					continue;
				}
			}
			// 查询成功
			map.put("state", "1");
			map.put("data", data);
		} else {
			// 查询失败，
			map.put("state", "2");
		}

		return map;
	}

	// 修改头像
	@Override
	public String updatePix(Integer docloginid, MultipartFile picture) throws Exception {
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

	@Override
	public String getAllAddress(Integer docloginid) throws Exception{
		List<Doctoraddress> result = doctoraddressMapperCustom.selectByDocloginid(docloginid);
		if (result != null && result.size() > 0) {
			return DataResult.success("获取成功", result);
		} else {
			return DataResult.success("获取成功,数据为空", null);
		}

	}

	@Override
	public String setLocation(String time) throws Exception{
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
				updateAddress(doctorcalendar.getDocloginid(), doctorcalendar.getDoccalendaradressid());
			}
		}
		return "success";
	}

	// 更新百度云ChannelId
	@Override
	public String updateChannelId(Integer docloginid, String channelid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("用户不存在");
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
	public String updateInfoToReview(Integer docloginid) throws Exception{
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("该用户不存在");
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
			return DataResult.success("提交审核成功");
		} else {
			return DataResult.error("提交审核失败");
		}
	}

	// 提交审核
	@Override
	public String updateInfoToCancelReview(Integer docloginid) throws Exception{
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("该用户不存在");
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

}
