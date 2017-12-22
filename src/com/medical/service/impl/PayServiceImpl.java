/**  
* @Title: PayServiceImpl.java  
* @Package com.medical.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月20日  
* @version V1.0  
*/  
package com.medical.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.medical.mapper.PayMapper;
import com.medical.mapper.PayMapperCustom;
import com.medical.po.Pay;
import com.medical.service.iface.PayService;
import com.medical.utils.result.DataResult;
import com.pay.alipay.MakeOrderNum;

/**
 * @ClassName:     PayServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月20日 下午2:15:20 
 */
public class PayServiceImpl implements PayService {
	@Autowired
	private PayMapper payMapper;
	@Autowired
	private PayMapperCustom payMapperCustom;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateAlipayRecordToCreat(Integer senderid,String sendername,BigDecimal totalAmount,Integer receiveid,String receivename,Integer orderid,Integer ordertype,Integer type,String outtradeno ) throws Exception{
		Pay pay = new Pay();
		pay.setPaycreattime(new Date());
		// 1为支付宝支付
		pay.setPaymodeid(1);
		pay.setPayordertypeid(ordertype);
		pay.setPaysenderid(senderid);
		//付款者姓名
		pay.setPaysendername(sendername);
		//应收金额
		pay.setPaytotalamount(totalAmount);
		pay.setPayreceiverid(receiveid);
		pay.setPayreceivername(receivename);
		pay.setPayorderid(orderid);
		pay.setPaytradeno(outtradeno);
		pay.setPaytypeid(type);
		// 1为交易创建，等待买家付款
		pay.setPaystateid(1);
		boolean result = payMapper.insertSelective(pay)>0;
		if (result) {
			return DataResult.success("新增成功");
		}else {
			return DataResult.error("新增失败");
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateAlipayRecordToCancle(String out_trade_no,Integer payid,String trade_no,String buyer_logon_id,String seller_email,String info) throws Exception{
		Pay pay = payMapperCustom.selectByPayTradeNo(out_trade_no);
		if (pay == null) {
			return DataResult.error("交易不存在");
		}
		Pay payrecord = new Pay();
		payrecord.setPayid(payid);
		payrecord.setPayalipaytradeno(trade_no);
		payrecord.setPaysenderaccount(buyer_logon_id);
		payrecord.setPayreceiveraccount(seller_email);
	    payrecord.setPayinfo(info);
	    //2为未付款交易超时关闭，或支付完成后全额退款
		payrecord.setPaystateid(2);
		payrecord.setPayendtime(new Date());
		boolean result = payMapper.updateByPrimaryKeySelective(payrecord)>0;
		if (result) {
			return DataResult.success("新增成功");
		}else {
			return DataResult.error("新增失败");
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateAlipayRecordToFinish(String out_trade_no,Integer payid,String trade_no,String buyer_logon_id,String seller_email,String info,BigDecimal receiptamount,Integer stateid) throws Exception{
		Pay pay = payMapperCustom.selectByPayTradeNo(out_trade_no);
		if (pay == null) {
			return DataResult.error("交易不存在");
		}
		Pay payrecord = new Pay();
		payrecord.setPayid(payid);
		payrecord.setPayalipaytradeno(trade_no);
		payrecord.setPaysenderaccount(buyer_logon_id);
		payrecord.setPayreceiveraccount(seller_email);
	    payrecord.setPayinfo(info);
	    payrecord.setPayreceiptamount(receiptamount); 
	    
		payrecord.setPaystateid(stateid);
		payrecord.setPayendtime(new Date());
		boolean result = payMapper.updateByPrimaryKeySelective(payrecord)>0;
		if (result) {
			return DataResult.success("新增成功");
		}else {
			return DataResult.error("新增失败");
		}
	}
}