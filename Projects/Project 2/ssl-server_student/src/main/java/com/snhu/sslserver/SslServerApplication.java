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
import java.util.logging.Level;
import java.util.logging.Logger;

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

	// Logger taken from below tutorial:
		// https://www.digitalocean.com/community/tutorials/logger-in-java-logging-example

		private static final Logger logger = Logger.getLogger(ServerController.class.getName());

	/**
	 * bytesToHex
	 *
	 * @param bytes - A byte array that will be converted into a HexString
	 * @return hex - A string containing the HexString converted message as output.
	 */
	
	 public String bytesToHex(byte[] bytes) {
		String hex;

		// Converts byte array into HexString object
		StringBuilder hexString = new StringBuilder();

		for (int i = 0; i < bytes.length; ++i) {
			hexString.append(String.format("%02x", bytes[i]));
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
	 * @param userData - A string to be converted into a SHA-3-384 checksum.
	 * @return checkSum - A string containing the HexString converted message as output.
	 */

	 public String generateCheckSum(String userData) {

		if (userData.isEmpty()) { // Error handling and input validation
			logger.log(Level.WARNING, "User data is empty / Invalid");
			throw new IllegalArgumentException("User data must not be empty");
		}

		String checkSum ="";
		// Create Message Digest
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-384");

			// Pass data to the created MessageDigest object
			md.update(userData.getBytes());

			// Computes the message digest
			byte[] digest = md.digest();

			checkSum = bytesToHex(digest);

		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.SEVERE, "Algorithm not found/does not exist", e);
			throw new IllegalArgumentException("Algorithm not found/does not exist", e);
		}

		// Create Message Digest
		return checkSum;
	 }
	 
	@RequestMapping("/hash")
	public String myHash() {

		String data = null;// = "Artemis Financial, developed by Alex Baires";

		return "<p>Static data: " + data + "<p>SHA3-384 Checksum Value: " + generateCheckSum(data);
	}

	@RequestMapping("/")
	public String rootHandler() {
		return "<p>Error: Please provide a valid web address";
	}

}