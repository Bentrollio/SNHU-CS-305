/*
 * Alex Baires
 * CS-305 Software Security
 * Module 5-1 Assignment: Checksum Verification
 * 
 * 6/9/2024
 * 
 */

package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

@RestController
class ServerController{
	
	/**
	 * bytesToHex
	 *
	 * @param bytes - A byte array that will be converted into a HexString
	 * @return hex - A string containing the HexString converted message as output.
	 */
	
	
	public String bytesToHex(byte[] bytes) {
		String hex = ""; // Initialize the local variable
		
		// Converts the byte array into HexString object
		StringBuffer hexString = new StringBuffer();
		
		for (int i = 0; i < bytes.length; ++i) {
			hexString.append(Integer.toHexString(0xFF & bytes[i]));
		}
		
		hex = hexString.toString();
		
		return hex;
	}
	
	/**
	 * generateCheckSum
	 * 
	 * Adapted from:
	 * https://www.tutorialspoint.com/java_cryptography/java_cryptography_message_digest.htm#:~:text=You%20can%20generate%20the%20message,digest%20using%20the%20digest%20method.
	 * 
	 * @param userData - A string to be converted into a SHA-256 checksum.
	 * @return checkSum - A string containing the HexString converted message as output.
	 */
	
	public String generateCheckSum(String userData) {
		
		String checkSum = "";
		
		// Create MessageDigest object
    	try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			// Pass data to the created MessageDigest object
			md.update(userData.getBytes());
			
			// Computes the message digest
			byte[] digest = md.digest();
			
			checkSum = bytesToHex(digest);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return checkSum;
	}
	
    @RequestMapping("/hash")
    public String myHash(){
    	
    	// Update 6-3 - Added student name.
    	String data = "Hello Alex Baires!";
    	
        return "<p>data: " + data + "<p>SHA-256: CheckSum Value: " + generateCheckSum(data);
    }
}
