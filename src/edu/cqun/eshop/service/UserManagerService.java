package edu.cqun.eshop.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.dao.UserDAO;
import edu.cqun.eshop.domain.Buyer;


@Transactional
@Service("UserManagerService")
public class UserManagerService implements IUserManagerService {
	@Autowired
	private BuyerDAO buyerDAO;

	@Override
	public boolean checkLogin(Buyer buyer){
		// TODO Auto-generated method stub
		try{
			List<Buyer> result = buyerDAO.findByExample(buyer);
			if (result != null && result.size() == 1) {
				return true;
			}else {
				return false;
			}
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public boolean regester(Buyer buyer) {
		// TODO Auto-generated method stub
		try{
			buyerDAO.save(buyer);
			return true;
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<Buyer> findUser(Buyer buyer) {
		// TODO Auto-generated method stub
		try{
			List<Buyer> result = (buyerDAO.findByExample(buyer));
			if (result != null) 
				return result;
			else 
				return null;
		}catch (RuntimeException re) {
			throw re;
		}
	} 

	@Override
	public boolean modifypassword(long id,String old_password,String new_password){
		// TODO Auto-generated method stub
		try{
			Buyer result = buyerDAO.findById(id);
			if(result==null)
				return false;
			else if((result.getPassword()).equalsIgnoreCase(old_password))
			{
				result.setPassword(new_password);
				buyerDAO.save(result);
				return true;
			}
			else
				return false; 
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public boolean modifyUserInfo(long id,String name, String sex, String user,
			String email, Timestamp registerDate) {
		// TODO Auto-generated method stub
		try{
			Buyer result=buyerDAO.findById(id);
			if(result!=null)
			{
				if(name!=null)
				result.setName(name);
				
				if(sex!=null)
				result.setSex(sex);
				
				if(user!=null)
				result.setUser(user);
				
				if(email!=null)
				result.setEmail(email);
				
				if(registerDate!=null)
				result.setRegisterDate(registerDate);
				
				buyerDAO.save(result);
			}
			return true;
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public boolean deleteUser(long buyerId) {
		// TODO Auto-generated method stub
		try{
			Buyer buyer=buyerDAO.findById(buyerId);
			if(buyer!=null)
			{
				buyerDAO.delete(buyer);
			    return true;	
			}
			 else
				 return false;
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public boolean deleteUsers(List<Long> buyerIds) {
		// TODO Auto-generated method stub
		try{
			for (Long buyerId : buyerIds) {
				Buyer buyer= buyerDAO.findById(buyerId);
				buyerDAO.delete(buyer);
			}
			return true;
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<Buyer> getAllUser() {
		// TODO Auto-generated method stub
		try {
			return buyerDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
