package project.reportcreator.parser;

import java.util.stream.Stream;

import project.reportcreator.model.Client;
import project.reportcreator.model.ListaDeAbacaxi;
import project.reportcreator.model.Sale;
import project.reportcreator.model.Salesman;

public class FileParser {
	
	private ListaDeAbacaxi listaDeAbacaxi = new ListaDeAbacaxi();
	
	public ListaDeAbacaxi parser(Stream<String> linhas, String delimiter) {
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
