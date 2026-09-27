package test.kr.swdl.model;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import kr.swdl.model.CustomerService;
import kr.swdl.model.DBCP;

public class CustomerServiceTest {
	private static Connection conn;

	@BeforeClass
	public static void 클래스_사전동작() throws SQLException {
		conn = DBCP.getConnection();
		System.out.println("클래스_사전동작-select 공통 코드");
	}

	@Test
	public void 회원가입_성공() throws SQLException {
		conn.setAutoCommit(false);
		CustomerService service = new CustomerService();
		assertTrue(service.addCustomer("김민경", "010-4444-7777"));
		// boolean 값으로 반환하는 addCustomer 메서드는 생성 성공시 true 반환 -> assertTrue로 test
		conn.rollback();
		conn.setAutoCommit(true);
	}
	@Test
	public void 포인트_부여_성공() throws SQLException {
	conn.setAutoCommit(false);
	CustomerService service = new CustomerService();
	assertTrue(service.addCustomer("박건태", "010-9999-9999", 100));
	conn.rollback();
	conn.setAutoCommit(true);
}
}