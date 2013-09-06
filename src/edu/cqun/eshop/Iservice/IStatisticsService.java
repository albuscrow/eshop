package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;

public interface IStatisticsService {
	
	/**
	 * 返回日利润
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
	
	/**
	 * 返回一段时间的利润
	 * @param time
	 * @return
	 */
	double getPeriodProfit(Timestamp start,Timestamp end);
}
