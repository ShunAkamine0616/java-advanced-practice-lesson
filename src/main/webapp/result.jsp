<%@ page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%
  //必要な処理を記述してください。
  // セッションで保存
  	request.setCharacterEncoding("UTF-8");
  	if(session.getAttribute("num_user") == null) {
  		session.setAttribute("num_user", 0);
  	}
  	User[] users1 = new User[5];
  	if(session.getAttribute("users") == null) {
  		session.setAttribute("users", users1);
  	}
	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String age = request.getParameter("age");
	int age_int = 0;
	if(!age.isEmpty() && !age.equals(null)) {
		age_int = Integer.parseInt(age);
	}
	int num_user = (int) session.getAttribute("num_user");
	User[] users = (User[]) session.getAttribute("users");
	num_user++;
	
	String result = "";
	
// 	User[] users = new User[6];
// 	User u1 = null;
	User u1 = new User(userId, userName, age_int);
	for(int i = 0; i < users.length; i++) {
		if(users[i] == null) {
			users[i] = u1;
			break;
		}
	}
	if (num_user < 5) {
		// セッションを保存
		session.setAttribute("num_user", num_user);
		session.setAttribute("users", users);
		result = "ユーザーを登録しました";
	} else {
		result = "これ以上ユーザーを登録できません";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題1(発展)</title>
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

a.button {
    background-color: #ddeeff;
    border: 1px solid #ccc;
    padding: 5px;
    cursor: pointer;
}
</style>
</head>
<body>

  <h1>Java応用 - 演習問題1(発展)</h1>

  <h2>登録結果</h2>

  <div class="result">
    <h3>実行結果</h3>
    <p><%=result%></p>
  </div>

  <p>

    <span>現在の登録ユーザー</span><br>

    <%
        // 現在のユーザー情報を表示
        for (User tempUser : users) {
            if (tempUser != null) {
                // ユーザー情報を取得
                // todo:
                // 現在は変数のみ定義している。
                // Userクラスの情報取得用メソッドを呼んだ値をセットするように修正。
                String msg = tempUser.returnUserInfo();

                // ユーザー情報表示
                out.println(msg);
                out.println("<br>");
            } 
        }
    %>
  </p>

  <form action="input.jsp">
    <button type="submit" name="btn" value="back">戻る</button>
    <button type="submit" name="btn" value="reset">リセット</button>
  </form>
</body>
</html>