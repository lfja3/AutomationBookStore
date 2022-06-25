package com.asignacitas.testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestNGDataProviderExample {
	
	WebDriver driver;
	
	By signInLocator = By.linkText("Sign in");
	By emailLocator = By.id("email");
	By passwordLocator = By.id("passwd");
	By singInBtnLocator = By.id("SubmitLogin");
	By singOutBtnLocator = By.cssSelector("a.logout");
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com");
		}

  
  @Test(dataProvider = "authenticationData")
  public void login (String email, String password) {     //Integer n lo reemplazmos l por el String email -- String s lo remplazmos por el Password
	  
	  //se realizarán las acciones sobre los elementos Web
	  
	  if(driver.findElement(signInLocator).isDisplayed()) {  //valida si elemento ya se cargo en la página y luego se la da click
		driver.findElement(signInLocator).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);   // Se declara una espera explicita para que cargue 
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(emailLocator));//Condición por la que deb esperar 
	  
		driver.findElement(emailLocator).sendKeys(email);
		driver.findElement(passwordLocator).sendKeys(password);// se envi el parametro password que vien como parametro del método y que se carga en el  método dataprovider  
		driver.findElement(singInBtnLocator).click();
		
		assertEquals(driver.findElement(singOutBtnLocator).getText(),"Sign out");                   //Vamos a comparar el texto del link SingOut y debe ser igual al texto SingOut
		
		driver.findElement(singOutBtnLocator).click();
	  } else {
		  System.out.println("Sign in Link is not present ");
	  }  
	  
  }

  @DataProvider (name= "authenticationData")
  public Object[][] getData() {  //arreglo bidimensional de tipo objet -- matriz con dod colmnas 0,0-0,1-1,0-1,1
   Object[][]data = new Object [2][2]; //Crear un arreglo bidimensonal de tipo objet de dos x Dos
   	data[0][0]="lfja3@gmail.com"; data[0][1]= "fp1234";
   	data[1][0]="testq@gmail.com"; data[1][1]= "ja1234";
   	
     return data;
   
  }
 

  @AfterClass
  public void afterClass() {
	 // driver.close();
  }

}
