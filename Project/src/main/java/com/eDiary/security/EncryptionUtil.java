package com.eDiary.security;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//public class EncryptionUtil {
//	
//	public static String getEncodedPassword(String password) {
//		BCryptPasswordEncoder bce = new BCryptPasswordEncoder();
//		return bce.encode(password);
//	}
//
//	public static boolean validatePassword(String password, String encodedPassword) {
//		BCryptPasswordEncoder bce = new BCryptPasswordEncoder();
//		// menjamo zbog baze podataka
//		String replaceEncodedPassword = encodedPassword.replace("{bcrypt}", "");
//		return bce.matches(password, replaceEncodedPassword);
//	}
//	
//	public static void main(String[] args) {
//		//System.out.println(getEncodedPassword("sifra"));
//		System.out.println(validatePassword("sifra", "{bcrypt}$2a$10$dXsb1AX.M43805Kh4dzOJu/GO56oMsb5VkW2CJzG6wekuu7UFYAke"));
//	}
//}
// $2a$10$pdhtjEp3n4yyVdeeyU8Ng.gLEPT2oZxFAV2itZiT3e6DB6PF9Hrj6
// $2a$10$G0zNnXOXiJwmQ4X8Cm2OKujbX5Dk24xxoUC1Bhxah3TDwv/Ur9myG