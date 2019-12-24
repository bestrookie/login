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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
				//���մ�jsp��������������
				String name = request.getParameter("username").toString();
				String password = request.getParameter("password").toString();
				//�жϱ������Ƿ��͹���
				System.out.println(name +" "+password );
				//��ȡlogin.jspҳ���ύ���˺ź��������õ�ʵ����User��
				User user=new User();
				user.setUsername(name);
				user.setPassword(password);
				UserDao dao = new UserDaoImpl();
				User us = dao.getUser(user);
				if(us != null)
				{
					request.getSession(true).setAttribute("usename", name);
					response.sendRedirect("loginSucceed.html");
				}
				else
				{
					response.sendRedirect("loginFail.html");
				}
	}

}
