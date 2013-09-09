package edu.cqun.eshop.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.Iservice.ITrolleyManagerService;
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.OrderList;

public class BuyerDetailAction extends ActionSupport implements SessionAware,
		ServletRequestAware,ServletResponseAware {

	@Autowired
	private IUserManagerService userManagerService;
	
	@Autowired
	private ITrolleyManagerService trolleyManagerService;
	
	@Autowired
	private IOrderManagerService iOrderManagerService;

	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String buyerId;
    
	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	@Override
    public String execute()  {
    	// TODO Auto-generated method stub
    	Buyer buyer = userManagerService.findUserById(Long.parseLong(buyerId));
    	
//    	Set<OrderList> commodifyInTrolley = (Set<OrderList>) trolleyManagerService.checkTrolley(buyer.getBuyerId());
//    	att.put("commoditys", commodifyInTrolley);
    	att.put("currentBuyer", buyer);
    	
    	Set<OrderList> orderLists = iOrderManagerService.findOrderListByUser(Long.parseLong(request.getParameter("buyerId")));
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
