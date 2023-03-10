package com.eDiary.security;

//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
//
//	@Override
//	public void afterPropertiesSet() {
//		this.setRealmName("DeveloperStack");
//		super.afterPropertiesSet();
//	}
//
//	// UNATHORIZED
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException {
//		// response realm header
//		response.addHeader("WWW-AUTHENTICATE", "Basic realm = " + this.getRealmName());
//		// response status
//		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
//		// response body
//		PrintWriter writer = response.getWriter();
//		writer.println("HTTP Status 401 - " + authException.getMessage());
//	}
//}
