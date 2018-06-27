package project.reportcreator.parser;

import org.apache.camel.Exchange;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import project.reportcreator.dto.InputFileDTO;
import project.reportcreator.model.Client;
import project.reportcreator.model.ListEntity;
import project.reportcreator.model.Sale;
import project.reportcreator.model.Salesman;

@Component
public class FileParser {
	
	private static final Logger log = LogManager.getLogger(FileParser.class);
	
	private ListEntity listEntity = new ListEntity();
	
	public void convert(Exchange exchange) {
		InputFileDTO inputFileDTO = (InputFileDTO) exchange.getIn().getBody();
		
		parser(inputFileDTO);
		
		exchange.getOut().setBody(listEntity);
	}
	
	protected ListEntity parser(InputFileDTO inputFileDTO) {
		if(inputFileDTO == null) {
			log.warn("No line to process");
			return listEntity;
		}
		log.info("Processing line" + inputFileDTO);
		flowDecision(inputFileDTO);
		
		return listEntity;
	}

	private void flowDecision(InputFileDTO inputFileDTO) {
		if("001".equals(inputFileDTO.getField1())) {
			log.info("Create a salesman");
			listEntity.addListSalesman(new Salesman(inputFileDTO));
		} else if("002".equals(inputFileDTO.getField1())) {
			log.info("Create a Client");
			listEntity.addListClient(new Client(inputFileDTO));
		} else if("003".equals(inputFileDTO.getField1())) {
			log.info("Create a Sale");
			listEntity.addListSale(new Sale(inputFileDTO));
		}
	}

}
