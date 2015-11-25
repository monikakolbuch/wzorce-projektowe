package eu.jpereira.trainings.designpatterns.creational.factorymethod; 
 
 
 public class XMLReportFactory implements ReportFactory { 
 
 
 	ReportData data; 
 	XMLReport xmlRaport; 
 	public XMLReportFactory(ReportData data) { 
 		this.data = data; 
 		createReport(); 
 	} 
 
 
 	@Override 
 	public Report createReport() { 
 		xmlRaport = new XMLReport(); 
 		xmlRaport.generateReport(data); 
 		return xmlRaport; 
 	} 
 
 
 }
