package eu.jpereira.trainings.designpatterns.creational.factorymethod;

/**
 * The Report Generator will create reports based on a given type
 * @author jpereira
 *
 */
public class ReportGenerator {

	ReportFactory generatedReport = null;
	
	/**
	 * Generate a new report.
	 * @param data The report data
	 * @param type the type of report
	 * @return the generated report, or null of type is unknown
	 */
	public Report generateReport(ReportData data, ReportFactory report) { 
		 


 		return report.createReport(); 
 	} 
}