package project.summarycreator.dto;

public class Salesman {
	
	private String cpf;
	
	private String name;
	
	private double salary;
	
	public Salesman(String[] lineSplit) {
		this.cpf = lineSplit[1];
		this.name = lineSplit[2];
		this.salary = Double.parseDouble(lineSplit[3]);
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
