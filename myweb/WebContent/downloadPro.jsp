<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%!
public static String con(String s){
	String str = null;
	try{
		str = new String(s.getBytes("8859_1"), "ksc5601");
	}catch(Exception e){
		e.printStackTrace();
	}
	return str;
}

%>

<%
try{
	String SAVEFOLDER = request.getSession().getServletContext().getRealPath("/fileSave");
 	String filename = request.getParameter("filename");
	String convName2 = new String(filename.getBytes("8859_1"), "euc-kr"); 
	File file = new File(con(SAVEFOLDER + File.separator + filename + convName2));  
	byte b[] = new byte[(int)file.length()];
	response.setHeader("Accept-Ranges", "bytes");
	String strClient = request.getHeader("User-Agent");
	if (strClient.indexOf("MSIE6.0") != -1) {
		response.setContentType("application/smnet;charset=euc-kr");
		response.setHeader("Content-Disposition", "filename=" + filename + ";");
	} else {
		response.setContentType("application/smnet;charset=euc-kr");
		response.setHeader("Content-Disposition", "attachment;filename="+ filename + ";");
	}
	out.clear();
	out = pageContext.pushBody();
	if (file.isFile()) {
		BufferedInputStream fin = new BufferedInputStream(
				new FileInputStream(file));
		BufferedOutputStream outs = new BufferedOutputStream(
				response.getOutputStream());
		int read = 0;
		while ((read = fin.read(b)) != -1) {
			outs.write(b, 0, read);
		}
		outs.close();
		fin.close();
	}
	
}catch(Exception e){
	e.printStackTrace();
}
%>    