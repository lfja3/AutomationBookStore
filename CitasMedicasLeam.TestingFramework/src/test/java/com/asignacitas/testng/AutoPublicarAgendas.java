package com.asignacitas.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoPublicarAgendas {
	WebDriver driver;
	String Fecha = "4/1/2022";
	private String baseUrl;
	
	// LOCALIZADORES DECLARADOS COMO VARIABLES //
	
	By UsernameLocator = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
	By PaswordLocator = By.xpath("(//input[@class='dx-texteditor-input'])[2]");
	By Login = By.xpath("//div[@class='dx-button dx-button-default dx-button-mode-contained dx-widget dx-button-has-text']");
	By Validacion = By.xpath("//div[@class='oph-toast-right-text']/p");
	By TarjetaAsignacionCitaLocator = By.xpath("(//div[@class='cardContent-container'])[18]");
	By FechaFinal = By.xpath("(//*[@class='dx-texteditor-input-container'])[3]/input");
	
	// BÚSQUEDA POR NOMBRE DE PROFESIONAL//
	
	By NombreProfesional = By.xpath("(//*[@class='dx-texteditor-input-container'])[4]/input"); 
	By BotonBuscar = By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[4]");	
	
	// BÚSQUEDA POR NÚMERO DE SOLICITUD //
	
	By NumeroSolicitud = By.xpath("(//*[@class='dx-texteditor-input-container'])[6]/input");
	By PuntosDetalles = By.xpath("(//*[@class='dx-datagrid-adaptive-more'])[1]");
	By BotonPublicar = By.xpath("(//*[@class='dx-button-content'])[10]");
	By BotonPublicarAgenda = By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//div[@class='dx-button-content'])[3]");
	By RadioButtonParcial = By.xpath("(//*[@class='dx-radio-value-container'])[1]");
	By FechaInicialParcial = By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//input[@class='dx-texteditor-input'])[4]");
	By FechaFinalParcial = By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//input[@class='dx-texteditor-input'])[5]");
	By FechaInicialC = By.xpath("((//*[@class='dx-form dx-widget dx-visibility-change-handler'])/..//input)[2]");
	By FechaFinalC = By.xpath("((//*[@class='dx-form dx-widget dx-visibility-change-handler'])/..//input)[3]");
	
	// VARIABLE PUBLICACIÓN AGENDA //
	
	By OpcionPublicarAgenda = By.xpath("(//*[@class='list-content'])/div[4]");
	
	WebDriverWait TiempoNormaL;
	WebDriverWait TiempoMaximo;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().window().maximize();
		driver.get("https://his-server-app-qa.sitechnology.cl/Agora/#/login");
	}
	
	@Test(priority = 0)
	public void Login() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(UsernameLocator).click();
		driver.findElement(UsernameLocator).clear();
		driver.findElement(UsernameLocator).sendKeys("pablom");
		driver.findElement(PaswordLocator).sendKeys("Klinic2021**");
		Thread.sleep(3000);
		driver.findElement(Login).click();
		Thread.sleep(2000);
		Boolean Val = false;
		String Cadena = "";

		try {			
			Cadena = driver.findElement(Validacion).getText().strip();
			Val = true;
		} catch (Exception e) {
			Val = false;
		}
		if (Val == true) {
			if (Cadena.equals("Usuario y/o contraseña inválido")) {
				System.out.println("Usuario y/o contraseña inválido perrito");

			} else {
				System.out.println("Credenciales correctas");
			}

		}
		Thread.sleep(8000);
	}
	
	// MÉTODO PARA PUBLICACIÓN AGENDA //
	
	@Test(priority = 1)
		public void IngresoModuloPublicar() throws InterruptedException {		
			TiempoNormaL = new WebDriverWait(driver, 10);
			TiempoMaximo = new WebDriverWait(driver, 80);
			Thread.sleep(8000);
			TiempoNormaL.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='cardContent-container'])[1]")));
			WebElement element = driver.findElement(TarjetaAsignacionCitaLocator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			TiempoNormaL.until(ExpectedConditions.elementToBeClickable(TarjetaAsignacionCitaLocator));
			driver.findElement(TarjetaAsignacionCitaLocator).click();
			Thread.sleep(8000);
			driver.switchTo().frame(0);
			TiempoMaximo.until(ExpectedConditions.elementToBeClickable(OpcionPublicarAgenda));
			Thread.sleep(5000);
			driver.findElement(OpcionPublicarAgenda).click();
			Thread.sleep(8000);
			new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/oph-root/oph-principal-page/oph-intermedial-page/div[1]/div[2]/div[3]/div/iframe")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			TiempoMaximo.until(ExpectedConditions.elementToBeClickable(FechaFinal));
			Thread.sleep(5000);
			driver.findElement(FechaFinal).click();
			Thread.sleep(1000);
			driver.findElement(FechaFinal).clear();
			Thread.sleep(1000);
			driver.findElement(FechaFinal).sendKeys(Fecha);
			Thread.sleep(1000);
			driver.findElement(NombreProfesional).click();
			Thread.sleep(1000);
			driver.findElement(NombreProfesional).sendKeys("");
			Thread.sleep(1000);
			driver.findElement(BotonBuscar).click();
			Thread.sleep(3000);
			driver.findElement(NumeroSolicitud).click();
			Thread.sleep(1000);
			driver.findElement(NumeroSolicitud).sendKeys("578"); // -> INGRESAR EL NÚMERO DE SOLICITUD //
			
					// VALIDACIÓN DE NÚMERO DE SOLICITUD DE AGENDA, SI NO EXISTE NÚMERO GENERA ERROR POR CONSOLA //
			
					Boolean ValSol = false;
					try {			
						Thread.sleep(2000);
						driver.findElement(PuntosDetalles).click();
						ValSol = true;
					} catch (Exception e) {
						ValSol = false;
					}
					if (ValSol == true) {
				 
					System.out.println("El Número de Solicitud Se encontró");
					Thread.sleep(1000);
					driver.findElement(BotonPublicar).click();
					Thread.sleep(4000);
								
					// CODIGO DE SCROLL BAR BUSCA EL RADIO BUTTON OPCIÓN PARCIAL //
					
					new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div/div/div[2]/div/iframe")));
					Thread.sleep(4000);
					WebElement element1 = driver.findElement(By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//div[@class='dx-button-content'])[1]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
					Thread.sleep(2000);
					
					// VARIABLES DE FECHAS PARCIALES PARA DILIGENCIAR MANUALMENTE //
												
					String TipoAgenda = "Parcial";
					String Fecha1 = "";
					String Fecha2 = "";
					
					// ENTRA AL VALIDADOR EN OPCIÓN RADIO BUTTON PARCIAL //
					
					if(TipoAgenda=="Parcial")
					 {
						
						driver.findElement(RadioButtonParcial).click();
						Thread.sleep(1000);
						
						// VALIDADOR PARA IDENTIFICAR QUE LAS FECHAS LLEVAN INFORMACIÓN O NO //
						
						if(Fecha1.equals("") || Fecha2.equals(""))
							{
								System.out.println("La Fecha Está Vacía");
							}
							else {
								
								WebElement element2 = driver.findElement(By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//div[@class='dx-button-content'])[1]"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
								Thread.sleep(1000);
								driver.findElement(FechaInicialParcial).click();
								Thread.sleep(1000);
								driver.findElement(FechaInicialParcial).sendKeys(Fecha1);
								Thread.sleep(1000);
								driver.findElement(FechaFinalParcial).click();
								Thread.sleep(1000);
								driver.findElement(FechaFinalParcial).sendKeys(Fecha2);
								Thread.sleep(1000);
								driver.findElement(BotonPublicarAgenda).click();
								Thread.sleep(1000);
								
								System.out.println("Típo de Agenda Parcial Pubicada");
								
							}
										
					 }else{
						 
						 // DE LO CONTRARIO PUBLICA LA AGENDA COMO TOTAL //
					
						 driver.findElement(BotonPublicarAgenda).click();
						 Thread.sleep(1000);
						 System.out.println("Típo de Agenda Total Pubicada");
					
					 }

				} else {
					
					// SI NO ENCUENTRA NUMERO DE SOLICITUD ARROJA ESTE ERROR POR CONSOLA //
					
					System.out.println("El Número de Solicitud No se encontró");
				}
		}

	@AfterClass
	public void afterClass() {
	}

}


