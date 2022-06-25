package com.asignacitas.testng;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AsigbaCitasTestNG {
	WebDriver driver;
	private String baseUrl;
	Select selectItem;
	Scanner in = new Scanner(System.in);
	
	
	

	// FormularioLogIn
	By UsernameLocator = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
	By PaswordLocator = By.xpath("(//input[@class='dx-texteditor-input'])[2]");
	By Login = By.xpath("//div[@class='dx-button dx-button-default dx-button-mode-contained dx-widget dx-button-has-text']");
	By ValidaLogIn = By.xpath("//div[@class='oph-toast-right-text']/p");

	// FormularioHomeSelectTarAsignaCita
	By TarjetaAsignacionCitaLocator = By.xpath("(//div[@class='cardContent-container'])[21]");
	By ModuloAsignaCitas = By.xpath("(//div[@class='cardContent-container'])[18]");
	By ModuloFichaClinica = By.xpath("(//div[@class='cardContent-container'])[1]");
	By SelectFichaTecProcedAmbulatorio = By.xpath("//div[@id='Ambulatorio']");
	By SelectFichaTecProcedAmbulatorioTipoId = By.xpath("(//div[@class='dx-dropdowneditor-icon'])[1]");
	By BtnActualizaPage = By.xpath("//ngb-tabset[@class='home-ngbTabset']/..//ul[1]//li[2]/a[1]/i[2]");
	By PageModuloLocator = By.xpath("(//div[@class='cardContent-container'])[1]");
	By PageModuloLocatorModFichaClinica = By.xpath("//div[@class='dx-button dx-button-success dx-button-mode-contained dx-widget dx-button-has-icon dx-button-has-text']");
	By dropdownListTipoProcemiento = By.xpath("//div[@class='list-content']");
	By clickCloseWindows = By.xpath("//a[@id='604564a184b3e48ef08d9e87']/i[3]");
	By clickCloseWindowsComfirm = By.xpath("((//*[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable dx-popup-inherit-height'])/..//div[@class='dx-button-content'])[1]");
	// FormularioGestionarHora
	By SelecBtnTipoDoc = By.xpath("((//div[@class='dx-button-content'])[1])/div[last( )]");
	By SelectTipoDoc = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[2]");
	By DigitaNumDoc = By.xpath("(//input[@class='dx-texteditor-input'])[2]");
	By SearchBtnPaciente = By.xpath("//dx-button[@class='filter-button dx-button dx-button-success dx-button-mode-contained dx-widget dx-button-has-icon dx-button-has-text']");
	By SelectBtnListaDeEspera = By.xpath("//dx-button[@class='filter-button dx-button dx-button-success dx-button-mode-contained dx-widget dx-button-has-text']");
	// FomuarioBuscarHistoricoHoras
	By SelectBtnHistorico1 = By.xpath("//dx-button[@class='styleButton dx-button dx-button-normal dx-button-mode-contained dx-widget dx-button-has-text']");
	By SelectBtnHistorico2 = By.xpath("((//div[@class='dx-button-content'])[4])/span");
	By SelectBtnProgramar1 = By.xpath("//dx-button[@class='dx-button dx-button-success dx-button-mode-contained dx-widget dx-button-has-text']");
	By ClicListaDesplegableEstado = By.xpath("(//div[@class='dx-dropdowneditor-icon'])[2]");
	By ClicListaDesplegableEspecialidadHist = By.xpath("");
	By ClicListaDesplegableSucursalHist = By.xpath("");
	By InputFechaDesde = By.xpath("(//div[@class='dx-texteditor-input-container'])[6]");
	By InputFechaHasta = By.xpath("(//div[@class='dx-texteditor-input-container'])[7]");
	By SelectBtnBuscarHistorico = By.xpath("(//div[@class='dx-button dx-button-success dx-button-mode-contained dx-widget dx-button-has-icon dx-button-has-text'])");
	By ClicCloseFormHistorico = By.xpath("(//div[@class='dx-toolbar-after']//div/i[@class='dx-icon dx-icon-close'])[1]");

	// FormularioProgrmarHoras
	By SelectBtnProgramar = By.xpath("((//div[@class='dx-button-content'])[5])/span");
	By SelectBtnTipoHora = By.xpath("((//div[@class='dx-button-content'])[1])/div");
	By SelectTipoHora = By.xpath("(//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content'])[2]");
	By SelectDropDownListBtnEspecialidadProgHora = By.xpath("((//div[@class='dx-button-content'])[2])/div");
	By SelectEspecialidadProgHora = By.xpath("(//input[@class='dx-texteditor-input'])[2]"); // ingresar nombre especialidad -para lista larga
	By SelectEspecialidadProgHoraSelecList = By.xpath("(//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content'])[7]");// Tener presente que se selecciona el primero de la lista (comienza en posición '7')																																																		
	By SelectDropDownListBtnPrestacion = By.xpath("((//div[@class='dx-button-content'])[3])/div");
	By SelectPrestacionSelectList = By.xpath("(//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content'])[last( )]");
	By SelectDropDownListBtnModalidad = By.xpath("((//div[@class='dx-button-content'])[4])/div");
	By SelectModalidadSeletList = By.xpath("(//div[@class='dx-scrollview-content']/..//div[@class='dx-item-content dx-list-item-content'])[12]");
	By SelectDropDownListBtnSucursal = By.xpath("((//div[@class='dx-button-content'])[5])/div");
	By SelectSucursalSeletList = By.xpath("(//div[@class='dx-scrollview-content']/..//div[@class='dx-item-content dx-list-item-content'])[16]");
	By MensajeAdvertenciaFaltaDiligCampo = By.xpath("//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable dx-popup-flex-height']");
	By SelectBtnPrograma = By.xpath("((//div[@class='dx-button-content'])[6])/div");
	By SelectBtnActividades = By.xpath("((//div[@class='dx-button-content'])[7])/div");
	By SelectBtnProfesional = By.xpath("//div[@class='dx-texteditor-input-container dx-tag-container dx-native-click']");
	By SelectProfesionalSeletList = By.xpath("(//div[@class='dx-scrollview-content']/..//div[@class='dx-item-content dx-list-item-content'])[17]");
	// Formulario calendario
	By SelectBtnBuscarProgCita = By.xpath("//dx-button[@text='Buscar']");
	By SelectFrameCalendar = By.xpath("//div[@class='iframe-container']");
	By SeledctBtnMes = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Semana'])[1]/following::div[1]");
	By SeledctCitaCalendar = By.xpath("((//div[@class='dx-item dx-scheduler-appointment dx-scheduler-appointment-horizontal dx-resizable'])/..//strong)[4]");// Seleccionar del calendario																																																					 
	By SeledctListCitasCalendar = By.xpath("((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div/strong");
	By SelectFormProgramarHora = By.xpath("//div[@class='dx-popup-content' and @style='height: auto; max-height: 572.065px; min-height: 0px;']");
	By SelectBtnBoxCosultorio = By.xpath("(//div[@class='dx-popup-content' and @style='height: auto; max-height: 572.065px; min-height: 0px;']/..//*[@class='dx-field-item-content dx-field-item-content-location-bottom'])[8]");
	By SelectBoxCosultorio = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[1]");
	By SelectBtnFormProgramaHoraHecho = By.xpath("//*/text()[normalize-space(.)='Hecho']/parent::*");
	By SelectPopUpValidaCalendar = By.xpath("//div[@class='dx-toast-message']");
	By SelectPopUpValidaComfirmaCita = By.xpath("(//*[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable dx-popup-flex-height'])/..//div[@class='dx-item-content dx-list-item-content']");
	// por utilizar en otros flujos del formulario.
	By SelectBtnMesAño = By.xpath("//div[@class='dx-scheduler-navigator-caption dx-button dx-button-normal dx-button-mode-contained dx-widget dx-button-has-text']");
	By SelectBtnPrevioPeriodo = By.xpath("//div[@class='dx-scheduler-navigator-previous dx-button dx-button-normal dx-button-mode-contained dx-widget dx-button-has-icon']");
	By SelectBtnNextPeriodo = By.xpath("//div[@class='dx-scheduler-navigator-next dx-button dx-button-normal dx-button-mode-contained dx-widget dx-button-has-icon']");
	By SeledctBtnDia = By.xpath("//view-calendar/dx-scheduler/div[1]/div[2]/div/div[1]");
	By SeledctBtnSem = By.xpath("//view-calendar/dx-scheduler/div[1]/div[2]/div/div[2]");
	By SeledctBtnVolver = By.xpath("//dx-button[@text='Volver']");
	By SelectBtnProgListaDeEspera = By.xpath("//dx-button[@text='Lista de Espera']");

	WebDriverWait TiempoMin;
	WebDriverWait TiempoMax;
	JavascriptExecutor js;
	
	//static void Select_Calendar(String usuario, String pass, String NumeroDocumento, String Nacionalidad,String FechaCalendario,String dates,String Agenda ,String Horas,int cont, String Hora) {}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().window().maximize();
		driver.get("https://factoryaut.digitalwaresaas.com.co:8082/Agora/#/login");
	}

	// User LogIn
	@Test(priority = 0)
	public void signIn() throws InterruptedException {
		Thread.sleep(1000); // Time recomedable para que no se presente un alto delay en la ejecución.
		driver.findElement(UsernameLocator).click();
		// Thread.sleep(3000); //Activar para cuando se tenga una lista de usuarios
		driver.findElement(UsernameLocator).clear();
		driver.findElement(UsernameLocator).sendKeys("pablom");
		driver.findElement(PaswordLocator).click();
		// Thread.sleep(3000); //Activar para cuando se tenga una lista de usuarios
		driver.findElement(PaswordLocator).clear();
		driver.findElement(PaswordLocator).sendKeys("Klinic2021**");
		Thread.sleep(3000);
		driver.findElement(Login).click();
		Thread.sleep(2000);
		Boolean Val = false;
		String Cadena = "";

		try {
			Cadena = driver.findElement(ValidaLogIn).getText().strip();
			Val = true;
		} catch (Exception e) {
			Val = false;
		}

		if (Val == true) {
			if (Cadena.equals("Usuario y/o contraseña inválido")) {
				System.out.println("Usuario y/o contraseña inválido");

			} else {
				System.out.println("Credenciales correctas");
			}

		}
		Thread.sleep(8000);
	}

	// InToModuloFichaClinicaMedica
	// Se ingresa a la tarjeta para traer los archivos que contiene las listas
	// desplegables para utilizar en AsignaCita 01-09-2021

	@Test(priority = 1)
	public void IngresoModuloFichaClinicaMedica() throws InterruptedException, IOException {
		TiempoMin = new WebDriverWait(driver, 10);
		TiempoMax = new WebDriverWait(driver, 80);
		TiempoMin.until(ExpectedConditions.elementToBeClickable(PageModuloLocator));
		driver.findElement(ModuloFichaClinica).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(SelectFichaTecProcedAmbulatorio).click();
		Thread.sleep(3000);
		//Se Agregó este actulizar para poder ingresar al fomulario de Ambulatorio 
		driver.switchTo().defaultContent();
		driver.findElement(BtnActualizaPage).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(SelectFichaTecProcedAmbulatorio).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(SelectFichaTecProcedAmbulatorioTipoId).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.findElement(clickCloseWindows).click();
		Thread.sleep(1000);
		driver.findElement(clickCloseWindowsComfirm).click();
		Thread.sleep(2000);
	}
	// InToModuloAsignaCitas

	@Test(priority = 2)
	public void IngresoModuloAsignacionAgenda() throws InterruptedException, IOException {
		TiempoMin = new WebDriverWait(driver, 10);
		TiempoMax = new WebDriverWait(driver, 80);
		TiempoMin.until(ExpectedConditions.elementToBeClickable(PageModuloLocator));
		WebElement element = driver.findElement(TarjetaAsignacionCitaLocator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(TarjetaAsignacionCitaLocator).click();
	}

	// GestionAsignaCita

	@SuppressWarnings("unused")
	@Test(priority = 3)
	public void MakeAsignaCita() throws InterruptedException, IOException {
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(SelecBtnTipoDoc).click();
		driver.findElement(SelectTipoDoc).click();
		driver.findElement(DigitaNumDoc).clear();
		driver.findElement(DigitaNumDoc).sendKeys("6584933"); //
		driver.findElement(SearchBtnPaciente).click();
		Thread.sleep(3000);
		driver.findElement(SelectBtnProgramar).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();// Cierra todos los paneles
		driver.switchTo().frame(0);// Ingresa al panel cero
		Thread.sleep(5000);
		driver.findElement(SelectBtnTipoHora).click();
		driver.findElement(SelectTipoHora).click();
		Thread.sleep(3000);
		// driver.findElement(SelectDropDownListBtnEspecialidadProgHora).click();
		driver.findElement(SelectEspecialidadProgHora).click();
		driver.findElement(SelectEspecialidadProgHora).clear();
		driver.findElement(SelectEspecialidadProgHora).sendKeys("CARDIOLOGIA");
		Thread.sleep(3000);
		driver.findElement(SelectEspecialidadProgHoraSelecList).click();
		Thread.sleep(3000);
		driver.findElement(SelectDropDownListBtnPrestacion).click();
		Thread.sleep(3000);
		driver.findElement(SelectPrestacionSelectList).click();
		Thread.sleep(3000);
		driver.findElement(SelectDropDownListBtnModalidad).click();
		driver.findElement(SelectModalidadSeletList).click();
		Thread.sleep(3000);
		driver.findElement(SelectDropDownListBtnSucursal).click();
		driver.findElement(SelectSucursalSeletList).click();
		Thread.sleep(3000);
		driver.findElement(SelectBtnProfesional).click();
		driver.findElement(SelectProfesionalSeletList).click();
		Thread.sleep(3000);
		driver.findElement(SelectBtnBuscarProgCita).click();
		// valida Actualiza calendario
		String Cadena1 = "";
		boolean Val1;

		try {
			Thread.sleep(1000);
			Cadena1 = driver.findElement(SelectPopUpValidaCalendar).getText().strip();
			Val1 = true;
		} catch (Exception e) {
			Val1 = false;
		}

		if (Val1 == true) {
			if (Cadena1.equals("Calendario Actualizado")) {
				System.out.println("El calendario fue actualizado");

			} else {
				System.out.println("Vuelva a presionar botón buscar");
			}

		}
		Thread.sleep(5000);
	    driver.switchTo().frame("pruebaiframe");
		driver.findElement(SeledctBtnDia).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//view-calendar/dx-scheduler/div[1]/div[2]/div/div[1]"));
		Thread.sleep(2000);
		String FechaCalendario=driver.findElement(By.xpath("((//div[@class='dx-scheduler-header dx-widget']))/..//div[@class='dx-button-content']/span")).getText().strip();
		String Mes = FechaCalendario.split(" ")[1];
		String Year = FechaCalendario.split(" ")[2];
		String Dia = FechaCalendario.split(" ")[0];		
		String FechaCita="20 diciembre 2021"; // Fecha de la cita
		String MesCita = FechaCita.split(" ")[1];
		String YearCita = FechaCita.split(" ")[2];
		String DiaCita = FechaCita.split(" ")[0];	
		String Hora="16:00 - 16:20";// Hora de la cita 

		
		while ((!DiaCita.equals(Dia)) || (!MesCita.equals(Mes))|| (!YearCita.equals(Year))) { // para Ubicar mes y año que sea igual ala fecha de la cita
			driver.findElement(By.xpath("((//div[@class='dx-scheduler-header dx-widget'])/..//div[@class='dx-button-content'])[3]")).click();
			Thread.sleep(100);
			Mes = FechaCalendario=driver.findElement(By.xpath("((//div[@class='dx-scheduler-header dx-widget']))/..//div[@class='dx-button-content']/span")).getText().strip();
			Mes = FechaCalendario.split(" ")[1];
			Year = FechaCalendario.split(" ")[2];
			Dia = FechaCalendario.split(" ")[0];
		}
		
		boolean veri=false;			
		//Thread.sleep(2000);
		try {
			WebElement element2 = driver.findElement(By.xpath("(((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div/strong)[1]"));
	  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2); //hace_Scroll_en_calendario_en_las_horas_del_día_hasta_que_encuentra_una cita 
	  		veri=true;
		}catch (Exception e) {				
			veri=false;
		}
		
  		Thread.sleep(1000);

  		if(veri==true) {
  			List<WebElement> dates = driver.findElements(SeledctListCitasCalendar);
  			int cont=1;
  			for(WebElement e : dates) {
  				Thread.sleep(500);
  				WebElement element2 = driver.findElement(By.xpath("((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div/strong"));//Citas_del_día_en_el_calendario
  				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
  				String Agenda=driver.findElement(By.xpath("(((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div/strong)["+cont+"]")).getText().strip();//Captura_el_nombre_y_la_hora 
  				String Horas=Agenda.split(" ")[3]+" - "+Agenda.split(" ")[5];//Se_Separa_las_Horas
  				System.out.println(Horas);
  				cont++;	
  				if (Hora.equals(Horas)) {  // las_validaciones 
  					System.out.println("Se encontró agenda disponible en esa fecha y hora");
  					System.out.println("Hay "+cont+"citas disponibles");
  					System.out.println("Horas disponibles "+Horas+" para citas ");
  					Thread.sleep(1000);
  					Actions actions = new Actions(driver);
  					WebElement elementLocator = driver.findElement(By.xpath("(((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div)["+cont+"]"));
  					actions.doubleClick(elementLocator).perform();
  					Thread.sleep(5000);
  					WebElement element4 = driver.findElement(SeledctBtnMes);
  					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
  					Thread.sleep(3000);
  					driver.findElement(SelectBtnBoxCosultorio).click();
  					driver.findElement(SelectBoxCosultorio).click();
  					Thread.sleep(3000);
  					//driver.findElement(SelectBtnFormProgramaHoraHecho).click();
  					Thread.sleep(5000);
  				   }


		// Valida Asigna cita
		String Cadena2 = "";
		boolean Val2;

		try {
			Thread.sleep(1000);
			Cadena2 = driver.findElement(SelectPopUpValidaComfirmaCita).getText().strip();
			Val2 = true;
			// System.out.println("El mensaje es: "+ Cadena2);
		} catch (Exception e1) {
			Val2 = false;
		}

		if (Val2 == true) {
			if (Cadena2.equals("Registro satisfactorio!!")) {
				System.out.println("El Registro fue satisfactorio!!");

			} else if (Cadena2.equals("El paciente ya tiene una fecha programada para la fecha indicada.")) {
				System.out.println("El paciente ya tiene una fecha programada para la fecha indicada.");

			} else {
				System.out.println("El paciente ya tiene una fecha programada para la fecha indicada.");
			}
			
			}
		
  			}
  			}
			}
		
		
  	

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
