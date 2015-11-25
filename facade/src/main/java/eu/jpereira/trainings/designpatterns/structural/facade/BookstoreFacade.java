package eu.jpereira.trainings.designpatterns.structural.facade; 

 
 import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService; 
 import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService; 
 import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService; 
 import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService; 
 import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService; 
 
 
 /** 
  * @author windows 
  * 
  */ 
 public interface BookstoreFacade { 
 
 
 	/** 
 	 * @param customerId 
 	 * @param isbn 
 	 */ 
 	void placeOrder(String customerId, String isbn); 
 
 
 	void setCustomerService(CustomerDBService customerService); 
 
 
 	void setBookService(BookDBService bookService); 
 
 
 	void setBookService(OrderingService orderingService); 
 
 
 	void setWarehouseService(WharehouseService warehouseService); 
 	 
 	void setNotificationService(CustomerNotificationService customerNotificationService); 
 
 
 
 
 
 
 
 
 }