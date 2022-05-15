package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.entity.Car;
import jp.co.axiz.util.Utility;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/inputServlet")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession(true);
    	// ここに必要な処理を記述してください。
    	ArrayList<Car> historyList = new ArrayList<Car>();
    	
    	request.setCharacterEncoding("UTF-8");
    	String carName = request.getParameter("carName");
    	String bodyColor = request.getParameter("bodyColor");
    	String maxSpeed = request.getParameter("maxSpeed");
    	String result;
    	
    	if(Utility.isNullOrEmpty(carName) || Utility.isNullOrEmpty(bodyColor) 
    			|| Utility.isNullOrEmpty(maxSpeed)) {
    		result = "未入力の項目があります。";
    		request.setAttribute("result", result);
    		request.getRequestDispatcher("input.jsp").forward(request, response);
    	}
    	int maxSpeed_int = 0;
    	try {
    		maxSpeed_int = Integer.parseInt(maxSpeed);
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
    	}
    	Car c = null;
    	try {
    		c = new Car(carName, bodyColor, maxSpeed_int);
    	} catch (Exception e) {
    		c = new Car();
    		c.setCarName(carName);
    		c.setBodyColor(bodyColor);
    		c.setMaxSpeed(0);
    		e.printStackTrace();
    	}
    	
    	historyList.add(c);
    	session.setAttribute("historyList", historyList);
    	session.setAttribute("nowCar", c);
//    	session.setAttribute("car", c);
        // 結果画面へ遷移
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
