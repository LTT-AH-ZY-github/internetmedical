package com.medical.utils;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Strings;

public class FileUtil {
	/** 
     * 取得文件名. 
     * @param fullpath 完整路径名 
     * @return 
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
}