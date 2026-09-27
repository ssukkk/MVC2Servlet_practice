<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 xxx관리자님 <a href="#">로그아웃</a> <br>
 
 <h1>고객등록</h1>
 <form action = "controller?cmd=addCustomerAction" method="post">
 	고객이름<input name="name"> <br>
 	고객 전화번호 <input name="phoneNumber"> <br>
 	<input type = "submit" value="등록">
  </form>
</body>
</html>