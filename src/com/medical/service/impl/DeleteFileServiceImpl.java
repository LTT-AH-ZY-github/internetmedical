/**  
* @Title: DeleteFileServiceImpl.java  
* @Package com.medical.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月14日  
* @version V1.0  
*/  
package com.medical.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.medical.mapper.DeletefileMapper;
import com.medical.po.Deletefile;
import com.medical.service.iface.DeleteFileService;
import com.medical.utils.FileUtil;

/**
 * @ClassName:     DeleteFileServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月14日 下午3:05:13 
 */
public class DeleteFileServiceImpl implements DeleteFileService {
	@Autowired
	private DeletefileMapper deletefileMapper;
	
	
	@Override
	public boolean addFileName(String filename) throws Exception{
		if (StringUtils.isBlank(filename)) {
			return false;
		}
		String[] path = filename.split(",");
		for (int i = 0; i < path.length; i++) {
			String key = FileUtil.getFileNameFromUrl(path[i]);
			Deletefile deletefile  = new Deletefile();
			deletefile.setFilename(key);
			deletefile.setTime(new Date());
			int result =deletefileMapper.insertSelective(deletefile);
			if (result<=0) {
				return false;
			}
		}
		return true;
		
	}
	
}
