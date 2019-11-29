package bshow.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encryptdecrypt {
	public static Cipher ciph=null;
	public static String encrypt(String s) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		String miwen=null;
		md.update(s.getBytes());
		miwen=new String(md.digest());
		return decrypt(miwen);
		
	}
	
	private static String decrypt(String s) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		String miwen=null;
		md.update(s.getBytes());
		miwen=new String(md.digest());
		return miwen;
	}
}
