package com.medical.mapper;

import com.medical.po.Notification;
import com.medical.po.NotificationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NotificationMapperCustom {
    
	/**
	 * 根据接收者和信息类型查询消息
	 * @param type 
     * @param 
     * @return 
     */
	List<Map<String, Object>> selectByReceiverAndType(Integer notificationreceiver,Integer notificationType,Integer type);
	/**
	 * 根据发送者和信息类型查询消息
     * @param 
     * @return 
     */
	List<Map<String, Object>> selectBySenderAndType(Integer notificationsender, Integer notificationType,Integer type);
	/**
	 * 根据接受者id和接受者类型将所有消息置为已读
     * @param 
     * @return 
     */
	int updateAllToReadByReceverIdAndNotificationType(Integer notificationreceiver,Integer notificationType);
	/**
	 * 根据接受者id和接受者类型将所有消息删除
     * @param 
     * @return 
     */
	int updateAllToDelByReceverIdAndNotificationType(Integer notificationreceiver,Integer notificationType);
}