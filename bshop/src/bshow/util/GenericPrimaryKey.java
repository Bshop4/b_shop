package bshow.util;

import java.util.Random;
import java.util.UUID;

/**
 * UUID生成
 * @author Administrator
 *
 */
public class GenericPrimaryKey {
	
	public static String getPrimaryKey(){
		return UUID.randomUUID().toString();
		
	}
}
