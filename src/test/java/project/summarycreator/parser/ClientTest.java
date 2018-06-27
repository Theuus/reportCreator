package project.summarycreator.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import project.reportcreator.model.Client;

public class ClientTest {

	@Test
	public void testCreateClient() {
		String line = "002çCNPJçNAMEçBussinesArea";
		Client client = new Client(line.split("ç"));
		
		assertEquals("CNPJ",client.getCnpj());
		assertEquals("NAME",client.getName());
		assertEquals("BussinesArea",client.getBusinessArea());
	}

}
