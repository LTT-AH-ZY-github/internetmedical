package com.medical.service.iface.user;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.Familyinfo;

public interface UserInfoService {

	/**
	 *  更新位置信息
	 * @Title: updateLocation 
	 * @Description: TODO
	 * @return: Boolean
	 */
	boolean updateLocation(Integer userloginid, String userloginlon, String userloginlat);
	/**
	 *  更新百度云推送ChannelId
	 * @Title: updateChannelId 
	 * @Description: TODO
	 * @return: Boolean
	 */
	boolean updateChannelId(Integer userloginid, String channelid);
	/**
	 *  更新用户头像和昵称
	 * @Title: updateUserPixAndUserName 
	 * @Description: TODO
	 * @return: String
	 */
	String updateUserPixAndUserName(MultipartFile pictureFile, Integer userloginid, String username) throws Exception;

	Map<String, Object> findUserInfo(Integer userloginid);

	boolean updateUserInfo(Integer userloginid, String username, String usermale, String usercardnum,
			String useradrprovince, String useradrcity, Integer userage, String useradrarea, String useradrother,
			MultipartFile[] pictureFile) throws Exception;

	List<Familyinfo> findFamily(Integer userloginid) ;

	boolean addFamily(Familyinfo familyinfo) throws Exception;

	boolean updateFamily(Familyinfo familyinfo) throws Exception;

	boolean deleteFamily(Integer familyid) throws Exception;

}
