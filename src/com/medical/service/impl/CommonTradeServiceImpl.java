package com.medical.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import com.medical.service.iface.CommonTradeService;

/**
 * @ClassName:     CommonTradeServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月15日 下午3:11:35 
 */
public class CommonTradeServiceImpl implements CommonTradeService {
	public static Map<String, Object> UserFundMap = new HashMap<String, Object>();
	public static Map<String, Object> DoctorFundMap = new HashMap<String, Object>();
	public static Map<String, Object> HospitalFundMap = new HashMap<String, Object>();
	public static Map<String, Object> UserOrderMap = new HashMap<String, Object>();
	public static Map<String, Object> HospitalOrderMap = new HashMap<String, Object>();
	public static boolean count = true;
	public static void main(String[] args) {
	   
	    /**
	     * 分析：
	     * t1线程先持有object对象的Lock锁，t2线程可以以异步的方式调用对象中的非synchronized修饰的方法
	     * t1线程先持有object对象的Lock锁，t2线程如果在这个时候调用对象中的同步（synchronized）方法则需等待，也就是同步
	     */
	    Thread t1 = new Thread(new Runnable() {
	        @Override
	        public void run() {
	        	doexit();
	        }
	    },"t1");
	    Thread t2 = new Thread(new Runnable() {
	        @Override
	        public void run() {
	        	
	        }
	    },"t2");
	
	    t1.start();
	    t2.start();
	}
	public synchronized static void doexit() {
		 try {
			 System.out.println(Thread.currentThread().getName());
			 Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						System.out.println("123");
						
						
					}
				}, 1);//2分钟
			System.out.println(Thread.currentThread().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public  synchronized   boolean queryUserFundForUpdate( final Integer id) {
	  boolean isExit = UserFundMap.containsKey(id+"");
		if (isExit) {
			return true;
		}else {
			UserFundMap.put(id+"", "1");
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					UserFundMap.remove(id+"");
					System.out.println(id);;
					
				}
			}, 120000);//2分钟
			
		}
		return false;
	}
	@Override
	public  synchronized   void queryUserFundForFinish(Integer id) {
		UserFundMap.remove(id+"");
	}
	@Override
	public  synchronized   boolean queryDoctorFundForUpdate( final Integer id) {
	  boolean isExit = DoctorFundMap.containsKey(id+"");
		if (isExit) {
			return true;
		}else {
			DoctorFundMap.put(id+"", "1");
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					DoctorFundMap.remove(id+"");
					System.out.println(id);;
					
				}
			}, 120000);//2分钟
			
		}
		return false;
	}
	@Override
	public  synchronized   void queryDoctorFundForFinish(Integer id) {
		DoctorFundMap.remove(id+"");
	}
	
	@Override
	public  synchronized   boolean queryHospitalFundForUpdate( final Integer id) {
	  boolean isExit = HospitalFundMap.containsKey(id+"");
		if (isExit) {
			return true;
		}else {
			HospitalFundMap.put(id+"", "1");
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					HospitalFundMap.remove(id+"");
					System.out.println(id);;
					
				}
			}, 120000);//2分钟
			
		}
		return false;
	}
	@Override
	public  synchronized   void queryHospitalFundForFinish(Integer id) {
		HospitalFundMap.remove(id+"");
	}
	
	@Override
	public  synchronized   boolean queryUserOrderForCreat( final Integer id) {
	  boolean isExit = UserOrderMap.containsKey(id+"");
		if (isExit) {
			return true;
		}else {
			UserOrderMap.put(id+"", "1");
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					UserOrderMap.remove(id+"");
					System.out.println(id);;
					
				}
			}, 120000);//2分钟
			
		}
		return false;
	}
	@Override
	public  synchronized   boolean queryUserOrderIsExit(Integer id) {
		return UserOrderMap.containsKey(id+"");
	}
	@Override
	public  synchronized   void queryUserOrderForFinish(Integer id) {
		UserOrderMap.remove(id+"");
	}
	
	@Override
	public  synchronized   boolean queryHospitalOrderForCreat( final Integer id) {
	  boolean isExit = HospitalOrderMap.containsKey(id+"");
		if (isExit) {
			return true;
		}else {
			HospitalOrderMap.put(id+"", "1");
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					HospitalOrderMap.remove(id+"");
					System.out.println(id);;
					
				}
			}, 120000);//2分钟
			
		}
		return false;
	}
	@Override
	public  synchronized   boolean queryHospitalOrderIsExit(Integer id) {
		return HospitalOrderMap.containsKey(id+"");
	}
	@Override
	public  synchronized   void queryHospitalOrderForFinish(Integer id) {
		HospitalOrderMap.remove(id+"");
	}
}
