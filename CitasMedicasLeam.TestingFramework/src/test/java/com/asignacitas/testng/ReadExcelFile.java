package com.asignacitas.testng;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
	// Método que nos permite leer una hoja de Excel fila por fila y cada una de las celadas

	// Método constructor
	public ReadExcelFile(File filename) {
	}
	// lee todo el archivo de excel y se pasan los parametros

	public ReadExcelFile() {
		// TODO Auto-generated constructor stub
	}

	public void readExcelStrin(String filepath, String sheetName) throws IOException { // "filepaht"ruta del archivo excel, "sheetName"Nombre de la hoja.
																						

		File file = new File(filepath); // se crea objeto de tipo file, Es el Panth donde va estar el fichero

		FileInputStream inputStream = new FileInputStream(file); //

		@SuppressWarnings("resource")
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);// En el "inputStream" es donde están todos los datos de los archivo que se cargó --- Objeto donde se guarda el fichero -- la hoja de trabajo

		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);// Se crea el objeto que es la hoja con la que se esta
																// trabajando.

		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum(); // Variable para guardar cant filas

		for (int i = 0; i <= rowCount; i++) { // cicly for count row

			XSSFRow row = newSheet.getRow(i); // row--se va iterando por cada fila

			for (int j = 0; j < rowCount; j++) { // cell row -- se va iterando sobre todas las celdas de cada fila --
													// bajo el supuesto que todas las celdas tienen la misma cantidad de
													// filas.
				System.out.println(row.getCell(j).getStringCellValue() + "");
			}
		}

	}

	// Métdo que permite leer una celda especifica

	public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

		File file = new File(filepath);

		FileInputStream inputStream = new FileInputStream(file);

		@SuppressWarnings("resource")
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

		XSSFRow row = newSheet.getRow(cellNumber); // Celda de la fila
		XSSFCell cell = row.getCell(cellNumber); // Número de celda

		return cell.getStringCellValue();
	}

}
