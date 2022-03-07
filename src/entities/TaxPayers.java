package entities;

public abstract class TaxPayers  {

		private String name;
		private Double yearlyIncome;
		
		public TaxPayers() {
		}
		
		public TaxPayers(String name, Double yearlyIncome) {
			this.name = name;
			this.yearlyIncome = yearlyIncome;
		}
		
		public String getName() {
			return name;
		}
		
		public String setName(String name) {
			return this.name = name;
		}
		
		public Double getYearlyIncome() {
			return this.yearlyIncome = yearlyIncome;
		}
		
		public abstract Double taxesAmount(Double yearlyIncome);
		
		public  String toString() {
			return name
				+	": $ " ;
		}

}
