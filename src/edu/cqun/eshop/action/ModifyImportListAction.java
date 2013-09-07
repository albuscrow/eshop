package edu.cqun.eshop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.domain.ImportList;

public class ModifyImportListAction extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware {

	@Autowired
	private IImportListManagerService iImportListManagerService;

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@Override
	public String execute()  {
	// TODO Auto-generated method stub
		System.out.println("SDFASLKDJFKALSJDFLAJL"+request.getParameter("importId"));
		ImportList importList = iImportListManagerService.getById(Long.parseLong(request.getParameter("importId")));
		att.put("importList", importList);
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
