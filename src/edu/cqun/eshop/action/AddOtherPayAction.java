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
import edu.cqun.eshop.Iservice.IOtherPayManagerService;
import edu.cqun.eshop.Iservice.ISystemUserManagerService;
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;

public class AddOtherPayAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

	@Autowired
	private IOtherPayManagerService iOtherPayManagerService;
	@Autowired
	private ISystemUserManagerService iSystemUserManagerService;

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String name;
	private String note;
	private String amount;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		Double pricenum = Double.parseDouble(amount);
		Timestamp importDate = new Timestamp(System.currentTimeMillis());
		
		List<Commodity> list = iCommodityManagerService.getCommoditiesByCommodityName(name);
		
		if(!list.isEmpty()){
			Commodity commodity = list.get(0);
//			Commodity commodity = iCommodityManagerService.getCommodityById(10401001l);
			importList.setCommodity(commodity);
			iImportListManagerService.addImportList(importList);
			att.put("importLists", iImportListManagerService.getAllImportList());
			return SUCCESS;
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
