<%--
  GameAppクラス作成後、下記の記述が必要です。
  <%@ page import="app.GameApp"%>
 --%>

<%@ page import="app.GameApp"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <% --%>
<!--     request.setCharacterEncoding("UTF-8"); -->
<!--     String name = request.getParameter("name"); -->

<!--     String result = "未実施"; -->
<!-- 	GameApp g1 = new GameApp("何か"); -->
<!--     if (name != null && !name.isEmpty()) { -->
<!--     	// このif分の中で、GameAppクラスのstartメソッドを呼び出し、 -->
<!--     	// 戻り値をresultに代入してください。 -->
<!--     	result = g1.start(name);  -->
<!--     } -->
<!-- %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題1</title>
<style>
body {
  border: solid 2px #000080;
  padding: 5px;
}

.result {
  background: #fffacd;
  display: inline-block;
  margin: 5px;
  padding: 10px;
}
</style>
</head>
<body>

  <h1>Java応用 - 演習問題2</h1>

  <h2>ゲームアプリ実行ページ</h2>

  
  <c:if test="${not empty result and result != \"未実施\"}">
   <div class="result">
    <h3>アプリの実行結果</h3>
    <p>${result}</p>
    </div>
   </c:if>
  

  <form action="StartAppServlet" method="post">
    <label>ユーザ名：</label>
    <input type="text" name="name">
    <br>
    <button type="submit">実行</button>
  </form>
</body>
</html>