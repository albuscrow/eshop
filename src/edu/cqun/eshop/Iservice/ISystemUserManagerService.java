package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.User;

public interface ISystemUserManagerService {
	
	/**
	 * ���ϵͳ�û�
	 * @param user
	 * @return
	 */
	boolean addSystemUser(User user);
	
	/**
	 * �����û�Idɾ���û�
	 * @param UserId
	 * @return
	 */
	boolean deleteSystemUser(long userId);
	
	/**
	 * �����û�Idɾ���û�
	 * @param userIds
	 * @return
	 */
	boolean deleteSystemUsers(List<Long> userIds);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	boolean modifySystemUser(User user);
	
}
