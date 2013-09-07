package edu.cqun.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.IOtherPayManagerService;
import edu.cqun.eshop.dao.OtherPayDAO;
import edu.cqun.eshop.domain.OtherPay;

@Transactional
@Service("otherPayManagerService")
public class OtherPayManagerService implements IOtherPayManagerService {

	@Autowired
	private OtherPayDAO otherPayDAO;
	
	@Override
	public boolean addOtherPay(OtherPay otherPay) {
		// TODO Auto-generated method stub
		otherPayDAO.save(otherPay);
		return true;
	}

	@Override
	public boolean deleteOtherPay(long id) {
		// TODO Auto-generated method stub
		OtherPay otherPay = otherPayDAO.findById(id);
		otherPayDAO.delete(otherPay);
		return true;
	}

	@Override
	public boolean modifyOtherPay(OtherPay otherPay) {
		// TODO Auto-generated method stub
		otherPayDAO.attachDirty(otherPay);
		return true;
	}

	@Override
	public List<OtherPay> getAllOtherPay() {
		// TODO Auto-generated method stub
		List<OtherPay> list = otherPayDAO.findAll();
		return list;
	}

	@Override
	public OtherPay getById(long id) {
		// TODO Auto-generated method stub
		return otherPayDAO.findById(id);
	}

}
