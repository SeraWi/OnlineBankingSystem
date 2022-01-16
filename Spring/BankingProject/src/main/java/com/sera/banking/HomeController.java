package com.sera.banking;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sera.banking.domain.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, 
			HttpServletRequest request,
			Model model) {
		
		
		// 사용자 정보 userName, userIdx
		UserVo userVo = new UserVo("mia123456",4);
				
		// 세션에 저장
		request.getSession().setAttribute("userVo", userVo);
		
		
		return "home";
	}
	
}
