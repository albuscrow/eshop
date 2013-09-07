package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.OtherPay;

public interface IOtherPayManagerService {
	
	/**
	 * �������֧��
	 * @param otherPay
	 * @return
	 */
	boolean addOtherPay(OtherPay otherPay);
	
	/**
	 * ɾ������֧��
	 * @param id
	 * @return
	 */
	boolean deleteOtherPay(long id);
	
	/**
	 * ��������֧��
	 * @param otherPay
	 * @return
	 */
	boolean modifyOtherPay(OtherPay otherPay);
	
	/**
	 * ������������֧��
	 * @return
	 */
	List<OtherPay> getAllOtherPay ();
	
	/**
	 * ͨ��ID��������֧��
	 * @param id
	 * @return
	 */
	OtherPay getById(long id);
}
