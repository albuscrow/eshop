package edu.cqun.eshop.Iservice;

import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;

public interface ICostManagerService {
	
	/**
	 * 增加进货单
	 * @param importList
	 * @return
	 */
	boolean addImportList(ImportList importList);
	
	/**
	 * 增加其他支出
	 * @param otherPay
	 * @return
	 */
	boolean addOtherCost(OtherPay otherPay);

}
