package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/semi-login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/member/login.jsp");	// 로그인 jsp주소
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.login(userId, userPassword);
		HttpSession session = request.getSession();
		
		if(member == null) System.out.println("member null");
		if(member.getUserId() != null) {
			System.out.println("로그인성공");
			session.setAttribute("login", "true");
			session.setAttribute("userName", member.getUserName());
			session.setAttribute("userEmail", member.getUserEmail());
			session.setAttribute("userPhone", member.getUserPhone());
			session.setAttribute("joinDate", member.getJoinDate());
			
			response.sendRedirect("");	// 게시판 주소
		} else {
			System.out.println("로그인실패");
			// 로그인 실패시 팝업창 띄우기
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/member/loginError_pop.jsp");
			dp.forward(request, response);
		}
		
		// 로그인 실패 팝업 test용
		if(userId.equals("admin") && userPassword.equals("1234")) {
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/member/loginError_pop.jsp");
			dp.forward(request, response);
		}
	}

}
