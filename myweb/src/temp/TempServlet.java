package temp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/temp")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. TempDAO를 사용하여 전체 데이터 조회
		TempDAO dao = new TempDAO();
		
		// 2. ArrayList<TempVO>에 전체 조회 데이터 정보를 저장
		ArrayList<TempVO> datas = dao.getAll();
		
		// 3. request.setAttribute()를 이용하여 웹 페이지에 조회한 데이터를 테이블 구조로
		//	  만들 수 있는 JSP에 데이터 전달할 객체 생성
		request.setAttribute("datas", datas);
		
		// 4. RequestDispatcher를 사용하여 조회 데이터를 테이블 구조로 만들 JSP 파일로
		//	  포워드 수행
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/temp/list.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
