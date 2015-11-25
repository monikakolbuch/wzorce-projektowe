package eu.jpereira.trainings.designpatterns.creational.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.jpereira.trainings.designpatterns.creational.singleton.crwaling.CannotCrawlException;
import eu.jpereira.trainings.designpatterns.creational.singleton.crwaling.DummySiteCrawler;
import eu.jpereira.trainings.designpatterns.creational.singleton.crwaling.SiteCrawler;

/**
 * @author Joao Pereira
 * 
 */
public class ReportBuilder {

	// Instance variables
	private Map<String, StringBuffer> sitesContens;

	private SiteCrawler siteCrawler;

	// Class variables
	// Single instance
	private volatile static ReportBuilder INSTANCE;//
	private static List<String> configuredSites;

	// Class initializer block
	static {

		configuredSites = new ArrayList<String>();
		configuredSites.add("http://www.wikipedia.com");
		configuredSites.add("http://jpereira.eu");
	}

	private ReportBuilder() {// 
		initiatlize();
	}

	/**
	 * Very time consuming initialize method...
	 */
	private void initiatlize() {

		// defer it to an factory method
		this.siteCrawler = createSiteCrawler();

		// Now crawl some pre-defined sites
		for (String url : configuredSites) {
			this.siteCrawler.withURL(url);
		}
		try {
			this.setSitesContens(this.siteCrawler.crawl().packSiteContens());
		} catch (CannotCrawlException e) {
			// this singleton instance is in very bad shape... what wiil you do?
			// I cannot recover from this and this instance will be useless to
			// clients...
			throw new RuntimeException("Could not load sites:" + e.getMessage());
		}

	}

	/**
	 * Factory method with default implementation
	 * 
	 * @return
	 */
	protected SiteCrawler createSiteCrawler() {

		return new DummySiteCrawler();
	}

	/**
	 * Get a single instance of type ReportBuilder
	 * 
	 * @return A single instance
	 */
	public static ReportBuilder getInstance() {//
    //public static synchronized ReportBuilder getInstance() {//	
 		System.out.println("Getting instance for Thread " + Thread.currentThread().getId());
 		
 		/*if (INSTANCE == null) {
			INSTANCE = new ReportBuilder();
		}
 		
		return	INSTANCE;
		*/

 		if (INSTANCE == null) {
			synchronized (ReportBuilder.class) {
				if (INSTANCE == null) {
					INSTANCE = new ReportBuilder();
				}
			}
 		}

 		return INSTANCE;
 	}

	/**
	 * 
	 * @return the sitesContens
	 * 
	 */
	public Map<String, StringBuffer> getSitesContens() {

		return sitesContens;
	}

	/**
	 * @param sitesContens
	 *            the sitesContens to set
	 */
	private void setSitesContens(Map<String, StringBuffer> sitesContens) {
		this.sitesContens = sitesContens;
	}

	/**
	 * 
	 */
	public static void resetInstance() {
		INSTANCE = null;

	}

}