package project.reportcreator.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import project.reportcreator.dto.ReportDTO;

public class WriterReport {

	public void writer(ReportDTO reportDTO) throws IOException {
		
		Path caminho = Paths.get(System.getProperty("user.home"), 
		        "data/out/teste.done.dat");
		
		Files.write(caminho, reportDTO.infosToWrite().getBytes());
	}
	
	
	public static void main(String[] args) throws IOException {
		WriterReport report = new WriterReport();
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setClientQuantity(2);
		reportDTO.setSalesmanQuantity(3);
		reportDTO.setMostExpensiveSaleId(1);
		reportDTO.setWorstSalesmanName("name");
		report.writer(reportDTO);
	}
}
