package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.Carriage;

public interface ICarriageManagerService {
	
	/**
	 * 添加运费路线
	 * @param carriage
	 * @return
	 */
	boolean addCarriageRoute(Carriage carriage);
	
	/**
	 * 删除运费路线
	 * @param id
	 * @return
	 */
	boolean deleteCarriageRoute(Long id);
	
	/**
	 * 更改运费路线
	 * @param id
	 * @param start
	 * @param destination
	 * @param company
	 * @param cost
	 * @return
	 */
	boolean modifyCarriageRoute(Long id, String start,String destination,String company,Short cost);
	
	/**
	 * 通过信息查询运费路线
	 * @param start
	 * @param destination
	 * @param company
	 * @param cost
	 * @return
	 */
	List<Carriage> queryCarriageRouteByMessage(String start,String destination,String company,Short cost);
	
	/**
	 * 通过ID查询运费路线
	 * @param id
	 * @return
	 */
	Carriage queryCarriageRouteById(Long id);
}
