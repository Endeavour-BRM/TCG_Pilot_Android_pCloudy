package test.java;

import static org.junit.Assert.*;


import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.runners.MethodSorters;

import com.ssts.pcloudy.ConnectError;

import appiumtest.awstest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpinner {


	@Test
	public void t1InstallApp() throws IOException, ConnectError, InterruptedException {
		awstest cAppium = new awstest();
		cAppium.InstallApp();
	}
	
	@Test
	public void t2SelectEarth(){
		awstest cAppium = new awstest();
		cAppium.selectElement("Earth");
	}
	
	@Test
	public void t3SelectMars(){
		awstest cAppium = new awstest();
		cAppium.selectElement("Mars");
	}
	@AfterClass
	public static void closesession() throws IOException, ConnectError, InterruptedException {
		awstest cAppium = new awstest();
		
	}

}
