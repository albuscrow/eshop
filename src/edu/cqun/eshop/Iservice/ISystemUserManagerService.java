package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.RoleList;
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
	 * 根据用户密码
	 * @param userIds
	 * @return
	 */
	boolean modifySystemUserPassword(long id,String old_password,String new_password);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	boolean modifySystemUserInfo(long user_id,long role_id,String user);
	
	/**
	 * 取得所有系统用户信息
	 * @param user
	 * @return
	 */
	List getAllUser();
}
