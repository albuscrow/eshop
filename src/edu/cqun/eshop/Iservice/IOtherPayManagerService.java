package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.OtherPay;

public interface IOtherPayManagerService {
	
	/**
	 * 添加其他支出
	 * @param otherPay
	 * @return
	 */
	boolean addOtherPay(OtherPay otherPay);
	
	/**
	 * 删除其他支出
	 * @param id
	 * @return
	 */
	boolean deleteOtherPay(long id);
	
	/**
	 * 更改其他支出
	 * @param otherPay
	 * @return
	 */
	boolean modifyOtherPay(OtherPay otherPay);
	
	/**
	 * 查找所有其他支出
	 * @return
	 */
	List<OtherPay> getAllOtherPay ();
	
	/**
	 * 通过ID查找其他支出
	 * @param id
	 * @return
	 */
	OtherPay getById(long id);
}
