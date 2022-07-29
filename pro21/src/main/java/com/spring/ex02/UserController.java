package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		String viewName = getViewName(request); // request->도메인 요청 (Https://localhost ...)

		ModelAndView mav = new ModelAndView();  
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		
		// ModelandView 에 로그인 정보를 집어 넣음(바인딩)
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		// mav.setViewName("result");  // ModelandView 객체에 포워딩할 JSP 이름.
		mav.setViewName(viewName); // 뷰이름을 지정
		System.out.println("ViewName:" + viewName);
		return mav;
	}
	
	
		 // 항목 하나 추가 된 것 외에 다를 게 없다.
		public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
		    ModelAndView mav=new ModelAndView();
		    String id=request.getParameter("id");
		    String pwd=request.getParameter("pwd");
		    String name=request.getParameter("name");
		    String email=request.getParameter("email");

		    mav.addObject("id",id);
		    mav.addObject("pwd",pwd);
		    mav.addObject("name",name);
		    mav.addObject("email",email);
		    mav.setViewName("memberInfo");
		    return mav;
		
	}
		
		
		public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = getViewName(request);
			return new ModelAndView(viewName); // ModelAndView = JSP 띄워라.
							
		}
		
		public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = getViewName(request);
			return new ModelAndView(viewName); // ModelAndView = JSP 띄워라.
							
		}
		
		private  String getViewName(HttpServletRequest request) throws Exception {
		      String contextPath = request.getContextPath(); 
		      // request.getContextPath(); -> 프로젝트 명을 가져온다
		//      System.out.println("contextPath:" + contextPath); 
		      
		      String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		//      System.out.println("uri:" + uri);
		      
		      if(uri == null || uri.trim().equals("")) {
		         uri = request.getRequestURI();
		      }
		//      System.out.println("uri:" + uri);

		      int begin = 0;
		      // contextPath(프로젝트 길이)에 내용(length)이 있으면 begin에 길이의 갯수를 넘겨라 
		      if(!((contextPath==null)||("".equals(contextPath)))){
		         begin = contextPath.length();
		//         System.out.println("begin:" + begin);
		      }

		      int end; // 쿼리스트링 
		      if(uri.indexOf(";")!=-1){ // indexOf -> 몇번째에 있는지 위치 찾는 함수
		         end=uri.indexOf(";");
		      }else if(uri.indexOf("?")!=-1){
		         end=uri.indexOf("?");
		      }else{
		         end=uri.length();
		      }
		//      System.out.println("end:" + end);
		    
		      
		      String fileName=uri.substring(begin,end);
		      if(fileName.indexOf(".")!=-1){
		         fileName=fileName.substring(0,fileName.lastIndexOf("."));
		      }
		      if(fileName.lastIndexOf("/")!=-1){
		         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
		      }
		//      System.out.println("fileName" + fileName);
		      return fileName;
		   }
}
