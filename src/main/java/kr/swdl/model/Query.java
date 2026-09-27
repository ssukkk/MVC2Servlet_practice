package kr.swdl.model;
//생성자가 없다. static final
//쿼리문은 다 스트링이다~~~~
public interface Query {
	String GET_CUSTOMER = "select name from customers where customer_no=?";
	String ADD_CUSTOEMR = "insert into CUSTOMERS(CUSTOMER_NO, NAME, PHONE_NO, IN_DATE) "
			+ "values (CUSTOMER_NO_SEQ.nextval, ?, ?, sysdate)"; //방금 넣었어!!!!
	String GET_CUSTOEMR_ID = "select CUSTOMER_NO_SEQ.currval from dual"; 
	String UPDATE_POINT = "update CUSTOMERS SET point= nvl(point,0) + ? where CUSTOMER_NO = ?";
}
