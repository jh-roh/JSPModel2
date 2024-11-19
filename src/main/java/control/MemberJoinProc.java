package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MemberBean;

import java.io.IOException;


@WebServlet("/proc")
public class MemberJoinProc extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberBean bean = new MemberBean();
		
		bean.setId(request.getParameter("id"));
		bean.setPass1(request.getParameter("pass1"));
		bean.setPass2(request.getParameter("pass2"));
		bean.setEmail(request.getParameter("email"));
		bean.setTel(request.getParameter("tel"));
		
		String[] arr = request.getParameterValues("hobby");
		
		String data = "";
		for(String string : arr) {
			data += string + " "; //하나의 스트링으로 데이터 연결
		}
		
		bean.setHobby(data);
		bean.setJob(request.getParameter("job"));
		bean.setAge(request.getParameter("age"));
		bean.setInfo(request.getParameter("info"));
		
		
		//데이터 베이스 객체 선언한 후 저장
	}

}
