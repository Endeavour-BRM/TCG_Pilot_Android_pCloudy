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
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class awstest {
	 protected static WebDriver driver;
	
	public void InstallApp() throws IOException, InterruptedException{
	
    	
    
    
    	// Get the endpoint from pCloudy
    	URL endpoint = new URL("http://127.0.0.1:4723/wd/hub");
    	System.out.println("Appium Endpoint:" + endpoint);
    	
        DesiredCapabilities capabilities = new DesiredCapabilities();
        driver = new AndroidDriver(endpoint, capabilities);        

	}
	
	public void selectElement(String element){
		System.out.println("Trying to select an element");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        driver.findElement(By.className("android.widget.CheckedTextView")).click();

//        TouchAction tap = new TouchAction((MobileDriver) driver);
//		System.out.println(driver.findElement(By.className("android.widget.CheckedTextView")).getLocation());
//		List<WebElement> listElement = driver.findElements(By.xpath(".//*"));
//		for(int i =0;i<listElement.size();i++) {
//		 String elementText = listElement.get(i).getText(); 
//		 System.out.println(elementText); 
//		}
    		driver.findElement(By.xpath(".//*[@text='"+element+"']")).click();
		
	}
	
	
	

}
