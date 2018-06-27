package project.reportcreator.creator;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.apache.camel.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import project.reportcreator.dto.InputFileDTO;
import project.reportcreator.dto.ReportDTO;
import project.reportcreator.model.Domain;
import project.reportcreator.model.Item;
import project.reportcreator.model.MapDomainFromReport;
import project.reportcreator.model.Sale;
import project.reportcreator.parser.Parse;
import project.reportcreator.parser.TypeLine;

@Component
public class ReportCreator {
	
	private static final Logger log = LogManager.getLogger(ReportCreator.class);

	private Item mostExpensiveSaleItem;
	private Sale mostExpensiveSale;
	private Map<String, Double> worstSalesmanMap;
	private MapDomainFromReport mapFromReport;
	
	public void creator(Exchange exchange) {
		worstSalesmanMap = new HashMap<>();
		mapFromReport = new MapDomainFromReport();
		
		List<InputFileDTO> inputFileDTO = (List<InputFileDTO>) exchange.getIn().getBody();
		inputFileDTO.forEach(line->createType(line));
		
		log.info("Creating report");
		Stream<Sale> streamSale = mapFromReport.getSales().stream();
		streamSale.forEach(sale-> {
			getGreaterSale(sale);
			getWorstSalesman(sale);
		});
		
		Entry<String, Double> worstSalesman = Collections.min(worstSalesmanMap.entrySet(),Comparator.comparing(Entry::getValue));
		
		int mostExpensiveSaleId = mostExpensiveSale.getId();
		String worstSalesmanName = worstSalesman.getKey();
		int clientQuantity = mapFromReport.getClient().size();
		int salesmanQuantity = mapFromReport.getSalesman().size();
		ReportDTO reportDTO = new ReportDTO(salesmanQuantity, clientQuantity, mostExpensiveSaleId, worstSalesmanName);
		
		log.info("Report created with infos: " + reportDTO.infosToWrite());
		
		exchange.getOut().setBody(reportDTO);
	}

	private void createType(InputFileDTO inputFileDTO) {
		TypeLine typeLine = TypeLine.getTypeLine(inputFileDTO.getField1());
		Parse parse = typeLine.getType();
		Domain domain = parse.parser(inputFileDTO);
		mapFromReport.add(typeLine, domain);
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
