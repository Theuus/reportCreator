package project.reportcreator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import project.reportcreator.dto.InputFileDTO;
import project.reportcreator.model.Domain;
import project.reportcreator.model.Item;
import project.reportcreator.model.Sale;

public class ParserSale implements Parse {

	@Override
	public Domain parser(InputFileDTO inputFile) {
		int id = Integer.parseInt(inputFile.getField2());
		List<Item> listItem = createListOfItems(inputFile);
		String salesmanName = inputFile.getField4();
		return new Sale(id, listItem, salesmanName);
	}

	private List<Item> createListOfItems(InputFileDTO inputFile) {
		String listSales = replace(inputFile.getField3());
		Stream<String> streamListItems = Stream.of(listSales.split(","));
		List<Item> listItem = new ArrayList<>();
		streamListItems.forEach(s -> listItem.add(new Item(s)));
		return listItem;
	}

	private String replace(String lineSplit) {
		String string = lineSplit.replace('[', ' ');
		string = string.replace(']', ' ');
		return string.trim();
	}

}
