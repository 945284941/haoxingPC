package com.qlzy.mainPage.common.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonService {

	public void toHtml(HttpServletRequest request, HttpServletResponse response, String url, String file_name) throws ServletException, IOException;
}
