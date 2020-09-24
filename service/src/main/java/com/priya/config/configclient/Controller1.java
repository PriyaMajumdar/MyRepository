package com.priya.config.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;


@RestController
@RequestMapping("demo")
public class Controller1 {
	@Autowired
	Demointerface serv;
	@RequestMapping("Hii")
	public void getRequest() {
		System.out.println("demo");
		serv.demo();
		
	}
	
	
	
	
	@PostMapping("login")
	public  void userLogin(@RequestHeader String username ,@RequestHeader String password , Http2 header) {
		
		
    System.out.println(username);
    System.out.println(password);
		
	
	}
	
	
	@PostMapping("login2")
	public  void userLogin2(@RequestHeader String username ,@RequestHeader String password , @RequestHeader String Authorization) {
		
		
		System.out.println("Header="+ Authorization);
		
		String username_and_password = Authorization.substring(6);
		System.out.println("username_and_password=="+username_and_password);
		
		
		
		
		
		Base64.Encoder enc = Base64.getEncoder();
        Base64.Decoder dec = Base64.getDecoder();
        
        String decoded = new String(dec.decode(username_and_password));
       
        
        
        int seprator =	decoded.indexOf(':');
        
        	
        System.out.println("Seperator = :"+ seprator);
        
   String username1 = decoded.substring(0, seprator);
   seprator++;
   String password1 = decoded.substring(seprator);
   
   System.out.println("username===="+username1);
   System.out.println("password===="+password1);
        
       
        
        System.out.println("decoded="+ decoded);
		
   
		
	
	}

	
	
	
	

}
