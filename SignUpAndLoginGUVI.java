package task_20_guvi;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpAndLoginGUVI {

	public static void main(String[] args) {
		Random rand = new Random();
        int randomNo = rand.nextInt(1000);
		
//		Setting up the Chrome Driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//		Adding explicit wait for 30 seconds duration 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		Maximizing the window
		driver.manage().window().maximize();
		
//		Opening the GUVI URL
		driver.get("https://www.guvi.in/");
		
		String mailID = "testuser"+randomNo+"@gmail.com";
		
//		Locating the Sign up button by link text and clicking on it
		driver.findElement(By.linkText("Sign up")).click();
//		explicitly waiting till Name field is loaded successfully 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name"))));
//		Filling up the Sign Up form with required details like Name, Mail ID, Password and Mobile Number
		driver.findElement(By.id("name")).sendKeys("Aravindhan S");
		driver.findElement(By.id("email")).sendKeys(mailID);
		driver.findElement(By.id("password")).sendKeys("Testuser@12345");
		driver.findElement(By.id("mobileNumber")).sendKeys("9876543210");
//		Locating the Sign up button by link text and clicking on it
		driver.findElement(By.linkText("Sign Up")).click();
		
		WebElement profile = driver.findElement(By.id("profileDrpDwn"));
		Select dropDownProfile = new Select(profile);
		dropDownProfile.selectByValue("Student");
		
		WebElement degree = driver.findElement(By.id("degreeDrpDwn"));
		Select dropDownDegree = new Select(degree);
		dropDownDegree.selectByValue("B.E. / B.Tech. Computer Science");
		
		driver.findElement(By.id("year")).sendKeys("2020");
		driver.findElement(By.linkText("Submit")).click();
//		Verifying whether Registration is successfully done or not
		if(driver.getTitle().contains("Sign Up"))
			System.out.println("Registration is successful");
		
//		Redirecting to the login page
		driver.navigate().to("https://www.guvi.in/");
		driver.findElement(By.id("login-btn")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
//		Filling up the Login form with required details like Mail ID and Password
		driver.findElement(By.id("email")).sendKeys(mailID);
		driver.findElement(By.id("password")).sendKeys("Testuser@12345");
		driver.findElement(By.linkText("Login")).click();
//		Verifying whether Login is successfully done or not
		if(driver.getTitle().contains("Login"))
			System.out.println("Login is successful");
		
//		Closing the Browser Instance
		driver.close();

	}

}
