package edu.cqun.eshop.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.Iservice.IOtherPayManagerService;
import edu.cqun.eshop.Iservice.ISystemUserManagerService;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;
import edu.cqun.eshop.domain.User;

public class ModifyOtherPayAction extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware {

	@Autowired
	private IOtherPayManagerService iOtherPayManagerService;

	@Autowired
	private ISystemUserManagerService iSystemUserManagerService;

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String name;
	private String note;
	private String amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		if (amount == null || amount.equals("")) {
			String opayId = request.getParameter("opayId");
			System.out.println("SDFASLKDJFKALSJDFLAJL:" + opayId);
			OtherPay otherPay = iOtherPayManagerService.getById(Long
					.parseLong(opayId));
			att.put("otherPay", otherPay);
		} else {
			if (!amount.equals("") & !note.equals("") & !name.equals("")) {
				List<User> list = iSystemUserManagerService
						.getUsersByName(name);
				if (list.isEmpty()) {
					return "fail";
				}
				OtherPay otherPay = (OtherPay) att.get("otherPay");
				Long id = otherPay.getOpayId();
				System.out.println("DDDDiergele:" + id);
				Timestamp opayDate = otherPay.getOpayDate();
				Double amountnum = Double.parseDouble(amount);
				OtherPay otherPay2 = new OtherPay(opayDate);
				System.out.println("Commodity:" + list.get(0));
				otherPay2.setNote(note);
				otherPay2.setUser(list.get(0));
				otherPay2.setOpayId(id);
				otherPay2.setAmount(amountnum);
				iOtherPayManagerService.modifyOtherPay(otherPay2);
				att.put("otherPays", iOtherPayManagerService.getAllOtherPay());
			} else {
				return "fail";
			}
			// List<ImportList> importLists =
			// iImportListManagerService.getAllImportList();
			// att.put("importLists", importLists);
		}
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
