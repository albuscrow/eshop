package edu.cqun.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.domain.Buyer;

public class LoginService {
	@Autowired
	private BuyerDAO buyerDAO;
	
	public boolean checkLogin(Buyer buyer){
		buyerDAO.findById(3l);
		return true;
	}
	
	public static void main(String[] args) {
		LoginService service = new LoginService();
		service.checkLogin(new Buyer());
	}
}
