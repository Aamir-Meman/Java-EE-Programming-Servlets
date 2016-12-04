/*It is a servlet used for logging statement in a console , where in a url you should give http://localhost:8081/DebuggingServlets/ContextLog?param = Success,
then you should observe a console in IDE it changes 


*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextLog
 */
@WebServlet("/ContextLog")
public class ContextLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContextLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("param");

		ServletContext context = getServletContext();

		if (param == null || param.equals("")) {
			context.log("No Message Received", new IllegalStateException("Missing Parameter"));
		}
		context.log(" Visitor's Message :  " + param);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<!Doctype HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Demo: Servlet Debugging using Message Logging</title>");
		out.println("</head>");
		out.println("<body>");

		context.log("Generating the Body for the Response ");

		out.println("<h3>Message logging Demo</h3>");

		out.println("Message Recieved : " + param + "</p>");

		context.log("Completed Generating the Response");

		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
