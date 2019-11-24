package bshow.test;

import org.apache.log4j.Logger;

public class Test {
	
	private static final Logger log = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		
		try {
			int a = 4 / 0;
		} catch (Exception e) {
			log.debug(e);
		}
		
	}
}
