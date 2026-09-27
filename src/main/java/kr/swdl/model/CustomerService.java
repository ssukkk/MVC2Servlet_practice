package kr.swdl.model;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerService {
	// 회원 가입시 포인트 부여X
	public boolean addCustomer(String name, String phoneNumber) {
		try {
			return new CustomerDAO(DBCP.getConnection()).addCustomer(name, phoneNumber);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; // catch로 떨어지면 false로(정상 등록만 true, 외에는 false)
	}

	// 회원 가입시 포인트 OO
	public boolean addCustomer(String name, String phoneNumber, int point) {
		// 1. 회원가입, 2. 가입된 회원 정보 가져오기, 3. 포인트 부여
		boolean result = false;
		// 세 단계니까 result 선언! 미리 선언하면, try/catch 안에서 추가로 false 선언을 계~속 적을 필요가 없으니까. 미리
		// 박아둔다고
		Connection conn = null;
		try {
			conn = DBCP.getConnection();
			CustomerDAO dao = new CustomerDAO(conn);
			conn.setAutoCommit(false); // 오토커밋 끄기
			if (dao.addCustomer(name, phoneNumber)) { // 1.회원가입
				int currentCustomerId = dao.getCustomerId(); // 2.가입 정보 가져오기
				if (dao.updatePoint(point, currentCustomerId)) { // 3.포인트 부여
					result = true;
					conn.commit();
				}
				// 트랜젝션 관리를ㅜㅜㅜ 해줘야됨ㅜㅜㅜㅜ 끝이 아님ㅜㅜㅜㅜ
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				if (conn!= null)
					conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {

					conn.setAutoCommit(false);
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}
	// 포인트 정상적으로 들어갔냐를 확인해야하니까 void, boolean이 주로! 쓰임
}
