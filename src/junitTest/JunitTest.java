package junitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.qlzy.active.service.CollectService;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.memberCenter.goods.dao.GoodsPicMapper;


@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class JunitTest {
	@Autowired
	private CollectService collectService;
	@Autowired
	private GoodsPicMapper goodsPicMapper;
	@Autowired
	private GoodsMapper goodsMapper;
//	@Test
//	public void testQZHQ(){
//		List<Goods> temp =new ArrayList<Goods>();
//		List<GoodsPic> temp2 =new ArrayList<GoodsPic>();
//		List<ActiveCollectGoods> list= collectService.gainActiveCollectGoodsByCompanyId("ceefa483bd234dc693ef479d7af3e922");
//		for (ActiveCollectGoods e : list) {
//			Goods g=new Goods();
//			g.setId(ToolsUtil.getUUID());
//			if(e.getBn()==null){
//				e.setBn("");
//			}
//			if(e.getName()==null){
//				e.setName("");
//			}
//			g.setBn(e.getBn().equals("")?"":e.getBn());
//			g.setName(e.getName().equals("")?"":e.getName());
//			g.setIsStander("1");
//			g.setCompanyId("ceefa483bd234dc693ef479d7af3e922");
//			g.setCreatetime(new Date());
//			g.setModifytime(new Date());
//			g.setMarketable("false");
//			g.setDisabled("false");
//			g.setStore(1000L);
//			g.setPrice(0D);
//			List<String> acp=collectService.gainActiveCollectGoodsPicByGoodsId(e.getId());
//			for (String f : acp) {
//				GoodsPic gp=new GoodsPic();
//				gp.setId(ToolsUtil.getUUID());
//				gp.setGoodsId(g.getId());
//				gp.setCompanyId("ceefa483bd234dc693ef479d7af3e922");
//				gp.setPicSrc(f);
//				gp.setPicSize(0D);
//				temp2.add(gp);
//			}
//			temp.add(g);
//			System.out.println(44444);
//		}
//		System.out.println("333333333333333333333333333");
//		goodsMapper.insertBatch(temp);
//		goodsPicMapper.insertByList(temp2);
//		System.out.println(temp2.size());
//		System.out.println(1111111);
//		System.out.println(1111111);
//		System.out.println(1111111);
//		System.out.println(1111111);
//		System.out.println(1111111);
//	}
	@Test
	public void test(){
	}
}
