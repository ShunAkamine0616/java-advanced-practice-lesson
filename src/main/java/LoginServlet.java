

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
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
		String id =  request.getParameter("id");
		String pass =  request.getParameter("pass");
		request.setAttribute("id", id);
		
		request.setAttribute("id_check", false);
		request.setAttribute("pass_check", false);
		if(Utility.isNullOrEmpty(id) ) {
			request.setAttribute("id_check", true);
		}
		if(Utility.isNullOrEmpty(pass) ) {
			request.setAttribute("pass_check", true);
		}
		
		request.setAttribute("check", false);
		
		if(Utility.isNullOrEmpty(id) || Utility.isNullOrEmpty(pass)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (id.equals("axiz") && pass.equals("axizuser") || 
				id.equals("technocore") && pass.equals("techno-pass")) {
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		} else {
			request.setAttribute("check", true);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
