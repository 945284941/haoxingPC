package com.qlzy.active.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlzy.active.dao.ActiveCollectGoodsCheckMapper;
import com.qlzy.active.dao.ActiveCollectGoodsMapper;
import com.qlzy.active.dao.ActiveCollectGoodsPicMapper;
import com.qlzy.active.dao.ActiveCollectGoodsQBMapper;
import com.qlzy.active.service.CollectService;
import com.qlzy.common.tools.FtpUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.head.dao.CarBrandMapper;
import com.qlzy.mainPage.head.dao.GoodsCatMapper;
import com.qlzy.model.ActiveCollectGoods;
import com.qlzy.model.ActiveCollectGoodsCheck;
import com.qlzy.model.ActiveCollectGoodsPic;
import com.qlzy.model.ActiveCollectGoodsQB;
import com.qlzy.model.CarBrand;
import com.qlzy.model.GoodsCat;

/**
 * @ClassName: CheckServiceImpl
 * @Description: 
 * @author Huifeng Wang
 * @date 2013-6-21 上午10:42:20
 */
@Transactional(rollbackFor=Exception.class)
@Service("collectService")
public class CollectServiceImpl implements CollectService{
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ActiveCollectGoodsMapper activeCollectGoodsMapper;
	@Autowired
	private ActiveCollectGoodsQBMapper activeCollectGoodsQBMapper;
	@Autowired
	private ActiveCollectGoodsPicMapper activeCollectGoodsPicMapper;
	@Autowired
	private ActiveCollectGoodsCheckMapper activeCollectGoodsCheckMapper;
	@Autowired
	private ActiveCollectGoodsPicMapper acticeActiveCollectGoodsPicMapper;
	@Autowired
	private GoodsCatMapper goodsCatMapper;
	@Autowired
	private CarBrandMapper carBrandMapper;
	
	
	/**
	* @Title: saveActiveCollectGoods
	* @Description: 保存上传配件
	* @param @param acg    设定文件
	* @return void    返回类型
	*/
	public void saveActiveCollectGoods(Map<String,Object> map){
		activeCollectGoodsMapper.insertSelective((ActiveCollectGoods)map.get("acg"));
		List<ActiveCollectGoodsPic> acgpList=(List<ActiveCollectGoodsPic>) map.get("acgpList");
		if(!(acgpList.size()<=0)){
			activeCollectGoodsPicMapper.insertSelectiveBeach((List<ActiveCollectGoodsPic>) map.get("acgpList"));
		}
	}
	
	public void saveCheck(ActiveCollectGoodsCheck acgc){
		activeCollectGoodsCheckMapper.insertSelective(acgc);
	}

	@Override
	public List<ActiveCollectGoods> gainHasCheckedActiveCollectGoods(
			Map<String, Object> map) {
		List<ActiveCollectGoods> list = activeCollectGoodsMapper.gainHasCheckedActiveCollectGoods(map);
		for(ActiveCollectGoods g : list){
			List<String> pics = activeCollectGoodsPicMapper.gainActiveCollectGoodsPicByGoodsId(g.getId());
			if(pics != null && pics.size() > 0){
				g.setDefaultPic(pics.get(0));
			}
		}
		return list;
	}

	@Override
	public Long gainHasCheckedActiveCollectGoodsCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return activeCollectGoodsMapper.gainHasCheckedActiveCollectGoodsCount(map);
	}

	@Override
	public List<CarBrand> gainBrandList(Integer i) {
		// TODO Auto-generated method stub
		return carBrandMapper.gainCarBrandList(1);
	}

	@Override
	public List<GoodsCat> gainCatList(Integer i) {
		return goodsCatMapper.gainCatalogueByGrade(1);
	}

	/* (非 Javadoc)
	* <p>Title: gainSeriesList</p>
	* <p>Description: </p>
	* @param pid
	* @return
	* @see com.qlzy.active.service.CollectService#gainSeriesList(java.lang.String)
	*/
	@Override
	public List<CarBrand> gainNextCarBrandListByPid(String pid) {
		
		return carBrandMapper.gainCarBrandListByPidBeach(ToolsUtil.StringConvertList(pid));
	}

	/* (非 Javadoc)
	* <p>Title: gainNextGoodsListByPid</p>
	* <p>Description: </p>
	* @param pid
	* @return
	* @see com.qlzy.active.service.CollectService#gainNextGoodsListByPid(java.lang.String)
	*/
	@Override
	public List<GoodsCat> gainNextGoodsCatListByPid(String pid) {
		// TODO Auto-generated method stub
		return goodsCatMapper.gainCatalogueByPidBeach(ToolsUtil.StringConvertList(pid));
	}

	/* (非 Javadoc)
	* <p>Title: gainCarBrandNameById</p>
	* <p>Description: </p>
	* @param pid
	* @return
	* @see com.qlzy.active.service.CollectService#gainCarBrandNameById(java.lang.String)
	*/
	@Override
	public List<String> gainCarBrandNameById(String id) {
		return carBrandMapper.gainCarBrandNameById(ToolsUtil.StringConvertList(id));
	}

	/* (非 Javadoc)
	* <p>Title: gainActiveCollectGoodsById</p>
	* <p>Description: </p>
	* @param parameter
	* @return
	* @see com.qlzy.active.service.CollectService#gainActiveCollectGoodsById(java.lang.String)
	*/
	@Override
	public ActiveCollectGoods gainActiveCollectGoodsById(String parameter) {
		return activeCollectGoodsMapper.selectByPrimaryKey(parameter);
	}

	/* (非 Javadoc)
	* <p>Title: gainBrandListByBrandName</p>
	* <p>Description: </p>
	* @param brand
	* @return
	* @see com.qlzy.active.service.CollectService#gainBrandListByBrandName(java.lang.String)
	*/
	@Override
	public List<CarBrand> gainBrandListByBrandName(String brand) {
		List<String> list=ToolsUtil.StringConvertList(brand);
		return carBrandMapper.gainBrandListByBrandName(list);
	}

	/* (非 Javadoc)
	* <p>Title: gainActiveCollectGoodsPicByGoodsId</p>
	* <p>Description: </p>
	* @param parameter
	* @return
	* @see com.qlzy.active.service.CollectService#gainActiveCollectGoodsPicByGoodsId(java.lang.String)
	*/
	@Override
	public List<String> gainActiveCollectGoodsPicByGoodsId(String parameter) {
		// TODO Auto-generated method stub
		return acticeActiveCollectGoodsPicMapper.gainActiveCollectGoodsPicByGoodsId(parameter);
	}

	/* (非 Javadoc)
	* <p>Title: gainNextCarBrandListByPName</p>
	* <p>Description: </p>
	* @param parameter
	* @return
	* @see com.qlzy.active.service.CollectService#gainNextCarBrandListByPName(java.lang.String)
	*/
	@Override
	public List<CarBrand> gainNextCarBrandListByPName(String parameter) {
		// TODO Auto-generated method stub
		return carBrandMapper.gainNextCarBrandListByPName(ToolsUtil.StringConvertList(parameter));
	}

	/* (非 Javadoc)
	* <p>Title: gainNextGoodsCatListByPName</p>
	* <p>Description: </p>
	* @param cat
	* @return
	* @see com.qlzy.active.service.CollectService#gainNextGoodsCatListByPName(java.lang.String)
	*/
	@Override
	public List<GoodsCat> gainNextGoodsCatListByPName(String cat) {
		// TODO Auto-generated method stub
		return goodsCatMapper.gainNextGoodsCatListByPName(ToolsUtil.StringConvertList(cat));
	}

	/* (非 Javadoc)
	* <p>Title: gainCheckCountByParam</p>
	* <p>Description: </p>
	* @param acgc
	* @return
	* @see com.qlzy.active.service.CollectService#gainCheckCountByParam(com.qlzy.model.ActiveCollectGoodsCheck)
	*/
	@Override
	public Long gainCheckCountByParam(ActiveCollectGoodsCheck acgc) {
		// TODO Auto-generated method stub
		return activeCollectGoodsCheckMapper.gainCheckCountByParam(acgc);
	}

	/* (非 Javadoc)
	* <p>Title: gainActiveCollectGoodsQBById</p>
	* <p>Description: </p>
	* @param parameter
	* @return
	* @see com.qlzy.active.service.CollectService#gainActiveCollectGoodsQBById(java.lang.String)
	*/
	@Override
	public ActiveCollectGoodsQB gainActiveCollectGoodsQBById(String parameter) {
		// TODO Auto-generated method stub
		return activeCollectGoodsQBMapper.selectByPrimaryKey(parameter);
	}

	/* (非 Javadoc)
	* <p>Title: test</p>
	* <p>Description: </p>
	* @see com.qlzy.active.service.CollectService#test()
	*/
	@Override
	public void test() {
		FtpUtil ftp = new FtpUtil("120.192.31.153", "admin", "123456");
		ftp.connectServer();
		boolean result = ftp.upload("C:/a", "wocao.txt");
		System.out.println(result ? "上传成功！" : "上传失败！");
//		List list = ftp.getFileList("test");
//		for (int i = 0; i < list.size(); i++) {
//			String name = list.get(i).toString();
//			System.out.println(name);
//		}
		ftp.closeServer();
	}

	@Override
	public List<ActiveCollectGoods> gainActiveCollectGoodsByCompanyId(
			String string) {
		// TODO Auto-generated method stub
		return activeCollectGoodsMapper.gainActiveCollectGoodsByCompanyId(string);
	}
}
