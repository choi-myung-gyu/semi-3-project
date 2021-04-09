package board;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/board/write.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String btype = request.getParameter("btype");
		String context = request.getParameter("context");
		
		BoardVO data = new BoardVO();
		data.setTitle(title);
		data.setAuthor(author);
		data.setBtype(btype);
		data.setContext(context);
		
		BoardDAO dao = new BoardDAO();
		boolean result = dao.saveData(data);
		dao.close();
		
		if(result) {
			response.sendRedirect(request.getContextPath() + "/board");
		} else {
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/board/write.jsp");
			dp.forward(request, response);
		}
	}

}
