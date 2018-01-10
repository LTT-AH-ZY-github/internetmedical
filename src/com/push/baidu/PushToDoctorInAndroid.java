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

public class PushToDoctorInAndroid {
	public static void main(String[] args) {
		JSONObject notification = new JSONObject();
		notification.put("title", "12");
		notification.put("description", "msg");
		notification.put("notification_builder_id", 1);
		notification.put("notification_basic_style", 4);
		notification.put("open_type", 2);
		System.out.println("1223");
		System.out.println("123"+notification.toString());
		try {
			pushMsgToSingleDeviceInAndroid("4345462790363541415", "1", "123");
		} catch (PushClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PushServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean pushMsgToSingleDeviceInAndroid(String channelid, String title, String msg)
			throws PushClientException, PushServerException {
		// 1. get apiKey and secretKey from developer console
		PushKeyPair pair = new PushKeyPair(PushConfig.AndroidInDoctorApiKey, PushConfig.AndroidInDoctorSecretKey);

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

			PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest().addChannelId(channelid)
					.addMsgExpires(new Integer(3600)). // message有效时间
					addMessageType(0).// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
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
}
