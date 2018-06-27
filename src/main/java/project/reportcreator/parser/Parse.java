package project.reportcreator.parser;

import project.reportcreator.dto.InputFileDTO;
import project.reportcreator.model.Domain;

public interface Parse {

	Domain parser(InputFileDTO inputFile);
}
