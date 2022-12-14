package com.myspring.pro27.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
  
	/*main.do로 요청시 컨트롤러에서는 definion 태그에서 설정한 뷰이름 main을 타일즈 뷰리졸버로 반환 */
  @RequestMapping(value = "/main.do", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {   
    return "main";
  }
}


//다국어 기능 코드
/*
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}
}

*/