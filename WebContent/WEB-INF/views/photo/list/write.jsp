<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ㅇ_ ㅇㅋ</h1>
<form method="POST" action="/photo/write.jsp" enctype="multipart/form-data">
제목 : <input type="text" name="pbTitle">
내용 : <textarea name="pbContent"></textarea> 
파일 : <input type="file" name="pbFile">
<button>글쓰기</button>
</form>
</body>
</html>