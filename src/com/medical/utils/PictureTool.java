package com.medical.utils;

import java.io.File;
import org.apache.commons.lang3.StringUtils;
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
		String fileName = "";
		for (int i = 0; i < pictureFile.length; i++) {
			String name = MakeRandomNum.randomFileName();
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
		System.out.println("路径"+fileName);
		return fileName;
	}
	
	/**
	 * @Title: SavePicturesByPath
	 * @Description: 根据路径保存多图片
	 * @param path
	 * @return
	 * @throws Exception
	 * @return: String 七牛云路径
	 */
	public static String SavePicturesByPath(String[] path) throws Exception {
		if (path == null || path.length == 0) {
			return null;
		}
		String fileName = "";
		for (int i = 0; i < path.length; i++) {
			String cloudpath = QiniuUtil.upload(path[i]);
			if (i != path.length - 1) {
				fileName += cloudpath + ",";
			} else {
				fileName += cloudpath;
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
	 * @return: String 七牛云路径
	 */
	public static String SaveOnePicture(MultipartFile pictureFile) throws Exception {
		if (pictureFile == null || pictureFile.isEmpty()) {
			return null;
		}

		String name = MakeRandomNum.randomFileName();
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
	
	/**
	 * @Title: SaveOnePictureByPath
	 * @Description: 根据图片路径保存单张图片
	 * @param path
	 * @return
	 * @throws Exception
	 * @return: String 七牛云路径
	 */
	public static String SaveOnePictureByPath(String path) throws Exception {
		if (StringUtils.isBlank(path)) {
			return null;
		}
		return QiniuUtil.upload(path);

	}
}
