package com.medical.utils;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFCellStyle;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.medical.utils.test.Member;  
  
    
public class CreateSimpleExcelToDisk    
{    
    /**  
     * @功能：手工构建一个简单格式的Excel  
     */    
    private static List<Member> getMember() throws Exception    
    {    
        List list = new ArrayList();    
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");    
    
        Member user1 = new Member(1, "熊大", 24, df.parse("1993-08-28"));    
        Member user2 = new Member(2, "熊二", 23, df.parse("1994-08-19"));    
        Member user3 = new Member(3, "熊熊", 24, df.parse("1983-11-22"));    
        list.add(user1);    
        list.add(user2);    
        list.add(user3);    
    
        return list;    
    }    
    
    public static String creat(List<Map<String, Object>> list) throws Exception    
    {  
        // 第一步，创建一个webbook，对应一个Excel文件    
        HSSFWorkbook wb = new HSSFWorkbook();    
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
        HSSFSheet sheet = wb.createSheet("学生表一");    
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
        HSSFRow row = sheet.createRow((int) 0);    
        // 第四步，创建单元格，并设置值表头 设置表头居中    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式    
    
        HSSFCell cell = row.createCell((short) 0);    
        cell.setCellValue("商户订单号");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 1);    
        cell.setCellValue("支付方式");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 2);    
        cell.setCellValue("支付宝订单号");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 3);    
        cell.setCellValue("微信订单号");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 4);    
        cell.setCellValue("交易金额");    
        cell.setCellStyle(style);  
        cell = row.createCell((short) 5);    
        cell.setCellValue("实收金额");    
        cell.setCellStyle(style);  
        cell = row.createCell((short) 6);    
        cell.setCellValue("创建时间");    
        cell.setCellStyle(style);  
        cell = row.createCell((short) 7);    
        cell.setCellValue("完成支付时间");    
        cell.setCellStyle(style);  
        cell = row.createCell((short) 8);    
        cell.setCellValue("付款者姓名");    
        cell.setCellStyle(style);  
        cell = row.createCell((short) 9);    
        cell.setCellValue("付款账户");    
        cell.setCellStyle(style);  
        cell = row.createCell((short) 10);    
        cell.setCellValue("付款账户");    
        cell.setCellStyle(style);  
        cell = row.createCell((short) 11);    
        cell.setCellValue("收款者姓名");    
        cell.setCellStyle(style);  
        cell = row.createCell((short) 12);    
        cell.setCellValue("交易类型");    
        cell.setCellStyle(style);  
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，    
        for (int i = 0; i < list.size(); i++) {
        	row = sheet.createRow((int) i + 1);
			Map<String, Object> map = list.get(i);
			row.createCell((short) 0).setCellValue((String) map.get("paytradeno"));    
            row.createCell((short) 1).setCellValue((String)  map.get("paymodename"));    
            row.createCell((short) 2).setCellValue((String)  map.get("payalipaytradeno"));  
            row.createCell((short) 3).setCellValue((String) map.get("paywxtradeno"));
            BigDecimal paytotalamount = (BigDecimal)map.get("paytotalamount");
            row.createCell((short) 4).setCellValue(  paytotalamount.doubleValue());  
            BigDecimal payreceiptamount = (BigDecimal)map.get("payreceiptamount");
            row.createCell((short) 5).setCellValue(payreceiptamount.doubleValue());  
            row.createCell((short) 6).setCellValue(new SimpleDateFormat("yyyy-MM-dd-HH-mm:ss:ms").format((Date)map.get("paycreattime")));    
            row.createCell((short) 7).setCellValue(new SimpleDateFormat("yyyy-MM-dd-HH-mm:ss:ms").format((Date)map.get("payendtime")));    
            row.createCell((short) 8).setCellValue((String)  map.get("paysendername"));  
            row.createCell((short) 9).setCellValue((String) map.get("paysenderaccount"));    
            row.createCell((short) 10).setCellValue((String)  map.get("payreceivername"));    
            row.createCell((short) 11).setCellValue((String)  map.get("payreceiveraccount"));  
            row.createCell((short) 12).setCellValue((String)  map.get("paytypename")); 
			
		}
//        List list = CreateSimpleExcelToDisk.getMember();    
//    
//        for (int i = 0; i < list.size(); i++)    
//        {    
//            row = sheet.createRow((int) i + 1);    
//            Member stu = (Member) list.get(i);    
//            // 第四步，创建单元格，并设置值    
//            row.createCell((short) 0).setCellValue((double) stu.getCode());    
//            row.createCell((short) 1).setCellValue(stu.getName());    
//            row.createCell((short) 2).setCellValue((double) stu.getAge());    
//            cell = row.createCell((short) 3);    
//            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu    
//                    .getBirth()));    
//        }    
        
        // 第六步，将文件存到指定位置    
        try    
        {   String fileName = MakeRandomNum.getTradeNo("Pay")+".xls";
        	String path = "C:\\app\\excel\\"+fileName;
            FileOutputStream fout = new FileOutputStream(path);    
            wb.write(fout);    
            fout.close();    
            return  fileName;
        }catch (Exception e){    
            e.printStackTrace();    
        }  
        return  null;
    }    
     
}    
