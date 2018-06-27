package project.reportcreator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.reportcreator.parser.TypeLine;

public class MapDomainFromReport {
	
	private Map<TypeLine, List<Domain>> mapDomain = new HashMap<>();
	
	public void add(TypeLine typeLine ,Domain domain) {
		if(!mapDomain.containsKey(typeLine)) {
			mapDomain.put(typeLine, new ArrayList<>());
		}
		
		List<Domain> list = mapDomain.get(typeLine);
		list.add(domain);
		mapDomain.put(typeLine, list);
	}
	
	public List<Sale> getSales() {
		List<Domain> domains = getDomain(TypeLine.SALE);
		List<Sale> sales = new ArrayList<>();
		domains.stream().forEach(s->sales.add((Sale) s));
		return sales;
	}
	
	public List<Salesman> getSalesman() {
		List<Domain> domains = getDomain(TypeLine.SALESMAN);
		List<Salesman> salesman = new ArrayList<>();
		domains.stream().forEach(s->salesman.add((Salesman) s));
		return salesman;
	}

	public List<Client> getClient() {
		List<Domain> domains = getDomain(TypeLine.CLIENT);
		List<Client> clients = new ArrayList<>();
		domains.stream().forEach(s->clients.add((Client) s));
		return clients;
	}

	private List<Domain> getDomain(TypeLine typeLine) {
		return mapDomain.get(typeLine);
	}
	
}
