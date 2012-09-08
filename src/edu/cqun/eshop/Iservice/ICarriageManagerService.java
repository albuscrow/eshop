package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.Carriage;

public interface ICarriageManagerService {
	
	/**
	 * ����˷�·��
	 * @param carriage
	 * @return
	 */
	boolean addCarriageRoute(Carriage carriage);
	
	/**
	 * ɾ���˷�·��
	 * @param id
	 * @return
	 */
	boolean deleteCarriageRoute(Long id);
	
	/**
	 * ����˷�·��
	 * @param id
	 * @param start
	 * @param destination
	 * @param company
	 * @param cost
	 * @return
	 */
	boolean modifyCarriageRoute(Long id, String start,String destination,String company,Short cost);
	
	/**
	 * ͨ����Ϣ��ѯ�˷�·��
	 * @param start
	 * @param destination
	 * @param company
	 * @param cost
	 * @return
	 */
	List<Carriage> queryCarriageRouteByMessage(String start,String destination,String company,Short cost);
	
	/**
	 * ͨ��ID��ѯ�˷�·��
	 * @param id
	 * @return
	 */
	Carriage queryCarriageRouteById(Long id);
	/**
	 * 找出所有配送方式
	 * @param id
	 * @return
	 */
	List<Carriage>  findAll();
}
