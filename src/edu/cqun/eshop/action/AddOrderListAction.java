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
import edu.cqun.eshop.Iservice.ISystemUserManagerService;
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;
import edu.cqun.eshop.domain.User;

public class AddOrderListAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

	@Autowired
	private IOtherPayManagerService iOtherPayManagerService;
	@Autowired
	private ISystemUserManagerService iSystemUserManagerService;

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String name;
	private String buyerId;
	private String quantity;
	private String payType;
	private String state;
	private String logisticsState;
	private String postType;
	private String postcode;
	private String address;
	private String phone;
	private String carriageFee;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLogisticsState() {
		return logisticsState;
	}

	public void setLogisticsState(String logisticsState) {
		this.logisticsState = logisticsState;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCarriageFee() {
		return carriageFee;
	}

	public void setCarriageFee(String carriageFee) {
		this.carriageFee = carriageFee;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		if (!amount.equals("") & !note.equals("") & !name.equals("")) {
			Double amountnum = Double.parseDouble(amount);
			Timestamp opayDate = new Timestamp(System.currentTimeMillis());

			OtherPay otherPay = new OtherPay(opayDate);
			List<User> list = iSystemUserManagerService.getUsersByName(name);

			if (!list.isEmpty()) {
				User user = list.get(0);
				// Commodity commodity =
				// iCommodityManagerService.getCommodityById(10401001l);
				otherPay.setAmount(amountnum);
				otherPay.setNote(note);
				otherPay.setUser(user);
				iOtherPayManagerService.addOtherPay(otherPay);
				att.put("otherPays", iOtherPayManagerService.getAllOtherPay());
				return SUCCESS;
			} else {
				return "fail";
			}
		} else {
			return "fail";
		}

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
