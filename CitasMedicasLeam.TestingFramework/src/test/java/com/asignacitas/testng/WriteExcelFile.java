package com.asignacitas.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	
	

	public WriteExcelFile() {
	}

	public void writeExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);// Se crea el archivo y se le pasa la ruta
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream); // Se crea el libro
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);// se crea el objeto de la hoja
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();// Da la cantidad de filas que exite y se escribira a aprtir de la última fila para no sobre escribir la info que ya se tiene
		XSSFRow row = newSheet.getRow(0);// objeto fila
		XSSFRow newRow = newSheet.createRow(rowCount + 1); // Crear una nueva fila
		for (int i = 0; i < row.getLastCellNum(); i++) { // se cuenta la fila de arriba que ya tiene la estructura de
															// las celdas
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWrite[i]);// El arreglo que se estan recibiendo en ls parametros del método
		}
		inputStream.close();

		FileOutputStream outputStream = new FileOutputStream(file); // permite escribir la información en el Excel
		newWorkbook.write(outputStream); // se pasa la información que viene en el outputStream
		outputStream.close();
	}
	// Método que permite crear un valaor en una celda espcifica min 17:44 del video
	// --- https://www.youtube.com/watch?v=_xS6PRP0l68

	public void writeCellvalue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException { // "resultText"se ingresa el texto que se desea escribir																													// 
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);// Se crea el archivo y se le pasa la ruta
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream); // Se crea el libro
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);// se crea el objeto de la hoja
		XSSFRow row = newSheet.getRow(rowNumber); //se crea la fila		
		XSSFCell firstCell = row.getCell(cellNumber - 1);//se crea una nueva celda para leer los terminos para las busquedas -- CellNumber hace referencia a la segunda celda donde se ue es donde se quiere escribir la cant. de prendas encontradas 
		System.out.println("first cell value is: "+ firstCell.getStringCellValue()); // envia al log del sistema el valor de esa primera celda
		XSSFCell nextCell=row.createCell(cellNumber); //siguiente celda 
		nextCell.setCellValue(resultText); // es lo que se esta pasando por el metodo como parametro.
		System.out.println("nextCell value: " + nextCell.getStringCellValue());
		inputStream.close();
		FileOutputStream  outputStream = new FileOutputStream(file); // se crea un nuevo output para escribir la información 
		newWorkbook.write(outputStream);
		outputStream.close();
	}
	
}
