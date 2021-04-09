
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
		request.setCharacterEncoding("UTF-8");
		
		MultipartRequest multi = new MultipartREquest(
				request,	// 멀티파트로 요청한 request 객체
				request.getServletContext().getRealPath(File.separator) + "\\upload\\",	// 파일 업로드 경로
				1024*1024*5,	// 업로드 파일 최대 크기
				"uft-8",	// 인코딩
				new DefaultFileRenamePolicy()	// 파일명 중복 발생시 파일명에 숫자 추가시켜주는 객체
				);
		
		String name = multi.getParameter("userName");
		
		String file_sys_name = multi.getFilesystemName("file");
		String file_cli_name = multi.getOriginalFileName("file");
		
		TempDAO dao = new TempDAO();
		TempVO data = new TempVO();
		data.setUserName(name);
		data = dao.insert(data);
		
		if(data.getUserId() != 0) {
			response.sendRedirect(request.getContextPath() + "/temp/detail?userId=" + data.getUserId());
		} else {
			request.setAttribute("msg", "데이터 저장 처리 중 문제가 발생했습니다.");
			RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/err/err.jsp");
			dp.forward(request, response);
		}
	}

}