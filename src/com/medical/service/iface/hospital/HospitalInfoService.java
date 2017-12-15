package com.medical.service.iface.hospital;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.Hospinfo;

public interface HospitalInfoService {

	/**
	 * @Title: updateInfo
	 * @Description: TODO
	 * @param hospinfo
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String updateInfo(Hospinfo hospinfo) throws Exception;

	/**
	 * @Title: updateUserPix
	 * @Description: TODO
	 * @param pictureFile
	 * @return
	 * @return: String
	 */
	String updateUserPix(MultipartFile pictureFile) throws Exception;

	/**
	 * @Title: updateHospPic
	 * @Description: TODO
	 * @param hosploginid
	 * @param type
	 * @param picturefile
	 * @return
	 * @return: String
	 */
	String updateHospPic(Integer hosploginid, Integer type, String[]  picturefile)  throws Exception;

	/**
	 * @Title: updateToReview
	 * @Description: TODO
	 * @param hosploginid
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String updateToReview(Integer hosploginid) throws Exception;

	/**
	 * @Title: getInfo
	 * @Description: TODO
	 * @param hosploginid
	 * @return
	 * @return: String
	 */
	String getInfo(Integer hosploginid) throws Exception;

	/**
	 * @Title: getLoginInfo
	 * @Description: TODO
	 * @param hosploginid
	 * @return
	 * @return: String
	 */
	String getLoginInfo(Integer hosploginid) throws Exception;

}
