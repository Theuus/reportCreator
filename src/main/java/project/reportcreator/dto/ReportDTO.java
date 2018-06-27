package project.reportcreator.dto;

public class ReportDTO {
	
	private int salesmanQuantity;

	private int clientQuantity;

	private int mostExpensiveSaleId;
	
	private String worstSalesmanName;

	public int getSalesmanQuantity() {
		return salesmanQuantity;
	}

	public void setSalesmanQuantity(int salesmanQuantity) {
		this.salesmanQuantity = salesmanQuantity;
	}

	public int getClientQuantity() {
		return clientQuantity;
	}

	public void setClientQuantity(int clientQuantity) {
		this.clientQuantity = clientQuantity;
	}

	public int getMostExpensiveSaleId() {
		return mostExpensiveSaleId;
	}

	public void setMostExpensiveSaleId(int mostExpensiveSaleId) {
		this.mostExpensiveSaleId = mostExpensiveSaleId;
	}

	public String getWorstSalesmanName() {
		return worstSalesmanName;
	}

	public void setWorstSalesmanName(String worstSalesmanName) {
		this.worstSalesmanName = worstSalesmanName;
	}
}
