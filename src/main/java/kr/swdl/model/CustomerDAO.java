package kr.swdl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	private Connection conn;
	//원하는대로 추가 - overloading ==> 메모리에서 처리
	public CustomerDAO(Connection conn) {  //service
		this.conn=conn;
	}
	//refactoring 이슈가 적다 - 인터페이스 수정
	public String getCustomer( int customerId ) {		
		String name=null;
		try {
			PreparedStatement pstmt=conn.prepareStatement(
					Query.GET_CUSTOMER);
			pstmt.setInt(1, customerId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) name=rs.getString(1);
			rs.close();
			pstmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return name;
	}
}
