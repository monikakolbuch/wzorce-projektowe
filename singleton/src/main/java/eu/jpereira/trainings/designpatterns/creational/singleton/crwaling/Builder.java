package eu.jpereira.trainings.designpatterns.creational.singleton.crwaling;

import eu.jpereira.trainings.designpatterns.creational.singleton.ReportBuilder;

public enum Builder {
	INSTANCE;

	public Builder getInstance() {// 
		System.out.println("Getting instance for Thread " + Thread.currentThread().getId());
		if (INSTANCE == null) {
			synchronized (ReportBuilder.class) {
				if (INSTANCE == null) {
					System.out.println("Instance is null for Thread " + Thread.currentThread().getId());
					ReportBuilder.getInstance();
					System.out.println("Returing " + INSTANCE.hashCode() + " instance to Thread " + Thread.currentThread().getId());
				}
			}
		}
		return INSTANCE;
	}
}