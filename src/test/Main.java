package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.SistemaSaludDispositivos;

//Parcial 2022
//Realizado 22-9-2025
//Tiempo utilizado: 1:20
//Dificultades: Convertir caracteres a numeros 
//Nota estimada: 8

public class Main {

	public static void main(String[] args) {
		SistemaSaludDispositivos sistema = new SistemaSaludDispositivos();
		
		
		try {
			System.out.println("Test 1");
			sistema.agregarEmpresa("Empresa 1");
			sistema.agregarEmpresa("Empresa 2");
			System.out.println(sistema.getListaEmpresas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Test 2");
		System.out.println(sistema.traerEmpresa("Empresa 2"));
		
		try {
			System.out.println("Test 3");
			sistema.agregarDispositivo("Sensor Humedad", "A2020", sistema.traerEmpresa("Empresa 1"));
			sistema.agregarDispositivo("Sensor Temperatura", "A2325", sistema.traerEmpresa("Empresa 1"));
			sistema.agregarDispositivo("Sensor Presion", "B2021", sistema.traerEmpresa("Empresa 2"));
			sistema.agregarDispositivo("Sensor Calor", "B2326", sistema.traerEmpresa("Empresa 2"));
			System.out.println(sistema.getListaDispositivos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 4");
			sistema.agregarDispositivo("Sensor Movimiento", "A2021", sistema.traerEmpresa("Empresa 1"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("Test 5");
		System.out.println(sistema.traerDispositivo("B2326"));
		
		System.out.println("Test 6");
		sistema.traerDispositivo("B2326").agregarMetrica(
				18, 
				LocalDate.of(2022, 9, 18), 
				LocalTime.of(10, 00));
		
		sistema.traerDispositivo("B2326").agregarMetrica(
				19, 
				LocalDate.of(2022, 9, 19), 
				LocalTime.of(12, 30));
		
		sistema.traerDispositivo("B2326").agregarMetrica(
				23, 
				LocalDate.of(2022, 9, 20), 
				LocalTime.of(15, 00));
		sistema.traerDispositivo("B2326").agregarMetrica(
				20, 
				LocalDate.of(2022, 9, 21), 
				LocalTime.of(18, 30));
		sistema.traerDispositivo("B2326").agregarMetrica(
				18, 
				LocalDate.of(2022, 9, 22), 
				LocalTime.of(22, 30));
		System.out.println(sistema.traerDispositivo("B2326").getListaMetricas());
		
		
		System.out.println("Test 7");
		System.out.println(sistema.traerDispositivo("B2326").traerMetrica(
				LocalDate.of(2022, 9, 19), 
				LocalTime.of(12, 30)));
		
		
		System.out.println("Test 8");
		System.out.println(sistema.traerDispositivo("B2326").traerMetricas(
				LocalDate.of(2022, 9, 19), 
				LocalDate.of(2022, 9, 21)));
		
		System.out.println("Test 9 V1");
		System.out.println(sistema.traerMetricas2(
				sistema.traerDispositivo("B2326"), 
				LocalDate.of(2022, 9, 19), 
				LocalDate.of(2022, 9, 21), 22));
		
		System.out.println("Test 9 V2");
		System.out.println(sistema.traerMetricas(
				sistema.traerDispositivo("B2326"), 
				LocalDate.of(2022, 9, 19), 
				LocalDate.of(2022, 9, 21), 22));
	}
}
