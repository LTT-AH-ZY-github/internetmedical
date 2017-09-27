package com.baidu.yun.push.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.baidu.yun.push.model.PushMsgToSmartTagRequest;
import com.baidu.yun.push.model.PushMsgToSmartTagResponse;
import com.baidu.yun.push.model.PushMsgToTagRequest;
import com.baidu.yun.push.model.PushMsgToTagResponse;
import com.medical.service.DoctorService;

public class PushToAndroid {
	static Logger logger = Logger.getLogger(PushToAndroid.class);
	public static void pushMsgToSingleDevice(String id,String title,String msg) throws PushClientException,
			PushServerException {
		// 1. get apiKey and secretKey from developer console
		String apiKey = "GnIsxXgAHX6U2NsyMgP91o3n";
		String secretKey = "ng5QmzKFVp8ouXYdnzy7v2B5rEGSXhqX";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

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
			//创建 Android的通知
			JSONObject notification = new JSONObject();
			notification.put("title", title);
			notification.put("description",msg);
			notification.put("notification_builder_id", 1);
			notification.put("notification_basic_style", 4);
			notification.put("open_type", 2);
			//notification.put("url", "http://push.baidu.com");
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("key", "value"); //自定义内容，key-value
			notification.put("custom_content", jsonCustormCont);

			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
					.addChannelId(id)
					.addMsgExpires(new Integer(3600)). // message有效时间
					addMessageType(1).// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
					addMessage(notification.toString()).
					addDeviceType(3);// deviceType => 3:android, 4:ios
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
	public static void pushMsgToAll(String title,String msg) 
			throws PushClientException,PushServerException {
		// 1. get apiKey and secretKey from developer console
		String apiKey = "GnIsxXgAHX6U2NsyMgP91o3n";
		String secretKey = "ng5QmzKFVp8ouXYdnzy7v2B5rEGSXhqX";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

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
			
			//创建 Android的通知
			JSONObject notification = new JSONObject();
			notification.put("title", title);
			notification.put("description",msg);
			notification.put("notification_builder_id", 1);
			notification.put("notification_basic_style", 4);
			notification.put("open_type", 2);
			//notification.put("url", "http://push.baidu.com");
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("key", "value"); //自定义内容，key-value
			notification.put("custom_content", jsonCustormCont);	
			// 4. specify request arguments
			PushMsgToAllRequest request = new PushMsgToAllRequest()
					.addMsgExpires(new Integer(3600)).addMessageType(1)
					.addMessage(notification.toString()) //添加透传消息
					//.addSendTime(System.currentTimeMillis() / 1000 + 120) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
					.addDeviceType(3);
			// 5. http request
			PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());
		} catch (PushClientException e) {
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
	public static void pushMsgToTags(String tag,String title,String msg) 
			throws PushClientException,PushServerException {
		// 1. get apiKey and secretKey from developer console
		String apiKey = "GnIsxXgAHX6U2NsyMgP91o3n";
		String secretKey = "ng5QmzKFVp8ouXYdnzy7v2B5rEGSXhqX";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

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
			
			//创建 Android的通知
			JSONObject notification = new JSONObject();
			notification.put("title", title);
			notification.put("description",msg);
			notification.put("notification_builder_id", 1);
			notification.put("notification_basic_style", 4);
			notification.put("open_type", 2);
			//notification.put("url", "http://push.baidu.com");
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("key", "value"); //自定义内容，key-value
			notification.put("custom_content", jsonCustormCont);
			
			// pushTagTpye = 1 for common tag pushing
			PushMsgToTagRequest request = new PushMsgToTagRequest()
					.addTagName(tag)
					.addMsgExpires(new Integer(3600))
					.addMessageType(1)  // 0添加透传消息
					// .addSendTime(System.currentTimeMillis() / 1000 + 120) //设置定时任务
					.addMessage(notification.toString())
					
					.addDeviceType(3);
			// 5. http request
			PushMsgToTagResponse response = pushClient.pushMsgToTag(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());
		} catch (PushClientException e) {
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
	public static Map<String, Object> PushMsgToSmartTag(String[] tags,String title,String msg,String sign)
			throws PushClientException,PushServerException {
		Map<String, Object> map = new HashMap<>();
		// 1. get apiKey and secretKey from developer console
		String apiKey = "GnIsxXgAHX6U2NsyMgP91o3n";
		String secretKey = "ng5QmzKFVp8ouXYdnzy7v2B5rEGSXhqX";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

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

		try { //开放tag组合运算功能
			// example.1 {"OR":{"tag":["xxxx","xxxx"]}}
			JSONObject selector = new JSONObject();
			JSONObject tmpJson = new JSONObject();
			JSONArray tagArray = new JSONArray();
			tagArray.add(0, tags[0]);
			tagArray.add(1, tags[1]);
			tmpJson.put("tag", tagArray);
			selector.put("AND", tmpJson); // "AND":交,"OR":并,"DIFF":差

			// example.2 {"OR":[{"tag":"xxxx"},{"tag":"xxxx"}]}
			// JSONObject firstTag = new JSONObject();
			// firstTag.put("tag", "xxxx");
			// JSONObject secondTag = new JSONObject();
			// secondTag.put("tag", "xxxx");
			// JSONArray tagArray = new JSONArray();
			// tagArray.add(0, firstTag);
			// tagArray.add(1, secondTag);
			// selector.put("OR", tagArray);
			//创建 Android的通知
			JSONObject notification = new JSONObject();
			notification.put("title", title);
			notification.put("description",msg);
			notification.put("notification_builder_id", 1);
			notification.put("notification_basic_style", 4);
			notification.put("open_type", 2);
			//notification.put("url", "http://push.baidu.com");
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("state", sign); //自定义内容，key-value
			notification.put("custom_content", jsonCustormCont);
			
			
			PushMsgToSmartTagRequest request = new PushMsgToSmartTagRequest()
					.addSelector(selector.toString())
					.addMsgExpires(new Integer(3600))
					.addMessageType(1)
					.addMessage(notification.toString())
					.addDeviceType(3);
			// 5. http request
			PushMsgToSmartTagResponse response = pushClient
					.pushMsgToSmartTag(request);
			// Http请求结果解析打印
			/*System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());*/
			map.put("state", "1");
		} catch (PushClientException e) {
			/*if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}*/
			map.put("state", "2");
			map.put("msg", "PushClientException时异常");
			logger.error("PushMsgToSmartTag捕获PushClientException异常"+e);
		} catch (PushServerException e) {
			/*if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}*/
			String errMsg = String.format(
					"requestId: %d, errorCode: %d, errorMessage: %s",
					e.getRequestId(), e.getErrorCode(), e.getErrorMsg());
			logger.error("PushMsgToSmartTag捕获PushServerException异常"+e);
			map.put("state", "2");
			map.put("msg",errMsg);
		}
		return map;
	}
}
