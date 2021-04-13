package temp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/temp/update")
public class TempUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		String id = request.getParameter("id");
		
		// 1. 수정 요청한 데이터 번호에 맞는 데이터 조회
		TempDAO dao = new TempDAO();
		TempVO data = dao.selectId(Integer.parseInt(id));
		
		// 2. 수정할 수 있는 양식 데이터에 사용할 초기 값 설정(request.setAttrubute)
		request.setAttribute("data", data);
		
		// 3. 조회한 데이터를 수정할 수 있는 양식 페이지로 포워드
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/temp/update.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		TempDAO dao = new TempDAO();
		TempVO data = dao.selectId(Integer.parseInt(id));
		
		data.setName(name);
		
		if(dao.update(data) == 1) {
			response.sendRedirect(request.getContextPath() + "/temp/detail?id=" + id);
=======
		String id = request.getParameter("userId");
		
		// 1. 수정 요청한 데이터 번호에 맞는 데이터 조회
		TempDAO dao = new TempDAO();
		TempVO data = dao.selectId(Integer.parseInt(id));
		
		// 2. 수정할 수 있는 양식 데이터에 사용할 초기 값 설정(request.setAttribute)
		request.setAttribute("data", data);
		
		// 3. 조회한 데이터를 수정할 수 있는 양식 페이지로 포워드
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/temp/update.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		String name = request.getParameter("userName");
		
		TempDAO dao = new TempDAO();
		TempVO data = dao.selectId(Integer.parseInt(id));
		data.setUserName(name);
		if(dao.update(data) == 1) {
			response.sendRedirect(request.getContextPath() + "/temp/detail?userId=" + id);
>>>>>>> refs/remotes/origin/이성한
		} else {
			request.setAttribute("msg", "수정 처리 중 문제가 발생하였습니다.");
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/err/err.jsp");
			dp.forward(request, response);
		}
	}

}
