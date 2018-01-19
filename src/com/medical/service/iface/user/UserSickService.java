package com.medical.service.iface.user;

import org.springframework.web.multipart.MultipartFile;

public interface UserSickService {

	/**
	 * @Title: addSick
	 * @Description:  新增病情
	 * @param userloginid
	 * @param familyid
	 * @param usersickdesc
	 * @param usersickprimarydept
	 * @param usersickseconddept
	 * @param pictureFile
	 * @return
	 * @return: String
	 */
	String addSick(Integer userloginid, Integer familyid, String usersickdesc, String usersickprimarydept,
			String usersickseconddept, MultipartFile[] pictureFile) throws Exception;

	/**
	 * @Title: listSicks
	 * @Description: 按type获取病情
	 * @param userloginid
	 *            用户登录id
	 * @param type
	 *            类型
	 * @param page
	 *            当前页
	 * @return
	 * @return: String
	 */
	String listSick(Integer userloginid, Integer type, Integer page) throws Exception;

	/**
	 * @Title: getSickDetail
	 * @Description: 获取病情详情
	 * @param userloginid
	 *            用户登录id
	 * @param usersickid
	 *            病情id
	 * @return
	 * @return: String
	 */
	String getSickDetail(Integer userloginid, Integer usersickid) throws Exception;

	/**
	 * @Title: deleteSick
	 * @Description: 删除病情
	 * @param userloginid
	 *            用户登录id
	 * @param usersickid
	 *            病情id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String deleteSick(Integer userloginid, Integer usersickid) throws Exception;

	/**
	 * @Title: editSick
	 * @Description: 修改病情
	 * @param usersickid
	 * @param userloginid
	 * @param familyid
	 * @param usersickdesc
	 * @param usersickprimarydept
	 * @param usersickseconddept
	 * @param pictureFile
	 * @param usersickpic 
	 * @return
	 * @return: String
	 */
	String editSick(Integer usersickid, Integer userloginid, Integer familyid, String usersickdesc,
			String usersickprimarydept, String usersickseconddept, MultipartFile[] pictureFile, String usersickpic) throws Exception;

	/**
	 * @Title: updateSickStateToPublish
	 * @Description: 发布病情
	 * @param userloginid
	 *            用户登录id
	 * @param usersickid
	 *            病情id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateSickStateToPublish(Integer userloginid, Integer usersickid) throws Exception;

	/**
	 * @Title: updateSickStateToCancel
	 * @Description: 取消发布病情
	 * @param userloginid
	 *            用户登录id
	 * @param usersickid
	 *            病情id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateSickStateToCancel(Integer userloginid, Integer usersickid) throws Exception;

	/**
	 * @Title: listRelatedDoctor
	 * @Description: 获取病情相关医生
	 * @param userloginid
	 *            用户登录id
	 * @param preordertype
	 *            医生类型
	 * @param page
	 *            当前页
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listRelatedDoctor(Integer userloginid, Integer preordertype, Integer page) throws Exception;

	/**
	 * @Title: addRelatedDoctor
	 * @Description: 预选医生
	 * @param docloginid
	 *            医生登录id
	 * @param userloginid
	 *            用户登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addRelatedDoctor(Integer docloginid, Integer userloginid) throws Exception;

	

	

}
