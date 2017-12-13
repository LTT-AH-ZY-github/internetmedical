package com.medical.service.iface.user;

import org.springframework.web.multipart.MultipartFile;
import com.medical.po.Familyinfo;

/**
 * @ClassName: UserInfoService.java
 * @Description: 用户信息管理接口
 * @author xyh
 * @version V1.0
 * @Date 2017年12月7日 下午9:37:31
 */
public interface UserInfoService {

	/**
	 * @Title: updateLocation
	 * @Description: 更新位置信息
	 * @param userloginid
	 *            用户登录id
	 * @param userloginlon
	 *            经度
	 * @param userloginlat
	 *            纬度
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateLocation(Integer userloginid, String userloginlon, String userloginlat) throws Exception;

	/**
	 * @Title: updateChannelId
	 * @Description: 更新百度云推送ChannelId
	 * @param userloginid
	 *            用户登录id
	 * @param channelid
	 *            百度云id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateChannelId(Integer userloginid, String channelid) throws Exception;

	/**
	 * @Title: updateUserPixAndUserName
	 * @Description: 更新用户头像和昵称
	 * @param pictureFile
	 *            用户头像
	 * @param userloginid
	 *            用户登录id
	 * @param username
	 *            用户昵称
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateUserPixAndUserName(MultipartFile pictureFile, Integer userloginid, String username) throws Exception;

	/**
	 * @Title: findUserInfo
	 * @Description: 获取用户信息
	 * @param userloginid
	 *            用户登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String findUserInfo(Integer userloginid) throws Exception;

	/**
	 * @Title: updateUserInfo
	 * @Description: 修改用户信息
	 * @param userloginid
	 *            用户登录id
	 * @param username
	 *            用户真实姓名
	 * @param usermale
	 *            性别
	 * @param usercardnum
	 *            身份证号码
	 * @param useradrprovince
	 *            所在省
	 * @param useradrcity
	 *            所在市
	 * @param userage
	 *            年龄
	 * @param useradrarea
	 *            所在区县
	 * @param useradrother
	 *            所在详细地址
	 * @param pictureFile
	 *            身份证照片
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateUserInfo(Integer userloginid, String username, String usermale, String usercardnum,
			String useradrprovince, String useradrcity, Integer userage, String useradrarea, String useradrother,
			MultipartFile[] pictureFile) throws Exception;

	/**
	 * @Title: updateInfoToReview
	 * @Description: 将个人信息提交审核
	 * @param userloginid
	 *            用户登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateInfoToReview(Integer userloginid) throws Exception;

	/**
	 * @Title: findFamily
	 * @Description: 查询亲属信息
	 * @param userloginid
	 *            用户登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String findFamily(Integer userloginid) throws Exception;

	/**
	 * @Title: addFamily
	 * @Description: 添加亲属信息
	 * @param familyinfo
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addFamily(Familyinfo familyinfo) throws Exception;

	/**
	 * @Title: updateFamily
	 * @Description: 修改亲属信息
	 * @param familyinfo
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateFamily(Familyinfo familyinfo) throws Exception;

	/**
	 * @Title: deleteFamily
	 * @Description: 删除亲属信息
	 * @param familyid
	 *            亲属id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String deleteFamily(Integer familyid) throws Exception;

	/**
	 * @Title: updateInfoToCancelReview
	 * @Description: 撤销审核
	 * @param userloginid
	 *            用户登录id
	 * @return
	 * @return: String
	 */
	String updateInfoToCancelReview(Integer userloginid);

}
