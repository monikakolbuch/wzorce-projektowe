package eu.jpereira.trainings.designpatterns.creational.factorymethod; 
 
 
 public class HTMLReportFactory implements ReportFactory { 
 
 
 	ReportData data; 
 	HTMLReport htmlraport = null; 
 
 
 	public HTMLReportFactory(ReportData data) { 
 		this.data = data; 
 		createReport(); 
 	} 
 
 
 	@Override 
 	public Report createReport() { 
 		htmlraport = new HTMLReport(); 
 		htmlraport.generateReport(data); 
 		return htmlraport; 
 	} 
 
 
 }