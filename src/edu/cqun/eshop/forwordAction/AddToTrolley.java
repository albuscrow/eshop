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

import edu.cqun.eshop.Iservice.ITrolleyManagerService;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Commodity;

@SuppressWarnings("serial")
public class AddToTrolley extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware{
	@SuppressWarnings("rawtypes")
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Autowired
	private ITrolleyManagerService trolleyManagerService;
	
	public String execute(){
		Long commodityId = Long.parseLong(request.getParameter("commodity"));
		Buyer buyer = (Buyer)att.get("buyer");
		Long userId = buyer.getBuyerId();
		
		@SuppressWarnings("unchecked")
		List<Commodity> commodities = (List<Commodity>) att.get("commodities");
		
		Commodity addedCommodity = null;
		for (Commodity commodity : commodities) {
			if(commodity.getCommodityId().equals(commodityId)){
				addedCommodity = commodity;
				break;
			}
		}
		try {
			if(trolleyManagerService.addCommodity(userId, addedCommodity)){
				response.getWriter().write("success");
			}else{
				response.getWriter().write("fail");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
