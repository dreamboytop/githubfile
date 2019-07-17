package text;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id=request.getParameter("id");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("avgscore"));
		String birthday=request.getParameter("birthday");
		String description=request.getParameter("description");
		System.out.println(request.getParameter("name"));
		int avgscore=Integer.parseInt(request.getParameter("avgscore"));
		String name=request.getParameter("name");
		Student stu=new Student( name,  id,  birthday, description, avgscore);
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.lpush("student".getBytes(), SerializeUtil.serialize(stu));
		jedis.close();
		request.getRequestDispatcher("./index").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
