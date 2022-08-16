package com.blog.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.app.dao.UserTableDao;
import com.blog.app.entities.Message;
import com.blog.app.entities.UserTable;
import com.blog.app.helper.ConectionProvider;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//fetch useremail and password from login page (jsp page to servlet).
		
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		//now need to send the data from servlet to dao
		//create obj of dao to call dao layer and send useremail and userpassword.	
		try {
			UserTableDao dao = new UserTableDao(ConectionProvider.getConnection());
			
			// getUserTableByEmailAndPassword function will return obj of UserTable, so need to store this obj
			UserTable u = dao.getUserTableByEmailAndPassword(userEmail, userPassword);
			
			if(u==null)
			{
				//login error, email or password is incorrect.

				Message message = new Message("Invalid credential, Please login with right one", "error", "alert-danger");
				HttpSession s= request.getSession();
				s.setAttribute("message", message);
				
				response.sendRedirect("error.jsp");
			}
			else
			{
				//login is correct move to the next process.
				//we will use here httpsession, cookies can also be implemented.
				
				//get the current session
				HttpSession session = request.getSession();
				//pass the our obj to that session.
				session.setAttribute("currentuser", u);
				//redirect to profile page to show data which are coming from dao to servlet based on credentials.
				//response.sendRedirect("ProfilePage.jsp");
				response.sendRedirect("error.jsp");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
