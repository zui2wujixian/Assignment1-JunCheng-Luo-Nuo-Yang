/**
 * 
 */
package myTicketManagementSystem;

/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public class EconomyClassTicket extends Ticket {
	double ticketPrice;
	/**
	 * 
	 */
	public EconomyClassTicket(TrainService _service, TicketType _ticketType) {
		super(_service, _ticketType);
		super.setTicketPrice(_service.getTicketPrice());
		ticketPrice=_service.getTicketPrice();
		}
	/*
	 * public void changePrice() { ticketPrice=_s }
	 */
	
		@Override
		public double getTicketPrice() {
			//NOTYET  TODO set standard ticket price for economy based on fare for this service (sleeper or standard service)
			// also need to update so that the correct ticket type (full fare or concession fare) is produced
			
			if(super.getTicketType().fareType==0) {
				//ticketPrice=super.issueConcessionTicket();
				//NOTYET
				ticketPrice=ticketPrice*0.9;
			}
			
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
			return "This ticket's type is "+type+"\nCarriage is "+"Economy"+"\nService is "+super.getService().sleep;
		}
	

}
