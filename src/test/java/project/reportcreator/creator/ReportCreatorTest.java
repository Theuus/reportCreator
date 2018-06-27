package project.reportcreator.creator;

import static org.junit.Assert.*;

import org.junit.Test;

import project.reportcreator.dto.ReportDTO;
import project.reportcreator.model.Client;
import project.reportcreator.model.ListEntity;
import project.reportcreator.model.Sale;
import project.reportcreator.model.Salesman;

public class ReportCreatorTest {

//	@Test
//	public void testReportCreator() {
//		ReportCreator creator = new ReportCreator();
//		ListEntity abacaxi = new ListEntity();
//		
//		abacaxi.addListClient(buildClient());
//		abacaxi.addListSalesman(buildSalesman());
//		
//		String[] lineSplit = {"003", "1", "[1-2-30,2-3-10]", "SalesmanName"};
//		abacaxi.addListSale(buildSale(lineSplit));
//		
//		String[] lineSplit2 = {"003", "2", "[1-2-100,2-1-10]", "Name"};
//		abacaxi.addListSale(buildSale(lineSplit2));
//		
//		String[] lineSplit3 = {"003", "3", "[1-2-10,2-1-10]", "Name"};
//		abacaxi.addListSale(buildSale(lineSplit3));
//		
//		//ReportDTO reportDTO = creator.creator(abacaxi);
//		
//		assertEquals(1, reportDTO.getClientQuantity());
//		assertEquals(1, reportDTO.getSalesmanQuantity());
//		assertEquals(2, reportDTO.getMostExpensiveSaleId());
//		assertEquals("SalesmanName", reportDTO.getWorstSalesmanName()); 
//	}

//	private Client buildClient() {
//		String[] lineSplit = {"002", "CNPJ", "NAME", "BussinesArea"};
//		return new Client(lineSplit );
//	}
//	
//	private Salesman buildSalesman() {
//		String[] lineSplit = {"001", "CPF", "NAME", "100"};
//		return new Salesman(lineSplit );
//	}
//	
//	private Sale buildSale(String[] lineSplit) {
//		return new Sale(lineSplit );
//	}

}
