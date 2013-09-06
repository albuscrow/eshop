package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import edu.cqun.eshop.domain.Buyer;

public interface IUserManagerService {

	/**
	 * ��½
	 * @param buyer
	 * @return
	 */
	boolean checkLogin(Buyer buyer);
	
	/**
	 * ע��
	 * @param buyer
	 */
	boolean regester(Buyer buyer);
	
	/**
	 * �����û���
	 * @param buyer buyer�е��������Ϊnull�����������һ���������������Ϊnull�����ڲ���ʱ���Ը����ԣ����Ե���findbyexample�����Ǹ�����
	 * @return
	 */
	List<Buyer> findUser(Buyer buyer);
	
	/**
	 * �޸�����
	 * @param password
	 * @return
	 */
	boolean modifypassword(long id,String old_password,String new_password);

	
	/**
	 * �޸��û�����
	 * @param buyer buyer�а����û��޸ĺ������
	 * @return
	 */
	boolean modifyUserInfo(long id,String name, String sex, String user, 
			String email, Timestamp registerDate);
	
	/**
	 * ɾ���û�
	 * @param buyerId ���Ҫɾ����û���id
	 * @return
	 */
	boolean deleteUser(long buyerId);
	
	/**
	 * ����ɾ���û�
	 * @param buyerIds 
	 * @return
	 */
	boolean deleteUsers(List<Long> buyerIds);
	
	/**
	 * ��������û�
	 * @return
	 */
	List<Buyer> getAllUser();

	Buyer findUserById(Long id);
}
