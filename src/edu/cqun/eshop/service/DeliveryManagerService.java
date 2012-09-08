package edu.cqun.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.IDeliveryManagerService;
import edu.cqun.eshop.dao.BuyerDAO;
import edu.cqun.eshop.dao.CarriageDAO;
import edu.cqun.eshop.domain.Carriage;

@Transactional
@Service("DeliveryManagerService")
public class DeliveryManagerService implements IDeliveryManagerService{
	
	@Autowired
	private CarriageDAO carriageDAO;

	@Override
	public boolean addDelivery(Carriage carriage) {
		// TODO Auto-generated method stub
		try{
			carriageDAO.save(carriage);
			return true;
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public boolean deleteDelivery(long carriageId) {
		// TODO Auto-generated method stub
		try{
			carriageDAO.delete(carriageDAO.findById(carriageId));
			return true;
		}catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<Carriage> findAllDelivery() {
		// TODO Auto-generated method stub
		try{
			return carriageDAO.findAll();
		}catch (RuntimeException re) {
			throw re;
		}
	}


	

}
