

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Demo
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/html/EmailSend.html");
		dis.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		String getEmail=request.getParameter("mailFrom");
		String mailTo =request.getParameter("mailTo");
		String getSubject=request.getParameter("subject");
		String getMessage=request.getParameter("message");
		System.out.println("EMAIL: "+getEmail);
		System.out.println("SUBJECT: "+getSubject);
		System.out.println("MESSAGE: "+getMessage);
		
		SendMail newM = new SendMail(getEmail,mailTo,getSubject,getMessage);
		newM.send();
		
		response.sendRedirect("/MailService/Congrats");
	}

}
