/**
 * 
 */
package myTicketManagementSystem;

/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public class FirstClassTicket extends Ticket {
	double ticketPrice;
	/**
	 * 
	 */
	public FirstClassTicket(TrainService _service, TicketType _ticketType) {
		super(_service, _ticketType);
		super.setTicketPrice(_service.getTicketPrice());
		ticketPrice=_service.getTicketPrice();
	}

	@Override
	public double getTicketPrice() {
		//TODO get ticketprice based on the service (sleeper or standard)
	
		if(super.getTicketType().fareType==0) {
			//ticketPrice=super.issueConcessionTicket();
			//NOTYET
			ticketPrice=ticketPrice*0.9;
		}
		ticketPrice=ticketPrice*1.25;
		// update this to make ticketprice more expensive for first class ticket - add surcharge 25% extra 
		// also need to update so that the correct ticket type (full fare or concession fare) is produced
		return ticketPrice;
	}

	@Overload
	public double getTicketPrice(double price) {
		double ticketPrice = 0; //TODO get ticketprice based on the service (sleeper or standard)
	
		if(super.getTicketType().fareType==0) {
			ticketPrice=super.issueConcessionTicket();
			//NOTYET
		}
		ticketPrice=ticketPrice*1.25;
		// update this to make ticketprice more expensive for first class ticket - add surcharge 25% extra 
		// also need to update so that the correct ticket type (full fare or concession fare) is produced
		return ticketPrice;
	}

	
	@Override
	public String toString() {
		String type;
		if(super.getTicketType().fareType==0) {
			type="Concession fare";
		}
		else
			type="Full fare";
		return "This ticket's type is "+type+"\nCarriage is "+"FirstClass"+"\nService is "+super.getService().sleep;
	}

}
