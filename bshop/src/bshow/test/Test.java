package bshow.test;

import org.apache.log4j.Logger;

import bshow.pojo.Goods_table;

public class Test {
	
	private static final Logger log = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		
		try {
			int a = 4 / 0;
		} catch (Exception e) {
			log.debug(e);
		}
		
		Goods_table g1=new Goods_table();
		g1.setGoods_ban(11);
		System.out.println("g1"+g1.getGoods_ban());
		try {
			Goods_table g2=(Goods_table)g1.clone();
			
			System.out.println("g2old"+g2.getGoods_ban());
			g2.setGoods_ban(999);
			System.out.println("g2now"+g2.getGoods_ban());
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
