package student.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestParamServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step1 : set content type
		response.setContentType("test/html");
		//Step 2:get printwriter
		PrintWriter out=response.getWriter();
		//Step 3:read configuration params
		ServletContext context=getServletContext(); //inherit from HttpServlet
		String maxCartSize=context.getInitParameter("max-shopping-cart-size");
		String teamName=context.getInitParameter("project-team-name");
		//Step 4:generate HTML content
		out.println("<html><body>");
		out.println("Max cart "+ maxCartSize);
		out.println("Team Name "+ teamName);
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
