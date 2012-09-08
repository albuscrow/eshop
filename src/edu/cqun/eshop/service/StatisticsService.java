package edu.cqun.eshop.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.Result;

import edu.cqun.eshop.Iservice.IStatisticsService;
import edu.cqun.eshop.dao.ImportListDAO;
import edu.cqun.eshop.dao.OtherPayDAO;
import edu.cqun.eshop.dao.SalesRecordDAO;
import edu.cqun.eshop.domain.ImportList;
import edu.cqun.eshop.domain.OtherPay;
import edu.cqun.eshop.domain.SalesRecord;

@Transactional
@Service("statisticsService")
public class StatisticsService implements IStatisticsService{

	@Autowired
	private SalesRecordDAO salesRecordDAO;
	@Autowired
	private ImportListDAO importListDAO;
	@Autowired
	private OtherPayDAO otherPayDAO;
	
	private String startTime = "00:00:00";
	private String endTime = "23:59:59";
	
	@Override
	public double getDailyProfit(Timestamp time) {
		// TODO Auto-generated method stub
		String dateString = getDate(time);
		String start = dateString + " " + startTime;
		String end = dateString + " " + endTime;
		List<SalesRecord> salesRecords_needed = salesRecordDAO.
				getOverallSalesByPeriod(Timestamp.valueOf(start), Timestamp.valueOf(end));
		double profit = originProfitCal(salesRecords_needed);
		List<ImportList> importLists_needed = importListDAO.
				getOverallImportByPeriod(Timestamp.valueOf(start), Timestamp.valueOf(end));
		double importCost = importCostCal(importLists_needed);
		double result = profit - importCost;
		return result;
	}

	@Override
	public double getMonthProfit(Timestamp time) {
		// TODO Auto-generated method stub
		String dateString = getMonth(time);
		String start = dateString + "-" + "01" + " " + startTime;
		String end = dateString + "-" + "31" + " " + endTime;
		return finalProfitCal(start, end);
	}

	@Override
	public double getYearProfit(Timestamp time) {
		// TODO Auto-generated method stub
		String dateString = getYear(time);
		String start = dateString + "-" + "01" + "-" + "01" + " " + startTime;
		String end = dateString + "-" + "12" + "-" + "31" + " " + endTime;
		return finalProfitCal(start, end);
	}

	@Override
	public double getPeriodProfit(Timestamp start, Timestamp end) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startString = df.format(start)+ " " +startTime;
		String endString = df.format(end)+ " " +endTime;
		return finalProfitCal(startString, endString);
	}
	
	public double finalProfitCal(String start,String end){
		List<SalesRecord> salesRecords_needed = salesRecordDAO.
				getOverallSalesByPeriod(Timestamp.valueOf(start), Timestamp.valueOf(end));
		double profit = originProfitCal(salesRecords_needed);
		List<ImportList> importLists_needed = importListDAO.
				getOverallImportByPeriod(Timestamp.valueOf(start), Timestamp.valueOf(end));
		double importCost = importCostCal(importLists_needed);
		List<OtherPay> otherPays_needed = otherPayDAO.
				getOverallOtherPayByPeriod(Timestamp.valueOf(start), Timestamp.valueOf(end));
		double otherCost = otherPayCal(otherPays_needed);
		double result = profit - importCost - otherCost;
		return result;
	}
	
	public double otherPayCal(List<OtherPay> list){
		double otherCost = 0;
		for(OtherPay otherPay: list){
			otherCost += otherPay.getAmount();
		}
		return otherCost;
	}
	
	public double importCostCal(List<ImportList> list){
		double importCost = 0;
		for(ImportList importList: list){
			importCost += importList.getPrice()*importList.getQuantity();
		}
		return importCost;
	}
	
	public double originProfitCal(List<SalesRecord> list){
		double total = 0;
		for(SalesRecord salesRecord: list){
			total += salesRecord.getAmount();
		}
		return total;
	}
	
	public String getDate(Timestamp time){
		int yearnum = time.getYear()+1900;
		int mouthnum = time.getMonth()+1;
		int daynum = time.getDate();
		String year = yearnum + "";
		String mouth = mouthnum + "";
		String day = daynum + "";
		if(mouthnum<10){
			mouth = "0"+mouth;
		}
		if(daynum<10){
			day = "0"+day;
		}
		String resultString = year + "-" + mouth + "-" + day;
		return resultString;
		
	}
	
	public String getMonth(Timestamp time){
		int yearnum = time.getYear()+1900;
		int mouthnum = time.getMonth()+1;
		String year = yearnum + "";
		String mouth = mouthnum + "";
		if(mouthnum<10){
			mouth = "0"+mouth;
		}
		String resultString = year + "-" + mouth;
		return resultString;
	}
	
	public String getYear(Timestamp time){
		int yearnum = time.getYear()+1900;
		String year = yearnum + "";
		String resultString = year;
		return resultString;
	}

	
	
}
