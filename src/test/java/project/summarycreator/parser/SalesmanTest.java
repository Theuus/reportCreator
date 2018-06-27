package project.summarycreator.parser;

import org.junit.Test;

import junit.framework.TestCase;
import project.reportcreator.model.Salesman;
import project.summarycreator.utils.BuildInputFileDTO;

public class SalesmanTest extends TestCase {

	@Test
	public void testCreateSalesman() {
		BuildInputFileDTO buildInputFileDTO = new BuildInputFileDTO();
		Salesman salesman = new Salesman(buildInputFileDTO.build("001", "CPF", "NAME", "100"));
		
		assertEquals("CPF",salesman.getCpf());
		assertEquals("NAME",salesman.getName());
		assertEquals(100.0,salesman.getSalary());
	}
}
