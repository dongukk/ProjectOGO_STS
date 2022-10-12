package com.dao.pay;

import java.util.List;

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

	public List<PayDTO> Cpayment(String orderNum) {
		int num =template.update("PayMapper.Cpayment",orderNum);
		System.out.println("결제완료 변경 개수: "+num);
		List<PayDTO> list = getPayList(orderNum);
		return list;
	}
	
	public List<PayDTO> getPayList(String orderNum) {
		List<PayDTO> list = template.selectList("PayMapper.getPayList",orderNum);
		System.out.println("payment보낼 list" + list);
		return list;
	}

	public List<PayDTO> getPlog(String userId) {
		return template.selectList("PayMapper.getPlog",userId);
	}
	
}
