/**  
* @Title: HospitalUnitPriceServiceImpl.java  
* @Package com.medical.service.impl.hospital  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月11日  
* @version V1.0  
*/  
package com.medical.service.impl.hospital;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.HospitalunitpriceMapper;
import com.medical.mapper.HospitalunitpriceMapperCustom;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.po.Hospitalunitprice;
import com.medical.po.Hosplogininfo;
import com.medical.service.iface.hospital.HospitalUnitPriceService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.DataResult2;

/**
 * @ClassName:     HospitalUnitPriceServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午5:03:29 
 */
public class HospitalUnitPriceServiceImpl implements HospitalUnitPriceService {
	@Autowired
	private HosplogininfoMapper hosplogininfoMapper;
	@Autowired
	private HospitalunitpriceMapper hospitalunitpriceMapper;
	@Autowired
	private HospitalunitpriceMapperCustom hospitalunitpriceMapperCustom;
	/* (非 Javadoc)  
	* <p>Title: creatUnitPrice</p>  
	* <p>Description: </p>  
	* @param hospitalunitprice
	* @return  
	* @see com.medical.service.iface.hospital.HospitalUnitPriceService#creatUnitPrice(com.medical.po.Hospitalunitprice)  
	*/  
	@Override
	public String creatUnitPrice(Hospitalunitprice hospitalunitprice) throws Exception{
		int hosploginid = hospitalunitprice.getHosploginid();
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		hospitalunitprice.setUnitpriceid(null);
		hospitalunitprice.setUnitpricetime(new Date());
		boolean result= hospitalunitpriceMapper.insertSelective(hospitalunitprice)>0;
		if (result) {
			return DataResult.success("新增成功");
		}else {
			return DataResult.error("新增失败");
		}
		
	}
	/* (非 Javadoc)  
	* <p>Title: listUnitPrice</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.hospital.HospitalUnitPriceService#listUnitPrice(java.lang.Integer)  
	*/  
	@Override
	public String listUnitPrice(Integer hosploginid, Integer limit, Integer offset) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hospitalunitpriceMapperCustom.selectByHospLoginId(hosploginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			System.out.println("数据"+pageInfo.getList());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rows", pageInfo.getList());
			// 总共页数
			map.put("total", pageInfo.getTotal());
		
			return DataResult.success("获取成功", map);
		} else {
			return DataResult.success("获取成功", null);
		}
	}
	/* (非 Javadoc)  
	* <p>Title: updateUnitPrice</p>  
	* <p>Description: </p>  
	* @param hospitalunitprice
	* @return  
	* @see com.medical.service.iface.hospital.HospitalUnitPriceService#updateUnitPrice(com.medical.po.Hospitalunitprice)  
	*/  
	@Override
	public String updateUnitPrice(Hospitalunitprice hospitalunitprice) throws Exception{
		int hosploginid = hospitalunitprice.getHosploginid();
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int unitpriceid = hospitalunitprice.getUnitpriceid();
		Hospitalunitprice unitprice= hospitalunitpriceMapper.selectByPrimaryKey(unitpriceid);
		if (unitprice==null) {
			return DataResult.error("该记录不存在");
		}
		int hosp = unitprice.getHosploginid();
		if (hosploginid!=hosp) {
			return DataResult.error("账号信息不匹配");
		}
		hospitalunitprice.setUnitpricetime(new Date());
		boolean result= hospitalunitpriceMapper.updateByPrimaryKeySelective(hospitalunitprice)>0;
		if (result) {
			return DataResult.success("修改成功");
		}else {
			return DataResult.error("修改失败");
		}
	}
	/* (非 Javadoc)  
	* <p>Title: deleteUnitPrice</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @param unitpriceid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.hospital.HospitalUnitPriceService#deleteUnitPrice(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String deleteUnitPrice(Integer hosploginid, Integer unitpriceid) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Hospitalunitprice hospitalunitprice= hospitalunitpriceMapper.selectByPrimaryKey(unitpriceid);
		if (hospitalunitprice==null) {
			return DataResult.error("该记录不存在");
		}
		int hosp = hospitalunitprice.getHosploginid();
		if (hosploginid!=hosp) {
			return DataResult.error("账号信息不匹配");
		}
		boolean result = hospitalunitpriceMapper.deleteByPrimaryKey(unitpriceid)>0;
		if (result) {
			return DataResult.success("删除成功");
		}else {
			return DataResult.error("删除失败");
		}
	}

}
