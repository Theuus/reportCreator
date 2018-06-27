package project.summarycreator.parser;

import org.junit.Test;

import junit.framework.TestCase;
import project.reportcreator.model.Salesman;

public class SalesmanTest extends TestCase {

	@Test
	public void testCreateSalesman() {
		String linha = "001çCPFçNAMEç100";
		Salesman salesman = new Salesman(linha.split("ç"));
		
		assertEquals("CPF",salesman.getCpf());
		assertEquals("NAME",salesman.getName());
		assertEquals(100.0,salesman.getSalary());
	}
}
