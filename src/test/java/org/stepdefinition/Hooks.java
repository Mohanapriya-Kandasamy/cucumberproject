package org.stepdefinition;

import java.io.IOException;
import java.util.Date;

import org.base.BaseUtilityClass;
import org.junit.After;

import io.cucumber.java.Before;


public class Hooks extends BaseUtilityClass {
	
	@Before
	
	public void starting()  {
		
	launchBrowser("chrome");
	
	windowMax();
	
	explicitFluentWait();
	
	
		
	}

	@io.cucumber.java.After
	public void ending() {
		
    windowQuit();
	}
}
