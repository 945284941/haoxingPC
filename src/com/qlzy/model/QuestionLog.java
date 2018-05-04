/**??
* @Title: questionLog.java
* @Package com.qlzy.model
* @Description: TODO(用一句话描述该文件做什么)
* @author zhao yang bin
* @date 2013-11-7 上午9:39:06
* @version V1.0??
*/
package com.qlzy.model;

import java.io.Serializable;
import java.util.Date;

import com.qlzy.pojo.Base;

public class QuestionLog extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private Date createTime;
	
	private String titleNews;
	
	private String catNews;
	
	private String questionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitleNews() {
		return titleNews;
	}

	public void setTitleNews(String titleNews) {
		this.titleNews = titleNews;
	}

	public String getCatNews() {
		return catNews;
	}

	public void setCatNews(String catNews) {
		this.catNews = catNews;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

}
