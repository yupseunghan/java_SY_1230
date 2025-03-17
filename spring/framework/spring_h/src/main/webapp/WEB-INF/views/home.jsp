<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- 
서버에서 보낸 데이터를 처리할 떄는 $`{화면에서사용할이름}을 이용하여 활용
-단 주석에서도 인식 되기 때문에 주석에서 조심힘 작성.
 -->
<P>  서버에서 보낸 제 이름은 ${name} 입니다. </P>
<a href="/spring?name=abc&age=10">서버로 name 값을 전송</a>
<br>
<a href="/spring/send?name=abc&age=10">서버로 name 값을 전송</a>
<form action="/spring/send" method="post">
	<h1>form 태그를 이용하여 get방식으로 전송</h1>
	<input type="text" name="name" placeholder="이름을 입력하세요">
	<br>
	<input type="number" name="age" placeholder="나이를 입력하세요">
	<br>
	<button type="submit">전송</button>
</form>
<h1>url 경로에 데이터 보내기</h1>
<a href="/spring/홍길동/10">url 경로에 데이터 보내기</a>
<script type="text/javascript">
	let name1 ="${name}";
	console.log=name1;
</script>
</body>
</html>
