package edu.cqun.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ICarriageManagerService;
import edu.cqun.eshop.dao.CarriageDAO;
import edu.cqun.eshop.domain.Carriage;

@Transactional
@Service("carriageManagerService")
public class CarriageManagerService implements ICarriageManagerService {

	@Autowired
	private CarriageDAO carriageDAO;
	
	@Override
	public boolean addCarriageRoute(Carriage carriage) {
		// TODO Auto-generated method stub
		carriageDAO.save(carriage);
		return true;
	}

	@Override
	public boolean deleteCarriageRoute(Long id) {
		// TODO Auto-generated method stub
		Carriage carriage = carriageDAO.findById(id);
		carriageDAO.delete(carriage);
		return true;
	}

	@Override
	public boolean modifyCarriageRoute(Long id, String start,
			String destination, String company, Short cost) {
		// TODO Auto-generated method stub
		Carriage carriage = carriageDAO.findById(id);
		carriage.setCompany(company);
		carriage.setCost(cost);
		carriage.setDestination(destination);
		carriage.setStart(start);
		carriageDAO.attachDirty(carriage);
		return true;
	}

	@Override
	public List<Carriage> queryCarriageRouteByMessage(String start,
			String destination, String company, Short cost) {
		// TODO Auto-generated method stub
		Carriage carriage = new Carriage(start, destination, company, cost);
		List<Carriage> list = carriageDAO.findByExample(carriage);
		return list;
	}

	@Override
	public Carriage queryCarriageRouteById(Long id) {
		// TODO Auto-generated method stub
		Carriage carriage = carriageDAO.findById(id);
		return carriage;
	}

	@Override
	public List<Carriage> findAll() {
		// TODO Auto-generated method stub
		try{
			return carriageDAO.findAll();
		}catch (RuntimeException re) {
			throw re;
		}
	}

	

}
