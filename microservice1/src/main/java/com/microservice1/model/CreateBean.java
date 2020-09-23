package com.microservice1.model;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class CreateBean {
	@Bean
	public PasswordEncoder  get() {
		return new BCryptPasswordEncoder();
		
	}
	  
	public String generatePassword(String password) {
        
            // Create MessageDigest instance for MD5
            MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
			
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            password = sb.toString();
			}
			catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				System.out.println("check 88: No such algorithm");
				e.printStackTrace();
			}
         
        
        System.out.println(password);

		
		
		
		
		
		return password;
		
	}
	
	
	
	
	

}
