package costomer.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tech.db.DBcon;

//Data Access Object from here get the values from db and put those on Notice and return Notice type object 'n' to noticeDetail or noticeEdit  
import costomer.vo.Notice;
import customer.db.DBCon;

public class NoticeDao {
	
	//the notices have multiple rows of record so List is needed
	public List<Notice> noticeSelAll() throws Exception {
		//think elastically you can put variable in between String
		String sql="select * from notices order by to_number(seq) desc";
		//String sql="select * from notices where "+field+" like ? order by to_number(seq) desc";
		//dbcon
		Connection con=DBcon.getConnection();
		//execute
		PreparedStatement pstmt=con.prepareStatement(sql);
		

		//result
		ResultSet rs=pstmt.executeQuery();
		
		//putting Notice records on List
		List<Notice> list=new ArrayList<Notice>();
		while(rs.next()) {
			Notice n=new Notice();
			n.setSeq(rs.getString("seq"));
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			n.setRegdate(rs.getDate("regdate"));
			n.setHit(rs.getInt("hit"));
			n.setContent(rs.getString("content"));
			list.add(n);
		}
		rs.close();
		pstmt.close();
		con.close();
		return list;
	}

	public Notice getNotice(String seq, String hit) throws Exception { // 글번호에 맞는 Notice를 리턴받기	
		
		String sql = "SELECT * FROM notices WHERE seq=" + seq;
		Connection con=DBcon.getConnection();
		// 실행
		Statement st = con.createStatement();
		// 결과
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		// Notice에 select 결과물 담아보기
		Notice n = new Notice();
		n.setSeq(rs.getString("seq")); // DB에가 가져온 rs의 seq를 가져와서 Notice에 담기
		n.setWriter(rs.getString("writer"));
		n.setTitle(rs.getString("title"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));

		rs.close();
		st.close();
		con.close();

		return n; // n에 데이터를 다 입력받은 후 Notice타입인 n을 리턴
	}
	
}