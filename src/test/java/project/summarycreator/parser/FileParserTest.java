package project.summarycreator.parser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import project.reportcreator.model.ListaDeAbacaxi;
import project.reportcreator.parser.FileParser;

public class FileParserTest {

	@Test
	public void test() throws IOException {
		FileParser fileParser = new FileParser();
		
		Path caminho = Paths.get(System.getProperty("user.home"), 
		        "data/in/teste.dat");

		ListaDeAbacaxi listaDeAbacaxi = fileParser.parser(Files.lines(caminho), "ç");
		
		assertEquals(2, listaDeAbacaxi.getListSalesman().size());
		assertEquals(2, listaDeAbacaxi.getListClient().size());
		assertEquals(2, listaDeAbacaxi.getListSale().size());
	}

}
