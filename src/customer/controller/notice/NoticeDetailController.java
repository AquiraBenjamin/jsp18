package customer.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import costomer.dao.NoticeDao;
import costomer.vo.Notice;
import customer.controller.Controller;

public class NoticeDetailController implements Controller{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("<NoticeDetailController>");
		String seq=request.getParameter("c");
		String hit=request.getParameter("h");
		
		NoticeDao dao=new NoticeDao();
		Notice n=dao.getNotice(seq,hit);
		
		//saving List<Notice> on request
		request.setAttribute("n", n);
		
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);
		
	}
	
}
