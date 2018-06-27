package project.reportcreator.parser;

import org.junit.Test;

import junit.framework.TestCase;
import project.reportcreator.model.Salesman;
import project.reportcreator.utils.BuildInputFileDTO;

public class ParserSalesmanTest extends TestCase {

	@Test
	public void testCreateSalesman() {
		BuildInputFileDTO buildInputFileDTO = new BuildInputFileDTO();
		ParserSalesman parserSalesman = new ParserSalesman();

		Salesman salesman = (Salesman) parserSalesman.parser(buildInputFileDTO.build("001", "CPF", "NAME", "100"));
				
		assertEquals("CPF",salesman.getCpf());
		assertEquals("NAME",salesman.getName());
		assertEquals(100.0,salesman.getSalary());
	}
}
