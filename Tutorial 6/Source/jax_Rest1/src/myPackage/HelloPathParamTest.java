package myPackage;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

public class HelloPathParamTest {

	
	HelloPathParam helloP = new HelloPathParam();
	
	String emp_name = "Teja";
	
	int basic = 10000;
	
	int hra = 1000;
	
	int da =100;
	
	int de = 100;
	
	Response actualResult = helloP.getMemberInfo(emp_name, basic, hra, da, de);
	
	Response actualResult1 = helloP.getTaxInfo(emp_name, basic);
	String output = "Employee: Teja Total_salary is 11000";
	
	String output1 = "Employee: Teja Total tax to be deducted is 500";
	
	Response testResult = Response.status(200).entity(output).build();
	
	Response testResult1 = Response.status(200).entity(output1).build();
	@Test
	public void testGetMemberInfo() {
		
		assertEquals(actualResult,testResult);
			}
	
	@Test
	public void testGetTaxInfo() {
		
		assertEquals(actualResult1,testResult1);
			}
	
}
