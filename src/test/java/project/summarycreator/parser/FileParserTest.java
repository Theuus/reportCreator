package project.summarycreator.parser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import project.reportcreator.model.ListEntity;
import project.reportcreator.parser.FileParser;
import project.summarycreator.utils.BuildInputFileDTO;

public class FileParserTest {

	@Test
	public void test() throws IOException {
		FileParser fileParser = new FileParser();

		BuildInputFileDTO buildInputFileDTO = new BuildInputFileDTO();
		
		//buildInputFileDTO.build(field1, field2, field3, field4);
		
		//ListEntity listEntity = fileParser.parser(in);
		
//		assertEquals(2, listEntity.getListSalesman().size());
//		assertEquals(2, listEntity.getListClient().size());
//		assertEquals(2, listEntity.getListSale().size());
	}

}
