package com.qlzy.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PaginationTag extends TagSupport {

	private String formName;// form表单名称
	private String name;// 跳转
	private String page;// 页号
	private String path;// 跳转路径
	private String parameter;
	private static final long serialVersionUID = 0x17397014eaa56d45L;

	public PaginationTag() {
		path = null;
		name = null;
		page = null;
		formName = null;
		parameter = null;
	}

	/**
	 * 给标签创建一个JS
	 */
	private final void createJS(JspWriter out, String contextPath, Long totalPage, Long nextPage) throws Exception {
		out.println("<script language=\"javascript\">");
		out.println("function paginationSubmit(pageNum_) { ");
		out.println("  document.getElementById('" + formName + "').action='" + contextPath + "' + pageNum_ + '';");
		out.println("  document.getElementById('" + formName + "').submit();");
		out.println("}");
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String contPath = request.getContextPath() + "/" + path;
		out.println("function paginationGoto() { ");
		out.println("    pageNum_ = document.getElementById('" + page + "').value    ");
		out.println("    var i,j,strTemp;                               	");
		out.println("    strTemp = \"0123456789\";                      	");
		out.println("    if (pageNum_.length == 0){                    	    ");
		out.println("        return false;                     		");
		out.println("    }else{                                         	");
		out.println("   	 for (i = 0; i < pageNum_.length; i++) {  	    ");
		out.println("        	j = strTemp.indexOf(pageNum_.charAt(i));    ");
		out.println("        	if (j == -1) {                              ");
		out.println("	            document.getElementById('" + page + "').value=\"\";	    ");
		out.println("               return false;                     		");
		out.println("        	}                                    		");
		out.println("   	 }                                        		");
		out.println("    }                                        			");
		out.println("  if(pageNum_ > 0 && pageNum_ <= " + totalPage + ") {");
		out.println("    document." + formName + ".action='" + contPath + "?" + page + "=' + pageNum_ + '';");
		out.println("    document." + formName + ".submit();");
		out.println("  }else if(pageNum_<=0){                 				");
		out.println("     document." + formName + ".action='" + contPath + "?" + page + "=' + 1 + '';");
		out.println("     document." + formName + ".submit();");
		out.println("  }else if(pageNum_>" + totalPage + "){                   	");
		out.println("     document." + formName + ".action='" + contPath + "?" + page + "=" + totalPage + "';");
		out.println("     document." + formName + ".submit();");
		out.println("  }                                       				");
		out.println("}                                       				");
		out.println("</script>");
		out.println();
	}

	/**
	 * 给标签创建一个NoFormJS
	 */
	private final void createNoFormJS(JspWriter out, String href, Long totalPage, Long nextPage) throws Exception {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String contPath = request.getContextPath() + "/" + href;
		out.println("<script language=\"javascript\">");
		out.println("function paginationGoto() { ");
		out.println("    pageNum_ = document.getElementById('" + page + "').value    ");
		out.println("    var i,j,strTemp;                               	");
		out.println("    strTemp = \"0123456789\";                      	");
		out.println("    if (pageNum_.length == 0){                    	    ");
		out.println("        return false;                     		");
		out.println("    }else{                                         	");
		out.println("   	 for (i = 0; i < pageNum_.length; i++) {  	    ");
		out.println("        	j = strTemp.indexOf(pageNum_.charAt(i));    ");
		out.println("        	if (j == -1) {                              ");
		out.println("	            document.getElementById('" + page + "').value=\"\";	    ");
		out.println("               return false;                     		");
		out.println("        	}                                    		");
		out.println("   	 }                                        		");
		out.println("    }                                        			");
		out.println("  if(pageNum_ > 0 && pageNum_ <= " + totalPage + ") {  ");
		out.println("     document.location.href='" + contPath + "?" + page + "=' + pageNum_ + '';");
		out.println("  }else if(pageNum_<=0){                 				");
		out.println("     document.location.href='" + contPath + "?" + page + "=' + 1 + '';");
		out.println("  }else if(pageNum_>" + totalPage + "){                   	");
		out.println("     document.location.href='" + contPath + "?" + page + "=" + totalPage + "';");
		out.println("  }                                       				");
		out.println("}                                       				");
		out.println("</script>");
		out.println();
	}

	public int doEndTag() throws JspException {
		return 6;
	}

	/**
	 * 页面标签显示内容
	 */
	public int doStartTag() throws JspException {
		try {
			Pagination pagination;
			pagination = null;
			if (path == null)
				throw new NullPointerException("path is null");
			if (name == null)
				name = "pagination";
			if (page == null)
				page = "page";
			pagination = (Pagination) pageContext.getRequest().getAttribute(name);
			if (pagination == null)
				throw new NullPointerException(name + "is null in request");
			JspWriter out = pageContext.getOut();
			String contextPath = encodeURL(path, page);
			if (formName != null && formName.length() > 0) {
				if (pagination.isHasPreviousPage()) {
					out.println("<p id=\"wzpage\">");
					out.println(
							"<a  href=\"javascript: paginationSubmit('1');\" title=\"首页\"><span class=\"n2nn\">首页</span></a>");
					out.println("<a  href=\"javascript: paginationSubmit('" + pagination.getPreviousPage()
							+ "');\" title=\"上一页\" ><span class=\"nnn\">上一页</span></a>");
					if (pagination.getCurrPage() == pagination.getTotalPage()) {
						for (int i = 5; i >= 1; i--) {
							if ((pagination.getCurrPage() - i) >= 1) {
								out.println("<a href=\"javascript: paginationSubmit('"
										+ String.valueOf(pagination.getCurrPage() - i) + "');\" ><span class=\"pc\">"
										+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
							}
						}
					} else {
						if (pagination.getCurrPage() > 3) {
							if (pagination.getCurrPage() + 3 > pagination.getTotalPage()) {
								if (pagination.getCurrPage() == (pagination.getTotalPage() - 1)) {
									for (int i = 4; i >= 1; i--) {
										if ((pagination.getCurrPage() - i) >= 1) {
											out.println("<a href=\"javascript: paginationSubmit('"
													+ String.valueOf(pagination.getCurrPage() - i)
													+ "');\" ><span class=\"pc\">"
													+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
										}
									}
								} else {
									for (int i = 3; i >= 1; i--) {
										if ((pagination.getCurrPage() - i) >= 1) {
											out.println("<a href=\"javascript: paginationSubmit('"
													+ String.valueOf(pagination.getCurrPage() - i)
													+ "');\" ><span class=\"pc\">"
													+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
										}
									}
								}
							} else {
								for (int i = 2; i >= 1; i--) {
									if ((pagination.getCurrPage() - i) >= 1) {
										out.println("<a href=\"javascript: paginationSubmit('"
												+ String.valueOf(pagination.getCurrPage() - i)
												+ "');\" ><span class=\"pc\">"
												+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
									}
								}
							}
						} else {
							for (int i = 5; i >= 1; i--) {
								if ((pagination.getCurrPage() - i) >= 1) {
									out.println("<a href=\"javascript: paginationSubmit('"
											+ String.valueOf(pagination.getCurrPage() - i)
											+ "');\" ><span class=\"pc\">"
											+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
								}
							}
						}
					}
					out.println("<a class=\"on\">");
					out.println(pagination.getCurrPage());
					out.println("</a>");
					if (pagination.getCurrPage() < 3) {
						for (int i = 1; i <= 4; i++) {
							if ((pagination.getCurrPage() + i) <= pagination.getTotalPage()) {
								out.println("<a href=\"javascript: paginationSubmit('"
										+ String.valueOf(pagination.getCurrPage() + i) + "');\" ><span class=\"pc\">"
										+ String.valueOf(pagination.getCurrPage() + i) + "</span></a>");
							}
						}
					} else {
						if (pagination.getCurrPage() == pagination.getTotalPage()) {
							for (int i = 1; i <= 5; i++) {
								if ((pagination.getCurrPage() + i) <= pagination.getTotalPage()) {
									out.println("<a href=\"javascript: paginationSubmit('"
											+ String.valueOf(pagination.getCurrPage() + i)
											+ "');\" ><span class=\"pc\">"
											+ String.valueOf(pagination.getCurrPage() + i) + "</span></a>");
								}
							}
						} else {
							for (int i = 1; i <= 3; i++) {
								if ((pagination.getCurrPage() + i) <= pagination.getTotalPage()) {
									out.println("<a href=\"javascript: paginationSubmit('"
											+ String.valueOf(pagination.getCurrPage() + i)
											+ "');\" ><span class=\"pc\">"
											+ String.valueOf(pagination.getCurrPage() + i) + "</span></a>");
								}
							}
						}
					}
				} else {
					out.println("<p id=\"wzpage\">");
					out.println("<a title=\"首页\" class=\"n2nn\">首页</a>");
					out.println("<a title=\"上一页\" class=\"nnn\">上一页</a>");
					out.println("<a class=\"on\">");
					out.println(pagination.getCurrPage());
					out.println("</a>");
					for (int i = 1; i <= 5; i++) {
						if ((pagination.getCurrPage() + i) <= pagination.getTotalPage()) {
							out.println("<a href=\"javascript: paginationSubmit('"
									+ String.valueOf(pagination.getCurrPage() + i) + "');\" ><span class=\"pc\">"
									+ String.valueOf(pagination.getCurrPage() + i) + "</span></a>");
						}
					}
				}
				if (pagination.isHasNextPage()) {
					out.println("<a  href=\"javascript: paginationSubmit('" + pagination.getNextPage()
							+ "');\"  title=\"下一页\" ><span class=\"nnn\">下一页</span></a>");
					out.println("<a  href=\"javascript: paginationSubmit('" + pagination.getTotalPage()
							+ "');\" title=\"尾页\" ><span class=\"n2nn\">尾页</span></a>");
				} else {
					out.println("<a title=\"下一页\" class=\"nnn\">下一页</a>");
					out.println("<a title=\"尾页\" class=\"n2nn\">尾页</a>");
				}
			} else {
				if (pagination.isHasPreviousPage()) {
					out.println("<p id=\"wzpage\">");
					out.println("<a  href=\"" + contextPath + "1\" title=\"首页\" ><span class=\"n2nn\">首页</span></a>");
					out.println("<a  href=\"" + contextPath + pagination.getPreviousPage()
							+ "\" title=\"上一页\" ><span class=\"nnn\">上一页</span></a>");
					if (pagination.getCurrPage() == pagination.getTotalPage()) {
						for (int i = 5; i >= 1; i--) {
							if ((pagination.getCurrPage() - i) >= 1) {
								out.println("<a  href=\"" + contextPath + String.valueOf(pagination.getCurrPage() - i)
										+ "\" ><span class=\"pc\">" + String.valueOf(pagination.getCurrPage() - i)
										+ "</span></a>");
							}
						}
					} else {
						if (pagination.getCurrPage() > 3) {
							if (pagination.getCurrPage() + 3 > pagination.getTotalPage()) {
								if (pagination.getCurrPage() == (pagination.getTotalPage() - 1)) {
									for (int i = 4; i >= 1; i--) {
										if ((pagination.getCurrPage() - i) >= 1) {
											out.println("<a  href=\"" + contextPath
													+ String.valueOf(pagination.getCurrPage() - i)
													+ "\" ><span class=\"pc\">"
													+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
										}
									}
								} else {
									for (int i = 3; i >= 1; i--) {
										if ((pagination.getCurrPage() - i) >= 1) {
											out.println("<a  href=\"" + contextPath
													+ String.valueOf(pagination.getCurrPage() - i)
													+ "\" ><span class=\"pc\">"
													+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
										}
									}
								}
							} else {
								for (int i = 2; i >= 1; i--) {
									if ((pagination.getCurrPage() - i) >= 1) {
										out.println("<a  href=\"" + contextPath
												+ String.valueOf(pagination.getCurrPage() - i)
												+ "\" ><span class=\"pc\">"
												+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
									}
								}
							}
						} else {
							for (int i = 5; i >= 1; i--) {
								if ((pagination.getCurrPage() - i) >= 1) {
									out.println("<a  href=\"" + contextPath
											+ String.valueOf(pagination.getCurrPage() - i) + "\" ><span class=\"pc\">"
											+ String.valueOf(pagination.getCurrPage() - i) + "</span></a>");
								}
							}
						}
					}
					out.println("<a class=\"on\">");
					out.println(pagination.getCurrPage());
					out.println("</a>");
					if (pagination.getCurrPage() < 3) {
						for (int i = 1; i <= 4; i++) {
							if ((pagination.getCurrPage() + i) <= pagination.getTotalPage()) {
								out.println("<a  href=\"" + contextPath + String.valueOf(pagination.getCurrPage() + i)
										+ "\" ><span class=\"pc\">" + String.valueOf(pagination.getCurrPage() + i)
										+ "</span></a>");
							}
						}
					} else {
						if (pagination.getCurrPage() == pagination.getTotalPage()) {
							for (int i = 1; i <= 5; i++) {
								if ((pagination.getCurrPage() + i) <= pagination.getTotalPage()) {
									out.println("<a  href=\"" + contextPath
											+ String.valueOf(pagination.getCurrPage() + i) + "\" ><span class=\"pc\">"
											+ String.valueOf(pagination.getCurrPage() + i) + "</span></a>");
								}
							}
						} else {
							for (int i = 1; i <= 3; i++) {
								if ((pagination.getCurrPage() + i) <= pagination.getTotalPage()) {
									out.println("<a  href=\"" + contextPath
											+ String.valueOf(pagination.getCurrPage() + i) + "\" ><span class=\"pc\">"
											+ String.valueOf(pagination.getCurrPage() + i) + "</span></a>");
								}
							}
						}
					}
				} else {
					out.println("<p id=\"wzpage\">");
					out.println("<a title=\"首页\" class=\"nnn\">首页</a>");
					out.println("<a title=\"上一页\" class=\"nnn\">上一页</a>");
					out.println("<a class=\"on\">");
					out.println(pagination.getCurrPage());
					out.println("</a>");
					for (int i = 1; i <= 5; i++) {
						if ((pagination.getCurrPage() + i) <= pagination.getTotalPage()) {
							out.println("<a  href=\"" + contextPath + String.valueOf(pagination.getCurrPage() + i)
									+ "\" ><span class=\"pc\">" + String.valueOf(pagination.getCurrPage() + i)
									+ "</span></a>");
						}
					}
				}
				if (pagination.isHasNextPage()) {
					out.println("<a  href=\"" + contextPath + pagination.getNextPage()
							+ "\" title=\"下一页\" ><span class=\"nnn\">下一页</span></a>");
					out.println("<a  href=\"" + contextPath + pagination.getTotalPage()
							+ "\" title=\"尾页\" ><span class=\"n2\">尾页</span></a>");
				} else {
					out.println("<a title=\"下一页\" class=\"nnn\">下一页</a>");
					out.println("<a title=\"尾页\" class=\"n2nn\">尾页</a>");
				}
			}
			out.println("<a><span class=\"page-skip\"><em>");
			out.println("&nbsp;&nbsp;&nbsp;");
			out.println("第" + pagination.getCurrPage() + "页");
			out.print("&nbsp;");
			out.println("共" + pagination.getTotalPage() + "页");
			out.print("&nbsp;&nbsp;");
			out.println("共 " + pagination.getTotalCount() + "条");
			out.print("&nbsp;&nbsp;&nbsp;");

           /* out.print("到第</em>");
			if (pagination.isHasPreviousPage() && pagination.isHasNextPage()) {
				out.println("<input type=\"text\" id=\"" + page + "\" value=\"" + (pagination.getCurrPage() + 1)
						+ "\" class=\"jumpto\" onkeydown=\"if(event.keyCode==13) return paginationGoto()\">");
			} else {
				if (pagination.isHasPreviousPage()) {
					out.println("<input type=\"text\" id=\"" + page + "\" value=\"" + (pagination.getCurrPage())
							+ "\" class=\"jumpto\" onkeydown=\"if(event.keyCode==13) return paginationGoto()\">");
				} else if (pagination.isHasNextPage()) {
					out.println("<input type=\"text\" id=\"" + page + "\" value=\"" + pagination.getNextPage()
							+ "\" class=\"jumpto\" onkeydown=\"if(event.keyCode==13) return paginationGoto()\">");
				} else {
					out.println("<input type=\"text\" id=\"" + page + "\" value=\"" + (pagination.getCurrPage())
							+ "\" class=\"jumpto\" onkeydown=\"if(event.keyCode==13) return paginationGoto()\">");
				}
			}
			out.println("页</span></a>");
			out.println("<a href=\"javascript:void(0)\" onclick=\"paginationGoto();\" value=\"转到\" ><span class=\"btn-skipsearch\">转到</span></a>");
			*/
			out.println("<input type=\"hidden\" name=\"hiddenPageNum\" value=\"" + pagination.getCurrPage() + "\"");
			out.println("</p>");
			if (formName != null && formName.length() > 0)
				createJS(out, contextPath, pagination.getTotalPage(), pagination.getNextPage());
			else
				createNoFormJS(out, path, pagination.getTotalPage(), pagination.getNextPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private final String encodeURL(String href, String param) {
		StringBuffer buffer = new StringBuffer(100);
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		buffer.append(request.getContextPath() + "/" + href);
		int question = href.indexOf("?");
		if (question > 0)
			buffer.append("&" + param + "=");
		else
			buffer.append("?" + param + "=");
		return buffer.toString();
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setpage(String page) {
		this.page = page;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getFormName() {
		return formName;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}