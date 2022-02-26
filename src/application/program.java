package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class program {
	static Scanner sc;
	static Worker worker;
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {
		startProgram();
		inputWorker();
		inputContracts();
		calculateIncome();
		endProgram();
	}
	
	private static void calculateIncome() {
		System.out.println("Enter month and year to calculate income(MM/YYYY): ");
		String monthYear = sc.next();
		int month = Integer.parseInt(monthYear.substring(0, 2));
		int year = Integer.parseInt(monthYear.substring(3,7));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthYear + ": "+ String.format("%.2f%" , worker.income(year,month)));
		
		
		
	}
	public static void startProgram() {
		Locale.setDefault(Locale.US);
		sc = new Scanner(System.in);
	}
	public static void endProgram() {
		sc.close();
	}
	public static void inputWorker() {
		System.out.println("[ Department ]");
		System.out.println("Name: ");
		String dName= sc.nextLine();
		System.out.println("[ Worker ]");
		System.out.println("Name: ");
		String wName = sc.nextLine();
		System.out.println("Level: ");
		String wLevel = sc.nextLine();
		System.out.println("Base salary: ");
		double wBaseSalary = sc.nextDouble();
		worker = new Worker(wName, WorkerLevel.valueOf(wLevel), wBaseSalary, new Department(dName));
		
	}
	
	public static void inputContracts() throws ParseException {
		System.out.println("[ How many contracts to this worker? ] ");
		int n = sc. nextInt();
		for (int i=1; i<=n;i++) {
			System.out.println("Contract DATE (DD/MM/AAAA): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value per hour: ");
			double valuePerHour= sc.nextDouble();
			System.out.println("Duration (hour): ");
			int contractHours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, contractHours);
			worker.addContract(contract);
		}
	}
	

}
