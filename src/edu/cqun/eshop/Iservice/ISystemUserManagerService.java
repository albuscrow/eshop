package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.RoleList;
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
	 * �����û�����
	 * @param userIds
	 * @return
	 */
	boolean modifySystemUserPassword(long id,String old_password,String new_password);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	boolean modifySystemUserInfo(long user_id,long role_id,String user);
	
	/**
	 * ȡ������ϵͳ�û���Ϣ
	 * @param user
	 * @return
	 */
	List getAllUser();
}
