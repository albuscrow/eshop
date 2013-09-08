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

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.domain.Commodity;

public class SearchByK extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware{

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Autowired
	private ICommodityManagerService commodityManagerService;
	
	@Override
	public String execute() {
		String keyword = request.getParameter("K");
		List<Commodity> commodities = commodityManagerService.searchByKeyword(keyword);
//		att.put("commodities", commodities);
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
