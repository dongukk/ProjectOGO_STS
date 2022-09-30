package com.dao.pay;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.pay.PayDTO;

@Repository
public class PayDAO {
	@Autowired
	SqlSessionTemplate template;

	public PayDTO selectOrder(String orderNum) {
		return template.selectOne("PayMapper.selectOrder",orderNum);
	}
	
	
	
}
