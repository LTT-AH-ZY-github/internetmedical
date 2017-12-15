package com.push.baidu;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;

import net.sf.json.JSONObject;

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
						pushMsgToSingleDeviceInAndroid(channelid, title, msg);
					} catch (PushClientException | PushServerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					try {
						pushMsgToSingleDeviceInIOS(channelid, title, msg);
					} catch (PushClientException | PushServerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	public static boolean pushMsgToSingleDeviceInAndroid(String channelId, String title, String msg)
			throws PushClientException, PushServerException {
		// 1. get apiKey and secretKey from developer console
		PushKeyPair pair = new PushKeyPair(PushConfig.AndroidInUserApiKey, PushConfig.AndroidInUserSecretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});
		try {
			// 4. specify request arguments
			// 创建 Android的通知
			JSONObject notification = new JSONObject();
			notification.put("title", title);
			notification.put("description", msg);
			notification.put("notification_builder_id", 1);
			notification.put("notification_basic_style", 4);
			notification.put("open_type", 2);
			// notification.put("url", "http://push.baidu.com");
			/*
			 * JSONObject jsonCustormCont = new JSONObject(); jsonCustormCont.put("key",
			 * "value"); //自定义内容，key-value
			 */ // notification.put("custom_content", jsonCustormCont);

			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest().addChannelId(channelId)
					.addMsgExpires(new Integer(3600)). // message有效时间
					addMessageType(1).// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
					addMessage(notification.toString()).addDeviceType(3);// deviceType => 3:android, 4:ios
			// 5. http request
			PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: " + response.getSendTime());
			return true;
		} catch (PushClientException e) {
			/*
			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
			 */
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
			return false;
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(),
						e.getErrorCode(), e.getErrorMsg()));
			}
			return false;
		}

	}
	
	public static void pushMsgToSingleDeviceInIOS(String channelid, String title, String msg)
			throws PushClientException, PushServerException {
		
		// 1. get apiKey and secretKey from developer console
		PushKeyPair pair = new PushKeyPair(PushConfig.IOSInUserApiKey, PushConfig.IOSInUserSecretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			// make IOS Notification
			JSONObject notification = new JSONObject();
			JSONObject jsonAPS = new JSONObject();
			jsonAPS.put("alert", msg);
			jsonAPS.put("sound", "ttt"); // 设置通知铃声样式
			jsonAPS.put("badge", 1); // 设置角标，提示消息个数
			notification.put("aps", jsonAPS);
			notification.put("key1", "value1"); 
			notification.put("key2", "value2");

			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
					.addChannelId(channelid)
					.addMsgExpires(new Integer(3600)). // 设置message的有效时间
					addMessageType(1).// 1：通知,0:透传消息.默认为0 注：IOS只有通知.
					addMessage(notification.toString()).addDeployStatus(1). // IOS,
																			// DeployStatus
																			// => 1: Developer
																			// 2: Production.
					addDeviceType(4);// deviceType => 3:android, 4:ios
			// 5. http request
			PushMsgToSingleDeviceResponse response = pushClient
					.pushMsgToSingleDevice(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime());
		} catch (PushClientException e) {
			/*
			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
			 */
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
	}
}
