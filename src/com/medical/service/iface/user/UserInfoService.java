package com.medical.service.iface.user;

import org.springframework.web.multipart.MultipartFile;
import com.medical.po.Familyinfo;

public interface UserInfoService {

	/**
	 *  更新位置信息
	 * @Title: updateLocation 
	 * @return
	 * @param
	 */
	String updateLocation(Integer userloginid, String userloginlon, String userloginlat) throws Exception;
	/**
	 *  更新百度云推送ChannelId
	 * @Title: updateChannelId 
	 * @Description: TODO
	 * @return: Boolean
	 */
	String updateChannelId(Integer userloginid, String channelid) throws Exception;
	/**
	 *  更新用户头像和昵称
	 * @Title: updateUserPixAndUserName 
	 * @Description: TODO
	 * @return: String
	 */
	String updateUserPixAndUserName(MultipartFile pictureFile, Integer userloginid, String username) throws Exception;
	/**
	 * 获取用户信息
	*/
	String findUserInfo(Integer userloginid) throws Exception;
	/**
	 * 修改用户信息
	*/
	String updateUserInfo(Integer userloginid, String username, String usermale, String usercardnum,
			String useradrprovince, String useradrcity, Integer userage, String useradrarea, String useradrother,
			MultipartFile[] pictureFile) throws Exception;
	/**
	 * 将个人信息提交审核
	 * @return
	 * @param
	 * */
	String updateInfoToReview(Integer userloginid) throws Exception;
	/**
	 * 查询亲属信息
	 * @return
	 * @param
	 * */
	String findFamily(Integer userloginid) throws Exception;
	/**
	 * 添加亲属信息
	 * @return
	 * @param
	 * */
	String addFamily(Familyinfo familyinfo) throws Exception;
	/**
	 * 修改亲属信息
	 * @return
	 * @param
	 * */
	String updateFamily(Familyinfo familyinfo) throws Exception;
	/**
	 * 删除亲属信息
	 * @return
	 * @param
	 * */
	String deleteFamily(Integer familyid) throws Exception;
	/**
	 * @Title: updateInfoToCancelReview
	 * @Description: TODO
	 * @param userloginid
	 * @return
	 * @return: String
	 */
	String updateInfoToCancelReview(Integer userloginid);
	



}
