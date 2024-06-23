package task_20_guvi;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws Exception {
//		Setting up the Chrome Driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		Maximizing the window
		driver.manage().window().maximize();
		
//		Opening the Datepicker URL
		driver.get("https://jqueryui.com/datepicker/");
		
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
//		Writing code to select Next month from the datepicker
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//*[@title='Next']")).click();
//		Writing code to select the date "22" from the datepicker
		driver.findElement(By.xpath("//*[@data-date='22']")).click();
		
//		System.out.println(driver.findElement(By.id("datepicker")).getText());
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.id("datepicker")));
		actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL);
		actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL);
		actions.build().perform();
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String date = (String) clipboard.getData(DataFlavor.stringFlavor);

//		Closing the browser and quitting the WebDriver instance
		driver.close();
		driver.quit();
		
//		Printing the selected date on console as output
		System.out.println(date);

	}

}
