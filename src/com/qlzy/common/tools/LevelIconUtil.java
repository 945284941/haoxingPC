/**   
 * @Title: LevelIconUtil.java 
 * @Package com.qlzy.common.tools 
 * @Description: TODO(等级图标(会员等级图标、质量等级图标、服务等级图标、信誉等级图标、物流等级图标)) 
 * @author wangmei   
 * @date 2013-11-12 下午3:06:11 
 * @version V1.0   
 */
package com.qlzy.common.tools;

import java.util.HashMap;
import java.util.Map;

import com.qlzy.util.Constant;

public class LevelIconUtil {

	/**
	 * @Title: getVipLevelIcon
	 * @Description: TODO(根据企业会员等级经验值判断获取其相应的会员等级图标)
	 * @param @param vipGrade 企业会员级别
	 * @param @param vipGradePoint 企业会员等级经验值
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author wangmei
	 */
	public static Map<String, Object> getVipLevelIcon(Integer vipGrade, Long vipGradePoint) {
		Map<String, Object> map = new HashMap<String, Object>();
		String imgSrc = "";// 等级图标
		String type = "";// 等级图标类型
		String name = "";// 等级名称
		if (0 == vipGrade) {// 普通会员
			type = "putong";
			name = "普通会员";
			if (0 <= vipGradePoint && vipGradePoint <= 400) {// 1级
				imgSrc = "/pt01.gif";
			} else if (401 <= vipGradePoint && vipGradePoint <= 800) {// 2级
				imgSrc = "/pt02.gif";
			} else if (801 <= vipGradePoint && vipGradePoint <= 1600) {// 3级
				imgSrc = "/pt03.gif";
			} else if (1601 <= vipGradePoint && vipGradePoint <= 3200) {// 4级
				imgSrc = "/pt04.gif";
			} else if (3201 <= vipGradePoint && vipGradePoint <= 6400) {// 5级
				imgSrc = "/pt05.gif";
			} else if (6401 <= vipGradePoint && vipGradePoint <= 12800) {// 6级
				imgSrc = "/pt06.gif";
			} else if (12801 <= vipGradePoint && vipGradePoint <= 25600) {// 7级
				imgSrc = "/pt07.gif";
			} else if (25601 <= vipGradePoint && vipGradePoint <= 51200) {// 8级
				imgSrc = "/pt08.gif";
			} else if (51200 < vipGradePoint) {// 9级
				imgSrc = "/pt09.gif";
			} else {// 经验值为负时普通会员横向等级为1级
				imgSrc = "/pt01.gif";
			}
		} else if (1 == vipGrade) {// VIP会员
			type = "vip";
			name = "VIP会员";
			if (0 <= vipGradePoint && vipGradePoint <= 400) {// 1级
				imgSrc = "/VIP01.gif";
			} else if (401 <= vipGradePoint && vipGradePoint <= 800) {// 2级
				imgSrc = "/VIP02.gif";
			} else if (801 <= vipGradePoint && vipGradePoint <= 1600) {// 3级
				imgSrc = "/VIP03.gif";
			} else if (1601 <= vipGradePoint && vipGradePoint <= 3200) {// 4级
				imgSrc = "/VIP04.gif";
			} else if (3201 <= vipGradePoint && vipGradePoint <= 6400) {// 5级
				imgSrc = "/VIP05.gif";
			} else if (6401 <= vipGradePoint && vipGradePoint <= 12800) {// 6级
				imgSrc = "/VIP06.gif";
			} else if (12801 <= vipGradePoint && vipGradePoint <= 25600) {// 7级
				imgSrc = "/VIP07.gif";
			} else if (25601 <= vipGradePoint && vipGradePoint <= 51200) {// 8级
				imgSrc = "/VIP08.gif";
			} else if (51200 < vipGradePoint) {// 9级
				imgSrc = "/VIP09.gif";
			} else {// 经验值为负时VIP会员横向等级为1级
				imgSrc = "/VIP01.gif";
			}
		} else if (2 == vipGrade) {// 黄金会员
			type = "huangjin";
			name = "黄金会员";
			if (0 <= vipGradePoint && vipGradePoint <= 400) {// 1级
				imgSrc = "/hj01.gif";
			} else if (401 <= vipGradePoint && vipGradePoint <= 800) {// 2级
				imgSrc = "/hj02.gif";
			} else if (801 <= vipGradePoint && vipGradePoint <= 1600) {// 3级
				imgSrc = "/hj03.gif";
			} else if (1601 <= vipGradePoint && vipGradePoint <= 3200) {// 4级
				imgSrc = "/hj04.gif";
			} else if (3201 <= vipGradePoint && vipGradePoint <= 6400) {// 5级
				imgSrc = "/hj05.gif";
			} else if (6401 <= vipGradePoint && vipGradePoint <= 12800) {// 6级
				imgSrc = "/hj06.gif";
			} else if (12801 <= vipGradePoint && vipGradePoint <= 25600) {// 7级
				imgSrc = "/hj07.gif";
			} else if (25601 <= vipGradePoint && vipGradePoint <= 51200) {// 8级
				imgSrc = "/hj08.gif";
			} else if (51200 < vipGradePoint) {// 9级
				imgSrc = "/hj09.gif";
			} else {// 经验值为负时黄金会员横向等级为1级
				imgSrc = "/hj01.gif";
			}
		} else if (3 == vipGrade) {// 白金会员
			type = "baijin";
			name = "白金会员";
			if (0 <= vipGradePoint && vipGradePoint <= 400) {// 1级
				imgSrc = "/bj01.gif";
			} else if (401 <= vipGradePoint && vipGradePoint <= 800) {// 2级
				imgSrc = "/bj02.gif";
			} else if (801 <= vipGradePoint && vipGradePoint <= 1600) {// 3级
				imgSrc = "/bj03.gif";
			} else if (1601 <= vipGradePoint && vipGradePoint <= 3200) {// 4级
				imgSrc = "/bj04.gif";
			} else if (3201 <= vipGradePoint && vipGradePoint <= 6400) {// 5级
				imgSrc = "/bj05.gif";
			} else if (6401 <= vipGradePoint && vipGradePoint <= 12800) {// 6级
				imgSrc = "/bj06.gif";
			} else if (12801 <= vipGradePoint && vipGradePoint <= 25600) {// 7级
				imgSrc = "/bj07.gif";
			} else if (25601 <= vipGradePoint && vipGradePoint <= 51200) {// 8级
				imgSrc = "/bj08.gif";
			} else if (51200 < vipGradePoint) {// 9级
				imgSrc = "/bj09.gif";
			} else {// 经验值为负时白金会员横向等级为1级
				imgSrc = "/bj01.gif";
			}
		} else {// 钻石会员
			type = "zuanshi";
			name = "钻石会员";
			if (0 <= vipGradePoint && vipGradePoint <= 400) {// 1级
				imgSrc = "/z01.gif";
			} else if (401 <= vipGradePoint && vipGradePoint <= 800) {// 2级
				imgSrc = "/z02.gif";
			} else if (801 <= vipGradePoint && vipGradePoint <= 1600) {// 3级
				imgSrc = "/z03.gif";
			} else if (1601 <= vipGradePoint && vipGradePoint <= 3200) {// 4级
				imgSrc = "/z04.gif";
			} else if (3201 <= vipGradePoint && vipGradePoint <= 6400) {// 5级
				imgSrc = "/z05.gif";
			} else if (6401 <= vipGradePoint && vipGradePoint <= 12800) {// 6级
				imgSrc = "/z06.gif";
			} else if (12801 <= vipGradePoint && vipGradePoint <= 25600) {// 7级
				imgSrc = "/z07.gif";
			} else if (25601 <= vipGradePoint && vipGradePoint <= 51200) {// 8级
				imgSrc = "/z08.gif";
			} else if (51200 < vipGradePoint) {// 9级
				imgSrc = "/z09.gif";
			} else {// 经验值为负时钻石会员横向等级为1级
				imgSrc = "/z01.gif";
			}
		}
		map.put("vipLevelIcon", type + imgSrc);
		map.put("vipLevelName", name);
		return map;
	}

	/**
	 * @Title: getSincerityLevelIcon
	 * @Description: TODO(根据诚信(质量、信誉、服务、物流)经验值获取其诚信(质量、信誉、服务、物流)等级图标)
	 * @param @param point
	 * @param @param type
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public static String getSincerityLevelIcon(Long point, String type) {
		String imgSrc = "";
		String sincerityType = "";
		if (Constant._QUALITY.equals(type)) {// 质量等级
			sincerityType = "zhiliang";
			if (point < 0) {// 0级
				imgSrc = "";
			} else if (0 <= point && point <= 50) {// 1级
				imgSrc = "/z01.gif";
			} else if (51 <= point && point <= 150) {// 2级
				imgSrc = "/z02.gif";
			} else if (151 <= point && point <= 300) {// 3级
				imgSrc = "/z03.gif";
			} else if (301 <= point && point <= 600) {// 4级
				imgSrc = "/z04.gif";
			} else if (601 <= point && point <= 1200) {// 5级
				imgSrc = "/z05.gif";
			} else if (1201 <= point && point <= 2400) {// 6级
				imgSrc = "/z06.gif";
			} else if (2401 <= point && point <= 4800) {// 7级
				imgSrc = "/z07.gif";
			} else if (4801 <= point && point <= 9600) {// 8级
				imgSrc = "/z08.gif";
			} else {// 9级
				imgSrc = "/z09.gif";
			}
		} else if (Constant._SERVE.equals(type)) {// 服务等级
			sincerityType = "fuwu";
			if (point < 0) {
				imgSrc = "";
			} else if (0 <= point && point <= 50) {// 1级
				imgSrc = "/f01.gif";
			} else if (51 <= point && point <= 150) {// 2级
				imgSrc = "/f02.gif";
			} else if (151 <= point && point <= 300) {// 3级
				imgSrc = "/f03.gif";
			} else if (301 <= point && point <= 600) {// 4级
				imgSrc = "/f04.gif";
			} else if (601 <= point && point <= 1200) {// 5级
				imgSrc = "/f05.gif";
			} else if (1201 <= point && point <= 2400) {// 6级
				imgSrc = "/f06.gif";
			} else if (2401 <= point && point <= 4800) {// 7级
				imgSrc = "/f07.gif";
			} else if (4801 <= point && point <= 9600) {// 8级
				imgSrc = "/f08.gif";
			} else {// 9级
				imgSrc = "/f09.gif";
			}
		} else if (Constant._CREDIT.equals(type)) {// 信誉等级
			sincerityType = "xinyu";
			if (point < 0) {// 0级
				imgSrc = "";
			} else if (0 <= point && point <= 50) {// 1级
				imgSrc = "/c01.gif";
			} else if (51 <= point && point <= 150) {// 2级
				imgSrc = "/c02.gif";
			} else if (151 <= point && point <= 300) {// 3级
				imgSrc = "/c03.gif";
			} else if (301 <= point && point <= 600) {// 4级
				imgSrc = "/c04.gif";
			} else if (601 <= point && point <= 1200) {// 5级
				imgSrc = "/c05.gif";
			} else if (1201 <= point && point <= 2400) {// 6级
				imgSrc = "/c06.gif";
			} else if (2401 <= point && point <= 4800) {// 7级
				imgSrc = "/c07.gif";
			} else if (4801 <= point && point <= 9600) {// 8级
				imgSrc = "/c08.gif";
			} else {// 9级
				imgSrc = "/c09.gif";
			}
		} else {// 物流等级
			sincerityType = "wuliu";
			if (point < 0) {// 0级
				imgSrc = "";
			} else if (0 <= point && point <= 50) {// 1级
				imgSrc = "/w01.gif";
			} else if (51 <= point && point <= 150) {// 2级
				imgSrc = "/w02.gif";
			} else if (151 <= point && point <= 300) {// 3级
				imgSrc = "/w03.gif";
			} else if (301 <= point && point <= 600) {// 4级
				imgSrc = "/w04.gif";
			} else if (601 <= point && point <= 1200) {// 5级
				imgSrc = "/w05.gif";
			} else if (1201 <= point && point <= 2400) {// 6级
				imgSrc = "/w06.gif";
			} else if (2401 <= point && point <= 4800) {// 7级
				imgSrc = "/w07.gif";
			} else if (4801 <= point && point <= 9600) {// 8级
				imgSrc = "/w08.gif";
			} else {// 9级
				imgSrc = "/w09.gif";
			}
		}
		return sincerityType + imgSrc;
	}
}
