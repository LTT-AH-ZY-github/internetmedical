package com.medical.service.iface.doctor;

import java.util.Map;

public interface DoctorHomeService {

	Map<String, Object> listSick(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,
			String time, String province, String city, String area);

	Map<String, Object> getSickDetail(Integer usersickid) throws Exception;

}
