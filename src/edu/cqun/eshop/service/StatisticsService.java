package edu.cqun.eshop.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		double total = originProfit(salesRecords_needed);
		
		
		return total;
	}

	@Override
	public double getMonthProfit(Timestamp time) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public double getYearProfit(Timestamp time) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public double originProfit(List<SalesRecord> list){
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
}
