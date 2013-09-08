package edu.cqun.eshop.action;

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

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.Iservice.IOtherPayManagerService;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;

public class QueryOtherPayAction extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	IOtherPayManagerService iOtherPayManagerService;

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String opayId;
	private String name;
	private String years;
	private String months;
	private String days;
	private String yeare;
	private String monthe;
	private String daye;
	private String startTime = "00:00:00";
	private String endTime = "23:59:59";
	
	public String getOpayId() {
		return opayId;
	}

	public void setOpayId(String opayId) {
		this.opayId = opayId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getYeare() {
		return yeare;
	}

	public void setYeare(String yeare) {
		this.yeare = yeare;
	}

	public String getMonthe() {
		return monthe;
	}

	public void setMonthe(String monthe) {
		this.monthe = monthe;
	}

	public String getDaye() {
		return daye;
	}

	public void setDaye(String daye) {
		this.daye = daye;
	}

	
	public String execute() {
		Long id = null;
		Timestamp start = null;
		Timestamp end = null;
		if(!years.equals("") & !months.equals("") & !days.equals("") & !yeare.equals("") & !monthe.equals("") & !daye.equals("")){
			System.out.println("years"+years);
			String startString = years + "-" + months + "-" + days + " " + startTime;
			String endString = yeare + "-" + monthe + "-" + daye + " " + endTime;
			System.out.println("AARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
			System.out.println(startString+" "+"RRDR"+" "+endString);
			start = Timestamp.valueOf(startString);
			end = Timestamp.valueOf(endString);
		}
		if(!opayId.equals("")){
			id = Long.parseLong(opayId);
		}
		List<OtherPay> list = iOtherPayManagerService.getOtherPayByMessage(id, name, start, end);
//		if(!list.isEmpty()){
		att.put("otherPays", list);
		return SUCCESS;
//		}
//		else {
//			return "fail";
//		}
		
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
