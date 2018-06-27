package project.reportcreator.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import project.reportcreator.model.Client;
import project.reportcreator.utils.BuildInputFileDTO;

public class ParserClientTest {

	@Test
	public void testCreateClient() {
		BuildInputFileDTO buildInputFileDTO = new BuildInputFileDTO();
		ParserClient parserClient = new ParserClient();
		Client client = (Client) parserClient.parser(buildInputFileDTO.build("002", "CNPJ", "NAME", "BussinesArea"));
		
		assertEquals("CNPJ",client.getCnpj());
		assertEquals("NAME",client.getName());
		assertEquals("BussinesArea",client.getBusinessArea());
	}

}
