package project.summarycreator.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Sale {

	private int id;
	
	private List<Item> listItem = new ArrayList<>();
	
	private String salesmanName;
	
	public int getId() {
		return id;
	}

	public List<Item> getListItem() {
		return listItem;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public Sale(String[] lineSplit) {
		this.id = Integer.parseInt(lineSplit[1]);
		String listSales = replace(lineSplit[2]);
		Stream<String> streamListItems = Stream.of(listSales.split(","));
		streamListItems.forEach(s->listItem.add(new Item(s)));
		this.salesmanName = lineSplit[3];
	}

	private String replace(String lineSplit) {
		String string = lineSplit.replace('[', ' ');
		string = string.replace(']', ' ');
		return string.trim();
	}

}
