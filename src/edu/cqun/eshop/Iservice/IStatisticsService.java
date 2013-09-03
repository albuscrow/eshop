package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;

public interface IStatisticsService {
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	double getDailyProfit(Timestamp time);
	
	/**
	 * 返回月利润
	 * @param time
	 * @return
	 */
	double getMonthProfit(Timestamp time);
	
	/**
	 * 返回年利润
	 * @param time
	 * @return
	 */
	double getYearProfit(Timestamp time);
}
