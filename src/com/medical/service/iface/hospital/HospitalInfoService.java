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
	 */
	String updateInfo(Hospinfo hospinfo);

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
	 * @param pictureFile
	 * @return
	 * @return: String
	 */
	String updateHospPic(Integer hosploginid, Integer type, MultipartFile[] pictureFile)  throws Exception;

	/**
	 * @Title: updateToReview
	 * @Description: TODO
	 * @param hosploginid
	 * @return
	 * @return: String
	 */
	String updateToReview(Integer hosploginid);

}
