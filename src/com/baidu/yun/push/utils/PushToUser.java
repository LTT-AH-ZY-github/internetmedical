package com.baidu.yun.push.utils;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

/**
 * @ClassName:     PushToUser.java
 * @Description:   异步向用户发送百度云消息 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:49:44 
 */
public class PushToUser {
	private String channelid;

	private String title;

	private String msg;

	private Integer dev;

	public PushToUser(String channelid, String title, String msg, Integer dev) {
		super();
		this.channelid = channelid;
		this.title = title;
		this.msg = msg;
		this.dev = dev;
	}
	
	public void send() {
		new Thread() {
			public void run() {
				if (dev==1) {
					try {
						PushToUserInAndroid.pushMsgToSingleDevice(channelid, title, msg);
					} catch (PushClientException | PushServerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					try {
						PushToUserInIOS.pushMsgToSingleDevice(channelid, title, msg);
					} catch (PushClientException | PushServerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
