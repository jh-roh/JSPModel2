package control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MemberBean;

import java.io.IOException;

/**
 * Servlet implementation class Mproc2
 */
@WebServlet("/Mproc2")
public class Mproc2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqProc(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqProc(request,response);
	}
	
	
	protected void reqProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pass= request.getParameter("pass1");
		String email= request.getParameter("email");
		String tel= request.getParameter("tel");
		String info= request.getParameter("info");
		
		MemberBean bean = new MemberBean();
		bean.setId(id);
		bean.setPass1(pass);
		bean.setEmail(email);
		bean.setTel(tel);
		bean.setInfo(info);
		
		request.setAttribute("bean", bean);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("MemberTest.jsp");
		
		rd.forward(request, response);
	}
	

}
