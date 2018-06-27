package project.summarycreator.utils;

import project.reportcreator.dto.InputFileDTO;

public class BuildInputFileDTO {
	
	public InputFileDTO build(String field1, String field2, String field3, String field4) {
		InputFileDTO inputFileDTO = new InputFileDTO();
		inputFileDTO.setField1(field1);
		inputFileDTO.setField2(field2);
		inputFileDTO.setField3(field3);
		inputFileDTO.setField4(field4);
		return inputFileDTO;
	}

}

