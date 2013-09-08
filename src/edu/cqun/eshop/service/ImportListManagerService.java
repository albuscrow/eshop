package edu.cqun.eshop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.dao.CommodityDAO;
import edu.cqun.eshop.dao.ImportListDAO;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.ImportList;

@Transactional
@Service("importListManagerService")
public class ImportListManagerService implements IImportListManagerService {

	@Autowired
	private ImportListDAO importListDAO;
	@Autowired
	private CommodityDAO commodityDAO;
	
	@Override
	public boolean addImportList(ImportList importList) {
		// TODO Auto-generated method stub
		importListDAO.save(importList);
		return true;
	}

	@Override
	public boolean deleteImportList(long id) {
		// TODO Auto-generated method stub
		ImportList importList = importListDAO.findById(id);
		importListDAO.delete(importList);
		return true;
	}

	@Override
	public boolean modifyImportList(ImportList importList) {
		// TODO Auto-generated method stub
		importListDAO.attachDirty(importList);
		return true;
	}

	@Override
	public List<ImportList> getAllImportList() {
		// TODO Auto-generated method stub
		List<ImportList> list = importListDAO.findAll();
		return list;
	}

	@Override
	public ImportList getById(long id) {
		// TODO Auto-generated method stub
		ImportList importList = importListDAO.findById(id);
		return importList;
	}

	@Override
	public List<ImportList> getImportListByMessage(Long id, String name,
			Timestamp start, Timestamp end) {
		// TODO Auto-generated method stub
		if(id!=null){
			List<ImportList> list = new ArrayList<ImportList>();
			ImportList importList = importListDAO.findById(id);
			list.add(importList);
			return list;
		}
		else {
			if(!name.equals("") & start!=null & end!=null){
				List<ImportList> list = importListDAO.getOverallImportByPeriod(start, end);
				List<ImportList> result = new ArrayList<ImportList>();
				for (ImportList importList : list) {
					Hibernate.initialize(importList);
					if(importList.getCommodity().getName().equals(name)){
						result.add(importList);
					}
				}
				return result;
			}
			else if(!name.equals("")){
				List<Commodity> list = commodityDAO.findByName(name);
				List<ImportList> result = new ArrayList<ImportList>();
				for (Commodity commodity : list) {
					List<ImportList> list2 = importListDAO.findImportListByCommodity(commodity);
					result.addAll(list2);
				}
				return result;
			}
			else if(start!=null & end!=null){
				return importListDAO.getOverallImportByPeriod(start, end);
			}
			else {
//				return null;
				List<ImportList> list = importListDAO.findAll();
				return list;
			}
		}
	}

}
