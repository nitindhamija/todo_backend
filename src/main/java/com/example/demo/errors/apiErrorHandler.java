package com.example.demo.errors;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class apiErrorHandler extends DefaultResponseErrorHandler{
	
	 @Override
	  public void handleError(ClientHttpResponse response) throws IOException {
	    // your error handling here
		 if(response.getRawStatusCode()==401)
			 System.out.println("token expired");
	  }
}
