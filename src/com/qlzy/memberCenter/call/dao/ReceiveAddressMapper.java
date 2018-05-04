package com.qlzy.memberCenter.call.dao;

import java.util.List;

import com.qlzy.model.ReceiveAddress;


public interface ReceiveAddressMapper {
    
	/**
	 * 根据ID查询数据<br>物理删除，不可恢复
	* @Title: deleteByPrimaryKey
	* @Description: TODO(根据ID查询数据，物理删除，不可恢复)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author 周张豹
	 */
	public int deleteByPrimaryKey(String id);
    /**
     * 选择行插入数据<br>将有值的数据插入，没有值的不操作，将是数据库吗，默认的值
    * @Title: insertSelective
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    * @author 周张豹
     */
    public int insertSelective(ReceiveAddress record);

	public int insertSelectiveNNN(ReceiveAddress record);


    
    /**
     * 根据ID查询
    * @Title: selectByPrimaryKey
    * @Description: TODO(根据ID查询)
    * @param @param id
    * @param @return    设定文件
    * @return ReceiveAddress    返回类型
    * @author 周张豹
     */
    public ReceiveAddress selectByPrimaryKey(String id);

    /**
     * 更新数据库<br>选择行更新，只更新实体存在的值，实体没有的值将保值数据库中原有的值
    * @Title: updateByPrimaryKeySelective
    * @Description: TODO(选择行更新)
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    * @author 周张豹
     */
    public int updateByPrimaryKeySelective(ReceiveAddress record);


	/**
	 * 根据用户的ID查询默认收货地址
	* @Title: selectReceiveAddressDefault
	* @Description: TODO(根据用户的ID查询默认收货地址)
	* @param @param userId
	* @param @return    设定文件
	* @return ReceiveAddress    返回类型
	* @author 周张豹
	*/
	public ReceiveAddress selectReceiveAddressDefault(String userId);
	
	/**
	 * 根据用户的ID查询该用户的所有收货地址
	* @Title: selectReceiveAddressAll
	* @Description: TODO(根据用户的ID查询该用户的所有收货地址)
	* @param @param userId
	* @param @return    设定文件
	* @return List<ReceiveAddress>    返回类型
	* @author 周张豹
	 */
	public List<ReceiveAddress> selectReceiveAddressAll(String userId);
	/**
	 * 查询用户的收货地址
	* @Title: gainReceiveAddresses
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param userId
	* @param @return    设定文件
	* @return List<ReceiveAddress>    返回类型
	* @author 周张豹
	*/
	public List<ReceiveAddress> gainReceiveAddresses(String userId);
	
	/**
	 * 根据用户的ID取消用户的默认收货地址
	* @Title: cancelDefaultAddrkByUserId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param receiveAddress    设定文件
	* @return void    返回类型
	* @author 周张豹
	 */
	public void cancelDefaultAddrkByUserId(ReceiveAddress receiveAddress);
}