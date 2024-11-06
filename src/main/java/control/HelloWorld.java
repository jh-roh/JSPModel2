package control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HelloWorld")// 		/HelloWorld라고 주소 url에 표시해주어야 서블릿 클래스가 실행
public class HelloWorld extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}
	
	//일괄처리, 즉 doget이던 dopost이던 아래 reqPro 메소드가 실행되게 해줌.
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		//화면에 Hello World라고 출력.. jsp 쪽으로 넘겨질 데이터를 설정
		String msg = "Hello world~~ 안녕하세요.";
		Integer data = 12;
		
		//jsp 쪽으로 데이터를 request에 부착하여 넘겨줌.
		request.setAttribute("msg", msg);
		request.setAttribute("data", data);
		
		
		
		//서블릿에서 jsp를 호출하면서 데이터를 같이 넘겨주는 객체를 선언 
		RequestDispatcher rd = request.getRequestDispatcher("HelloWorld.jsp"); //JSP 파일명을 기술
		
		rd.forward(request, response);
	}

}
