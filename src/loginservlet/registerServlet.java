package loginservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.User;
import login.UserDao;
import login.UserDaoImpl;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
				//接收从jsp表单传过来的数据
				String name = request.getParameter("username");
				String password = request.getParameter("password");
				//判断表单数据是否传送过来
				System.out.println(name +" "+password );
				//获取registerServlet.jsp页面提交的账号和密码设置到实体类User中
				User user=new User();
				user.setUsername(name);
				user.setPassword(password);
				UserDao dao = new UserDaoImpl();
				boolean flag = dao.setUser(user);
				if(flag == true)
				{
					response.sendRedirect("registerSucceed.html");
				}
				else
				{
					response.sendRedirect("registerFail.html");
				}
	}

}
