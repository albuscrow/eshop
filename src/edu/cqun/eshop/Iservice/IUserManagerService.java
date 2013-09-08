package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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
	 * 查找买家
	 * @param buyer buyer
	 * @return
	 */
	List<Buyer> findUser(Buyer buyer);
	
	/**
	 * 修改密码
	 * @param password
	 * @return
	 */
	boolean modifypassword(long id,String old_password,String new_password);

	
	/**
	 * 修改买家信息
	 * @param buyer buyer
	 * @return
	 */
	boolean modifyUserInfo(Long id,String name, String sex, String user, String email);
	
	/**
	 * 删除买家
	 * @param buyerId 
	 * @return
	 */
	boolean deleteUser(long buyerId);
	
	/**
	 * 批量删除买家
	 * @param buyerIds 
	 * @return
	 */
	boolean deleteUsers(List<Long> buyerIds);
	
	/**
	 * 找出所有买家
	 * @return
	 */
	List<Buyer> getAllUser();

	Buyer findUserById(Long id);
}
