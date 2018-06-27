package project.reportcreator.dto;

public class ReportDTO {
	
	private int salesmanQuantity;

	private int clientQuantity;

	private int mostExpensiveSaleId;
	
	private String worstSalesmanName;

	public String infosToWrite() {
		StringBuilder builder = new StringBuilder();
		builder.append("Report");
		builder.append("\nSalesman Count: ");
		builder.append(this.salesmanQuantity);
		builder.append("\nClient Count: ");
		builder.append(this.clientQuantity);
		builder.append("\nMost expensive sale ID: ");
		builder.append(this.mostExpensiveSaleId);
		builder.append("\nWorst Salesman: ");
		builder.append(this.worstSalesmanName);
		return builder.toString();
	}
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
