package com.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Preview
 */
@WebServlet("/Preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Preview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		
		// create a session
		
		HttpSession session =  request.getSession();
		
		String guestName = (String) session.getAttribute("guestName");
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!Doctype HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<p> Please confirm your information </p>");
		
		out.println("<p>Guest Name : "  + guestName + "</p>");
		
		out.println("<p>Email id : "  + email + "</p>");
		
		session.setAttribute("email", email);
		out.println("<form name='frm' action ='SaveData' method='post'>");
		out.println("<p><input type = 'submit'  value = 'Save Data' name = 'btnSave'/> </p>");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
	}

}
