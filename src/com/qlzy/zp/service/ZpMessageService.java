package com.qlzy.zp.service;

import java.util.List;

import com.qlzy.model.ZpCompany;
import com.qlzy.model.ZpMessage;

public interface ZpMessageService {

	ZpMessage gainZpMessage();

	ZpCompany gainCompany();

	List<ZpMessage> gainZpMessageList();

	ZpMessage gainZpMessageById(String zpId);

	

}
