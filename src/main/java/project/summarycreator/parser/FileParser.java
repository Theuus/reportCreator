package project.summarycreator.parser;

import java.util.stream.Stream;

import project.summarycreator.dto.Client;
import project.summarycreator.dto.ListaDeAbacaxi;
import project.summarycreator.dto.Sale;
import project.summarycreator.dto.Salesman;

public class FileParser {
	
	private ListaDeAbacaxi listaDeAbacaxi = new ListaDeAbacaxi();
	
	public ListaDeAbacaxi fileParser(Stream<String> linhas, String delimiter) {
		if(linhas == null) {
			//LOG
			return listaDeAbacaxi;
		}
		linhas.forEach(line->flowDecision(delimiter, line));
		
		return listaDeAbacaxi;
	}

	private void flowDecision(String delimiter, String line) {
		String[] lineSplit = line.split(delimiter);
		if("001".equals(lineSplit[0])) {
			listaDeAbacaxi.addListSalesman(new Salesman(lineSplit));
		} else if("002".equals(lineSplit[0])) {
			listaDeAbacaxi.addListClient(new Client(lineSplit));
		} else if("003".equals(lineSplit[0])) {
			listaDeAbacaxi.addListSale(new Sale(lineSplit));
		}
	}

}
