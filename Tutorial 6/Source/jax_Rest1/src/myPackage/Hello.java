package myPackage;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


//localhost:8080/jax_Rest1/rest/Hello?name=Teja&Card_No=123456&Amount=100000

@Path("/Hello")
public class Hello {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlaintextHello()
	{
		return "Hello Jersey1";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello()
	{
		return "<?xml version=\"1.0\">" +"<hello> Hello Jersey2" +"</hello>";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello(@QueryParam("name") String name,@QueryParam("Card_No") String Card_No,@QueryParam("Amount") int Amount)
	{
		System.out.println("Name is "+name);
		System.out.println("Amount:"+Amount);
		
		String retString;
		
		if(Amount > 10000)
		{
			
			System.out.println("Amount is greater than 1 lakh");
			retString = "Credit card amount is not approved ";
		
		}
		
		else
		{
			System.out.println("Amount is less than 1 lakh");
			retString = "Credit card amount is approved ";
		}
		
		//return "<html>" + "<title>" + "Credit card authorization " + name + "</title>" + "<body><h1>" + retString + "</body></h1>" + "</html>";
		
		return retString;
		}
		
	}
	
