package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	@RequestMapping(value = { "/test/loginForm.do", "/test/loginForm2.do" }, method = { RequestMethod.GET })
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
    @RequestMapping(value = "/test/login.do", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);

		return mav;
	}
/*
	@RequestMapping(value = "/test/login2.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login2(@RequestParam("userID") String userID,  //getParameter 사용 X
			                  @RequestParam("userName") String userName,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		
		// String userID = request.getParameter("userID");
		// String userName = request.getParameter("userName");
		
		System.out.println("userID: "+userID); // 콘솔출력
		System.out.println("userName: "+userName);
		mav.addObject("userID", userID); // 화면출력
		mav.addObject("userName", userName);

		return mav;
	}
*/	
	
	@RequestMapping(value = "/test/login2.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login2(
			@RequestParam("userID") String userID,                                
			@RequestParam(value="userName", required=true) String userName, //반드시 입력			                   
			@RequestParam(value="userEmail", required=false) String userEmail, // 입력 하거나 말거나
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		
		// String userID = request.getParameter("userID");
		// String userName = request.getParameter("userName");
		
		System.out.println("userID: "+userID);
		System.out.println("userName: "+userName);
		System.out.println("userEmail: "+ userEmail);
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		mav.addObject("userEmail", userEmail);
		return mav;
	}
	
	
	@RequestMapping(value = "/test/login3.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login3(@RequestParam Map<String, String> info,
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		String userID = info.get("userID");
		String userName = info.get("userName");
		System.out.println("userID: "+userID);
		System.out.println("userName: "+userName);
		
		mav.addObject("info", info); // Map -> addObject 한번만 사용한다 ( info 사용)
		mav.setViewName("result");
		return mav;
	}
	
	// @ModelAttribute 를 이용하여 데이터베이스 연결 ( VO )
	@RequestMapping(value = "/test/login4.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO,
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		System.out.println("userID: "+loginVO.getUserID());
		System.out.println("userName: "+loginVO.getUserName());
		mav.setViewName("result");
		return mav;
	}
	   
	@RequestMapping(value = "/test/login5.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login5(Model model,
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		// addAttribute() 이용하여 JSP 에서 전달할 값을 바로 바인딩
		model.addAttribute("userID", "hong");
		model.addAttribute("userName", "홍길동");
		return "result";
	}	
}
