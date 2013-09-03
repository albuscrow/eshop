package edu.cqun.eshop.Iservice;

import java.util.List;

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
	 * @param buyer buyer�е����������Ϊnull�����������һ���������������Ϊnull�����ڲ���ʱ���Ը����ԣ����Ե���findbyexample�����Ǹ�����
	 * @return
	 */
	Buyer findUser(Buyer buyer);
	
	/**
	 * �޸�����
	 * @param password
	 * @return
	 */
	boolean modifypassword(String password);

	
	/**
	 * �޸��û�����
	 * @param buyer buyer�а������û��޸ĺ������
	 * @return
	 */
	boolean modifyUserInfo(Buyer buyer);
	
	/**
	 * ɾ���û�
	 * @param buyerId ����Ҫɾ�����û���id
	 * @return
	 */
	boolean deleteUser(long buyerId);
	
	/**
	 * ƨ���Ǹ�ɾ���û�
	 * @param buyerIds 
	 * @return
	 */
	boolean deleteUsers(List<Long> buyerIds);
}
