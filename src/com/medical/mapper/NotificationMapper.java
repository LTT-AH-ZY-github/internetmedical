package com.medical.mapper;

import com.medical.po.Notification;
import com.medical.po.NotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationMapper {
    int countByExample(NotificationExample example);

    int deleteByExample(NotificationExample example);

    int deleteByPrimaryKey(Integer notificationid);

    int insert(Notification record);

    int insertSelective(Notification record);

    List<Notification> selectByExample(NotificationExample example);

    Notification selectByPrimaryKey(Integer notificationid);

    int updateByExampleSelective(@Param("record") Notification record, @Param("example") NotificationExample example);

    int updateByExample(@Param("record") Notification record, @Param("example") NotificationExample example);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
}