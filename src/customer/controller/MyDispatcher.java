package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.notice.NoticeController;

public class MyDispatcher extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("signsign");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		
		System.out.println("uri : "+uri);
		System.out.println("conpath : "+conPath);
		System.out.println("com : "+com);
		
	
		
		Controller controller=null;
		
		//making the controller by the requested process
		//controller
		try {
			 if(com.equals("/customer/notice.do")) {
				controller=new NoticeController();
				}
			controller.execute(request,response);
		}catch(Exception e) {
			
		}
		
	}

}
