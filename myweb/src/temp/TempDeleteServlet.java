package temp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/temp/delete")
public class TempDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		TempDAO dao = new TempDAO();
		if(dao.delete(Integer.parseInt(id)) == 1) {
			response.sendRedirect(request.getContextPath() + "/temp");
		} else {
			request.setAttribute("msg", "삭제 처리 중 문제가 발생하였습니다.");
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/err/err.jsp");
			dp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
