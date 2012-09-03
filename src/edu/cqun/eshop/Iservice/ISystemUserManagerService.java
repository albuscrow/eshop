package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.User;

public interface ISystemUserManagerService {
	
	/**
	 * 添加系统用户
	 * @param user
	 * @return
	 */
	boolean addSystemUser(User user);
	
	/**
	 * 根据用户Id删除用户
	 * @param UserId
	 * @return
	 */
	boolean deleteSystemUser(long userId);
	
	/**
	 * 根据用户Id删除用户
	 * @param userIds
	 * @return
	 */
	boolean deleteSystemUsers(List<Long> userIds);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	boolean modifySystemUser(User user);
	
}
