package edu.cqun.eshop.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.cqun.eshop.Iservice.IPayWayManagerService;
import edu.cqun.eshop.dao.PayWayDAO;
import edu.cqun.eshop.domain.PayWay;

@Transactional
@Service("PayWayManagerService")
public class PayWayManagerService implements IPayWayManagerService {
	
	@Autowired
	PayWayDAO payWayDAO;

//查出所有付款方式
	@Override
	public java.util.List<PayWay> getAllPayWay() {
		// TODO Auto-generated method stub
		try{
			List<PayWay> payWay = payWayDAO.findAll();
			return payWay;
		}catch(RuntimeException re){
			throw re;
		}
		
	}

	@Override
	public boolean addPay(PayWay payWay) {
		// TODO Auto-generated method stub
		try{
			payWayDAO.save(payWay);
			return true;
		}catch(RuntimeException re){
			throw re;
		}
	}

	@Override
	public boolean deletePay(long payId) {
		// TODO Auto-generated method stub
		try{
			 payWayDAO.delete(payWayDAO.findById(payId));
			return true;
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	


	

}
