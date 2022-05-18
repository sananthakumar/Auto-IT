import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_authentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91999\\Downloads\\Selenium_learning\\chromedriver.exe");
		//Creating webdriver

		WebDriver driver=new ChromeDriver();
		//Normal URL flow
		driver.get("https://the-internet.herokuapp.com/");
		
		//Changing url for windows authentication
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.partialLinkText("Basic")).click();
		

	}

}
