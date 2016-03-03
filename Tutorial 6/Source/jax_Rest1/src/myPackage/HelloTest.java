package myPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloTest {

	Hello hello = new Hello();	
	String name = "Teja";
	String Card_no = "123456";
	 int amount = 10000000;
	String s = hello.sayHTMLHello(name,Card_no,amount);
	String TestResult = "Credit card amount is approved ";
	String s1 = hello.sayPlaintextHello();
	String s2 = "Hello Jersey"; 
	
	@Test
	public void testSayPlaintextHello() {
		
		assertEquals(s1,s2);
	}


	@Test
	public void testSayHTMLHello() {
		
	//	System.out.println("@Test sayHTMLHello()" + s + "=" + TestResult);
		
		assertEquals(s,TestResult);
	}

	
	
}
