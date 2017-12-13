package com.medical.utils;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: PictureTool.java
 * @Description: 上传图片工具类
 * @author xyh
 * @version V1.0
 * @Date 2017年12月7日 下午9:47:03
 */
public class PictureTool {

	/**
	 * @Title: SavePictures
	 * @Description: 上传多图片
	 * @param pictureFile
	 * @return
	 * @throws Exception
	 * @return: String 图片路径
	 */
	public static String SavePictures(MultipartFile[] pictureFile) throws Exception {
		if (pictureFile == null || pictureFile.length == 0) {
			return null;
		}
		String fileName = null;
		if (pictureFile != null && pictureFile.length > 0) {
			fileName = "";
			for (int i = 0; i < pictureFile.length; i++) {
				String name = CommonUtils.randomFileName();
				// 获取文件名
				String oriName = pictureFile[i].getOriginalFilename();
				// 获取图片后缀
				String ext = oriName.substring(oriName.lastIndexOf("."));
				String file = name + ext;
				String reallyPath = Global.uploadLocalPath + file;
				pictureFile[i].transferTo(new File(reallyPath));
				String path = QiniuUtil.upload(reallyPath);
				if (i != pictureFile.length - 1) {
					fileName += path + ",";
				} else {
					fileName += path;
				}
			}
		}

		return fileName;
	}

	/**
	 * @Title: SaveOnePicture
	 * @Description: 上传单张图片
	 * @param pictureFile
	 * @return
	 * @throws Exception
	 * @return: String 图片路径
	 */
	public static String SaveOnePicture(MultipartFile pictureFile) throws Exception {
		if (pictureFile == null) {
			return null;
		}

		String name = CommonUtils.randomFileName();
		// 获取文件名
		String oriName = pictureFile.getOriginalFilename();
		// 获取图片后缀
		String ext = oriName.substring(oriName.lastIndexOf("."));
		String file = name + ext;
		String reallyPath = Global.uploadLocalPath + file;
		// String virtualPath = virtualDir + file;
		pictureFile.transferTo(new File(reallyPath));
		// fileName = virtualPath;
		return QiniuUtil.upload(reallyPath);

	}
}
