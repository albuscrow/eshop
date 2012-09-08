package edu.cqun.eshop.forwordAction;

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

import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.constant.OrderStatus;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.OrderList;

public class SubmitOrder extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware {

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Autowired
	private IUserManagerService userManagerService;

	
	
	

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

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
	
	public OrderList getOrder() {
		return order;
	}

	public void setOrder(OrderList order) {
		this.order = order;
	}
	
	private String payType;
	private String postType;
	private Long cid;
	private OrderList order;

	@Autowired
	private IOrderManagerService orderManagerService;

	public String execute(){
		Buyer buyer = (Buyer) userManagerService.findUserById(201309020001l);
		
		order.setBuyer(buyer);

		List<Commodity> commodities = (List<Commodity>) att.get("commodities");

		Commodity addedCommodity = null;
		for (Commodity commodity : commodities) {
			if(commodity.getCommodityId().equals(cid)){
				addedCommodity = commodity;
				break;
			}
		}
		order.setCommodity(addedCommodity);
		if (payType.compareTo("货到付款")==0) {
			order.setPayType((short) 0);
		}else{
			order.setPayType((short) 1);
		}
		
		if (postType.compareTo("平邮") == 0) {
			order.setPostType(0);
		}else{
			order.setPostType(1);
		}
		
		order.setRegisterDate(new Timestamp(System.currentTimeMillis()));
		
		order.setState(OrderStatus.NON_PAY);
		
		orderManagerService.generateOrderList(order);
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
