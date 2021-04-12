package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/join.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass1");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		// 회원정보 넘어온 것 확인
		System.out.println("ID : " + id);
		System.out.println("Name : " + name);
		System.out.println("Password : " + pass);
		System.out.println("Email : " + email);
		System.out.println("Phone : " + phone);
		
		// 회원가입 DB 추가

		int result = new MemberDAO().join(id, name, pass, email, phone);
				
		if(result == 1) {
			request.getSession().setAttribute("messageType", "성공 메시지");
			request.getSession().setAttribute("messageContent", "회원가입 완료");
			response.sendRedirect("main");

		} else {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "이미 존재하는 회원입니다");
			response.sendRedirect("join");
			return;
		}
		
	}

}