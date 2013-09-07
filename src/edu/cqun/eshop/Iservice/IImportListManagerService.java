package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.ImportList;

public interface IImportListManagerService {
	
	/**
	 * ��ӽ�����
	 * @param importList
	 * @return
	 */
	boolean addImportList(ImportList importList);
	
	/**
	 * ɾ��������
	 * @param id
	 * @return
	 */
	boolean deleteImportList(long id);
	
	/**
	 * ���Ľ�����
	 * @param importList
	 * @return
	 */
	boolean modifyImportList(ImportList importList);
	
	/**
	 * �������н�����
	 * @return
	 */
	List<ImportList> getAllImportList ();
	
	/**
	 * ͨ��ID���ҽ�����
	 * @param id
	 * @return
	 */
	ImportList getById(long id);
}
