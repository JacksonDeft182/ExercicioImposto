package entities;

public class Business extends TaxPayers {
	
	private Integer quantityEmployee;
	
	public Business() {
	}
	
	public Business(String name, Double yearlyIncome, Integer quantityEmployee) {
		super(name,yearlyIncome);
		this.quantityEmployee = quantityEmployee;
	}
	
	public Integer getQuantityEmployee() {
		return quantityEmployee;
	}

	public Integer setQuantityEmployee() {
		return this.quantityEmployee = quantityEmployee;
	}
	
	
	public Double taxesAmount(Double yearlyIncome) {
		Double taxes;
		if(quantityEmployee > 10) {
			return yearlyIncome = (yearlyIncome * 14)/100;
		}
		else {
			return yearlyIncome = (yearlyIncome * 16)/100;
		}

	}
	
	public String toString() {
		return super.toString()
			+	String.format("%.2f",taxesAmount(super.getYearlyIncome()));	
	}
}
