package appiumtest;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ssts.pcloudy.ConnectError;
import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.dto.booking.BookingDtoDevice;
import com.ssts.pcloudy.dto.device.MobileDevice;
import com.ssts.pcloudy.dto.file.PDriveFileDTO;

import io.appium.java_client.android.AndroidDriver;

public class appiumtest {
	 protected static WebDriver driver;
	public void InstallApp() throws IOException, ConnectError, InterruptedException{
		Connector pCloudyCONNECTOR = new Connector("https://fonebooth.techendeavour.com");
    	
    	String authToken = pCloudyCONNECTOR.authenticateUser("aanjan.hari@techendeavour.com", "wrw6sfqq3wdpdwmy3zvzn8ys");
    	ArrayList selectedDevices = new ArrayList();
    	MobileDevice[] devices = pCloudyCONNECTOR.getDevices(authToken,1,"android",true);
    	
    	for(int i = 0; i<devices.length;i++){
    		System.out.println(devices[i].full_name);
    		System.out.println(devices[i].id);
    		System.out.println(devices[i].model);
    		System.out.println(devices[i].platform);
    		System.out.println(devices[i].version);
    		System.out.println(devices[i].manufacturer);
    		System.out.println(devices[i].display_name);
    	}
    	// Populate the selected Devices here
    	//selectedDevices.add(pCloudyCONNECTOR.getDevices(authToken,1,"android",true));
    	
    	selectedDevices.add(MobileDevice.getNew("Samsung_GalaxyS4_Android_5.0.1", 19, "GalaxyS4", "Galaxy S4", "android", "5.0.1", "Samsung"));


    	// Book the selected devices in pCloudy

    	BookingDtoDevice[] bookedDevicesIDs = pCloudyCONNECTOR.bookDevicesForAppium(authToken, selectedDevices, 1, "friendlySessionName");;
    	System.out.println("Devices booked successfully");
    	
		
	

    	// Upload apk in pCloudy
		System.out.println("Working Directory = " +
                 System.getProperty("user.dir"));
    	PDriveFileDTO pDriveFile = pCloudyCONNECTOR.uploadApp(authToken, new File("../Spinner/bin/Spinner-release.apk"));
    	System.out.println("apk file uploaded successfully");
    	pCloudyCONNECTOR.initAppiumHubForApp(authToken, pDriveFile);

    	// Get the endpoint from pCloudy
    	URL endpoint = pCloudyCONNECTOR.getAppiumEndpoint(authToken);
    	System.out.println("Appium Endpoint:" + endpoint);
    	
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("deviceName", bookedDevicesIDs[0].capabilities.deviceName);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoDismissAlerts", true);
        //capabilities.setCapability("app", pDriveFile.file.);
        //capabilities.setCapability("appPackage", "com.flipkart.android");
        //capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
        driver = new AndroidDriver(endpoint, capabilities);

        
        //driver.findElement(By.xpath("//android.widget.Button")).click();
        //String windowhandle = driver.getWindowHandle();
        //driver.switchTo().alert().accept();
        //driver.switchTo().window(windowhandle);

	}
	
	public void selectElement(String element){
        driver.findElement(By.className("android.widget.CheckedTextView")).click();
        driver.findElement(By.name(element)).click();
	}

}
