package com.service.pay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.pay.PayDAO;
import com.dto.pay.PayDTO;

@Service
public class PayService {
	@Autowired
	PayDAO dao;

	public PayDTO selectOrder(String orderNum) {
		return dao.selectOrder(orderNum);
	}

	public List<PayDTO> Cpayment(String orderNum) {
		List<PayDTO> PayList = dao.Cpayment(orderNum);
		return PayList;
	}
	
	
}
