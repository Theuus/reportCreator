package project.reportcreator.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAbacaxi {
	
	private List<Salesman> listSalesman = new ArrayList<>();
	
	private List<Client> listClient = new ArrayList<>();
	
	private List<Sale> listSale = new ArrayList<>();
	
	public List<Salesman> getListSalesman() {
		return listSalesman;
	}
	public void addListSalesman(Salesman salesman) {
		this.listSalesman.add(salesman);
	}
	public List<Client> getListClient() {
		return listClient;
	}
	public void addListClient(Client client) {
		this.listClient.add(client);
	}
	public List<Sale> getListSale() {
		return listSale;
	}
	public void addListSale(Sale sale) {
		this.listSale.add(sale);
	}
}
