package test.kr.swdl.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.CustomerDAO;
import kr.swdl.model.DBCP;

public class CustomerDAOTest {
	private static Connection conn;

	@BeforeClass
	public static void 클래스_사전동작() throws SQLException {
		conn = DBCP.getConnection();
		System.out.println("클래스_사전동작-select 공통 코드");
	}

	@Test
	public void 고객정보_이름_가져오기() throws SQLException {
		CustomerDAO dao = new CustomerDAO(conn);
		assertEquals(dao.getCustomer(21), "홍길동");
	}

	@Test
	public void 고객정보_이름_없는_경우() {
		CustomerDAO dao = new CustomerDAO(conn);
		assertNull(dao.getCustomer(1));
	}
	
	
	@Test
	public void 고객등록_성공 () throws SQLException {
		conn.setAutoCommit(false);
		CustomerDAO dao = new CustomerDAO(conn);
		assertTrue(dao.addCustomer("이원규", "010-5555-5555"));
		
		conn.rollback();
		 conn.setAutoCommit(true);
	}
	//DAO와 Service단에서 테스트할 것이 나뉜다고!
}
