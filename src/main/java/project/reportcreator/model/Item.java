package project.reportcreator.model;

public class Item {
	
	private int id;
	
	private int quantity;
	
	private double price;

	private double totalPrice;

	public Item(String line) {
		String[] lineSplit = line.split("-");
		this.id = Integer.parseInt(lineSplit[0]);
		this.quantity = Integer.parseInt(lineSplit[1]);
		this.price = Double.parseDouble(lineSplit[2]);
		this.totalPrice = this.quantity * this.price;
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

	public double getTotalPrice() {
		return totalPrice;
	}

}
