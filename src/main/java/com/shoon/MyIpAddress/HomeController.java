package com.shoon.MyIpAddress;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {

		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}

		System.out.println("X-Forwarded-For : "+ ip);
		System.out.println("Proxy-Client-IP : "+ request.getHeader("Proxy-Client-IP"));
		System.out.println("WL-Proxy-Client-IP : "+ request.getHeader("WL-Proxy-Client-IP"));
		System.out.println("HTTP_CLIENT_IP : "+ request.getHeader("HTTP_CLIENT_IP"));
		System.out.println("HTTP_X_FORWARDED_FOR : "+ request.getHeader("HTTP_X_FORWARDED_FOR"));
		System.out.println("getRemoteAddr : "+ request.getRemoteAddr());
		
		model.addAttribute("ip", ip);
		
		return "home";
	}
	
}
