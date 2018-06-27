package project.summarycreator.dto;

public class Item {
	
	private int id;
	
	private int quantity;
	
	private double price;

	public Item(String line) {
		String[] lineSplit = line.split("-");
		this.id = Integer.parseInt(lineSplit[0]);
		this.quantity = Integer.parseInt(lineSplit[1]);
		this.price= Double.parseDouble(lineSplit[2]);
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

}
