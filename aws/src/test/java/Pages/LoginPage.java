/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A login page
 */
public class LoginPage extends BasePage {
  

    public LoginPage(AppiumDriver driver) {
        super(driver);
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
