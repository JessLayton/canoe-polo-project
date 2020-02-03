package com.bae.selenium;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPlayerStage {
	
	
	public static final String URL = "http://localhost/canoe-polo-project/index.html";
	
	
	private WebDriver driver;
	
		@FindBy(id = "newgame-button")
		private WebElement newgameBtn;
		
		@FindBy(id = "newplayer-button")
		private WebElement newplayerBtn;
		
		@FindBy(id = "InputFirstName")
		private WebElement firstNameInput;
		
		@FindBy(id = "InputSurname")
		private WebElement surnameInput;
		
		@FindBy(id = "addPlayerButton")
		private WebElement addPlayerBtn;
		
		public AddPlayerStage(WebDriver driver) {
			this.setDriver(driver);;
			PageFactory.initElements(driver, this);
		}
		
		public void navToAddGamePage() {
			newgameBtn.click();
		}
		
		public void navToAddPlayerPage() {
			newplayerBtn.click();
		}
		
		public void createPlayer(List<String> player) {
			firstNameInput.sendKeys(player.get(0));
			surnameInput.sendKeys(player.get(1));
			addPlayerBtn.click();
		}
				
		public WebDriver getDriver() {
			return driver;
		}

		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}
		
		public void alertOK() {
			getDriver().switchTo().alert().accept();
		}
		
		public String readAlertText() {
			return getDriver().switchTo().alert().getText();
		}
		
		
		
}