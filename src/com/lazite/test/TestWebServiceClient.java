package com.lazite.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;



import org.junit.Test;

import com.lazite.assist.webservice.request.Client;
import com.lazite.assist.webservice.request.ClientParameters;


public class TestWebServiceClient {
	
	   @Test
	   public void getClientReturn(String[] args) {
	 
		   String ss=new Client(
				   new ClientParameters("http://223.68.197.250:82/admin/services/ThirdPartyService?wsdl",
						   				"http://webservice.dhsoft.com",
						   				"getCarOutInInfo",
						   				new Object[]{}))
		   .clientReturn();
		   
		   System.out.println(ss);
	   }
	   
	  
}
