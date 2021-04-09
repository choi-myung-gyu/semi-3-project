package temp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/temp/detail")
public class TempDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		
		TempDAO dao = new TempDAO();
		TempVO data = dao.selectId(Integer.parseInt(id));
		
		request.setAttribute("data", data);
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/temp/detail.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}