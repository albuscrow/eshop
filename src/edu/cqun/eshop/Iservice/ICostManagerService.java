package edu.cqun.eshop.Iservice;

import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;

public interface ICostManagerService {
	
	/**
	 * ���ӽ�����
	 * @param importList
	 * @return
	 */
	boolean addImportList(ImportList importList);
	
	/**
	 * ��������֧��
	 * @param otherPay
	 * @return
	 */
	boolean addOtherCost(OtherPay otherPay);

}
