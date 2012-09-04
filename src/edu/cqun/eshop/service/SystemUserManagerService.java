package edu.cqun.eshop.service;

import java.util.List;

import edu.cqun.eshop.Iservice.ISystemUserManagerService;
import edu.cqun.eshop.domain.User;
import edu.cqun.eshop.dao.UserDAO;;

public class SystemUserManagerService implements ISystemUserManagerService{
	
	@Override
	public boolean addSystemUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSystemUser(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSystemUsers(List<Long> userIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifySystemUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
