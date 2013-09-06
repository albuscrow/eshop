package edu.cqun.eshop.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.dao.ImportListDAO;
import edu.cqun.eshop.domain.ImportList;

@Transactional
@Service("importListManagerService")
public class ImportListManagerService implements IImportListManagerService {

	@Autowired
	private ImportListDAO importListDAO;
	
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
//		Hibernate.initialize(list);
		
		System.out.println("listsize:"+list.size());
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS:"+list.get(0).getCommodity().getName());
//		System.out.println();
//		for (ImportList importList : list) {
//			
//		}
		return list;
	}

}
