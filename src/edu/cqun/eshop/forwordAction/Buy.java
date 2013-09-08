package edu.cqun.eshop.forwordAction;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.OrderList;

public class Buy extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware {

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;

	private OrderList orderList;
	
	private String payType;
	private String postType;

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public OrderList getOrderList() {
		return orderList;
	}

	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}

	@Autowired
	private IOrderManagerService orderManagerService;

	public String execute(){
		Buyer buyer = (Buyer) att.get("buyer");
		Long commodityId = Long.parseLong(request.getParameter("id"));
		orderList.setBuyer(buyer);

		List<Commodity> commodities = (List<Commodity>) att.get("commodities");

		Commodity addedCommodity = null;
		for (Commodity commodity : commodities) {
			if(commodity.getCommodityId().equals(commodityId)){
				addedCommodity = commodity;
				break;
			}
		}
		orderList.setCommodity(addedCommodity);
		
		orderManagerService.generateOrderList(orderList);
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		att = arg0;
	}
}
