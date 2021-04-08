package temp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/temp/write")
public class TempWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/temp/write.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		TempDAO dao = new TempDAO();
		TempVO data = new TempVO();
		data.setName(name);
		
		data = dao.insert(data);
		if(data.getId() != 0) {
			response.sendRedirect(request.getContextPath() + "/temp/detail?id=" + data.getId());
		} else {
			request.setAttribute("msg", "데이터 저장 처리 중 문제가 발생했습니다.");
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/err/err.jsp");
			dp.forward(request, response);
		}
	}

}
