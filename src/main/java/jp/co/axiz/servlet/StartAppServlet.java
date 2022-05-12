package jp.co.axiz.servlet;




import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.GameApp;
/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/StartAppServlet")
public class StartAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public StartAppServlet() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name"); 
		String item = request.getParameter("item"); 
		String result = "未実施"; 
		GameApp g;
		ClockApp c;
		App app = null;

		if(item.equals("トランプ")) {
			app = new CardGameApp(item); 
			result = app.start(name);
		} else if(item.equals("ダーツ")) {
			app = new DartsGameApp(item);
			result = app.start(name);
		} else if(item.equals("時計")) {
			app = new ClockApp();
			result = app.start(name);
		} else if(item.equals("その他")) {
			result = "アプリの実行に失敗しました。";
		}
		
		if(app instanceof GameApp) {
			GameApp gameApp = (GameApp) app;
			request.setAttribute("playTime", gameApp.getPlayTime());
			result += "<br><br> 実行時間：" + gameApp.getPlayTime() + "分";
		} 
		 
		request.setAttribute("result", result);
		request.getRequestDispatcher("/appStart.jsp").forward(request, response);
	}

}
