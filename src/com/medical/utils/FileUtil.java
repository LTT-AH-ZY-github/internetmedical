package com.medical.utils;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.medical.po.Deletefile;



public class FileUtil {
	
    /**
     * @Title: getFileName
     * @Description: 取得文件名
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
    
    public static String getFileNameFromUrl(String url) {

        String filename = url.substring(url.lastIndexOf('/') + 1);

        return filename;
    }
    
    
}
