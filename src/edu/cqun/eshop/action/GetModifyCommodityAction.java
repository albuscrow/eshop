package edu.cqun.eshop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.domain.Commodity;

public class GetModifyCommodityAction extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7248814509448855927L;

	@Autowired
	private ICommodityManagerService commodityService;
	
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String commodityId;
	
//	private String name;
//	private String price;
//	private String discountprice;
//	private String sales;
//	private String rest;
//	private String isRecommend;
//	private String brand;
//	private String categoryId;
//	private String origin;
//	private String regdate;
//	private String introduction;

	@Override
	public String execute() {
		commodityId=request.getParameter("commodityId");
		long goodsId=Long.parseLong(commodityId);
		Commodity currentCommodity=commodityService.getCommodityById(goodsId);
		
		att.put("current", currentCommodity);
		
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

