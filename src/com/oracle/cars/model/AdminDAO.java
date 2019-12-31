package com.oracle.cars.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *管理员数据库的DAO类，负责管理数据库后台系统 
 */
public class AdminDAO {
 public  Adminuser login(String username,String password) {
		 Adminuser  adminuser=null;
	 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cars2", "root", "root");
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<Adminuser>> h = new BeanListHandler<Adminuser>(Adminuser.class);
			adminuser= (Adminuser) run.query(connection,"SELECT * FROM adminuser where username=? and password=?",h,username,password);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	return adminuser; 
 }
}
