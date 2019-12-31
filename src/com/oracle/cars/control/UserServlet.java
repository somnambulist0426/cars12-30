package com.oracle.cars.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.cars.model.Car;
import com.oracle.cars.model.CarDAO;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class UserServlet extends HttpServlet {
	private CarDAO dao=new CarDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		switch (method) {
			case "listAll":
			{
				System.out.println("");
				List<User> users=dao.listAll();
				
			
				System.out.println(users.size());
				request.setAttribute("users", users);
				request.getRequestDispatcher("userList.jsp").forward(request, response);
				break;
			}
			case "add":
			{
				System.out.println("");
				break;
			}
			case "delete":
			{
				System.out.println("");
				String carid=request.getParameter("userid");
				
				Object result;
				request.setAttribute("deleteResult", result);
				request.getRequestDispatcher("CarServlet?method=listAll").forward(request, response);
				break;
			}
			case "update":
			{
				System.out.println("");
				break;
			}
		}
	}

}
