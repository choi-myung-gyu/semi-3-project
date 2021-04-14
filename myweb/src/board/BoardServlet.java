package board;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		System.out.println("############ sgahn uri:" + uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println("############ sgahn action:" + action);
		String viewPage = null;
		if(action.equals("write.do")) {
			
			viewPage = "writeForm.jsp";
		}
		if(action.equals("writePro.do")) {
			
			String filename = "";
			String realFolder = "";	

			String saveFolder = "/fileSave";
			File isDir = new File(saveFolder); // 업로드 디렉토리 생성용
			if(!isDir.isDirectory()) {
				System.out.println("디렉토리 없습니다");
				isDir.mkdir();
			}
			
			String encType = "utf-8";
			int maxSize = 5*1024*1024;

			ServletContext context = getServletContext();
			realFolder = context.getRealPath(saveFolder);

			MultipartRequest multi = null;
			try{
				
				multi = new MultipartRequest (request,realFolder,
						maxSize,encType,new DefaultFileRenamePolicy());
				
				Enumeration<?> params = multi.getParameterNames();
				Enumeration<?> files = multi.getFileNames();
				
				while(files.hasMoreElements()){
					String name = (String)files.nextElement();
					
					filename = multi.getFilesystemName(name);
				}
				
				BoardVO article = new BoardVO();
				
				article.setNum(Integer.parseInt(multi.getParameter("num")));
				article.setUserid(multi.getParameter("userid"));
				article.setTitle(multi.getParameter("title"));
				article.setContent(multi.getParameter("content"));
				article.setPasswd(multi.getParameter("passwd"));
				article.setRef(Integer.parseInt(multi.getParameter("ref")));
				article.setRe_step(Integer.parseInt(multi.getParameter("re_step")));
				article.setRe_level(Integer.parseInt(multi.getParameter("re_level")));
				
				article.setCreatedate(new Timestamp(System.currentTimeMillis()) );
				article.setFilename(filename);
				
				BoardDAO dbPro = BoardDAO.getInstance();
				dbPro.insertArticle(article);
				
			}catch(IOException ioe){
				System.out.println(ioe);
			}catch(Exception ex){
				System.out.println(ex);
			}
			
			viewPage = "writePro.jsp";
		}
		if(action.equals("list.do")) {
			
			viewPage = "list.jsp";
		}
		if(action.equals("content.do")) {
			
			viewPage = "content.jsp";
		}
		
		if(action.equals("delete.do")) {
			
			viewPage = "deleteForm.jsp";
		}
		if(action.equals("deletePro.do")) {
			int check = 0;
			
			String pageNum = request.getParameter("pageNum");
			String id = request.getParameter("id");
			String passwd = "";
			
			try {
				
				int num = Integer.parseInt(request.getParameter("num"));
				passwd = request.getParameter("passwd");
				
				BoardDAO dbPro = BoardDAO.getInstance();
				check = dbPro.deleteArticle(num, passwd);
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("id", id);
			request.setAttribute("passwd", passwd);
			request.setAttribute("check", check);
			
			viewPage = "deletePro.jsp";
		}
		
		if(action.equals("update.do")) {
			
			viewPage = "updateForm.jsp";
		}
		if(action.equals("updatePro.do")) {
			int check = 0;
			String pageNum = request.getParameter("pageNum");
			String passwd = request.getParameter("passwd");
			String realFolder = "";	
			String saveFolder = "/fileSave";
			String encType = "utf-8";
			int maxSize = 5*1024*1024;

			ServletContext context = getServletContext();
			realFolder = context.getRealPath(saveFolder);

			MultipartRequest multi = null;
			
			try {		
				
				multi = new MultipartRequest (request,realFolder,
						maxSize,encType,new DefaultFileRenamePolicy());
				
				BoardVO article = new BoardVO();
				article.setUserid(multi.getParameter("id"));
				article.setTitle(multi.getParameter("title"));
				article.setPasswd(multi.getParameter("passwd"));
				article.setContent(multi.getParameter("content"));
				article.setNum(Integer.parseInt(multi.getParameter("num")));
				
				BoardDAO dbPro = BoardDAO.getInstance();
				
				check = dbPro.updateArticle(article);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("pageNum", pageNum);

			request.setAttribute("check", check);
			viewPage = "updatePro.jsp";
		}
		RequestDispatcher rDis = request.getRequestDispatcher(viewPage);
		rDis.forward(request, response);
		
	}

}