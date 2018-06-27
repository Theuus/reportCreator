package project.summarycreator.dto;

public class Client {

	private String cnpj;
	
	private String name;
	
	private String businessArea;
	
	public String getCnpj() {
		return cnpj;
	}

	public String getName() {
		return name;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public Client(String[] lineSplit) {
		this.cnpj = lineSplit[1];
		this.name = lineSplit[2];
		this.businessArea = lineSplit[3];
	}

}
