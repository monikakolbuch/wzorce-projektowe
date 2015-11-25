package eu.jpereira.trainings.designpatterns.creational.factorymethod; 
 
 
 public class PDFReportFactory implements ReportFactory { 
 
 
 	ReportData data; 
 	PDFReport pdfRaport; 
 	public PDFReportFactory(ReportData data) { 
 		this.data = data; 
 		createReport(); 
 	} 
 
 
 
 
 	@Override 
 	public Report createReport() { 
 		pdfRaport = new PDFReport(); 
 		pdfRaport.generateReport(data); 
 		return pdfRaport; 
 	} 
 
 
 	 
 
 
 }
