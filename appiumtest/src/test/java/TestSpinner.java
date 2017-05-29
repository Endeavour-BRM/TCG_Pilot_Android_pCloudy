package test.java;

import static org.junit.Assert.*;


import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.*;
import org.junit.runners.MethodSorters;

import com.ssts.pcloudy.ConnectError;

import appiumtest.appiumtest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpinner {


	@Test
	public void t1InstallStartApp() throws IOException, ConnectError, InterruptedException {
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

}
