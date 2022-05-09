<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>&lt;result.jsp&gt;　結果画面</h1>
	<c:if test="${ check == true}">
		<p>IDまたはPASSが間違っています</p>
	</c:if>
<form action="LoginServlet" method="post">
	<div class="box">
 		<label>ID：</label> <input type="text" name="id"> 
      		<c:if test="${ id_check == true}">
				<label>IDは必須です</label>
			</c:if><br>
      	<label>PASS：</label> <input type="text" name="pass">
      		<c:if test="${ pass_check == true}">
				<label>PASSは必須です</label>
			</c:if><br>
	</div>
 <button type="submit">ログイン</button>
  </form>
</body>
</html>