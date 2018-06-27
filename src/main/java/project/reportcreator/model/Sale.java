package project.reportcreator.model;

import java.util.ArrayList;
import java.util.List;

public class Sale implements Domain {

	private int id;
	
	private List<Item> listItem = new ArrayList<>();
	
	private String salesmanName;

	public Sale(int id, List<Item> listItem, String salesmanName) {
		this.id = id;
		this.listItem = listItem;
		this.salesmanName = salesmanName;
	}

	public int getId() {
		return id;
	}

	public List<Item> getListItem() {
		return listItem;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

}
