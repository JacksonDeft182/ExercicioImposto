package entities;

public class Individual extends TaxPayers {

		private Double healthExpenses;
		
		
		public Individual() {
			super();
		}
		
		public Individual(String name, Double yearlyIncome, Double healthExpenses) {
			super(name,yearlyIncome);
			this.healthExpenses = healthExpenses;
		}
			
		public Double getHealthExpenses() {
			return healthExpenses;
		}
		
		public Double setHealthExpenses(Double healthExpenses) {
			return this.healthExpenses = healthExpenses;
		}
			
			
		public Double taxesAmount(Double yearlyIncome) {
			Double yIncome =super.getYearlyIncome();
			if(yIncome <= 20000.00) {
				yearlyIncome = ((yIncome * 15)/100 - healthExpenses/2);
				return yearlyIncome;
			}
			else {
				yearlyIncome = ((yIncome * 25)/100 - healthExpenses/2);
				return yearlyIncome;
			}
		}
		
		@Override
		public String toString() {
			return  super.toString()
				+ String.format("%.2f",taxesAmount(super.getYearlyIncome()));
		}
}

