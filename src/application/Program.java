package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.Person;
import entities.PhysicalPerson;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Person> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Physical Person or Legal Person (p/l)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income : ");
			double annualIncome = sc.nextDouble();
			
			if(type == 'p') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				list.add(new PhysicalPerson(name, annualIncome, healthExpenditures));
			}
			else {
				System.out.print("Number of Employees: ");
				int employeesNumber = sc.nextInt();
				
				list.add(new LegalPerson(name, annualIncome, employeesNumber));
			}
			
		}
		
		System.out.println();
		System.out.println("TAXES PAID");
		
		double sum = 0.0;
		for(Person person : list) {
			double tax = person.totalTax();
			System.out.println(person.getName() + ": $ " + String.format("%.2f", person.totalTax()));
			sum += tax;
		}
		
		System.out.println();
		System.out.print("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}

}
