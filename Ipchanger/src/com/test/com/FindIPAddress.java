package com.test.com;
import java.net.InetAddress; 

public class FindIPAddress
{ 
	public static void main(String args[]) throws Exception 
	{ 
		InetAddress localhost = InetAddress.getLocalHost(); 
		System.out.println("System IP Address : " + (localhost.getHostAddress()).trim()); 
	} 
} 

