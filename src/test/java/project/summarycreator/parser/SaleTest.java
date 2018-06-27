package project.summarycreator.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import project.reportcreator.model.Sale;

public class SaleTest {

	@Test
	public void testCreateSale() {
		String line = "002ç1ç[1-2-30,2-3-10]çSalesmanName";
		Sale sale = new Sale(line.split("ç"));
		
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
