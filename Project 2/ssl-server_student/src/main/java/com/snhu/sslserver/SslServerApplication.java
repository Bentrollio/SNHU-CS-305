/*
 * Alex Baires
 * CS-305 Software Security
 * Module 7-1 Project
 * 
 * 6/23/2024
 * 
 */

package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}
}

@RestController
class ServerController {

	/**
	 * bytesToHex
	 *
	 * @param bytes - A byte array that will be converted into a HexString
	 * @return hex - A string containing the HexString converted message as output.
	 */
	
	 public String bytesToHex(byte[] bytes) {
		String hex;

		// Converts byte array into HexString object
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

		String checkSum ="";
		// Create Message Digest
		try {
			MessageDigest md = MessageDigest.getInstance("SHA3-384");

			// Pass data to the created MessageDigest object
			md.update(userData.getBytes());

			// Computes the message digest
			byte[] digest = md.digest();

			checkSum = bytesToHex(digest);

		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}

		// Create Message Digest
		return checkSum;
	 }
	 
	@RequestMapping("/hash")
	public String myHash() {

		String data = "Artemis Financial, developed by Alex Baires";

		return "<p>Static data: " + data + "<p>SHA3-384 Checksum Value: " + generateCheckSum(data);
	}

}