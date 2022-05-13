package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.entity.Car;

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
    	
    	// ここに必要な処理を記述してください。
    	request.setCharacterEncoding("UTF-8");
    	String carName = request.getParameter("carName");
    	String bodyColor = request.getParameter("bodyColor");
    	String maxSpeed = request.getParameter("maxSpeed");
    	int maxSpeed_int = Integer.parseInt(maxSpeed);
    	
    	Car c = new Car(carName, bodyColor,maxSpeed_int);
    	
    	
    	request.setAttribute("car", c);
    	request.setAttribute("latestCar", c);
        // 結果画面へ遷移
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
