package com.medical.utils;

import java.io.File;

public class CreateFileUtil {
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
}
