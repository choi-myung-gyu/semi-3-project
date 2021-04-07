package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/semi-logout")
public class MemberLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/member/logout_pop.jsp");
		dp.forward(request, response);
		

	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String res = request.getParameter("logout_ans");
		
		System.out.println(res);
		
//		if(res.equals(true)) {
//			HttpSession session = request.getSession();
//	
//			if(session.getAttribute("login") != null) {
//				if(session.getAttribute("login").equals("true")) {
//					session.invalidate();
//				}
//			}
//			
//			response.sendRedirect(request.getContextPath());
//		}
		
	}
	
}
