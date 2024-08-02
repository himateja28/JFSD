package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentManager;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    int stu_id = Integer.parseInt(req.getParameter("T1"));
    String stu_name = req.getParameter("T2");
    String stu_dept = req.getParameter("T3");
    
    res.setContentType("text/html");
    PrintWriter PW = res.getWriter();
    
    try {
      
      Student S = new Student();
      
      S.setSid(stu_id);
      S.setSname(stu_name);
      S.setSdept(stu_dept);
      
      StudentManager SM = new StudentManager();
      String ack_message = SM.updateStudent(S);
      
      PW.println(ack_message);
      
      
    } catch (Exception e) {
      PW.println(e.getMessage());
    }
    
    RequestDispatcher RD = req.getRequestDispatcher("update.html");
    RD.include(req, res);
    
  }

  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
  }

}