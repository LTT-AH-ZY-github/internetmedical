package com.medical.mapper;

import com.medical.po.Feedback;
import com.medical.po.FeedbackExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FeedbackMapperCustom {
    



	/**
	 * @Title: selectByTypeAndCheck
	 * @Description: TODO
	 * @param map
	 * @return
	 * @return: List<Feedback>
	 */
	List<Feedback> selectByTypeAndCheck(Map<String, Object> map);

    
}