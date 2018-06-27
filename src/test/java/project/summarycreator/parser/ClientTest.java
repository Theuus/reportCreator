package project.summarycreator.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import project.reportcreator.model.Client;
import project.summarycreator.utils.BuildInputFileDTO;

public class ClientTest {

	@Test
	public void testCreateClient() {
		BuildInputFileDTO buildInputFileDTO = new BuildInputFileDTO();
		Client client = new Client(buildInputFileDTO.build("002", "CNPJ", "NAME", "BussinesArea"));
		
		assertEquals("CNPJ",client.getCnpj());
		assertEquals("NAME",client.getName());
		assertEquals("BussinesArea",client.getBusinessArea());
	}

}
