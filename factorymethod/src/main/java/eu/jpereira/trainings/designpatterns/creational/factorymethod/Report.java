package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public interface Report {

	/**
	 * Create the report
	 */
	void generateReport(ReportData data);

	/**
	 * Get the content generated fo9r this report
	 * 
	 * @return
	 */
	String getReportContent();

}