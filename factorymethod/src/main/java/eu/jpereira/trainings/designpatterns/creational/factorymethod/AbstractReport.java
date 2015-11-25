package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public abstract class AbstractReport implements Report {

	private String reportContent;

	@Override
	public String getReportContent() {
		return reportContent;
	}

	protected void setReportContent(String content) {
		this.reportContent = content;
	}

}