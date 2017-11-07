package com.medical.service.iface.user;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.UsersickCustom;

public interface UserSickService {

	boolean addSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception;

	List<Map<String, Object>> listSicks(Integer userloginid, Integer type);

	Map<String, Object> getSickDetail(Integer usersickid);

	boolean deleteSick(Integer userloginid, Integer usersickid) throws Exception;

	boolean editSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception;

	boolean updateSickStateToPublish(Integer userloginid, Integer usersickid) throws Exception;

	boolean updateSickStateToCancel(Integer userloginid, Integer userSickId) throws Exception;

	List<Map<String, Object>> listRelatedDoctor(Integer userloginid, Integer preordertype) throws Exception;

	boolean addRelatedDoctor(Integer docloginid, Integer userloginid) throws Exception;

	

}
