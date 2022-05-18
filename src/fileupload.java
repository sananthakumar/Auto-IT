import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.jodah.failsafe.internal.util.Assert;

public class fileupload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\91999\\Downloads\\Selenium_learning\\chromedriver.exe");
				//Creating webdriver
				//getting current directorry using user.dir
				String downpath=System.getProperty("user.dir");
				//creating chrome class options
				ChromeOptions ch=new ChromeOptions();
				//creating hashmap to add the preferences 
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
				 chromePrefs.put("profile.default_content_settings.popups", 0);  
				 chromePrefs.put("download.default_directory", downpath);  
				 //setting the preferences to chrome options object using setExperimentalOperation command
				ch.setExperimentalOption("prefs", chromePrefs);
				//creating webdriver by passing chrome options "ch"
				WebDriver driver=new ChromeDriver(ch);
				
				System.out.println(downpath);
				//Normal URL flow
				driver.get("https://www.ilovepdf.com/jpg_to_pdf");
				driver.findElement(By.id("pickfiles")).click();
				Thread.sleep(2000);
				//calling auto it complied  code exe application with uploading code
				
				Runtime.getRuntime().exec("C:\\Users\\91999\\OneDrive\\Documents\\Autoit\\fileupload.exe");
                //Thread.sleep(2000);
				WebDriverWait wait =new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
				driver.findElement(By.id("processTaskTextBtn")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
				driver.findElement(By.id("pickfiles")).click();
				//Cretaing new file using downpath+filename
				File fs=new File(downpath+"\\1531667.pdf");
				//uisng exists command check file xists or not
				Thread.sleep(4000);
				if(fs.exists()) {
					System.out.println("File is downloaded and present");
				
				}
				else
					System.out.println("File is not downloaded");
				driver.close();
				fs.delete();
				

	}

}
