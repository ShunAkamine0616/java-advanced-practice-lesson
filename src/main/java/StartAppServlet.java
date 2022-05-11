

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CardGameApp;
import app.ClockApp;
import app.DartsGameApp;
import app.GameApp;
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
	    String app = request.getParameter("app"); 
	    String result = "未実施"; 
	    GameApp g;
	    ClockApp c;
	    
	    if(app.equals("トランプ")) {
	    	g = new CardGameApp(app); 
	    	result = g.start(name);
	    } else if(app.equals("ダーツ")) {
	    	g = new DartsGameApp(app);
	    	result = g.start(name);
	    } else if(app.equals("時計")) {
	    	c = new ClockApp();
	    	result = c.start(name);
	    } else if(app.equals("その他")) {
	    	result = "アプリの実行に失敗しました。";
	    }
	    
	    
//	    request.setAttribute("app", app); //　appをスコープに保存
//	    GameApp g = new CardGameApp(app); 
//	    if (name != null && !name.isEmpty()) {
//	     	// このif分の中で、GameAppクラスのstartメソッドを呼び出し、 -->
//	     	// 戻り値をresultに代入してください。 -->
//	     	result = g.start(name);  
//	    } 
	    
	    request.setAttribute("result", result);
	    request.getRequestDispatcher("/appStart.jsp").forward(request, response);
	}

}
