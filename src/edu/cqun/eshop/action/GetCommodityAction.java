package edu.cqun.eshop.action;

import java.io.UnsupportedEncodingException;
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
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.*;
import edu.cqun.eshop.service.CommodityManagerService;

public class GetCommodityAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	private ICommodityManagerService commodityService;

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private List<Category> category;
	private String goodsId;
	private String goodsName;
	
	public String getGoodsId() {
		System.out.println("*****************************"+goodsId+":"+goodsName+"*****************************");
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		System.out.println("*****************************"+goodsId+":"+goodsName+"*****************************");
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	@Override
	public String execute() {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		
		category=commodityService.getCategories();
		
		String testString=goodsId;
		Commodity example = new Commodity();
		if(goodsId!=null&&!goodsId.equals("")){
		long commodityId=Long.parseLong(goodsId);
		System.out.println("+++++================="+commodityId+"+++++==================");
		example.setCommodityId(commodityId);
		}
<<<<<<< HEAD
		if(goodsName!=null&goodsName!=""){
			example.setName(goodsName);
		}
		att.put("commodities", commodityService.getCommodities(example));
=======

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goodsName = request.getParameter("goodsName");
		if(goodsName!=null & goodsName!=""){
			example.setName(goodsName);
		}
		List<Commodity> result=commodityService.getCommodities(example);
		System.out.println("_________________________________________________________");
		for (Commodity commodity : result) {
			System.out.println(commodity.getName());
		}
		System.out.println("_________________________________________________________");

		att.put("commodities", result );
		att.put("category",category);

>>>>>>> e111409249275346a0e4d98a9d4ea50f0c4efbbe
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
