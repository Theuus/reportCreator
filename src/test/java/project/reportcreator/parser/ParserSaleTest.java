package project.reportcreator.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import project.reportcreator.model.Sale;
import project.reportcreator.utils.BuildInputFileDTO;

public class ParserSaleTest {

	@Test
	public void testCreateSale() {
		BuildInputFileDTO buildInputFileDTO = new BuildInputFileDTO();
		ParserSale parserSale = new ParserSale();
		
		Sale sale = (Sale) parserSale.parser(buildInputFileDTO.build("002","1","[1-2-30,2-3-10]", "SalesmanName"));
		
		assertEquals(1, sale.getId());
		assertEquals("SalesmanName",sale.getSalesmanName());
		assertEquals(2, sale.getListItem().size());
		
		assertEquals(1, sale.getListItem().get(0).getId());
		assertEquals(2, sale.getListItem().get(0).getQuantity());
		assertEquals(30, sale.getListItem().get(0).getPrice(), 0.0);

		assertEquals(2, sale.getListItem().get(1).getId());
		assertEquals(3, sale.getListItem().get(1).getQuantity());
		assertEquals(10, sale.getListItem().get(1).getPrice(), 0.0);
		assertEquals(3*10, sale.getListItem().get(1).getTotalPrice(), 0.0);

	
	}

}
