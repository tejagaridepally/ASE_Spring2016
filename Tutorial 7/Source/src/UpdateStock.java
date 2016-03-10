
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Servlet implementation class UpdateStock
 */
@WebServlet("/UpdateStock")
public class UpdateStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateStock() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MongoClientURI uri=new MongoClientURI("mongodb://teja:password@ds019628.mlab.com:19628/tutorial7db");	
		MongoClient client=new MongoClient(uri);
		
		try {
			
		DB db=client.getDB(uri.getDatabase());
		DBCollection stocks=db.getCollection("stock");
		
		BasicDBObject updateQuery = new BasicDBObject("name", request.getParameter("company"));
        stocks.update(updateQuery, new BasicDBObject("$set", new BasicDBObject("price", request.getParameter("cost"))));
         
        //JOptionPane.showMessageDialog(null, "The price was updated");
        response.sendRedirect("displaystocks.html");
		doGet(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
//		finally {
//			client.close();
//		}
	}

}
