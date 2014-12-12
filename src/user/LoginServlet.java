package user;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import java.lang.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import user.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User newUser=new User(username,password);
		UserDao dao = new UserDao();
		String submission = request.getParameter("submit");
		HttpSession session = request.getSession(); 
		if(submission.equals("Register")){
			try{
				
				dao.createUser(newUser);
				response.sendRedirect("/finalproject/mainpage.jsp");
				session.setAttribute("myusername",username); 
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if(submission.equals("Submit")){
			User user = dao.findUserByUsernamePassword(username, password);
			if(user == null){
				response.sendRedirect("/finalproject/index.jsp");
			}
			else
			{
				response.sendRedirect("/finalproject/mainpage.jsp");
				session.setAttribute("myusername",username); 
			}
		}else{
			System.out.println("10");
		}
	}

}
