/**  
* @Title: PayService.java  
* @Package com.medical.service.iface  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月20日  
* @version V1.0  
*/  
package com.medical.service.iface;

import java.math.BigDecimal;

/**
 * @ClassName:     PayService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月20日 下午2:15:02 
 */
public interface PayService {

	/**
	 * @Title: updateAlipayRecordToCreat
	 * @Description: 创建交易记录
	 * @param senderid 付款者id
	 * @param sendername 付款者姓名
	 * @param totalAmount 应收金额
	 * @param receiveid 收款者id
	 * @param receivename 收款者姓名
	 * @param orderid 订单id
	 * @param ordertype 订单类型 1为病人订单，2为会诊订单，3为其他
	 * @param type 1为病人支付医生 2病人支付医院 3 医院支付医生 4 病人退款 5 医生提现 6 医院提现
	 * @param outtradeno 本地生成的订单号
	 * @param paymodeid 支付方式1为支付宝支付2为微信支付
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updatePayRecordToCreat(Integer senderid, String sendername, BigDecimal totalAmount, Integer receiveid,
			String receivename, Integer orderid, Integer ordertype, Integer type, String outtradeno, Integer payway)
			throws Exception;

	/**
	 * @Title: updateAlipayRecordToFinish
	 * @Description: TODO
	 * @param out_trade_no 本地生成的订单号
	 * @param payid 支付id 
	 * @param trade_no 支付宝单号
	 * @param buyer_logon_id 付款者支付宝账号 
	 * @param seller_email 收款者支付宝账号 
	 * @param info 支付信息
	 * @param receiptamount 实收金额
	 * @param stateid 状态  3 为交易支付成功 4 交易结束，不可退款
     * @param paymodeid paymodeid 支付方式1为支付宝支付2为微信支付
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updatePayRecordToFinish(String out_trade_no, Integer payid, String trade_no, String buyer_logon_id,
			String seller_email, String info, BigDecimal receiptamount, Integer stateid, Integer paymodeid)
			throws Exception;

	/**
	 * @Title: updatePayRecordToCancle
	 * @Description: TODO
	 * @param out_trade_no 本地生成的订单号
	 * @param payid 支付id 
	 * @param trade_no 支付宝单号
	 * @param buyer_logon_id 付款者支付宝账号 
	 * @param seller_email 收款者支付宝账号 
	 * @param info 支付信息
	 * @param payremark 备注信息
	 * @param paymodeid paymodeid 支付方式1为支付宝支付2为微信支付
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updatePayRecordToCancle(String out_trade_no, Integer payid, String trade_no, String buyer_logon_id,
			String seller_email, String info, String payremark, Integer paymodeid) throws Exception;

	
	

	
	

}
