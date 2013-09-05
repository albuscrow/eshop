package edu.cqun.eshop.Iservice;

import java.sql.Timestamp;

public interface IStatisticsService {
	
	/**
	 * ����������
	 * @param time
	 * @return
	 */
	double getDailyProfit(Timestamp time);
	
	/**
	 * ����������
	 * @param time
	 * @return
	 */
	double getMonthProfit(Timestamp time);
	
	/**
	 * ����������
	 * @param time
	 * @return
	 */
	double getYearProfit(Timestamp time);
	
	/**
	 * ����һ��ʱ�������
	 * @param time
	 * @return
	 */
	double getPeriodProfit(Timestamp start,Timestamp end);
}
