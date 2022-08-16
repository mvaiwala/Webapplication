package com.blog.app.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.app.dao.UserTableDao;
import com.blog.app.entities.UserTable;
import com.blog.app.helper.ConectionProvider;

/**
 * Servlet implementation class RegistorServlet
 */
@WebServlet("/RegistorServlet")
public class RegistorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		String gender = request.getParameter("gender");
		//String checkbox = request.getParameter("checkbox");
		String about = request.getParameter("about");
		
		//data comming from RegistorPage.jsp are set to UserTable class through usertable object using servlet variables.
		
		UserTable usertable=new UserTable(name, email, password, gender, about);
		
		
		//then call dao layer and pass the object of UserTable ( it will pass the data from servlet to dao through getter setter class)
		
		
		try {
			UserTableDao dao = new UserTableDao(ConectionProvider.getConnection());
			dao.saveuser(usertable);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		response.sendRedirect("LoginPage.jsp");

	}

}
