package edu.cqun.eshop.Iservice;

import java.util.List;
import java.util.Set;

import edu.cqun.eshop.domain.PayWay;


public interface IPayWayManagerService {
 
	/**
	 * 查出所有付款方式
	 * @param buyer
	 * @return
	 */
	List<PayWay> getAllPayWay();
	
	/**
	 * 增加付款方式
	 * @param buyer
	 * @return
	 */
	boolean addPay(PayWay payWay);
	
	/**
	 * 增加付款方式
	 * @param buyer
	 * @return
	 */
	boolean deletePay(long payId);
}
