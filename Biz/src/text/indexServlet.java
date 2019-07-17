package text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.util.Comparator;
import redis.clients.jedis.Jedis;


@WebServlet("/index")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//连接本地的 Redis 服务
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("连接成功");
        HttpSession session = request.getSession(); 
       /* Student stu=new Student("112501","xiaowang",80);
        Student stu1=new Student("112502","xiaoming",70);
        Student stu2=new Student("112503","xiaohong",90);
        jedis.lpush("student".getBytes(), SerializeUtil.serialize(stu));
        jedis.lpush("student".getBytes(), SerializeUtil.serialize(stu1));
        jedis.lpush("student".getBytes(), SerializeUtil.serialize(stu2));*/
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        List<byte[]> list = jedis.lrange("student".getBytes(), 0, -1);  
        /*List studentlist = new ArrayList();*/
       PageResult pg=new  PageResult();
       System.out.println(list.size());
       Student[] studentlist = new Student[list.size()];
        try {
        	for(int i=0; i<list.size(); i++) {       	
				Student userResult = (Student) SerializeUtil.deserialize(list.get(i));		
				System.out.println("列表项为: "+userResult.toString());
				//studentlist.add(userResult);
				studentlist[i]=userResult;
			}
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();      
        }       
        
        /*list.toArray(strings);*/
        Arrays.sort(studentlist,new MyComparator(1));
        pg.setList(Arrays.asList(studentlist));
        pg.setTotalItems(list.size());
        System.out.println(pg.getTotalItems());
        System.out.println(pg.getCurrentPage());
        pg.setCurrentlist();
        request.setAttribute("pageResult",pg);
        session.setAttribute("pageResult", pg);
       // jedis.ltrim("student".getBytes(), -1, 0);
        jedis.close();
        request.getRequestDispatcher("list.jsp").forward(request, response);// 转发到new.jsp
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
