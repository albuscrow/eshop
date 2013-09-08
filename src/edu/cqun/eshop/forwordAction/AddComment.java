package edu.cqun.eshop.forwordAction;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ICommentManagerService;
import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.Iservice.IOrderManagerService;
import edu.cqun.eshop.domain.OrderList;

public class AddComment extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware{
	@SuppressWarnings("rawtypes")
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Autowired
	private ICommentManagerService commentManagerService;
	
	private OrderList order;
	
	private Long oid;
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public OrderList getOrder() {
		return order;
	}

	public void setOrder(OrderList order) {
		this.order = order;
	}

	public String execute(){
		Set<OrderList> orders = (Set<OrderList>) att.get("orders");
		OrderList corder= null;
		for (OrderList order : orders) {
			if (order.getOrderId().equals(oid)) {
				corder = order;
				break;
			}
		}
		
		corder.setAttitude(order.getAttitude());
		corder.setIsMatched(order.getIsMatched());
		corder.setLogisticsSpeed(order.getLogisticsSpeed());
		corder.setTotal(order.getTotal());
		corder.setComment(order.getComment());
		
		commentManagerService.addComment(corder);
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
