package text;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/change")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		 HttpSession session = request.getSession(); 
		 PageResult result=(PageResult) session.getAttribute("pageResult");
		 result.setCurrentPage(currentPage);
		 result.setCurrentlist();
		 request.getRequestDispatcher("./list.jsp").forward(request, response);
		 session.removeAttribute("pageResult");
		 session.setAttribute("pageResult", result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
