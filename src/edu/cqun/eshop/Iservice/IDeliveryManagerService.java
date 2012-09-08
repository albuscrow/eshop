package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.Carriage;

public interface IDeliveryManagerService {

	boolean addDelivery(Carriage carriage);//增加配送方式
	
	boolean deleteDelivery(long carriageId);//删除配送方式
	
	List<Carriage> findAllDelivery();//查出所有配送方式
}
