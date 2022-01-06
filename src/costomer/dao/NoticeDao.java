package costomer.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tech.db.DBcon;

//Data Access Object from here get the values from db and put those on Notice and return Notice type object 'n' to noticeDetail or noticeEdit  
import costomer.vo.Notice;

public class NoticeDao {
	
	//the notices have multiple rows of record so List is needed
	public List<Notice> noticeSelAll(String field, String query) throws Exception {
		//think elastically you can put variable in between String
		//String sql="select * from notices order by to_number(seq) desc";
		String sql="select * from notices where "+field+" like ? order by to_number(seq) desc";
		//dbcon
		Connection con=DBcon.getConnection();
		//execute
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "%"+query+"%");

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
	
}