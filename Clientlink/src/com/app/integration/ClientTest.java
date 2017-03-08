package com.app.integration;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class ClientTest 
{
	

	public static void main(String[] args)
	
	{
		
		try
		{
			
			//create empty client object
			Client  client=Client.create();
			// add resource on clinet object request to be where to send it returns WebResource
			
			String url= "http://localhost:2017/serverprovider/rest/do/die";
			String s3="";
			String json="{\"stuName\":\"manoj\",\"stuNo\":12,\"stuMarks\":24}";
			
			WebResource rs=client.resource(url);
			
			// call get or post method on WebResource then only request sent to ServiceProvider application
			// its service provider returns ClientResponse Object it contains Entity object and status
		ClientResponse cr	=rs.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,json);
			//now get entity object from clientResponse
		String s=cr.getEntity(String.class);
			System.out.println(s);
			int x=cr.getStatus();
			System.out.println(x);
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		
	}
	
	
	
	

}
