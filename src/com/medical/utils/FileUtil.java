package com.medical.utils;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.medical.po.Deletefile;



/**
 * @ClassName:     FileUtil.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月10日 下午6:09:03 
 */
public class FileUtil {
	
	/**
	 * @Title: createDir
	 * @Description: 创建路径
	 * @param destDirName 路径名
	 * @return
	 * @return: boolean
	 */
	public static boolean createDir(String destDirName) {  
        File dir = new File(destDirName);  
        //创建目录失败，目标目录已经存在
        if (dir.exists()) {  
             return true;  
        }  
        if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        }  
        //创建目录  
        if (dir.mkdirs()) {  
           return true;  
        } else {  
           return false;  
        }  
    }
	
    /**
     * @Title: getFileName
     * @Description: 从文件名获取文件名
     * @param fullpath 完整路径名 
     * @return
     * @return: String
     */
    public static String getFileName(String fullpath) { 
    	if (StringUtils.isEmpty(fullpath)) {  
            return "";  
        }  
        int lastindex = fullpath.lastIndexOf(File.separator);  
        if (lastindex == -1) {  
            return "";  
        }  
        String name = fullpath.substring(lastindex + 1);  
  
        return name;  
    } 
   
    /**
     * @Title: getFileNameFromUrl
     * @Description: 从url获取文件名
     * @param url
     * @return
     * @return: String
     */
    public static String getFileNameFromUrl(String url) {

        String filename = url.substring(url.lastIndexOf('/') + 1);

        return filename;
    }
    
    
}
