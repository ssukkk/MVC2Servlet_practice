package kr.swdl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public boolean addCustomer(String name, String phoneNumber) {
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.ADD_CUSTOEMR);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			//신규 등록 성공여부 확인
			result = pstmt.executeUpdate() ==1; //executeUpdate()가 1 true
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}
	
	
	public int getCustomerId() {
		int customerId = 0; //초기값 세팅. 개발자가 보려는 임의 숫자 넣기 ; 0, -1
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Query.GET_CUSTOEMR_ID);
			rs.next();
			customerId = rs.getInt(1);
			//안 가리키다가 다음 번지 가리키면, 그때 불러와진 ID가 존재하면, 그 값을 불러오겠다
			//첫번째 번지에서 가져와~ rs.getInt(1)
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerId;
	}
	
	public boolean updatePoint(int point, int customerId) {
		//update가 되었냐 안 되었냐 판별을 return으로 갖고 싶음
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(Query.UPDATE_POINT);
			pstmt.setInt(1, point);
			pstmt.setInt(2, customerId);
			result = pstmt.executeUpdate() ==1;
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
			
	}
}
