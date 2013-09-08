package edu.cqun.eshop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.IOtherPayManagerService;
import edu.cqun.eshop.dao.OtherPayDAO;
import edu.cqun.eshop.dao.UserDAO;
import edu.cqun.eshop.domain.User;
import edu.cqun.eshop.domain.OtherPay;
import edu.cqun.eshop.domain.OtherPay;

@Transactional
@Service("otherPayManagerService")
public class OtherPayManagerService implements IOtherPayManagerService {

	@Autowired
	private OtherPayDAO otherPayDAO;
	@Autowired
	private UserDAO userDAO;

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

	@Override
	public List<OtherPay> getOtherPayByMessage(Long id, String name,
			Timestamp start, Timestamp end) {
		if (id != null) {
			List<OtherPay> list = new ArrayList<OtherPay>();
			OtherPay otherPay = otherPayDAO.findById(id);
			list.add(otherPay);
			return list;
		} else {
			if (!name.equals("") & start != null & end != null) {
				List<OtherPay> list = otherPayDAO.getOverallOtherPayByPeriod(
						start, end);
				List<OtherPay> result = new ArrayList<OtherPay>();
				for (OtherPay otherPay : list) {
					Hibernate.initialize(otherPay);
					if (otherPay.getUser().getName().equals(name)) {
						result.add(otherPay);
					}
				}
				return result;
			} else if (!name.equals("")) {
				List<User> list = userDAO.findByName(name);
				List<OtherPay> result = new ArrayList<OtherPay>();
				for (User user : list) {
					List<OtherPay> list2 = otherPayDAO.findOtherPayByUser(user);
					result.addAll(list2);
				}
				return result;
			} else if (start != null & end != null) {
				return otherPayDAO.getOverallOtherPayByPeriod(start, end);
			} else {
				// return null;
				List<OtherPay> list = otherPayDAO.findAll();
				return list;
			}
		}
	}
}
