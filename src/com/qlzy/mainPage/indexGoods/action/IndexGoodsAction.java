/**  
 * @Title: IndexGoodsAction.java
 * @Package com.qlzy.mainPage.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 周张豹  
 * @date 2013-5-7 下午5:25:25
 * @version V1.0  
 */
package com.qlzy.mainPage.indexGoods.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.qlzy.memberCenter.person.appraise.service.AppraiseService;
import com.qlzy.memberCenter.shop.service.CompanysGoodsCatService;
import com.qlzy.model.*;
import com.qlzy.util.Pagination;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.company.service.CompanyService;
import com.qlzy.mainPage.indexGoods.service.IndexGoodsService;
import com.qlzy.memberCenter.call.service.MemberCallService;
import com.qlzy.memberCenter.company.cominfo.service.CompanyInfoService;
import com.qlzy.memberCenter.person.memberCollect.service.MemberCollectService;
import com.qlzy.pojo.SessionInfo;
import com.qlzy.util.BaseAction;

@Namespace("/")
// 命名空间
@Action(value = "indexGoodsAction", results = {
		@Result(name = "hotGoods", location = "/admin/goods/hotGoods.jsp"),
		@Result(name = "goods", location = "/admin/goods/goods.jsp"),
		@Result(name = "goodsSh", location = "/shanghui/goods/goods.jsp"),
		@Result(name = "goodsHot", location = "/admin/goodsHot/goodsHot.jsp"),
		@Result(name = "toIndexGoodsHot", location = "/admin/goodsHot/indexGoodsHot.jsp") })
/**
 * @ClassName: IndexGoodsAction
 * @Description: TODO(首页商品)
 * @author 周张豹
 * @date 2013-5-7 下午5:25:25
 */
public class IndexGoodsAction extends BaseAction {
	@Resource
	private IndexGoodsService indexGoodsService;
	@Resource
	private CompanyService companyService;
	@Resource
	private MemberCollectService memberCollectService;
	@Resource
	private MemberCallService memberCallService;
	@Resource
	private CompanyInfoService companyInfoService;
	@Resource
	private CompanysGoodsCatService companysGoodsCatService ;
	@Resource
	private AppraiseService appraiseService;
	/**
	 * @ClassName: com.qlzy.mainPage.actionIndexGoodsAction.java
	 * @Description: TODO(这里用一句话描述这个类的作用)
	 * @author 周张豹
	 * @date 2013-5-7 下午5:26:32 2013-5-7
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	private Integer catLang;
	private Integer goodsLang;

	private String goodsCatId;
	private String shCatId;

	private List<GoodsCat> list = new ArrayList<GoodsCat>();

	private List<Goods> newGoods = new ArrayList<Goods>();

	private static final String REGQUERY_UTIL = "reg query ";
	private static final String REGSTR_TOKEN = "REG_SZ";
	private static final String REGDWORD_TOKEN = "REG_DWORD";

	private static final String PERSONAL_FOLDER_CMD = REGQUERY_UTIL
			+ "\"HKCU\\SOFTWARE\\Classes\\myClient\\shell\\open\\command\"";


	private List<Goods> hotGoods = new ArrayList<Goods>();


	private List<Goods> catGoodsList;
	private List<Goods> catGoodsList2;
	private List<Goods> catGoodsList3;





	//正在使用
	private String goodsId;
	private Goods goods;
	private Company company;
	private List<Goods> hotGoodsList;
	private SessionInfo sessionInfo;
	private List<CompanysGoodsCat> companyGoodsCatList = new ArrayList<CompanysGoodsCat>();
	private String appraiseType;
	private List<Appraise> appraiseList;
//	/**
//	 * @return the list
//	 */
//	public List<GoodsCat> getList() {
//		return list;
//	}
//
//	/**
//	 * @param list
//	 *            the list to set
//	 */
//	public void setList(List<GoodsCat> list) {
//		this.list = list;
//	}








	/**
	 * 根据商品ID转到商品详情页面
	 *
	 * @Title: getGoods
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author
	 */
	public String gainGoods() {
		sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		Map<String,Object> parmMap = new HashMap<>();
		parmMap.put("goodsId",goodsId);
		parmMap.put("addressId",sessionInfo.getAddressMap().get("addressId"));
		goods = indexGoodsService.gainGoodsByParm(parmMap);

		Pagination pagination = definationPagination(request);
		pagination.setRows(2L);//设置每页显示几条数据
		//查询该商品的评论信息分页
		parmMap = new HashMap<>();
		parmMap.put("appraiseType",appraiseType);
		parmMap.put("goodsId",goodsId);
		Long count = appraiseService.selectAppariseByTypeAndPageCount(parmMap);
		pagination.setTotalCount(count);
		parmMap.put("rows", pagination.getRows());
		parmMap.put("page", (pagination.getPage()-1)*pagination.getRows());
		appraiseList = appraiseService.selectAppariseByTypeAndPage(parmMap);
		request.setAttribute("pagination", pagination);
		if (sessionInfo != null && sessionInfo.getUserId() != null && !"".equals(sessionInfo.getUserId())) {
			// 插入浏览记录
			Views views = new Views();
			views.setId(ToolsUtil.getUUID());
			views.setUserId(sessionInfo.getUserId());

			views.setViewId(goodsId);
			views.setCreatetime(new Date());
			views.setType("goods");
			memberCollectService.insetMemberViews(views);
		}
//		goods.setCollectNum(memberCallService.selectCollectByCollectId(goodsId));// 获取被收藏的总数
		//商家信息

		//宝贝推荐列表 左侧推荐栏
		parmMap = new HashMap<>();
		parmMap.put("limitNum",5);
		parmMap.put("addressId",addressId);
		parmMap.put("companyId",goods.getCompanyId());
		parmMap.put("isSort","1");
		hotGoodsList = indexGoodsService.selectGoodsByType(parmMap);
		company = companyService.selectcCompanyById(goods.getCompanyId());
		//商家分类
		companyGoodsCatList = companysGoodsCatService.gainAllCompanyCat(company.getId());
		return "goods";
	}

	public String toIndexGoodsHot() {
		List<GoodsHot> goodsHotList = indexGoodsService.gainGoodsHot();
		/*
		 * List<GoodsHot> goodsHotList = new ArrayList<GoodsHot>(); GoodsHot
		 * goodsHot = null; if(null != list && list.size() > 0){ goodsHot =
		 * list.get(0); if(list.size() > 1){ goodsHotList = list.subList(1,
		 * list.size()); } }
		 * 
		 * request.setAttribute("goodsHot", goodsHot);
		 */
		request.setAttribute("goodsHotList", goodsHotList);
		return "toIndexGoodsHot";
	}

	@SuppressWarnings("null")
	public String gainGoodsHot() {
		// 查询特卖的促销商品
		List<GoodsHot> goodsHotListT = indexGoodsService.gainGoodsHotT();
		// 查询一般的促销商品
		List<GoodsHot> goodsHotListP = indexGoodsService.gainGoodsHotP();
		// 查询过期的促销商品
		List<GoodsHot> goodsHotListG = indexGoodsService.gainGoodsHotG();
		List<GoodsHot> goodsHotList1 = null;// 特卖3
		List<GoodsHot> goodsHotList2 = null;// 特卖2
		List<GoodsHot> goodsHotList3 = null;// 普通
		List<GoodsHot> goodsHotList4 = null;
		if (null != goodsHotListT && goodsHotListT.size() > 0) {
			if (goodsHotListT.size() >= 5) {
				goodsHotList1 = new ArrayList<GoodsHot>(goodsHotListT.subList(0, 3));
				goodsHotList2 = new ArrayList<GoodsHot>(goodsHotListT.subList(3, 5));
				if (null != goodsHotListP && goodsHotListP.size() > 0) {
					if (goodsHotListP.size() > 7) {
						goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(0, 8));
					} else {
						goodsHotList3 = goodsHotListP;
					}
				}
			} else if (goodsHotListT.size() == 4) {
				goodsHotList1 = new ArrayList<GoodsHot>(goodsHotListT.subList(0, 3));
				goodsHotList2 = new ArrayList<GoodsHot>(goodsHotListT.subList(3, 4));
				if (null != goodsHotListP && goodsHotListP.size() > 0) {
					goodsHotList2.add(goodsHotListP.get(0));
					if (goodsHotListP.size() > 8) {
						goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(1, 9));
					}
					if (goodsHotListP.size() > 1 && goodsHotListP.size() <= 8) {
						goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(1, goodsHotListP.size()));
					}
				}
			} else if (goodsHotListT.size() == 3) {
				goodsHotList1 = goodsHotListT.subList(0, 3);
				if (null != goodsHotListP && goodsHotListP.size() > 0) {
					if (goodsHotListP.size() < 2) {
						goodsHotList2.add(goodsHotListP.get(0));
					} else {
						goodsHotList2 = new ArrayList<GoodsHot>(goodsHotListP.subList(0, 2));
						if (goodsHotListP.size() > 9) {
							goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(2, 10));
						} else {
							goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(2, goodsHotListP.size()));
						}
					}
				}

			} else if (goodsHotListT.size() < 3) {
				int indexOne = goodsHotListT.size();
				goodsHotList1 = new ArrayList<GoodsHot>(goodsHotListT.subList(0, indexOne));
				if (null != goodsHotListP && goodsHotListP.size() > 0) {
					int indexThr = goodsHotListP.size();
					int indexTwo = 3 - indexOne;// 一行差几个
					int indextT = indexTwo + 2;
					int indextP = indextT + 8;
					List<GoodsHot> list = null;
					if (indexThr >= indexTwo) {
						list = new ArrayList<GoodsHot>(goodsHotListP.subList(0, indexTwo));
						if (indexThr - indexTwo > 0) {
							if (indexThr - indexTwo <= 2) {
								goodsHotList2 = new ArrayList<GoodsHot>(goodsHotListP.subList(indexTwo, indexThr));
							}
							if (indexThr - indexTwo > 2 && indexThr - indexTwo <= 10) {
								goodsHotList2 = new ArrayList<GoodsHot>(goodsHotListP.subList(indexTwo, indextT));
								goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(indextT, indexThr));
							}
							if (indexThr - indexTwo > 10) {
								goodsHotList2 = new ArrayList<GoodsHot>(goodsHotListP.subList(indexTwo, indextT));
								goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(indextT, indextP));
							}
						}
						/*
						 * if(indexThr == indextT){
						 * 
						 * }else if(indexThr > indextT){ goodsHotList2 =
						 * goodsHotListP.subList(indexTwo, indextT); if(indexThr
						 * >= indextP){ goodsHotList3 =
						 * goodsHotListP.subList(indextT, indextP); }else{
						 * goodsHotList3 = goodsHotListP.subList(indextT,
						 * indexThr); } }
						 */
					} else {
						list = new ArrayList<GoodsHot>(goodsHotListP.subList(0, indexThr));
					}
					for (GoodsHot t : list) {
						goodsHotList1.add(t);
					}
				}
			}
		} else {
			if (null != goodsHotListP && goodsHotListP.size() > 0) {
				if (goodsHotListP.size() >= 5) {
					goodsHotList1 = new ArrayList<GoodsHot>(goodsHotListP.subList(0, 3));
					goodsHotList2 = new ArrayList<GoodsHot>(goodsHotListP.subList(3, 5));
					if (goodsHotListP.size() >= 13) {
						goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(5, 13));
					} else if (goodsHotListP.size() >= 5 && goodsHotListP.size() < 13) {
						goodsHotList3 = new ArrayList<GoodsHot>(goodsHotListP.subList(5, goodsHotListP.size()));
					}
				} else if (goodsHotListP.size() == 4) {
					goodsHotList1 = new ArrayList<GoodsHot>(goodsHotListP.subList(0, 3));
					goodsHotList2 = new ArrayList<GoodsHot>(goodsHotListP.subList(3, 4));
				} else if (goodsHotListP.size() <= 3) {
					goodsHotList1 = goodsHotListP;
					// goodsHotList1 = new ArrayList<GoodsHot>();
					// for(GoodsHot s:goodsHotListP){
					// goodsHotList1.add(s);
					// }
				}
			}

		}
		if (null != goodsHotListG && goodsHotListG.size() > 0) {
			if (goodsHotListG.size() >= 4) {
				goodsHotList4 = new ArrayList<GoodsHot>(goodsHotListG.subList(0, 4));
			} else {
				goodsHotList4 = goodsHotListG;
			}
		}
		request.setAttribute("goodsHotList1", goodsHotList1);
		request.setAttribute("goodsHotList2", goodsHotList2);
		request.setAttribute("goodsHotList3", goodsHotList3);
		request.setAttribute("goodsHotList4", goodsHotList4);
		return "goodsHot";
	}

	/**
	 * 查询热销商品
	 * 
	 * @Title: gainHotGoods
	 * @Description: TODO(查询首页需要展示的热销商品)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainHotGoods() {
		List<Goods> list = null;
		try {
			list = indexGoodsService.gainHotGoods("热卖", type, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.writeJson(list);
	}

	public void gainNewGoods() {
		List<Goods> list = indexGoodsService.gainHotGoods("新品", type, 5);
		super.writeJson(list);

	}

	/**
	 * @Title: gainHotGoodsCat
	 * @Description: TODO(获取热销和新品显示的商品分类)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainHotGoodsCat() {
		super.writeJson(indexGoodsService.gainGoodsCat(catLang));

	}

	/**
	 * @Title: gainHotGoodsCat
	 * @Description: TODO(获取热销和新品显示的商品分类)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void updateGoods() {
		indexGoodsService.updateGoods(goods);
	}

	/**
	 * 转向首页的热销商品
	 * 
	 * @Title: toHotGoods
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 周张豹
	 */
	public String toHotGoods() {
		list = indexGoodsService.gainGoodsCat(18);
		// 获取热销商品（默认）
		hotGoods = indexGoodsService.gainGoodsByType("热卖", 5);
		// 获取新品商品（默认）
		newGoods = indexGoodsService.gainGoodsByType("新品", 5);
		return "hotGoods";
	}

	/**
	 * 获取默认的热卖商品<br>
	 * 首页的相关热卖商品<br>
	 * 是根据后台设置的热卖查询出来的
	 * 
	 * @Title: getHotGoodsDefault
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainHotGoodsDefault() {
		hotGoods = indexGoodsService.gainGoodsByType("热卖", 5);
		super.writeJson(hotGoods);
	}

	/**
	 * 根据商品的分类ID查询商城页面中左边相关热卖商品
	 * 
	 * @Title: gainHotGoodsByGoodId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainHotGoodsByGoodCatId() {
		hotGoods = indexGoodsService.gianHotGoodsByGoodCatId(goodsCatId, 12);
		super.writeJson(hotGoods);
	}

	public void gianHotGoodsByShGoodCatId() {
		hotGoods = indexGoodsService.gianHotGoodsByShGoodCatId(shCatId, 7);
		super.writeJson(hotGoods);
	}

	/***
	 * 检查注册表是否存在
	 */
	public void checkRegEditMsg() {
		String resultValue = "";
		try {
			Process process = Runtime.getRuntime().exec(PERSONAL_FOLDER_CMD);
			StreamReader streamreader = new StreamReader(process.getInputStream());

			streamreader.start();
			process.waitFor();
			streamreader.join();

			String result = streamreader.getResult();
			int p = result.indexOf(REGSTR_TOKEN);

			if (p == -1) {
				resultValue = "no";
			} else {
				resultValue = result.substring(p + REGSTR_TOKEN.length()).trim();
				String value[] = resultValue.split("%");
				resultValue = value[0];

			}
		} catch (Exception e) {
			resultValue = "104";
		}
		super.writeJson(resultValue);
	}

	class StreamReader extends Thread {
		private InputStream is;
		private StringWriter sw;

		StreamReader(InputStream is) {
			this.is = is;
			sw = new StringWriter();
		}

		@Override
		public void run() {
			try {
				/**
				 * 读取中文乱码问题
				 */
				// int c;
				// while ((c = is.read()) != -1)
				// sw.write(c);

				/**
				 * 解决中文乱码问题
				 */
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				int c = -1;
				while ((c = is.read()) != -1) {
					bos.write(c);
				}
				sw.write(bos.toString());
				// sw.write(new String(bos.toString("GBK").getBytes("UTF-8")));
			} catch (IOException e) {
				System.err.println(e);
			}
		}

		String getResult() {
			return sw.toString();
		}
	}



	/**
	 * @return the goods
	 */
	public Goods getGoods() {
		return goods;
	}

	/**
	 * 获取新品商品（默认)
	 * 
	 * @Title: getNewGoodsDefault
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @author 周张豹
	 */
	public void gainNewGoodsDefault() {
		newGoods = indexGoodsService.gainGoodsByType("新品", 5);
		super.writeJson(newGoods);
	}

	public void gainTest() {

		System.out.println("进入了" + goodsId + ">>" + type);
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the catLang
	 */
	public Integer getCatLang() {
		return catLang;
	}

	/**
	 * @param catLang
	 *            the catLang to set
	 */
	public void setCatLang(Integer catLang) {
		this.catLang = catLang;
	}

	/**
	 * @return the hotGoods
	 */
	public List<Goods> getHotGoods() {
		return hotGoods;
	}

	/**
	 * @param hotGoods
	 *            the hotGoods to set
	 */
	public void setHotGoods(List<Goods> hotGoods) {
		this.hotGoods = hotGoods;
	}

	/**
	 * @return the newGoods
	 */
	public List<Goods> getNewGoods() {
		return newGoods;
	}

	/**
	 * @param newGoods
	 *            the newGoods to set
	 */
	public void setNewGoods(List<Goods> newGoods) {
		this.newGoods = newGoods;
	}

	/**
	 * @return the goodsLang
	 */
	public Integer getGoodsLang() {
		return goodsLang;
	}

	/**
	 * @param goodsLang
	 *            the goodsLang to set
	 */
	public void setGoodsLang(Integer goodsLang) {
		this.goodsLang = goodsLang;
	}

	/**
	 * @return the goodsId
	 */
	public String getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goodsId
	 *            the goodsId to set
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * @param goods
	 *            the goods to set
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the goodsCatId
	 */
	public String getGoodsCatId() {
		return goodsCatId;
	}

	/**
	 * @param goodsCatId
	 *            the goodsCatId to set
	 */
	public void setGoodsCatId(String goodsCatId) {
		this.goodsCatId = goodsCatId;
	}

	public String getShCatId() {
		return shCatId;
	}

	public void setShCatId(String shCatId) {
		this.shCatId = shCatId;
	}

	public List<Goods> getHotGoodsList() {
		return hotGoodsList;
	}

	public void setHotGoodsList(List<Goods> hotGoodsList) {
		this.hotGoodsList = hotGoodsList;
	}

	public List<Goods> getCatGoodsList() {
		return catGoodsList;
	}

	public void setCatGoodsList(List<Goods> catGoodsList) {
		this.catGoodsList = catGoodsList;
	}

	public List<Goods> getCatGoodsList2() {
		return catGoodsList2;
	}

	public void setCatGoodsList2(List<Goods> catGoodsList2) {
		this.catGoodsList2 = catGoodsList2;
	}

	public List<Goods> getCatGoodsList3() {
		return catGoodsList3;
	}

	public void setCatGoodsList3(List<Goods> catGoodsList3) {
		this.catGoodsList3 = catGoodsList3;
	}

	public List<CompanysGoodsCat> getCompanyGoodsCatList() {
		return companyGoodsCatList;
	}

	public void setCompanyGoodsCatList(List<CompanysGoodsCat> companyGoodsCatList) {
		this.companyGoodsCatList = companyGoodsCatList;
	}

	public String getAppraiseType() {
		return appraiseType;
	}

	public void setAppraiseType(String appraiseType) {
		this.appraiseType = appraiseType;
	}

	public List<Appraise> getAppraiseList() {
		return appraiseList;
	}

	public void setAppraiseList(List<Appraise> appraiseList) {
		this.appraiseList = appraiseList;
	}
}
