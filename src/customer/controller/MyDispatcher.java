package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	
		
		
		
		//making the controller by the requested process
		/*try {
			if(com.equals("/customer/noticeDetail.do")) {
				
			}
			controller.execute(request,response);
		}catch(Exception e) {
			
		}*/
		
	}

}
