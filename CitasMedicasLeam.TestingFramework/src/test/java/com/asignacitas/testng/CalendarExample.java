package com.asignacitas.testng;

import java.util.Scanner;

public class CalendarExample {

	public static void main(String[] args) { // TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// pide dato de entrada
		System.out.println("Ingrese año: ");
		int ano = sc.nextInt();
		// proceso para construir el calendar

		for (int i = 1; i <= 12; i++) {
			System.out.println("\nmes: " + i);
			System.out.println("Dom\tLun\tMar\tMie\tJue\tVie\tSab");
			int dias = diasMes(ano, i);
			//Calculamos espacios para que el dia del mes empiece en el día correcto de la semana 
			 int z = zeller (ano, i);
			 int contDia = 0;
			 for(int k = 0; k < z; k++) {
				 contDia++;
				 System.out.print("\t");  //"\t" tabulador
			 }
			
			//Se imprime los días del mes
			
			for(int j = 1; j<= dias; j++) {
			    System.out.print(j +"\t");
			    contDia++;
			    if(contDia == 7) {
			         System.out.println();
			         contDia = 0;
			    } 
			}
				
		}
	}
	//Funcion Zeller
	//Devuelve 
	// 0 = Domingo, 1 = Lunes, 2 = Martes, 3 = Miércoles 
	// 4 = Jueves, 5 = Viernes, 6 = Sábado
	private static int zeller (int ano,int mes) {
		int a = (14 - mes) / 12;
		int y = ano - a;
		int m = mes + 12 * a - 2;
		int dia = 1, d;
		d=(dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;
		return d;
	}
	
	
	
	

	// Saber cuantos días tiene el mes
	public static int diasMes(int ano, int mes) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			return 31;
		} else if (mes == 2) {
			if(esBisiesto(ano)) {
				return 29;
			} else {
				return 28;
			}		
		} else {
			return 30;
		}
		
		
	}

	// metodo para deteminar si un año es bisiesto

	public static boolean esBisiesto(int ano) {
		if (ano % 4 == 0) {
			if (ano % 100 == 0) {
				if (ano % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

}
