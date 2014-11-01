package is.ru.TicTacToe;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;
	
public class GameWebTest {
	static WebDriver driver;
	static String baseUrl;
	static String port;
	
	@BeforeClass
	public static void before() {
	// Will be run before all tests in class are run
		driver = new FirefoxDriver();
		port = System.getenv("PORT");
		if(port == null) {
			port = "4567";
		}
		baseUrl = "http://ghastly-monster-9605.herokuapp.com"; // + port;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void after() {
	// Will be run after all tests in class have run
		driver.close();
	}

	@Before
	public void setup() {
	// Will be run before each test in class is run
	}

	@Test
	public void assertTitle() {
		driver.get(baseUrl); // + "/");
		assertEquals("TicTacToe", driver.getTitle());
	}

	@Test
	public void testNoWinner() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//button[@onclick='refreshPage()']")).click();
		driver.findElement(By.id("h1")).click();
		Thread.sleep(100);
		driver.findElement(By.id("h2")).click();
		Thread.sleep(100);	
		driver.findElement(By.id("h3")).click();
		Thread.sleep(100);
		driver.findElement(By.id("h5")).click();
		Thread.sleep(100);
		driver.findElement(By.id("h6")).click();
		Thread.sleep(100);
		driver.findElement(By.id("h7")).click();
		Thread.sleep(100);
		driver.findElement(By.id("h8")).click();
		Thread.sleep(100);
		driver.findElement(By.id("h9")).click();
		Thread.sleep(100);
		driver.findElement(By.id("h4")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("winner")));
		String found = driver.findElement(By.id("winner")).getText();
		String expected = "Leik Lokid enginn bar sigur ur bitum";
		assertEquals(expected, found);
	}

	@Test
	public void testPlayer2Winner() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//button[@onclick='refreshPage()']")).click();
                driver.findElement(By.id("h2")).click();
                Thread.sleep(100);
                driver.findElement(By.id("h1")).click();
                Thread.sleep(100);
                driver.findElement(By.id("h6")).click();
                Thread.sleep(100);
                driver.findElement(By.id("h5")).click();
                Thread.sleep(100);
                driver.findElement(By.id("h9")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("winner")));
                String found = driver.findElement(By.id("winner")).getText();
                String expected = "Leik Lokid leikmadur 2 bar sigur ur bitum";
                assertEquals(expected, found);
	}
/*	
	@Test
	public void testAllButtons() throws Exception {
		selenium.open("http://higgees.herokuapp.com/");
		selenium.click("h1");
		selenium.click("h2");
		selenium.click("h3");
		selenium.click("h4");
		selenium.click("h5");
		selenium.click("h6");
		selenium.click("h7");
		selenium.click("h8");
		selenium.click("h9");
		selenium.click("//button[@onclick='refreshPage()']");
	}

	@Test
	public void testNoWinner() throws Exception {
		selenium.open("http://higgees.herokuapp.com/");
		selenium.click("h1");
		Thread.sleep(NaN);
		selenium.click("h2");
		Thread.sleep(NaN);
		selenium.click("h3");
		Thread.sleep(NaN);
		selenium.click("h5");
		Thread.sleep(NaN);
		selenium.click("h6");
		Thread.sleep(NaN);
		selenium.click("h7");
		Thread.sleep(NaN);
		selenium.click("h8");
		Thread.sleep(NaN);
		selenium.click("h9");
		Thread.sleep(NaN);
		selenium.click("h4");
		Thread.sleep(NaN);
		selenium.type("id=winner", "Leik Lokid enginn bar sigur ur bitum");
		selenium.click("//button[@onclick='refreshPage()']");
	}

	@Test
	public void testHtmlValidate() throws Exception {
		selenium.open("http://validator.w3.org/check?uri=https%3A%2F%2Fhiggees.herokuapp.com%2F&charset=%28detect+automatically%29&doctype=Inline&group=0");
		assertEquals("This document was successfully checked as XHTML 1.0 Strict!", selenium.getText("css=h2.valid"));
		selenium.open("http://higgees.herokuapp.com/");
		assertEquals("Higgees TicTacToe", selenium.getTitle());
	}

*/
}
	
