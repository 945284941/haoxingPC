/**??
* @Title: AppraiseService.java
* @Package com.qlzy.memberCenter.person.appraise.service
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com??
* @date 2013-10-7 下午2:11:27
* @version V1.0??
*/
package com.qlzy.memberCenter.person.appraise.service;

import java.util.List;
import java.util.Map;

import com.qlzy.model.Appraise;
import com.qlzy.pojo.StatisticsInfo;

/**
 * @ClassName: AppraiseService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author  zhao  yang bin
 * @date 2013-10-7 下午2:11:27
 *
 */
public interface AppraiseService {
	/**
	 *
	 * @param appraise
	 * @return
	 */
	int insertAppraise(Appraise appraise);

	/**
	 * 通过订单id和商品id查询评论信息
	 * @param appraise
	 * @return
	 */
	Appraise gainByOrderIdAndGoodsId(Appraise appraise);

	/**
	* @Title: gainAppraiseList
	* @Description: TODO(我的评论列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return List<Appraise>????返回类型
	* @throws
	*/
	List<Appraise> gainAppraiseList(Map<String, Object> map);

	/**
	* @Title: gainAppraiseListCount
	* @Description: TODO(我的评论列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainAppraiseListCount(Map<String, Object> map);

	/**
	 * 会员对商品进行评价
	* @Title: memberAppraise
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param appraise    设定文件
	* @return void    返回类型
	* @author 周张豹
	*/
	public void memberAppraise(Appraise appraise);

	/**
	* @Title: gainAllCountRight
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param userId
	* @param @return????设定文件
	* @return StatisticsInfo????返回类型
	* @throws
	*/
	StatisticsInfo gainAllCountRight(String userId);

	/**
	* @Title: gainAppraiseListByType
	* @Description: TODO(企业买家列表)
	* @param @param map
	* @param @return????设定文件
	* @return List<Appraise>????返回类型
	* @throws
	*/
	List<Appraise> gainAppraiseListByType(Map<String, Object> map);

	/**
	* @Title: gainAppraiseListCountByType
	* @Description: TODO(企业买家列表数目)
	* @param @param map
	* @param @return????设定文件
	* @return Long????返回类型
	* @throws
	*/
	Long gainAppraiseListCountByType(Map<String, Object> map);

	/**
	* @Title: gainAllCountRightByCompany
	* @Description: TODO(企业右侧显示数目)
	* @param @param userId
	* @param
	* @return StatisticsInfo????返回类型
	* @throws
	*/
	StatisticsInfo gainAllCountRightByCompany(String userId);

	List<Appraise> selectAppariseByTypeAndPage(Map<String, Object> parmMap);

	Long selectAppariseByTypeAndPageCount(Map<String, Object> parmMap);

	/**
	 * @Title goodEvaluate
	 * @Description TODO(好评的数量)
	 * @param companyId
	 * @return
	 * @author Jason
	 */
	Long goodEvaluate(String companyId);
	/**
	 * @Title goodEvaluate
	 * @Description TODO(总评价数)
	 * @param companyId
	 * @return
	 * @author Jason
	 */
	Long Evaluate(String companyId);
}
