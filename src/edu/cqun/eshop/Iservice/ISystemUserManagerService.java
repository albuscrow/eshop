package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.RoleList;
import edu.cqun.eshop.domain.User;

public interface ISystemUserManagerService {
	
	/**
	 * 娣诲姞绯荤粺鐢ㄦ埛
	 * @param user
	 * @return
	 */
	boolean addSystemUser(User user);
	
	/**
	 * 锟斤拷锟斤拷没锟絀d删锟斤拷锟矫伙拷
	 * @param UserId
	 * @return
	 */
	boolean deleteSystemUser(long userId);
	
	/**
	 * 锟斤拷锟斤拷没锟絀d删锟斤拷锟矫伙拷
	 * @param userIds
	 * @return
	 */
	boolean deleteSystemUsers(List<Long> userIds);
	
	/**
	 * 锟斤拷锟斤拷没锟斤拷锟斤拷锟�
	 * @param userIds
	 * @return
	 */
	boolean modifySystemUserPassword(long id,String old_password,String new_password);
	
	/**
	 * 锟睫革拷锟矫伙拷锟斤拷息
	 * @param user
	 * @return
	 */
	boolean modifySystemUserInfo(long user_id,long role_id,String user,String name);
	
	/**
	 * 锟斤拷询系统锟矫伙拷锟斤拷息
	 * @param user
	 * @return
	 */	
	
	User findUser(long user_id);
	
	
	/**
	 * 取锟斤拷锟斤拷锟斤拷系统锟矫伙拷锟斤拷息
	 * @param user
	 * @return
	 */
	List<User> getAllUser();
	
	/**
	 * 通锟斤拷锟斤拷锟斤拷取锟斤拷锟矫伙拷
	 * @param name
	 * @return
	 */
	List<User> getUsersByName(String name);
	
	/**
	 * 系统用户登录
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean checkLogin(String userId,String password);
}
