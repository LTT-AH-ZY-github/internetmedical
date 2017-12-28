/**  
* @Title: RecommendDoctorServiceImpl.java  
* @Package com.medical.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月21日  
* @version V1.0  
*/  
package com.medical.service.impl;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Hospitaldept;
import com.medical.po.Preorder;
import com.medical.service.iface.RecommendDoctorService;
import com.medical.utils.KeyWords;


/**
 * @ClassName:     RecommendDoctorServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月21日 下午6:33:46 
 */
@Service
public class RecommendDoctorServiceImpl implements RecommendDoctorService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private HospitaldeptMapper hospitaldeptMapper;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addRecommendDoctors(Integer usersickid,Integer userloginid,String keyWord, String primaryDept, String secondDept)
			throws Exception {
		if (primaryDept == null && secondDept == null) {
			List<Doctorinfo> list = getByKeyWord(keyWord);
			if (list!=null && list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					addPreOrder(list.get(i).getDocloginid(), usersickid);
					if (i==10) {
						break;
					}
				}
			}
		} else {
			List<Doctorinfo> list = getByDept(primaryDept, secondDept);
			if (list!=null && list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					addPreOrder(list.get(i).getDocloginid(), usersickid);
					if (i==10) {
						break;
					}
				}
			}else {
				List<Doctorinfo> lists = getByKeyWord(keyWord);
				if (lists!=null && lists.size()>0) {
					for (int i = 0; i < lists.size(); i++) {
						addPreOrder(lists.get(i).getDocloginid(), usersickid);
						if (i==10) {
							break;
						}
					}
				}
				 	
			}
		}

	}
	
	@Transactional(rollbackFor = Exception.class)
	public List<Doctorinfo> getByKeyWord(String keyWord) throws Exception {
		String primaryDept = "内科";
		String secondDept = null;
		Map<Integer, List<String>> map = KeyWords.initWords();
		Iterator<Entry<Integer, List<String>>> it = map.entrySet().iterator();
		int hospdeptid = 0;
	    outer:  while (it.hasNext()) {
		   Entry<Integer, List<String>> entry = it.next();
		   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		   List<String> list = entry.getValue();
		   for (String string : list) {
			 //这里查找str中是否存在"cd"字符串，如果存在则会返回大于等于0的数，如果不存在，则返回-1
			  if(keyWord.indexOf(string)>=0){
			      System.out.println("找到了");
			      hospdeptid= entry.getKey();
			      break outer;
			   }
		   }
		   
		}
		Hospitaldept hospitaldept = hospitaldeptMapper.selectByPrimaryKey(hospdeptid);
		if (hospitaldept!=null) {
			int fatherid = hospitaldept.getHospdeptfatherid();
			if (fatherid==0) {
				primaryDept= hospitaldept.getHospdeptname();
			}else {
				Hospitaldept fatherdept = hospitaldeptMapper.selectByPrimaryKey(fatherid);	
				if (fatherdept!=null) {
					primaryDept= fatherdept.getHospdeptname();
				}
				 secondDept = hospitaldept.getHospdeptname();
			}
		}
		return getByDept(primaryDept, secondDept);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public List<Doctorinfo> getByDept(String primaryDept, String secondDept) throws Exception {
		List<Doctorinfo> list = doctorinfoMapperCustom.selectByDept(primaryDept, secondDept);
		return list;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public boolean addPreOrder(Integer docloginid, Integer usersickid) throws Exception {
		Preorder preorder = new Preorder();
		preorder.setPreorderdocloginid(docloginid);
		preorder.setUsersickid(usersickid);
		preorder.setPreordertype(1);
		preorder.setPreordertime(new Date());
		return preorderMapper.insertSelective(preorder)>0;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteRecommendDoctor(Integer usersickid,Integer docloginid,Integer preordertype )
			throws Exception {
		if (docloginid==null) {
			return preorderMapperCustom.deleteByUserSickIdAndPreOrderType(usersickid, preordertype)>0;
		}else {
			return preorderMapperCustom.deleteByDocLoginIdAndUserSickId(docloginid, usersickid)>0;
		}
		

	}
}
