package edu.cqun.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ISystemUserManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.dao.UserDAO;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.RoleList;
import edu.cqun.eshop.domain.User;
import edu.cqun.eshop.dao.UserDAO;;

@Transactional
@Service("SystemUserManagerService")
public class SystemUserManagerService implements ISystemUserManagerService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public boolean addSystemUser(User user) {
		// TODO Auto-generated method stub
		try{
			userDAO.save(user);
			return true;
		}catch(RuntimeException re){
			throw re;
		}
	}

	@Override
	public boolean deleteSystemUser(long userId) {
		// TODO Auto-generated method stub
		try{
			User user=userDAO.findById(userId);
			if(user!=null)
			{
				userDAO.delete(user);
				return true;
			}
			else 
				return false;
		}catch(RuntimeException re){
			throw re;
		}
	}

	@Override
	public boolean deleteSystemUsers(List<Long> userIds) {
		// TODO Auto-generated method stub
		try{
			for (Long userId : userIds) {
				User user= userDAO.findById(userId);
				userDAO.delete(user);
			}
			return true;
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public boolean modifySystemUserPassword(long id,String old_password,String new_password) {
		// TODO Auto-generated method stub
		try{
			User result = userDAO.findById(id);
			if(result==null)
				return false;
			else if((result.getPassword()).equalsIgnoreCase(old_password))
			{
				result.setPassword(new_password);
				userDAO.save(result);
				return true;
			}
			else
				return false; 
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public boolean modifySystemUserInfo(long id, RoleList roleList, String user) {
		// TODO Auto-generated method stub
		try{
			User result=userDAO.findById(id);
			if(result!=null)
			{
				if(roleList!=null)
				result.setRoleList(roleList);
				
				if(user!=null)
				result.setUser(user);
				
				userDAO.save(result);
				return true;
			}
			else
				return false;
		}catch (RuntimeException re) {
			throw re;
		}
	}

}
