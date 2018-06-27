package project.reportcreator.parser;

import project.reportcreator.dto.InputFileDTO;
import project.reportcreator.model.Domain;
import project.reportcreator.model.Salesman;

public class ParserSalesman implements Parse {

	@Override
	public Domain parser(InputFileDTO inputFile) {
		String cpf = inputFile.getField2();
		String name = inputFile.getField3();
		double salary = Double.parseDouble(inputFile.getField4());
		return new Salesman(cpf, name, salary);
	}

}
