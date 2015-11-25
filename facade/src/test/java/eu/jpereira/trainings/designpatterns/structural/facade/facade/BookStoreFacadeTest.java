package eu.jpereira.trainings.designpatterns.structural.facade.facade;

import static org.mockito.Mockito.*;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.facade.BookstoreFacade;
import eu.jpereira.trainings.designpatterns.structural.facade.DefaultBookstoreFacade;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;

/**
 * @author windows
 * 
 */
public class BookStoreFacadeTest extends AbstractClientTest {

	@Test
	public void testPlaceOrder() {
		// Dummy literals
		String isbn = "123";
		String customerId = "wall-e";
		Book dummyBook = new Book(isbn);
		Customer dummyCustomer = new Customer(customerId);
		Order dummyOrder = new Order();
		DispatchReceipt dummyDispatchReceipt = new DispatchReceipt();

		// prepate SUT
		BookstoreFacade facade = createFacade();

		// Prepare stubs
		when(bookService.findBookByISBN(isbn)).thenReturn(dummyBook);
		when(customerService.findCustomerById(customerId)).thenReturn(dummyCustomer);
		when(orderingService.createOrder(dummyCustomer, dummyBook)).thenReturn(dummyOrder);
		when(warehouseService.dispatch(dummyOrder)).thenReturn(dummyDispatchReceipt);

		// Exercise SUT
		facade.placeOrder(customerId, isbn);

		// Verify behavior
		verify(warehouseService).dispatch(dummyOrder);
		verify(customerNotificationService).notifyClient(dummyDispatchReceipt);

	}

	/**
	 * @return
	 */
	protected BookstoreFacade createFacade() {
		// TODO: Implement the interface bookstoreFacade and set the
		// dependencies. We're using mocks, so you'll have to set the mocks as
		// dependencies of the facade
		// Example:
		// impl.setCustomerService(customerService)
		// impl.setWarehouseService(wharehouseService)
		
		BookstoreFacade impl = new DefaultBookstoreFacade(); 
		 		impl.setNotificationService(customerNotificationService); 
		 		impl.setBookService(bookService); 
		 		impl.setCustomerService(customerService); 
		 		impl.setWarehouseService(warehouseService); 
		 		impl.setBookService(orderingService); 
		 		// ... 
		 		// Return an instance of your facade implementation 
		 		return impl; 

		
		//return null;
	}
}