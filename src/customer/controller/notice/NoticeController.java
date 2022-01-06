package customer.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import costomer.dao.NoticeDao;
import costomer.vo.Notice;
import customer.controller.Controller;

public class NoticeController implements Controller{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("<NoticeController>");
		
		NoticeDao dao=new NoticeDao();
		List<Notice> list=dao.noticeSelAll();
		
		//saving List<Notice> on request
		request.setAttribute("list", list);
		request.getRequestDispatcher("notice.jsp").forward(request, response);
		
	}
	
}
