package com.medical.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class PictureTool {
	public static String SavePictures(MultipartFile[] pictureFile) throws Exception {
		// 真实路径
		String reallyDir = "D:\\\\upload\\\\";
		// 保存到数据库的路径
		String virtualDir = "";
		String fileName = null;
		if (pictureFile!=null && pictureFile.length>0) {
			fileName = "";
			for (int i = 0; i < pictureFile.length; i++) {
				String name = CommonUtils.randomFileName();
				// 获取文件名
				String oriName = pictureFile[i].getOriginalFilename();
				// 获取图片后缀
				String ext = oriName.substring(oriName.lastIndexOf("."));
				String file = name + ext;
				String reallyPath = reallyDir + file;
				String virtualPath = virtualDir + file;
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
	public static String SaveOnePicture(MultipartFile pictureFile) throws Exception {
		// 真实路径
		String reallyDir = "D:\\\\upload\\\\";
		// 保存到数据库的路径
		
		String fileName = null;
		if (pictureFile!=null ) {
			String name = CommonUtils.randomFileName();
			// 获取文件名
			String oriName = pictureFile.getOriginalFilename();
			// 获取图片后缀
		    String ext = oriName.substring(oriName.lastIndexOf("."));
			String file = name + ext;
			String reallyPath = reallyDir + file;
			//String virtualPath = virtualDir + file;
			pictureFile.transferTo(new File(reallyPath));
			//fileName = virtualPath;
			return QiniuUtil.upload(reallyPath);
			
		}
		return null;
	}
}
