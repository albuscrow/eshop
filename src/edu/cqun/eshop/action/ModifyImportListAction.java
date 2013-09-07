package edu.cqun.eshop.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.ImportList;

public class ModifyImportListAction extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware {

	@Autowired
	private IImportListManagerService iImportListManagerService;
	
	@Autowired
	private ICommodityManagerService iCommodityManagerService;
	
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String name;
	private String price;
	private String quantity;
//	private String importId;
//	
//	
//	public String getImportId() {
//		return importId;
//	}
//
//	public void setImportId(String importId) {
//		this.importId = importId;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String execute()  {
	// TODO Auto-generated method stub
		if(price==null){
			String importId = request.getParameter("importId");
			System.out.println("SDFASLKDJFKALSJDFLAJL:"+importId);
			ImportList importList = iImportListManagerService.getById(Long.parseLong(importId));
			att.put("importList", importList);
		}
		else {
			System.out.println("Price¾¹È»²»ÎªNULLLLLLLLLLLLLL!");
			System.out.println(name);
			List<Commodity> list;
			try {
				list = iCommodityManagerService.getCommoditiesByCommodityName(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (list.isEmpty()) {
				System.out.println("FAILED!dededed!!!!!!!!!!!!!!");
				return "fail";
			}
//			Long id = Long.parseLong(request.getParameter("importId"));
			ImportList importList = (ImportList) att.get("importList");
			Long id = importList.getImportId();
			System.out.println("DDDDiergele:"+id);
			Timestamp timestamp = importList.getImportDate();
			Short quantitynum = Short.parseShort(quantity);
			Double pricenum = Double.parseDouble(price);
			ImportList importList2 = new ImportList(quantitynum, pricenum, timestamp);
			System.out.println("Commodity:"+list.get(0));
			importList2.setCommodity(list.get(0));
			importList2.setImportId(id);
			iImportListManagerService.modifyImportList(importList2);
		}
	return SUCCESS;
}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.att = arg0;

	}

}
