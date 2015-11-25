package eu.jpereira.trainings.designpatterns.creational.factorymethod;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Ignore;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.ReportData;

@Ignore
public abstract class AbstractReportingTest {

	
	private SecureRandom random = new SecureRandom();
	
	
	/**
	 * Create a dummy ReportData Object
	 * @return
	 */
	protected ReportData createDummyReportData() {
		ReportData dummyReportDate = new ReportData();
		dummyReportDate.setName("Dummy "+generateRandomString());
		return dummyReportDate;
	}
	
	/**
	 * Generate an random String
	 * @return
	 */
	private String generateRandomString() {
		return new BigInteger(132, random).toString(32);
	}
	
	

}