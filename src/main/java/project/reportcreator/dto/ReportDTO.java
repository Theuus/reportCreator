package project.reportcreator.dto;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = "\n")
public class ReportDTO {
	
	@DataField(pos = 1)
	private int salesmanQuantity;

	@DataField(pos = 2)
	private int clientQuantity;

	@DataField(pos = 3)
	private int mostExpensiveSaleId;
	
	@DataField(pos = 4)
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
	
	public ReportDTO(int salesmanQuantity, int clientQuantity, int mostExpensiveSaleId, String worstSalesmanName) {
		this.salesmanQuantity = salesmanQuantity;
		this.clientQuantity = clientQuantity;
		this.mostExpensiveSaleId = mostExpensiveSaleId;
		this.worstSalesmanName = worstSalesmanName;
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
