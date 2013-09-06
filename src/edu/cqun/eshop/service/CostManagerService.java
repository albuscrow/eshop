package edu.cqun.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.ICostManagerService;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;
import edu.cqun.eshop.dao.*;

@Transactional
@Service("CostManagerService")
public class CostManagerService implements ICostManagerService {
	@Autowired
	private ImportListDAO importListDAO;
	@Autowired
	private OtherPayDAO otherPayDAO;
	
	@Override
	public boolean addImportList(ImportList importList) {
		try {
			importListDAO.save(importList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addOtherCost(OtherPay otherPay) {
		try {
			otherPayDAO.save(otherPay);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
