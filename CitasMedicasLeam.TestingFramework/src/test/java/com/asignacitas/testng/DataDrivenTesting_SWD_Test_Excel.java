package com.asignacitas.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class DataDrivenTesting_SWD_Test_Excel {
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	
// localizadores
	
   By searchBoxLocator = By.id("search_query_top");
   By BtnsearchBoxLocator = By.xpath("//*[@class='btn btn-default button-search']");
   By resultTextLocator = By.xpath("//span[@class='heading-counter']");
   //By resultTextLocator = By.cssSelector("span.heading-counter");
   
 @BeforeClass
 public void beforeClass() {
	 System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	 driver = new ChromeDriver();
	 setWriteFile(new WriteExcelFile());
	 readFile = new ReadExcelFile(null);
	 ReadExcelFile readFile1 = new ReadExcelFile(null);
	 driver.get("http://automationpractice.com");
  }
	
  @Test (priority = 0)
  public void testRow1Col1() throws IOException {
	  String filepath = "C:\\Digitalware\\KlinicE\\Casos de Prueba\\test_read_write_excel.xlsx";//ruta del excel
	  
	  String searchText = readFile.getCellValue(filepath, "Hoja1", 0, 0); // "se guarda el valor de la celda Fila 0, Columna 0"--El termino que vamos a buscar el primer elemento de la primera fila y primera columna 
	  //Para leer la información de la primera celda
	  driver.findElement(searchBoxLocator).sendKeys(searchText);// Se selecciona el primer valor y se busca en la página.
	  driver.findElement(BtnsearchBoxLocator).click();
	  String resultText = driver.findElement(resultTextLocator).getText();// "ResultText" se gurda el texto de la cantidad de prendas
	  System.out.println("Page result text: " + resultText);
	  
	  //Escribrir a lado de la primera celda el resltado que se esta obteniendo de la página.  
	  //readFile.readExcelStrin(filepath, "Hoja1"); //Nos devuelve lo que esta escrito en el excel antes de comenzar a escribir.
	  writeFile.writeCellvalue(filepath, "Hoja1", 0, 1, resultText); // escribe el valor que retorna la página web
	  //readFile.readExcelStrin(filepath, "Hoja1");// Para coroborar que si se escribió en la página.
	  
  }
 
 /*
  @Test (priority = 1)
  public void testRow2Col1() throws IOException {
	  String filepath = "C:\\Digitalware\\KlinicE\\Casos de Prueba\\test_read_write_excel.xlsx";//ruta del excel
	 
	  
	  String searchText = readFile1.getCellValue(filepath, "Hoja1", 2, 0); // "se guarda el valor de la celda Fila 0, Columna 0"--El termino que vamos a buscar el primer elemento de la primera fila y primera columna 
	  //Para leer la información de la primera celda
	  driver.findElement(searchBoxLocator).clear();
	  driver.findElement(searchBoxLocator).sendKeys(searchText);// Se selecciona el primer valor y se busca en la página.
	  driver.findElement(BtnsearchBoxLocator).click();
	  String resultText = driver.findElement(resultTextLocator).getText();// "ResultText" se gurda el texto de la cantidad de prendas
	  System.out.println("Page result text: " + resultText);
	 
	  
	//Escribrir a lado de la primera celda el resltado que se esta obteniendo de la página.  
	  writeFile.writeCellvalue(filepath, "Hoja1", 1, 1, resultText); // escribe el valor que retorna la página web

  }
 */
  
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

public WriteExcelFile getWriteFile() {
	return writeFile;
}

public void setWriteFile(WriteExcelFile writeFile) {
	this.writeFile = writeFile;
}

}
