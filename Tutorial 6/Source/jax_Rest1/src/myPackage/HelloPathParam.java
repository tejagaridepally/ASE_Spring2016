package myPackage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

// localhost:8080/jax_Rest1/rest/pay_calculator/Teja/10000/1000/100/100
@Path("/pay_calculator")
public class HelloPathParam {
	
	@GET
	@Path("{emp_name}/{basic}/{hra}/{da}/{deductions}")
	public Response getMemberInfo(@PathParam("emp_name")String emp_name,@PathParam("basic")int basic,@PathParam("hra")int hra,@PathParam("da")int da,@PathParam("deductions")int deductions)
	{
		int total_pay = basic + hra + da - deductions;
		
		String output = "Employee: " + emp_name + " Total_salary is " + total_pay;
		
		return Response.status(200).entity(output).build();
	}	

	@GET
	@Path("{emp_name}/{basic}")
	public Response getTaxInfo(@PathParam("emp_name")String emp_name,@PathParam("basic")int basic)
	{
		int total_tax = basic /20;
		
		String output = "Employee: " + emp_name + " Total tax to be deducted is " + total_tax;
		
		return Response.status(200).entity(output).build();
	}	

}
