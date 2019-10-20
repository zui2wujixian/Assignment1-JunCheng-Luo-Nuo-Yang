/**
 * 
 */
package myTicketManagementSystem;

/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public abstract class Ticket {

	private double ticketPrice;   // price for ticket
 	private TrainService service;  // service booked for ticket issued
 	private TicketType ticketType; //Ensure the ticketType  
	
 	public Ticket(TrainService _service, TicketType _ticketType) {  //When you want to instantiation the abstract class Ticket.You can instantiation the subclass 
 		this.setTicketType(_ticketType);							//which extend from Ticket.
 		this.setService(_service);
 		this.ticketPrice=_service.getTicketPrice();
 	}
 	
 	
 	
 	
 	private void setTicketType(TicketType _ticketType) {
		this.ticketType = _ticketType;
	}

	private void setService(TrainService _service) {
		this.service = _service;
	}

	public TrainService getService() {
		return this.service;
	}
	
	public TicketType getTicketType() {
		return this.ticketType;
	}

	/*
	 * public void setTicketPrice(double price) { ticketPrice=price; }
	 */
	public void setTicketPrice(double price) 
	{ ticketPrice=price; 
	}
	
	public abstract double getTicketPrice();  // get ticket price, override this in sub classes
 	
 	public double issueConcessionTicket() {  //OK concession ticket is 10% discount on full price ticket
 		ticketPrice=service.getTicketPrice();
 		ticketPrice=ticketPrice*0.9;
 		// get full price ticket fare
 		// apply concession discount
 		return ticketPrice;
 	}
 	
 	public double issueFullPriceTicket() {
 		
 		ticketPrice=service.getTicketPrice();
 		
 			// if travel multiple zones, increase ticket price.
 			// for each zone travelled multiply by ticket price for zone 
 		return ticketPrice; // update this 
 	}
 	
 	public void print() {
 		System.out.println(this.toString()); // should print correct type of ticket - economy or first class
 	}
 	
 	public abstract String toString(); // override this in sub classes to generate specific types of tickets
}
