package test.java;

import static org.junit.Assert.*;


import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.runners.MethodSorters;

import com.ssts.pcloudy.ConnectError;

import appiumtest.appiumtest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpinner {


	@Test
	public void t1InstallApp() throws IOException, ConnectError, InterruptedException {
		appiumtest cAppium = new appiumtest();
		cAppium.InstallApp();
	}
	
	@Test
	public void t2SelectEarth(){
		appiumtest cAppium = new appiumtest();
		cAppium.selectElement("Earth");
	}
	
	@Test
	public void t3SelectMars(){
		appiumtest cAppium = new appiumtest();
		cAppium.selectElement("Mars");
	}
	@AfterClass
<<<<<<< HEAD
	public static void closesession() throws IOException, ConnectError, InterruptedException {
=======
	public static void closesession(){
>>>>>>> f0aece6f4b12f7ef56b3fdd2b226070671c2be76
		appiumtest cAppium = new appiumtest();
		cAppium.releasesession();
	}

}
