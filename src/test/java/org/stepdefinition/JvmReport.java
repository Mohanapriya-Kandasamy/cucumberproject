package org.stepdefinition;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport{
	
	
	
	public static void generateJvmReport(String jsonfile) {
		File f = new File(System.getProperty("user.dir")+"\\ReportFolder\\JVM Report");
	 
		Configuration c = new Configuration(f,"Facebook Application");
		c.addClassifications("platform", "Windows 11");
		c.addClassifications("JDK version","17");
		List<String> l= new ArrayList<String>();
		l.add(jsonfile);
		
		ReportBuilder r= new ReportBuilder(l,c);
		r.generateReports();
	}
	
	
	

}
