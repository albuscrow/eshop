package edu.cqun.eshop.service;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Test;

public class StaticsServiceTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		System.out.println(timestamp.getYear()+1900);
		System.out.println(timestamp.getDate());
		System.out.println(timestamp.getMonth()+1);
		System.out.println(timestamp.getDay());
	}
	
	
}
