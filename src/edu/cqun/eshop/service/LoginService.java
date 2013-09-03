package edu.cqun.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ILoginService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.domain.Buyer;


@Transactional
@Service("loginService")
public class LoginService implements ILoginService {
	@Autowired
	private BuyerDAO buyerDAO;
	
	@Override
	public boolean checkLogin(Buyer buyer){
		buyerDAO.findById(3l);
		return true;
	}
	
	public static void main(String[] args) {
		LoginService service = new LoginService();
		service.checkLogin(new Buyer());
	}
}
