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
	public boolean checkLogin(Buyer buyer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean regester(Buyer buyer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Buyer findUser(Buyer buyer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifypassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyUserInfo(Buyer buyer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(long buyerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUsers(List<Long> buyerIds) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
