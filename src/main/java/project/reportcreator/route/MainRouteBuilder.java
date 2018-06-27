package project.reportcreator.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.springframework.beans.factory.annotation.Autowired;

import project.reportcreator.config.ConfigBindy;
import project.reportcreator.creator.ReportCreator;
import project.reportcreator.dto.InputFileDTO;
import project.reportcreator.dto.ReportDTO;
import project.reportcreator.parser.FileParser;


public class MainRouteBuilder extends RouteBuilder {
	
	@Autowired
	FileParser fileParser;
	
	@Autowired
	ReportCreator reportCreator;
	
	@Autowired
	ConfigBindy configBindy;
	
	@Override
	public void configure() throws Exception {

		BindyFixedLengthDataFormat bindyFixedLengthDataFormat = new BindyFixedLengthDataFormat(ReportDTO.class);
		BindyCsvDataFormat bindyCsvDataFormat = new BindyCsvDataFormat(InputFileDTO.class);
		
		from(getInputFileUri())
			.setProperty("fileInProgress", simple("${file:onlyname.noext}"))
			.unmarshal(bindyCsvDataFormat)
			.split(body())
			.streaming()
				.log("LINE: ${body}")
				.bean(fileParser)
			.end()
			.bean(reportCreator)
			.marshal(bindyFixedLengthDataFormat)
			.to(getOutFileUri())
			.end();
	}
	

	private String getInputFileUri() {
		return "file://"+configBindy.getInputDir()+"?preMove=inprogress&move=.done";
	}

	private String getOutFileUri() {
		return "file://"+configBindy.getOutputDir()+"?fileName=${property.fileInProgress}-done.dat&fileExist=Append";
	}
}
