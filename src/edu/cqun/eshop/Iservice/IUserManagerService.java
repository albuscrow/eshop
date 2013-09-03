package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.Buyer;

public interface IUserManagerService {

	/**
	 * 登陆
	 * @param buyer
	 * @return
	 */
	boolean checkLogin(Buyer buyer);
	
	/**
	 * 注册
	 * @param buyer
	 */
	boolean regester(Buyer buyer);
	
	/**
	 * 查找用户，
	 * @param buyer buyer中的属性如果不为null，则该属性是一个查找条件，如果为null，这在查找时忽略该属性，可以调用findbyexample（）那个函数
	 * @return
	 */
	Buyer findUser(Buyer buyer);
	
	/**
	 * 修改密码
	 * @param password
	 * @return
	 */
	boolean modifypassword(String password);

	
	/**
	 * 修改用户资料
	 * @param buyer buyer中包含了用户修改后的资料
	 * @return
	 */
	boolean modifyUserInfo(Buyer buyer);
	
	/**
	 * 删除用户
	 * @param buyerId 代表要删除的用户的id
	 * @return
	 */
	boolean deleteUser(long buyerId);
	
	/**
	 * 屁来那个删除用户
	 * @param buyerIds 
	 * @return
	 */
	boolean deleteUsers(List<Long> buyerIds);
}
