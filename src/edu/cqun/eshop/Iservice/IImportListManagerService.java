package edu.cqun.eshop.Iservice;

import java.util.List;

import edu.cqun.eshop.domain.ImportList;

public interface IImportListManagerService {
	
	/**
	 * 添加进货单
	 * @param importList
	 * @return
	 */
	boolean addImportList(ImportList importList);
	
	/**
	 * 删除进货单
	 * @param id
	 * @return
	 */
	boolean deleteImportList(long id);
	
	/**
	 * 更改进货单
	 * @param importList
	 * @return
	 */
	boolean modifyImportList(ImportList importList);
	
	/**
	 * 查找所有进货单
	 * @return
	 */
	List<ImportList> getAllImportList ();
	
	/**
	 * 通过ID查找进货单
	 * @param id
	 * @return
	 */
	ImportList getById(long id);
}
