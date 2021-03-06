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

//extra stuff
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;	

public class GameWebTest {
	static WebDriver driver;
	static String baseUrl;
	static String port;
       //extra stuff
	  private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public static void before() {
	// Will be run before all tests in class are run
		driver = new FirefoxDriver();
		port = System.getenv("PORT");
		if(port == null) {
			port = "4567";
		}
		baseUrl = "https://tictactoe-assignment.herokuapp.com/"; // + port;
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
		driver.findElement(By.id("newGame")).click();
		Thread.sleep(1000);
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
		driver.findElement(By.id("newGame")).click();
	}

	@Test
	public void testPlayer2Winner() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("newGame")).click();
		Thread.sleep(1000);
        driver.findElement(By.id("h2")).click();
        Thread.sleep(100);
        driver.findElement(By.id("h1")).click();
        Thread.sleep(100);
        driver.findElement(By.id("h6")).click();
        Thread.sleep(100);
        driver.findElement(By.id("h5")).click();
        Thread.sleep(100);
        driver.findElement(By.id("h3")).click();
		Thread.sleep(100);
		driver.findElement(By.id("h9")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("winner")));
        String found = driver.findElement(By.id("winner")).getText();
        String expected = "Leik Lokid leikmadur 2 bar sigur ur bitum";
        assertEquals(expected, found);
        driver.findElement(By.id("newGame")).click();
	}

	@Test
        public void testPlayer1Winner() throws Exception {
                driver.get(baseUrl);
                driver.findElement(By.id("newGame")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("h1")).click();
                Thread.sleep(100);
                driver.findElement(By.id("h2")).click();
                Thread.sleep(100);
                driver.findElement(By.id("h4")).click();
                Thread.sleep(100);
                driver.findElement(By.id("h5")).click();
                Thread.sleep(100);
                driver.findElement(By.id("h7")).click();
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("winner")));
                String found = driver.findElement(By.id("winner")).getText();
                String expected = "Leik Lokid leikmadur 1 bar sigur ur bitum";
                assertEquals(expected, found);
                driver.findElement(By.id("newGame")).click();
        }

	@Test
  		public void testVAlidationOnSite() throws Exception {
    	driver.get("http://validator.w3.org/check?uri=https%3A%2F%2Ftictactoe-assignment.herokuapp.com%2F&charset=%28detect+automatically%29&doctype=Inline&group=0");
    	try {
      		assertEquals("This document was successfully checked as XHTML 1.0 Strict!", driver.findElement(By.cssSelector("h2.valid")).getText());
    	}
    	catch (Error e) {
      		verificationErrors.append(e.toString());
    }
  }

}
	
