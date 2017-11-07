package com.medical.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.huanxin.utils.TokenManager;
import com.huanxin.utils.UserManger;
import com.medical.service.DoctorService;

@Component
public class TimerController {
	@Autowired
	private DoctorService doctorService;
	/**  
     * 每天中午十二点触发 
     */    
   //@Scheduled(cron = "0 0 12 * * ?")   
    public void executeAtNoon(){  
    	doctorService.setLocation("下午");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        System.out.println("timer : "+format.format(new Date()));   
    }  
    /**  
     * 每天晚上十二点触发 
     */    
   //@Scheduled(cron = "0 0 0 * * ?")   
    public void executeAtNight(){
    	TokenManager.updateToken();
    	doctorService.setLocation("上午");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        System.out.println("timer : "+format.format(new Date()));   
    }  
    
}
