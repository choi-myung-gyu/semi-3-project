package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoardDAO board = new BoardDAO();
		ArrayList<BoardVO> datas = board.getAll();
		
		request.setAttribute("datas", datas);
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/board/main.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

}
