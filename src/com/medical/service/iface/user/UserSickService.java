package com.medical.service.iface.user;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.UsersickCustom;

public interface UserSickService {
	/**
	 * 新增病情
	 * */
	String addSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception;
	/**
	 * 按type获取病情
	 * */
	String listSicks(Integer userloginid, Integer type,Integer page);
	/**
	 * 获取病情详情
	 * */
	String getSickDetail(Integer userloginid, Integer usersickid);
	/**
	 * 删除病情
	 * */
	String deleteSick(Integer userloginid, Integer usersickid) throws Exception;
	/**
	 * 修改病情
	 * */
	String editSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception;
	/**
	 * 发布病情
	 * */
	String updateSickStateToPublish(Integer userloginid, Integer usersickid) throws Exception;
	/**
	 * 取消发布病情
	 * */
	String updateSickStateToCancel(Integer userloginid, Integer userSickId) throws Exception;
	/**
	 * 获取病情相关医生
	 * */
	String listRelatedDoctor(Integer userloginid, Integer preordertype, Integer page) throws Exception;
	/**
	 * 预选医生
	 * */
	String addRelatedDoctor(Integer docloginid, Integer userloginid) throws Exception;

	

}
