package com.medical.utils;

import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Random;


/**
 * @ClassName:     MakeOrderNum.java
 * @Description:   订单、文件名生成
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月10日 下午4:14:22 
 * @Description: 
 */
public class MakeRandomNum {  
    /** 
     * 锁对象，可以为任意对象 
     */  
	private static byte[] lockObj = new byte[0];  // 特殊的instance变量
    //private static Object lockObj = "lockerOrder";  
    
    private static  byte[] lockRandomFileNameObj= new byte[0];  
    /** 
     * 订单号生成计数器 
     */  
    private static long orderNumCount = 0L;  
    /** 
     * 每毫秒生成订单号数量最大值 
     */  
    private static int maxPerMSECSize=1000;  
    /** 
     * 生成非重复订单号，理论上限1毫秒1000个，可扩展 
     * prefix为  1为病人订单
     * 		   2为医院订单
     * 	
     * @param tname 测试用 
     */  
    public static String getTradeNo(String prefix ) { 
    	String finOrderNum = ""; 
        try {  
            // 最终生成的订单号  
            synchronized (lockObj) {  
                // 取系统当前时间作为订单号变量前半部分，精确到毫秒  
                long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));  
                // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万  
                if (orderNumCount >= maxPerMSECSize) {  
                    orderNumCount = 0L;  
                }  
                //组装订单号  
                String countStr=maxPerMSECSize +orderNumCount+"";  
                finOrderNum=nowLong+countStr.substring(1);  
                orderNumCount++;  
                //System.out.println(finOrderNum + "--" + Thread.currentThread().getName() + "::" + Thread.currentThread().getName() );  
                //Thread.sleep(1000);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return  prefix+finOrderNum;
    }  
    
    /**
     * @Title: randomFileName
     * @Description: 生成非重复文件名
     * @return
     * @return: String
     */
    public static  String randomFileName() {
    	synchronized (lockRandomFileNameObj) {
    		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmssSSS");
    		String temp = df.format(new Date())+new Random().nextInt(1000);
    		return temp;
		}
		
   }
//   public static void main(String[] args) {  
//        // 测试多线程调用订单号生成工具  
//        try {  
//            for (int i = 0; i < 200; i++) {  
//                Thread t1 = new Thread(new Runnable() {  
//                    public void run() {  
//                    	MakeRandomNum makeOrder = new MakeRandomNum();  
//                        makeOrder.getPayTradeNo("a");  
//                    }  
//                }, "at" + i);  
//                t1.start();  
//  
//                Thread t2 = new Thread(new Runnable() {  
//                    public void run() {  
//                    	MakeRandomNum makeOrder = new MakeRandomNum();  
//                        makeOrder.getPayTradeNo("b");   
//                    }  
//                }, "bt" + i);  
//                t2.start();  
//            }  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//  
//    } 
  
}  
