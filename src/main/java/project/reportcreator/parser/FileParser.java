package project.reportcreator.parser;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import project.reportcreator.dto.InputFileDTO;
import project.reportcreator.model.Domain;
import project.reportcreator.model.MapDomainFromReport;

@Component
public class FileParser {

	MapDomainFromReport mapFromReport = new MapDomainFromReport();
		
	public void flowDecision(Exchange exchange) {
		InputFileDTO inputFileDTO = (InputFileDTO) exchange.getIn().getBody();
		TypeLine typeLine = TypeLine.getTypeLine(inputFileDTO.getField1());
		Parse parse = typeLine.getType();
		Domain domain = parse.parser(inputFileDTO);
		mapFromReport.add(typeLine, domain);
		exchange.getOut().setBody(mapFromReport);
	}

}
