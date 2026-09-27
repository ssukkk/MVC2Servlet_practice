package kr.swdl.model;
//생성자가 없다. static final
public interface Query {
	String GET_CUSTOMER = "select name from customers where customer_no=3";
}
