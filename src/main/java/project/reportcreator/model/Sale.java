package project.reportcreator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import project.reportcreator.dto.InputFileDTO;

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

	public Sale(InputFileDTO inputFileDTO) {
		this.id = Integer.parseInt(inputFileDTO.getField2());
		String listSales = replace(inputFileDTO.getField3());
		Stream<String> streamListItems = Stream.of(listSales.split(","));
		streamListItems.forEach(s->listItem.add(new Item(s)));
		this.salesmanName = inputFileDTO.getField4();
	}

	private String replace(String lineSplit) {
		String string = lineSplit.replace('[', ' ');
		string = string.replace(']', ' ');
		return string.trim();
	}

}
