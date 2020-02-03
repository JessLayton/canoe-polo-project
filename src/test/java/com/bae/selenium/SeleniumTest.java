package com.bae.selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

	
	@LocalServerPort
	private int port;
	
	@Value("${server.servlet.context-path}")
	private String context;
	
	private WebDriver driver;
	
	private List<String> player = new ArrayList<>();
	
	private AddPlayerStage addPlayerStage;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		this.addPlayerStage = new AddPlayerStage(this.driver);
		this.addPlayerStage = PageFactory.initElements(this.driver, AddPlayerStage.class);
		player.add("John");
		player.add("Smith");
				
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void seleniumTest() throws InterruptedException {
		this.driver.get("http://localhost:" + port + context);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		addPlayerStage.navToAddGamePage();
		
		addPlayerStage.navToAddPlayerPage();

		addPlayerStage.createPlayer(player);
		
		wait.until(ExpectedConditions.alertIsPresent());
		assertEquals("Player added", addPlayerStage.readAlertText());
		addPlayerStage.alertOK();
		
		
		
	}
	
	
	
}	