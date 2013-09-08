package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;
import java.util.List;

import edu.cqun.eshop.domain.ImportList;
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
	
	/**
	 * 通过信息查询其他支出单
	 * @param id
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	List<OtherPay> getOtherPayByMessage(Long id, String name, Timestamp start, Timestamp end);
}
