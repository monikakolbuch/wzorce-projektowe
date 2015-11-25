package eu.jpereira.trainings.designpatterns.creational.factorymethod; 
 
 
 import static org.junit.Assert.assertEquals; 
 
 
 import org.junit.Test; 
 public class ReportGeneratorTest extends AbstractReportingTest{ 
 
 
 	AbstractReport raport = null; 
 	 
 	@Test 
 	public void testCreateJSONReport() { 
 		ReportData reportData = createDummyReportData(); 
 		ReportGenerator generator = new ReportGenerator(); 
 		JSONReportFactory jsonraport = new JSONReportFactory(reportData); 
 		Report generatedReport = generator.generateReport(reportData, jsonraport); 
 		assertEquals("JSON Report. Name: " + reportData.getName(), generatedReport.getReportContent()); 
 	} 
 	 
 	 
 	@Test 
 	public void testCreateXMLReport() { 
 		ReportData reportData = createDummyReportData(); 
 		ReportGenerator generator = new ReportGenerator(); 
 		XMLReportFactory xmlraport = new XMLReportFactory(reportData); 
 		Report generatedReport = generator.generateReport(reportData, xmlraport); 
 		assertEquals("XML Report. Name: "+reportData.getName(), generatedReport.getReportContent()); 
 	} 
 	 
 	@Test 
 	public void testCreateHTMLReport() { 
 		ReportData reportData = createDummyReportData(); 
 		ReportGenerator generator = new ReportGenerator(); 
 		HTMLReportFactory htmlraport = new HTMLReportFactory(reportData); 
 		Report generatedReport = generator.generateReport(reportData, htmlraport); 
 		assertEquals("HTML Report. Name: "+reportData.getName(), generatedReport.getReportContent()); 
 	} 
 	 
 	@Test 
 	public void testCreatePDFReport() { 
 		ReportData reportData = createDummyReportData(); 
 		ReportGenerator generator = new ReportGenerator(); 
 		PDFReportFactory pdfraport = new PDFReportFactory(reportData); 
 		Report generatedReport = generator.generateReport(reportData, pdfraport); 
 		assertEquals("PDF Report. Name: "+reportData.getName(), generatedReport.getReportContent()); 
 	} 
 	 
 
 
 	 
 	 
 }