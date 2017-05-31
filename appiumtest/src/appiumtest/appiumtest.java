package appiumtest;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ssts.pcloudy.ConnectError;
import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;
import com.ssts.pcloudy.dto.device.MobileDevice;
import com.ssts.pcloudy.dto.file.PDriveFileDTO;
import com.ssts.pcloudy.appium.PCloudyAppiumSession;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest {
	 protected static WebDriver driver;
	 public static PCloudyAppiumSession pCloudySession;
	public void InstallApp() throws IOException, ConnectError, InterruptedException{
		Connector pCloudyCONNECTOR = new Connector("https://fonebooth.techendeavour.com");
    	
    	String authToken = pCloudyCONNECTOR.authenticateUser("aanjan.hari@techendeavour.com", "wrw6sfqq3wdpdwmy3zvzn8ys");
    	ArrayList<MobileDevice> devices = new ArrayList<>();
		// Populate the selected Devices here
    	//devices.add(MobileDevice.getNew("Samsung_GalaxyS4_Android_5.0.1", 19, "GalaxyS4", "Galaxy S4", "android", "5.0.1", "Samsung"));
    	
    	devices.add(MobileDevice.getNew("Lg_Nexus5_Android_6.0.1", 28, "Nexus5", "Nexus 5", "android", "6.0.1", "Lg"));

    	

    
    	
    	
		// To select multiple devices manually, use either of these:
		//selectedDevices.addAll(con.chooseMultipleDevices(authToken, "android"));
		// selectedDevices.addAll(CloudyCONNECTOR.chooseSingleDevice(authToken, "android"));

		String sessionName = devices.get(0).display_name + " Appium Session";
    	
    	for(int i = 0; i<devices.size();i++){
    		System.out.println(devices.get(i).full_name);
    		System.out.println(devices.get(i).id);
    		System.out.println(devices.get(i).model);
    		System.out.println(devices.get(i).platform);
    		System.out.println(devices.get(i).version);
    		System.out.println(devices.get(i).manufacturer);
    		System.out.println(devices.get(i).display_name);
    	}
    	// Populate the selected Devices here
    	//selectedDevices.add(pCloudyCONNECTOR.getDevices(authToken,1,"android",true));
    	
    	//selectedDevices.add(MobileDevice.getNew("Samsung_GalaxyS4_Android_5.0.1", 19, "GalaxyS4", "Galaxy S4", "android", "5.0.1", "Samsung"));

    	//String sessionName = selectedDevices.get(0).display_name + " Appium Session";

    	// Book the selected devices in pCloudy

    	//BookingDtoDevice[] bookedDevicesIDs = pCloudyCONNECTOR.bookDevicesForAppium(authToken, selectedDevices, 1, "friendlySessionName");;
    	//BookingDtoDevice[] bookedDevicesIDs = pCloudyCONNECTOR.bookDevice(authToken, 1, 19);
    	BookingDtoDevice[] bookedDevicesIDs = pCloudyCONNECTOR.AppiumApis().bookDevicesForAppium(authToken, devices, 1, sessionName);
    	
    	System.out.println(bookedDevicesIDs.length);
    	System.out.println(bookedDevicesIDs[0].version);
    	System.out.println(bookedDevicesIDs[0].model);
    	System.out.println(bookedDevicesIDs[0].os);
    	System.out.println(bookedDevicesIDs[0].manufacturer);
    	System.out.println(bookedDevicesIDs[0].capabilities.deviceName);
    	System.out.println(bookedDevicesIDs[0].capabilities.platformName);
    	System.out.println(bookedDevicesIDs[0].capabilities.toString());
    	System.out.println("Devices booked successfully");
    	
		
		BookingDtoDevice aDevice = bookedDevicesIDs[0];
    	pCloudySession = new PCloudyAppiumSession(pCloudyCONNECTOR, authToken, aDevice);

    	// Upload apk in pCloudy
    	 System.out.println("Working Directory = " +
                 System.getProperty("user.dir"));
    	PDriveFileDTO pDriveFile = pCloudyCONNECTOR.uploadApp(authToken, new File("../Spinner/bin/Spinner-release.apk"));
    	System.out.println("apk file uploaded successfully");
    	pCloudyCONNECTOR.AppiumApis().initAppiumHubForApp(authToken, pDriveFile);

    	// Get the endpoint from pCloudy
    	URL endpoint = pCloudyCONNECTOR.AppiumApis().getAppiumEndpoint(authToken);
    	System.out.println("Appium Endpoint:" + endpoint);
    	
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", aDevice.capabilities.platformName);

        capabilities.setCapability("deviceName", aDevice.capabilities.deviceName);
        //capabilities.setCapability("deviceName", "Samsung_GalaxyS4_Android_5.0.1");
        //capabilities.setCapability("autoAcceptAlerts", true);
        //capabilities.setCapability("autoDismissAlerts", true);
        

        //capabilities.setCapability("app", pDriveFile.file.);
        //capabilities.setCapability("appPackage", "com.flipkart.android");
        //capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
        driver = new AndroidDriver(endpoint, capabilities);

        
        //driver.findElement(By.xpath("//android.widget.Button")).click();
        //String windowhandle = driver.getWindowHandle();
        //driver.switchTo().alert().accept();
        //driver.switchTo().window(windowhandle);
        //pCloudyCONNECTOR.revokeTokenPrivileges(authToken);
        

	}
	
	public void selectElement(String element){
        driver.findElement(By.className("android.widget.CheckedTextView")).click();
<<<<<<< HEAD
//        TouchAction tap = new TouchAction((MobileDriver) driver);
//		System.out.println(driver.findElement(By.className("android.widget.CheckedTextView")).getLocation());
//		List<WebElement> listElement = driver.findElements(By.xpath(".//*"));
//		for(int i =0;i<listElement.size();i++) {
//		 String elementText = listElement.get(i).getText(); 
//		 System.out.println(elementText); 
//		}
    		driver.findElement(By.xpath(".//*[@text='"+element+"']")).click();
	}
	
	public void releasesession() {
		try {
=======
        driver.findElement(By.className("android.widget.CheckedTextView")).sendKeys("element");
	}
	
	public void releasesession() throws IOException, ConnectError, InterruptedException{
			try {
>>>>>>> f0aece6f4b12f7ef56b3fdd2b226070671c2be76
			pCloudySession.releaseSessionNow();
		} catch (ConnectError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
