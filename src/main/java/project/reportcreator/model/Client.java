package project.reportcreator.model;

import project.reportcreator.dto.InputFileDTO;

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

	public Client(InputFileDTO inputFileDTO) {
		this.cnpj = inputFileDTO.getField2();
		this.name = inputFileDTO.getField3();
		this.businessArea = inputFileDTO.getField4();
	}
}
