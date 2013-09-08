package edu.cqun.eshop.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.ImportList;

public class AddImportListAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

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
	public String execute() {
		// TODO Auto-generated method stub
		if(!quantity.equals("") & !price.equals("") & !name.equals("")){
			Short quantitynum = Short.parseShort(quantity);
			Double pricenum = Double.parseDouble(price);
			Timestamp importDate = new Timestamp(System.currentTimeMillis());
			ImportList importList = new ImportList(quantitynum, pricenum, importDate);
			
			List<Commodity> list = iCommodityManagerService.getCommoditiesByCommodityName(name);
			
			if(!list.isEmpty()){
				Commodity commodity = list.get(0);
//				Commodity commodity = iCommodityManagerService.getCommodityById(10401001l);
				importList.setCommodity(commodity);
				iImportListManagerService.addImportList(importList);
				att.put("importLists", iImportListManagerService.getAllImportList());
				return SUCCESS;
			}
			else {
				return "fail";
			}
		}
		else {
			return "fail";
		}
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
