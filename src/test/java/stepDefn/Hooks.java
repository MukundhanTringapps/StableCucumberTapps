package stepDefn;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before 
	public void before(Scenario scenario) { 
	    System.out.println("------------------------------"); 
	    System.out.println("Starting - " + scenario.getName()); 
	    System.out.println("------------------------------"); 
	}
	
	@After
	public void after(Scenario scenario) {
	    System.out.println("------------------------------");
	    System.out.println(scenario.getName() + " - Status - " + scenario.getStatus());
	    System.out.println("------------------------------");
	}
}