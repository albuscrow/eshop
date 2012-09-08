package edu.cqun.eshop.action;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.Timestamp;

import edu.cqun.eshop.Iservice.ICarriageManagerService;
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Carriage;
import edu.cqun.eshop.domain.Delivery;
import edu.cqun.eshop.domain.OrderList;
import edu.cqun.eshop.domain.RoleList;
import edu.cqun.eshop.domain.User;


public class AddCarriageAction extends ActionSupport  implements SessionAware, ServletRequestAware, ServletResponseAware{

	/**
	 * 添加新的配送方式
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	private ICarriageManagerService carriageManagerService;

	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;

    
    @Override
	public String execute() {
		String start = request.getParameter("start");
		String destination = request.getParameter("destination");
		String company = request.getParameter("company");
		String costr = request.getParameter("cost");
		short cost = Short.parseShort(costr);
		
		Carriage carriage = new Carriage(start, destination, company, cost);
		
		if(carriageManagerService.addCarriageRoute(carriage)){
			return SUCCESS;
		}
	    else{
		     return ERROR;
		} 
    	//return SUCCESS;
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
