package entities;

public class PhysicalPerson extends Person{
	
	private Double healthExpenses;
	
	public PhysicalPerson() {
		super();
	}

	public PhysicalPerson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}



	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	
	@Override
	public Double totalTax() {
		if (getAnnualIncome() < 20000.00) {
			return getAnnualIncome() * 0.15 - healthExpenses * 0.5;
		}
		else {
			return getAnnualIncome() * 0.25 - healthExpenses * 0.5;
		}
	}

}
