package project.reportcreator.creator;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import project.reportcreator.dto.ReportDTO;
import project.reportcreator.model.Item;
import project.reportcreator.model.ListaDeAbacaxi;
import project.reportcreator.model.Sale;

public class ReportCreator {
	
	Item mostExpensiveSaleItem;
	Sale mostExpensiveSale;
	
	Map<String, Double> worstSalesmanMap = new HashMap<>();
	
	public ReportDTO creator(ListaDeAbacaxi abacaxi) {
		Stream<Sale> streamSale = abacaxi.getListSale().stream();
		streamSale.forEach(sale-> {
			getGreaterSale(sale);
			getMinorSale(sale);
		});
		
		Entry<String, Double> min = Collections.min(worstSalesmanMap.entrySet(),Comparator.comparing(Entry::getValue));
		
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setMostExpensiveSaleId(mostExpensiveSale.getId());
		reportDTO.setWorstSalesmanName(min.getKey());
		reportDTO.setClientQuantity(abacaxi.getListClient().size());
		reportDTO.setSalesmanQuantity(abacaxi.getListSalesman().size());
		
		return reportDTO;
	}

	private void getGreaterSale(Sale sale) {
		Item maxSale = getGreaterTotalPrice(sale);
		if(isGreater(maxSale)) {
			mostExpensiveSaleItem = maxSale;
			mostExpensiveSale = sale;
		}
	}

	private void getMinorSale(Sale sale) {
		double totalPriceSale = sale.getListItem().stream().mapToDouble(Item::getTotalPrice).sum();
		Double totalMap = worstSalesmanMap.putIfAbsent(sale.getSalesmanName(), totalPriceSale);
		if(totalMap == null) {
			return;
		}
		worstSalesmanMap.put(sale.getSalesmanName(), totalMap + totalPriceSale);
	}

	private Item getGreaterTotalPrice(Sale sale) {
		return sale.getListItem().stream().max(Comparator.comparing(Item::getTotalPrice)).get();
	}

	private boolean isGreater(Item maxSale) {
		return mostExpensiveSaleItem == null || maxSale.getTotalPrice() > mostExpensiveSaleItem.getTotalPrice();
	}
	
}
