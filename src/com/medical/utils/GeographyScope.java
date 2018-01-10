package com.medical.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName:     GeographyScope.java
 * @Description:   经纬度工具类
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月10日 下午6:09:58 
 */
public class GeographyScope {

   /**
    * 
    * @Title: getAround 
    * @Description: 根据经纬度和半径算出极点
    * @param lat 纬度
    * @param lon 经度
    * @param raidus 半径
    * @return
    * @return: Map<String,Object>
    */
	public static Map<String, Object> getAround(double lat, double lon, int raidus) {

		Map<String, Object> aroundMap = new HashMap<>();
		Double latitude = lat;
		Double longitude = lon;

		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLon = degree * Math.cos(latitude * (Math.PI / 180));
		Double dpmLon= 1 / mpdLon;
		Double radiusLng = dpmLon * raidusMile;
		Double minLon = longitude - radiusLng;
		Double maxLon = longitude + radiusLng;
		aroundMap.put("minLat", minLat);
		aroundMap.put("minLon", minLon);
		aroundMap.put("maxLat", maxLat);
		aroundMap.put("maxLon", maxLon);
		return aroundMap;
	}
}
