package edu.cqun.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.domain.Buyer;


@Transactional
@Service("loginService")
public class UserManagerService implements IUserManagerService {
	@Autowired
	private BuyerDAO buyerDAO;
	
	@Override
	public boolean checkLogin(Buyer buyer){
		List<Buyer> buyer2 = buyerDAO.findByName(buyer.getName());
		return true;
	}
	
}
