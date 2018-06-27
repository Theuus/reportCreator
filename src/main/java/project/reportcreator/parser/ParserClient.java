package project.reportcreator.parser;

import project.reportcreator.dto.InputFileDTO;
import project.reportcreator.model.Client;
import project.reportcreator.model.Domain;

public class ParserClient implements Parse{

	@Override
	public Domain parser(InputFileDTO inputFile) {
		String cnpj = inputFile.getField2();
		String name = inputFile.getField3();
		String businessArea =inputFile.getField4();
		return new Client(cnpj, name, businessArea);
	}

}
