package com.medical.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.huanxin.utils.TokenManager;
import com.medical.service.iface.doctor.DoctorInfoService;

/**
 * @ClassName:     TimerController.java
 * @Description:   定时器 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:47:31 
 */
@Component
public class TimerController {
	@Autowired
	private DoctorInfoService doctorInfoService;
	/**  
     * 每天中午十二点触发 
	 * @throws Exception 
     */    
    @Scheduled(cron = "0 0 12 * * ?")   
    public void executeAtNoon() throws Exception{  
    	
    	doctorInfoService.updateLocation("上午");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        System.out.println("timer : "+format.format(new Date()));   
    }  
    /**  
     * 每天晚上十二点触发 
     * @throws Exception 
     */    
    @Scheduled(cron = "0 0 0 * * ?")   
    public void executeAtNight() throws Exception{
    	TokenManager.updateToken();
    	doctorInfoService.updateLocation("下午");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        System.out.println("timer : "+format.format(new Date()));   
    }  
    
}
