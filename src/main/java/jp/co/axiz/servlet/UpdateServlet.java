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
		HttpSession session = request.getSession(true);
		// ここに必要な処理を記述してください。
		@SuppressWarnings("unchecked")
		ArrayList<Car> historyList = (ArrayList<Car>) session.getAttribute("historyList");

		//    	Car c = (Car) session.getAttribute("car");
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("btn");
		String bodyColor = request.getParameter("bodyColor");
		String speed = request.getParameter("speed");
		Car nowCar = (Car) session.getAttribute("nowCar");
		String result = "車体の色と現在速度を変更しました。";

		if(btn.equals("back")) {
			request.getRequestDispatcher("input.jsp").forward(request, response);
		} else if(Utility.isNullOrEmpty(bodyColor) || Utility.isNullOrEmpty(speed)) {
			result = "未入力の項目があります。";
			request.setAttribute("result", result);
			session.setAttribute("nowCar", nowCar);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} else {

			int speed_int = 0;
			try {
				speed_int = Integer.parseInt(speed);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			Car c = null;
			try {
				c = new Car(nowCar.getCarName(), bodyColor, nowCar.getMaxSpeed(), speed_int);
				historyList.add(c);

				session.setAttribute("hisotryList", historyList);
				session.setAttribute("nowCar", c);
				request.setAttribute("result", result);
				// 結果画面へ遷移
				request.getRequestDispatcher("update.jsp").forward(request, response);
			} catch (Exception e) {
				c = new Car();
				c.setCarName(nowCar.getCarName());
				c.setBodyColor(bodyColor);
				c.setMaxSpeed(nowCar.getMaxSpeed());
				c.setSpeed(nowCar.getSpeed());
				historyList.add(c);

				session.setAttribute("hisotryList", historyList);
				session.setAttribute("nowCar", c);
				request.setAttribute("result", result);
				e.printStackTrace();
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
		}
	}
}
