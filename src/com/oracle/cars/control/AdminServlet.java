package com.oracle.cars.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.cars.model.AdminDAO;
import com.oracle.cars.model.Adminuser;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private AdminDAO dao=new AdminDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.��ȡ�û���������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//2.�����ݿ��жϸ��û��������Ƿ����
		Adminuser adminuser=dao.login(username,password);
	System.out.println("��¼����:��¼���"+adminuser);
		//���ݲ�ѯ�Ľ����תҳ��
	if(adminuser!=null){
		request.getSession().setAttribute("user", adminuser);
	    request.getRequestDispatcher("index.jsp").forward(request,response);
	}else {
		request.getRequestDispatcher("login.jsp").forward(request,response);	
	}
	
	}
}
