package project.summarycreator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigBindy {

	@Value("${input.dir:input}")
	private String inputDir;

	@Value("${output.dir:output}")
	private String outputDir;
	
	public String getInputDir() {
		return inputDir;
	}

	public String getOutputDir() {
		return outputDir;
	}
}
