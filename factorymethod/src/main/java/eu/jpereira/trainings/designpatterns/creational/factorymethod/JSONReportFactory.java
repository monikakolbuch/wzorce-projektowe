package eu.jpereira.trainings.designpatterns.creational.factorymethod; 
 
 
 public class JSONReportFactory implements ReportFactory { 
 
 
 	ReportData data; 
 	JSONReport jsonRaport; 
 
 
 	public JSONReportFactory(ReportData data) { 
 		this.data = data; 
 		createReport(); 
 	} 
 
 
 
 
 	@Override 
 	public Report createReport() { 
 		jsonRaport = new JSONReport(); 
 		jsonRaport.generateReport(data); 
 		return jsonRaport; 
 	} 
 
 
 }
