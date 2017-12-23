
package com.medical.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.StaticApplicationContext;

/**
 * @ClassName: KeyWords.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年12月22日 下午2:39:40
 */
public class KeyWords {

	public static Map<Integer, List<String>> initWords() {
		Map<Integer, List<String>> map = new HashMap<>();
		// 呼吸内科
		List<String> list = new ArrayList<>();
		list.add("咳嗽");
		list.add("发烧");
		list.add("流鼻涕");
		list.add("咳痰");
		list.add("胸闷");
		list.add("持续低烧乏力");
		list.add("口干");
		list.add("突然高烧头痛");
		list.add("呼吸不畅");
		map.put(4, list);

		// 消化内科
		List<String> list2 = new ArrayList<>();
		list2.add("恶心呕吐");
		list2.add("胀气反酸");
		list2.add("舌红苔薄黄");
		list2.add("消化不良");
		list2.add("胃部疼痛");
		list2.add("饭后饱胀");
		list2.add("厌食");
		list2.add("食物中毒");
		list2.add("便秘");
		list2.add("大便干结");
		list2.add("无排便");
		list2.add("拉肚子");
		map.put(5, list2);

		// 心血管内科
		List<String> list3 = new ArrayList<>();
		list3.add("头晕");
		list3.add("剧烈头痛");
		list3.add("心慌气短");
		list3.add("心跳过快");
		list3.add("无力疲乏");
		list3.add("恶心呕吐");
		list3.add("心悸");
		list3.add("皮肤苍白");
		list3.add("胸闷胸痛");
		list3.add("心率不齐");
		list3.add("多饮多尿多食");
		list3.add("呼吸困难");
		list3.add("恶寒");
		map.put(3, list3);

		// 血液科
		List<String> list4 = new ArrayList<>();
		list4.add("气血不足");
		list4.add("生长缓慢");
		list4.add("腹部肿块");
		list4.add("食欲减退");
		list4.add("面色苍白");
		list4.add("指甲易碎");
		list4.add("牙龈出血");
		list4.add("头晕");
		list4.add("精神萎靡");
		list4.add("怕冷");
		list4.add("高热寒战");
		list4.add("腰酸背痛");
		list4.add("关节肿胀");
		list4.add("皮肤出血斑");
		list4.add("紫斑");
		list4.add("四肢麻木");
		list4.add("头发枯黄");
		map.put(8, list4);

		// 内分泌科
		List<String> list5 = new ArrayList<>();
		list5.add("多尿");
		list5.add("糖尿");
		list5.add("消瘦");
		list5.add("多饮");
		list5.add("腋窝痛");
		list5.add("乳房硬化");
		list5.add("大脖子病");
		list5.add("心悸冷汗");
		list5.add("面色苍白");
		list5.add("头晕呕吐");
		list5.add("脱发");
		list5.add("厌食");
		list5.add("嗜睡");
		list5.add("头油");
		list5.add("血虚眩晕");
		list5.add("粉刺");
		list5.add("皮肤干燥");
		list5.add("足底溃疡");
		list5.add("声音嘶哑");
		list5.add("食欲异常");
		map.put(7, list5);

		// 神经内科
		List<String> list6 = new ArrayList<>();
		list6.add("上肢麻痹");
		list6.add("肩背痛");
		list6.add("颈椎痛");
		list6.add("癫痫");
		list6.add("口吐白沫");
		list6.add("失眠多梦");
		list6.add("易乏");
		list6.add("多疑疲劳");
		list6.add("偏头痛");
		list6.add("头晕头痛");
		list6.add("焦虑");
		list6.add("坐立不安");
		list6.add("失眠");
		list6.add("情绪波动大");
		list6.add("烦躁不安");
		list6.add("心慌");
		list6.add("入睡困难");
		list6.add("步态不稳");
		list6.add("健忘");
		list6.add("面瘫");
		list6.add("面色苍白");
		list6.add("眩晕");
		list6.add("脑鸣");
		list6.add("癔症");
		list6.add("脑鸣");
		list6.add("昏迷");
		map.put(2, list6);
		// 感染内科
		List<String> list7 = new ArrayList<>();
		list7.add("大三阳");
		list7.add("小三阳");
		list7.add("肝肿大");
		list7.add("疲劳消瘦");
		list7.add("恶心呕吐");
		list7.add("食欲异常");
		list7.add("乏力肌痛");
		list7.add("多疑疲劳");
		list7.add("低烧");
		list7.add("昏迷嗜睡");
		list7.add("黄疸少尿");
		list7.add("痤疮样皮疹");
		map.put(11, list7);

		// 骨科
		List<String> list8 = new ArrayList<>();
		list8.add("骨折");
		list8.add("肩膀酸疼");
		list8.add("关节疼痛");
		list8.add("关节肿胀");
		list8.add("腰酸腰疼");
		list8.add("罗圈腿");
		list8.add("手腕疼痛");
		list8.add("肘痛");
		list8.add("肋骨疼");
		list8.add("扭伤");
		list8.add("膝关节肿大");
		list8.add("不能屈膝");
		list8.add("胸廓异常");
		list8.add("骨质疏松");
		list8.add("四肢瘫痪");
		list8.add("手麻");
		list8.add("踝关节疼痛");
		map.put(35, list8);

		// 肝胆外科
		List<String> list9 = new ArrayList<>();
		list9.add("上腹不适");
		list9.add("胃灼热");
		list9.add("恶心呕吐");
		list9.add("消瘦");
		list9.add("大便色浅");
		list9.add("肚子疼");
		list9.add("乏力消瘦");
		list9.add("肝气不足");
		list9.add("肝郁气滞");
		list9.add("腹部肿块");
		list9.add("出冷汗");
		list9.add("肚子疼");
		list9.add("反酸");
		list9.add("右上腹疼痛");
		list9.add("腹鸣烧心");
		list9.add("胃肠气胀");
		map.put(18, list9);
		// 泌尿科
		List<String> list10 = new ArrayList<>();
		list10.add("尿频");
		list10.add("尿滴沥");
		list10.add("排尿困难");
		list10.add("尿分叉");
		list10.add("排尿时伴有烧灼感");
		list10.add("滴灼感");
		list10.add("尿血");
		list10.add("龟头瘙痒");
		list10.add("脓尿");
		map.put(20, list10);

		// 肛肠科
		List<String> list11 = new ArrayList<>();
		list11.add("痔疮");
		list11.add("便血");
		list11.add("肛裂");
		list11.add("排便疼痛");
		list11.add("直肠疼痛");
		list11.add("排便障碍");
		list11.add("肛门疼痛");
		list11.add("肛门瘙痒");
		list11.add("肛门坠胀");
		list11.add("肚子疼");
		list11.add("肠痉挛");
		list11.add("大小便失禁");
		list11.add("刺痛");
		list11.add("胃肠气胀");
		map.put(19, list11);
		// 肿瘤科
		List<String> list12 = new ArrayList<>();
		list12.add("子宫出血");
		list12.add("白带增多");
		list12.add("腹部肿块");
		list12.add("乳汁郁结");
		list12.add("乳房肿块");
		list12.add("呼吸异常");
		list12.add("直肠疼痛");
		list12.add("吞咽困难");
		list12.add("便秘伴剧烈腹痛");
		list12.add("甲状腺结节");
		list12.add("下腹疼痛");
		list12.add("阴道出血");
		list12.add("盗汗严重");
		list12.add("口痛溃疡");
		list12.add("食欲不振");
		list12.add("呼吸困难");
		map.put(44, list12);

		// 儿科
		List<String> list13 = new ArrayList<>();
		list13.add("幼儿");
		list13.add("小儿");
		list13.add("新生儿");
		list13.add("婴幼儿");
		map.put(34, list13);

		// 妇科
		List<String> list14 = new ArrayList<>();
		list14.add("白带增多");
		list14.add("宫颈糜烂");
		list14.add("月经不调");
		list14.add("子宫出血");
		list14.add("乳房硬化");
		list14.add("下腹痛");
		list14.add("外阴瘙痒");
		list14.add("不排卵");
		list14.add("前阴寒冷");
		list14.add("阴道不规则出血");
		list14.add("阴道分泌物增多");
		list14.add("毛发过密");
		list14.add("会阴溃疡");
		map.put(29, list14);

		// 产科
		List<String> list15 = new ArrayList<>();
		list15.add("宫外孕");
		list15.add("流产");
		list15.add("难产");
		list15.add("产后出血");
		list15.add("早孕反应");
		list15.add("胎动频繁");
		list15.add("阴道出血");
		list15.add("子宫出血");
		list15.add("孕妇");
		list15.add("胎儿生长发育迟缓");
		list15.add("孕吐严重");
		list15.add("习惯性流产");
		map.put(28, list15);

		// 眼科
		List<String> list16 = new ArrayList<>();
		list16.add("眼屎多");
		list16.add("红眼");
		list16.add("瞳孔变白");
		list16.add("泪溢");
		list16.add("眼中有异物");
		list16.add("流泪");
		list16.add("重影");
		list16.add("两眼干涩");
		list16.add("畏光");
		list16.add("眼疼");
		list16.add("散光");
		list16.add("视物模糊");
		list16.add("眼球突出");
		list16.add("眼球不能动");
		list16.add("斜视");
		list16.add("眼角长斑");
		map.put(39, list16);

		// 耳鼻喉科
		List<String> list17 = new ArrayList<>();
		list17.add("咽部肿痛");
		list17.add("喉咙疼");
		list17.add("鼻窦炎");
		list17.add("鼻炎");
		list17.add("张口呼吸");
		list17.add("鼻内发痒");
		list17.add("耳道流脓");
		list17.add("鼻出血");
		list17.add("耳痛");
		list17.add("耳鸣");
		list17.add("耳聋");
		list17.add("鼻涕");
		list17.add("喉咙痒");
		map.put(36, list17);

		// 口腔科
		List<String> list18 = new ArrayList<>();
		list18.add("口腔溃疡");
		list18.add("口臭");
		list18.add("牙龈坏死");
		list18.add("牙疼");
		list18.add("口腔血泡");
		list18.add("口角生疮");
		list18.add("磨牙");
		map.put(40, list18);

		// 皮肤科
		List<String> list19 = new ArrayList<>();
		list19.add("红疹");
		list19.add("痒");
		list19.add("红肿");
		list19.add("皮疹");
		list19.add("泛红");
		list19.add("掉皮");
		list19.add("起疙瘩");
		list19.add("水肿");
		list19.add("脚气");
		list19.add("粉刺");
		list19.add("脓疱");
		list19.add("起癣");
		list19.add("脱发");
		map.put(42, list19);

		// 中医科
		List<String> list20 = new ArrayList<>();
		list20.add("调理");
		map.put(54, list20);

		// 针灸推拿科
		List<String> list21 = new ArrayList<>();
		list21.add("除湿气");
		list21.add("按摩");
		map.put(54, list21);

		// 心理咨询室
		List<String> list22 = new ArrayList<>();
		list22.add("抑郁");
		list22.add("情绪低落");
		list22.add("噩梦多梦");
		list22.add("注意力不集中");
		list22.add("多疑焦虑");
		map.put(49, list22);

		// 感染科
		List<String> list23 = new ArrayList<>();
		list23.add("水泡");
		list23.add("脓疱");
		list23.add("丘疹");
		list23.add("发热");
		list23.add("阴囊瘙痒");
		list23.add("皮疹");
		list23.add("打喷嚏");
		list23.add("咳嗽");
		map.put(42, list23);
		// 烧伤科
		List<String> list24 = new ArrayList<>();
		list24.add("烧伤感染");
		list24.add("化学试剂灼伤");
		list24.add("烫伤");
		list24.add("冻伤");
		list24.add("皮肤发红起水泡");
		list24.add("起脓");
		map.put(57, list24);

		// 不孕科
		/*List<String> list25 = new ArrayList<>();
		list25.add("烧伤感染");
		map.put(42, list25);*/

		// 整形科
		List<String> list26 = new ArrayList<>();
		list26.add("器官移植");
		list26.add("接手指");
		list26.add("美容");
		map.put(23, list26);
		return map;

	}

}
