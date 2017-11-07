package com.medical.service.iface.doctor;

import java.util.Date;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.Doctoraddress;
import com.medical.po.Doctorinfo;

public interface DoctorInfoService {

	

	int updateSecondInfo(Integer docloginid, Integer type, String oldpicture, MultipartFile[] picture);

	Map<String, Object> getInfo(Integer docLoginId, Integer flag);

	int updateInfo(Doctorinfo doctor) throws Exception;

	Map<String, Object> getAddress(Integer docloginid, Integer page);

	int addAddress(Doctoraddress doctoraddress);

	int editAddress(Doctoraddress doctoraddress);

	int delAddress(Integer docloginid, Integer docaddressid);

	int updateAddress(Integer docloginid, Integer docaddressid);

	int addCalendar(Integer docloginid, Date doccalendarday, String doccalendartime, String doccalendaraffair,
			Integer doccalendaradressid);

	int editCalendar(Integer doccalendarid, Integer docloginid, Date doccalendarday, String doccalendartime,
			String doccalendaraffair, Integer doccalendaradressid);

	int deleteCalendar(Integer doccalendarid, Integer docloginid);

	Map<String, Object> getCalendar(Integer docloginid, Integer page);

	
	Map<String, Object> getDept() throws Exception;

}
