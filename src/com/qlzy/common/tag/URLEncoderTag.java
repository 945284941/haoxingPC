package com.qlzy.common.tag;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.qlzy.common.tools.URLEncoderTwice;

public class URLEncoderTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String value ;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public int doStartTag() throws JspException {
		if(value!=null && !"".equals(value)){
			value=URLEncoderTwice.decoder(value);
			try {
				pageContext.getOut().write(value+"");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doStartTag();
	}
}
