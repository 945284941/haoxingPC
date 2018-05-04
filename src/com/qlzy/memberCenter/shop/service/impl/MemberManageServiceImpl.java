
package com.qlzy.memberCenter.shop.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlzy.common.tools.FtpUtil;
import com.qlzy.common.tools.ResourceUtil;
import com.qlzy.common.tools.ToolsUtil;
import com.qlzy.mainPage.company.dao.CompanyMapper;
import com.qlzy.mainPage.indexGoods.dao.GoodsMapper;
import com.qlzy.memberCenter.shop.dao.CompanySysMapper;
import com.qlzy.memberCenter.shop.dao.CompanysGoodsCatMapper;
import com.qlzy.memberCenter.shop.dao.CompanysHeadImgMapper;
import com.qlzy.memberCenter.shop.dao.CompanysInfoMapper;
import com.qlzy.memberCenter.shop.dao.CompanysMessageMapper;
import com.qlzy.memberCenter.shop.service.MemberManageService;
import com.qlzy.model.Company;
import com.qlzy.model.CompanySys;
import com.qlzy.model.CompanysGoodsCat;
import com.qlzy.model.CompanysHeadImg;
import com.qlzy.model.CompanysInfo;
import com.qlzy.model.CompanysMessage;


@Service("memberManageService")
public class MemberManageServiceImpl implements MemberManageService {
	@Autowired
	private CompanysGoodsCatMapper companysGoodsCatMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private CompanysHeadImgMapper companysHeadImgMapper;
	@Autowired
	private CompanysMessageMapper companysMessageMapper;
	@Autowired
	private CompanysInfoMapper companysInfoMapper;
	@Autowired
	private CompanySysMapper companySysMapper;
	
	
	@Override
	public List<CompanysGoodsCat> gainGoodsCatList(String memberIdString) {
		// TODO Auto-generated method stub
		return companysGoodsCatMapper.gainCompanyGoodsCatList(memberIdString);
	}
	@Override
	public Long dropById(Map<String, Object> map ) {
		Long numGoods=goodsMapper.gainComGoodsListByMemberCatCount(map);
		if(numGoods==0){
			companysGoodsCatMapper.deleteById((String) map.get("id"));
		}
		return numGoods;
	}
	
	@Override
	public void updateGoodsCat(Map<String, Object> map) {
		// TODO Auto-generated method stub
		companysGoodsCatMapper.updateById(map);
		
	}
	@Override
	public List<CompanysGoodsCat> gainGoodsCatListShop(String memberIdString) {
		// TODO Auto-generated method stub
		return companysGoodsCatMapper.gainGoodsCatListShop(memberIdString);
	}
	@Override
	public void addCompanyCat(String goodsCatId,String memberIdString) {
		// TODO Auto-generated method stub
				String[] goodsCats=goodsCatId.split(",");
				for (int i = 0; i < goodsCats.length; i++) {
					CompanysGoodsCat cat=new CompanysGoodsCat();
					cat.setCompanyId(memberIdString);
//					cat.setCreateTime(new Date());
//					cat.setGoodsCatId(goodsCats[i]);
					cat.setId(ToolsUtil.getUUID());
//					cat.setPorder(10);
					companysGoodsCatMapper.addCompanyGoods(cat);
				}
				
	}
	@Override
	public Company gainCompanyById(String string) {
		// TODO Auto-generated method stub
		return companyMapper.selectByPrimaryKey(string);
	}
	@Override
	public void updateMemberInoformation(Company company) {
		// TODO Auto-generated method stub
		companyMapper.updateByPrimaryKeySelective(company);
	}
	@Override
	public List<CompanysHeadImg> gainCompanysHeadImg(String string) {
		// TODO Auto-generated method stub
		List<CompanysHeadImg> list=companysHeadImgMapper.gainCompanysHeadImgsByMember(string);
		if(list.size()==0){
			for (int i = 1; i < 6; i++) {
				CompanysHeadImg companysHeadImg=new CompanysHeadImg();
				companysHeadImg.setCompanyId(string);
				companysHeadImg.setId(ToolsUtil.getUUID());
				companysHeadImg.setPorder(i);
				companysHeadImgMapper.addCompanysHeadImg(companysHeadImg);
			}	
			list=companysHeadImgMapper.gainCompanysHeadImgsByMember(string);
		}
		return list;
	}
	@Override
	public void updateHeadImg(CompanysHeadImg companysHeadImg) {
		// TODO Auto-generated method stub
		companysHeadImgMapper.updateHeadImg(companysHeadImg);
	}
	@Override
	public void deleteHeadImg(CompanysHeadImg companysHeadImg) {
		// TODO Auto-generated method stub
		String temp=companysHeadImg.getImgSrc();
		String src = ResourceUtil.getCompany_Head_Img_Directory().replaceAll("/", "\\\\") +   temp.substring(temp.lastIndexOf("/") + 1).toLowerCase();
		FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
		ftp.connectServer();
//			ftp.sendServer(src);
		ftp.closeServer();
		
		
		
//		FileUtil.delete(src);
		companysHeadImgMapper.deleteHeadImg(companysHeadImg);
	}
	@Override
	public List<CompanysMessage> gainCompanyMessageListById(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return companysMessageMapper.gainCompanyMessageListById(map);
	}
	@Override
	public Long gainCompanyMessageListByIdCount(Map<String, Object> map) {
		return companysMessageMapper.gainCompanyMessageListByIdCount(map);
	}
	@Override
	public CompanysMessage gainCustomerMessageById(String id) {
		// TODO Auto-generated method stub
		return companysMessageMapper.gainCustomerMessageById(id);
	}
	@Override
	public Long gainCompanyInfoListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return companysInfoMapper.gainCompanysInfoListCount(map);
	}
	@Override
	public List<CompanysInfo> gainCompanyInfoList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return companysInfoMapper.gainCompanysInfoListForPage(map);
	}
	@Override
	public void addCompanyInfo(CompanysInfo companysInfo) {
		companysInfo.setId(ToolsUtil.getUUID());
		companysInfo.setCreateTime(new Date());
		companysInfoMapper.addCompanyInfo(companysInfo);		
	}
	@Override
	public void updateCompanyInfo(CompanysInfo companysInfo) {
		companysInfo.setModifytime(new Date());
		companysInfoMapper.updateCompanyInfo(companysInfo);
	}
	@Override
	public CompanysInfo gainCompanyInfoById(String id) {
		
		return companysInfoMapper.gainById(id);
	}
	@Override
	public void deleteCompanyInfoList(String companyInfoIds) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		String[] ids=companyInfoIds.split(",");
		for (int i = 0; i < ids.length; i++) {
			list.add(ids[i]);
		}
		 companysInfoMapper.deleteCompanyInfoList(list);
	}
	@Override
	public List<CompanySys> gainCompanySys(String userId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<CompanySys> list=companySysMapper.gainCompanySysByMember(userId);
		if(list.size()==0){
			for (int i = 1; i < 26; i++) {
				CompanySys companySys=new CompanySys();
				companySys.setCompanyId(userId);
				companySys.setId(ToolsUtil.getUUID());
				companySys.setPosition(i);
				companySysMapper.insertSelective(companySys);
			}	
			list=companySysMapper.gainCompanySysByMember(userId);
		}
		return list;
	}
	@Override
	public void updateCompanySy(CompanySys companySy) {
		// TODO Auto-generated method stub
		companySysMapper.updateByPrimaryKeySelective(companySy);
	}
	@Override
	public void deleteCompanySys(CompanySys companySy) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String temp=companySy.getImageUrl();
		String src = ResourceUtil.getCompany_Head_Img_Directory().replaceAll("/", "\\\\") +   temp.substring(temp.lastIndexOf("/") + 1).toLowerCase();
		FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
		ftp.connectServer();
//			ftp.sendServer(src);
		ftp.closeServer();
//		FileUtil.delete(src);
		companySysMapper.deleteCompanySys(companySy);
	}
}
