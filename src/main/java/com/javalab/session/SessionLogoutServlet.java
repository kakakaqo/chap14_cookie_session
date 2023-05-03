package com.javalab.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogout")
public class SessionLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 로그아웃 처리 메소드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
			System.out.println("세션을 무효화 하였습니다.");
			
		}
		
		// sendRedirect(로그아웃 후에 인덱스 페이지로 이동)
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
