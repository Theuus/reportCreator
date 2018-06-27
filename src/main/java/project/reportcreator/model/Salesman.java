package project.reportcreator.model;

import project.reportcreator.dto.InputFileDTO;

public class Salesman {
	
	private String cpf;
	
	private String name;
	
	private double salary;
	
	public Salesman(InputFileDTO line) {
		this.cpf = line.getField2();
		this.name =  line.getField3();
		this.salary = Double.parseDouble(line.getField4());
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

}
