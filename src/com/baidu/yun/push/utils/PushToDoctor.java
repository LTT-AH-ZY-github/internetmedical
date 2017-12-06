package com.baidu.yun.push.utils;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

/**
 * @ClassName:     PushToDoctor.java
 * @Description:   异步向医生发送百度云消息
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:48:43 
 */
public class PushToDoctor {
	private String channelid;

	private String title;

	private String msg;

	private Integer dev;

	public PushToDoctor(String channelid, String title, String msg, Integer dev) {
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
						PushToDoctorInAndroid.pushMsgToSingleDevice(channelid, title, msg);
					} catch (PushClientException | PushServerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					try {
						PushToDoctorInIOS.pushMsgToSingleDevice(channelid, title, msg);
					} catch (PushClientException | PushServerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
