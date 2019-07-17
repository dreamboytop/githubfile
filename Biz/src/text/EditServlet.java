package text;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		HttpSession session = request.getSession(); 
		PageResult pg=(PageResult) session.getAttribute("pageResult");
		System.out.println();
		System.out.println(id);
		int index=0;
		List studentlist=pg.getList();
		 Jedis jedis = new Jedis("127.0.0.1",6379);
		 jedis.ltrim("student".getBytes(), -1, 0);
		for(int i=0;i<studentlist.size();i++){
			
			if(!id.equals( ((Student) studentlist.get(i)).getId()) ){
				 jedis.lpush("student".getBytes(), SerializeUtil.serialize(((Student) studentlist.get(i))));
				// studentlist.remove(i);
			}else{
				index=i;
			}
		}
		request.setAttribute("student", (Student) studentlist.get(index));
		jedis.close();
		request.getRequestDispatcher("./edit.jsp").forward(request, response);// 转发到new.jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
