package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.entity.Car;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
    	ArrayList<Car> historyList = new ArrayList<Car>();
  
    	request.setCharacterEncoding("UTF-8");
    	String bodyColor = request.getParameter("bodyColor");
    	String speed = request.getParameter("speed");
    	int speed_int = Integer.parseInt(speed);
    	Car preCar = (Car) request.getAttribute("car");
    	Car latestCar = null;
    	try {
    		latestCar = new Car( preCar.getCarName(), bodyColor, preCar.getMaxSpeed(), speed_int);
    	} catch (NullPointerException e) {
    		e.printStackTrace();
    	}
    	historyList.add(preCar);
    	historyList.add(latestCar);
    	request.setAttribute("hisotryList", historyList);
    	request.setAttribute("car", latestCar);
        // 結果画面へ遷移
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }
}
