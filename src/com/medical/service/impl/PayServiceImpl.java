package com.medical.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.medical.mapper.PayMapper;
import com.medical.mapper.PayMapperCustom;
import com.medical.po.Pay;
import com.medical.service.iface.PayService;


/**
 * @ClassName:     PayServiceImpl.java
 * @Description:   支付记录
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
	public int updatePayRecordToCreat(Integer senderid,String sendername,BigDecimal totalAmount,Integer receiveid,
			String receivename,Integer orderid,Integer ordertype,Integer type,String outtradeno,Integer paymodeid) throws Exception{
		Pay pay = new Pay();
		pay.setPaycreattime(new Date());
		// 1为支付宝支付2 微信支付
		pay.setPaymodeid(paymodeid);
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
		boolean result = payMapperCustom.insertSelectiveReturnId(pay)>0;
		if (result) {
			return pay.getPayid();
		}else {
			return 0;
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updatePayRecordToCancle(Integer payid,String trade_no,String buyer_logon_id,
			String seller_email,String info,String payremark) throws Exception{
		Pay pay = payMapper.selectByPrimaryKey(payid);
		if (pay == null) {
			return false;
		}
		int paymodeid= pay.getPaymodeid();
		Pay payrecord = new Pay();
		payrecord.setPayid(payid);
		if (paymodeid==1) {
			payrecord.setPayalipaytradeno(trade_no);
		}else {
			payrecord.setPaywxtradeno(trade_no);
		}
		payrecord.setPaysenderaccount(buyer_logon_id);
		payrecord.setPayreceiveraccount(seller_email);
	    payrecord.setPayinfo(info);
	    //2为未付款交易超时关闭，或支付完成后全额退款
	    payrecord.setPayremark(payremark);
		payrecord.setPaystateid(2);
		payrecord.setPayendtime(new Date());
		return payMapper.updateByPrimaryKeySelective(payrecord)>0;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updatePayRecordToFinish(Integer payid,String trade_no,String buyer_logon_id,
			String seller_email,String info,BigDecimal receiptamount) throws Exception{
		Pay pay = payMapper.selectByPrimaryKey(payid);
		if (pay == null) {
			return false;
		}
		int paymodeid= pay.getPaymodeid();
		Pay payrecord = new Pay();
		payrecord.setPayid(payid);
		if (paymodeid==1) {
			payrecord.setPayalipaytradeno(trade_no);
		}else {
			payrecord.setPaywxtradeno(trade_no);
		}
		payrecord.setPaysenderaccount(buyer_logon_id);
		payrecord.setPayreceiveraccount(seller_email);
	    payrecord.setPayinfo(info);
	    payrecord.setPayreceiptamount(receiptamount); 
	    payrecord.setPayremark("交易成功");
		payrecord.setPaystateid(3);
		payrecord.setPayendtime(new Date());
		return payMapper.updateByPrimaryKeySelective(payrecord)>0;
		
	}
}
