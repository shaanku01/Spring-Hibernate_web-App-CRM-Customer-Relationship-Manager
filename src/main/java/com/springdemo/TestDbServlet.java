package com.springdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/com.springdemo.TestDbServlet")
public class TestDbServlet extends HttpServlet {

    public static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException {
        // setup Connection variables

        String user = "hbstudent";
        String password = "Welcome123$";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

        String driver = "com.mysql.jdbc.Driver";

        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to DataBase "+jdbcUrl);
            Class.forName(driver);
            Connection myCon = DriverManager.getConnection(jdbcUrl,user,password);

            out.println("Connection Sucessfull");

            myCon.close();

        }catch (Exception ex){
            ex.printStackTrace();
            throw new ServletException(ex);
        }

        //get connection to database
    }
}
