package com.qlzy.memberCenter.person.perinfo.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qlzy.memberCenter.person.perinfo.dao.JiesuanItemMapper;
import com.qlzy.memberCenter.person.perinfo.service.JiesuanItemService;
@Service("jiesuanItemService")
@Transactional(rollbackFor = Exception.class)
public class JiesuanItemServiceImpl implements JiesuanItemService {
	@Resource
	private JiesuanItemMapper jiesuanItemMapper;
	
}
