package edu.cqun.eshop.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.Iservice.IOtherPayManagerService;
import edu.cqun.eshop.Iservice.ISystemUserManagerService;
import edu.cqun.eshop.Iservice.ITrolleyManagerService;
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OrderList;
import edu.cqun.eshop.domain.OtherPay;
import edu.cqun.eshop.domain.User;
import edu.cqun.eshop.constant.OrderStatus;

public class ModifyOrderListAction extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware {

	@Autowired
	private IUserManagerService userManagerService;
	
	@Autowired
	private ITrolleyManagerService trolleyManagerService;
	
	@Autowired
	private IOrderManagerService iOrderManagerService;
	
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		Long orderId = Long.parseLong(request.getParameter("orderId"));
		Short status = OrderStatus.DELIVERING;
		iOrderManagerService.OrderListStatus(orderId, status);
		Buyer buyer = (Buyer) att.get("currentBuyer");
//		System.out.println(buyer);
//    	Set<OrderList> commodifyInTrolley = (Set<OrderList>) trolleyManagerService.checkTrolley(buyer.getBuyerId());
//    	att.put("commoditys", commodifyInTrolley);
//    	att.put("currentBuyer", buyer);
    	Set<OrderList> orderLists = iOrderManagerService.findOrderListByUser(buyer.getBuyerId());
    	att.put("orderLists", orderLists);
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
