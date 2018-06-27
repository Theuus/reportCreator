package project.reportcreator.model;

public class Salesman implements Domain {
	
	private String cpf;
	
	private String name;
	
	private double salary;
	
	public Salesman(String cpf, String name, double salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
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
