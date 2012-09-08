package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;
import java.util.List;

import edu.cqun.eshop.domain.ImportList;
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
	
	/**
	 * ͨ����Ϣ��ѯ����֧����
	 * @param id
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	List<OtherPay> getOtherPayByMessage(Long id, String name, Timestamp start, Timestamp end);
}
