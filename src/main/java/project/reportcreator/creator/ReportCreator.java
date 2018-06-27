package project.reportcreator.creator;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.apache.camel.Exchange;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import project.reportcreator.dto.ReportDTO;
import project.reportcreator.model.Item;
import project.reportcreator.model.ListEntity;
import project.reportcreator.model.Sale;

@Component
public class ReportCreator {
	
	private static final Logger log = LogManager.getLogger(ReportCreator.class);

	Item mostExpensiveSaleItem;
	Sale mostExpensiveSale;
	Map<String, Double> worstSalesmanMap = new HashMap<>();
	
	public void creator(Exchange exchange) {
		ListEntity listEntity = (ListEntity) exchange.getIn().getBody();
		
		log.info("Creating report");
		Stream<Sale> streamSale = listEntity.getListSale().stream();
		streamSale.forEach(sale-> {
			getGreaterSale(sale);
			getWorstSalesman(sale);
		});
		
		Entry<String, Double> min = Collections.min(worstSalesmanMap.entrySet(),Comparator.comparing(Entry::getValue));
		
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setMostExpensiveSaleId(mostExpensiveSale.getId());
		reportDTO.setWorstSalesmanName(min.getKey());
		reportDTO.setClientQuantity(listEntity.getListClient().size());
		reportDTO.setSalesmanQuantity(listEntity.getListSalesman().size());
		log.info("Report created with infos: " + reportDTO.infosToWrite());
		
		exchange.getOut().setBody(reportDTO);
	}

	private void getGreaterSale(Sale sale) {
		log.info("Calculating most expensive sale. Id-sale [ " + sale.getId() + "]");
		Item maxSale = getGreaterTotalPrice(sale);
		if(isGreater(maxSale)) {
			log.info("most expensive sale so far Id-sale [ " + sale.getId() + "]");
			mostExpensiveSaleItem = maxSale;
			mostExpensiveSale = sale;
		}
	}

	private void getWorstSalesman(Sale sale) {
		log.info("Calculating worst salesman. Id-sale [ " + sale.getId() + "]");
		double totalPriceSale = sale.getListItem().stream().mapToDouble(Item::getTotalPrice).sum();
		Double totalMap = worstSalesmanMap.putIfAbsent(sale.getSalesmanName(), totalPriceSale);
		if(totalMap != null) {
			worstSalesmanMap.put(sale.getSalesmanName(), totalMap + totalPriceSale);
		}
	}

	private Item getGreaterTotalPrice(Sale sale) {
		return sale.getListItem().stream().max(Comparator.comparing(Item::getTotalPrice)).get();
	}

	private boolean isGreater(Item maxSale) {
		return mostExpensiveSaleItem == null || maxSale.getTotalPrice() > mostExpensiveSaleItem.getTotalPrice();
	}
	
}
