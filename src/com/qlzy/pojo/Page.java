package com.qlzy.pojo;

import java.util.List;

/**
 * @ClassName: Page
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-22 上午10:42:13
 *
 */

public class Page<E>{
	private Long pageNum=1L; //当前页
	private Long rows=1L;//每页显示多少条
	private Long totalPage;//总页数
	private Long totalCount;//总条数
	private String sort;// 排序字段名
	private String order;//排列顺序,desc,asc
	private List<?> list;
	/**
	 * @return the pageNum
	 */
	public Long getPageNum() {
		return pageNum;
	}
	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}
	/**
	 * @return the rows
	 */
	public Long getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(Long rows) {
		this.rows = rows;
	}
	/**
	 * @return the totalPage
	 */
	public Long getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}
	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}
	
}
