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
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.OrderList;

public class Comment extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware{
	@SuppressWarnings("rawtypes")
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Autowired
	private ICommentManagerService commentManagerService;
	
	public String execute(){
		Long id = Long.parseLong(request.getParameter("cid"));
		Set<OrderList> commentLists = commentManagerService.checkComment(id);
		att.put("comments", commentLists);
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
