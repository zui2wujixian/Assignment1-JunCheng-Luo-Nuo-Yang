/**
 * 
 */
package myTicketManagementSystem;

import java.util.Scanner;

/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public class RailManager {
	TrainService allServices[] = new TrainService[100]; // up to 100 services, change to ArrayList
	static Scanner input = new Scanner(System.in);
	
	
	public void setUpData() {
		// set up some dummy data - need to change or overload to read from a file
		allServices[0] = new StandardService("Central", "Lithgow", "10:00");
		allServices[1] = new StandardService("Central", "Bathurst", "10:00");
		allServices[2] = new StandardService("Bathurst", "Lithgow", "12:00");
		allServices[3] = new SleeperService("Central", "CoffsHarbour", "22:00");
		allServices[4] = new SleeperService("Central", "ByronBay", "22:00");
	}
	
	public void getData() {
		for(int i=0;i<5;i++) {
		System.out.println(allServices[i].toString());
		}
	}
	
	public String getAllStationNames() {
		String result = "";
		//NOT YET print a list of all stations for information
		for (Station s : TrainService.allStationNames) {    //for(Station s="";)
					result = result + s.name + " ";
		}
		return result;
		
		
	}
	
	public void sellTickets() {
		int departSt, arriveSt, hourDepart;
		String reply;
		TicketType fareType;
		Ticket newTicket;
		
		
		
		System.out.println("Please Enter Departure Station number : (1-5)");
		departSt = input.nextInt();
		System.out.println("Please Enter Destination Station number : (1-5)");
		arriveSt = input.nextInt();
		System.out.println("Please Enter Departure Hour (00-24): ");
		hourDepart = input.nextInt();
		System.out.println("Is this a concession Ticket?(Y/N) ");
		reply = input.next();
		reply = reply.toUpperCase(); //toUpperCase()use to make the "y" to "Y"
		if (reply.startsWith("Y")) //startswith() used to judge if the string is beginning with "Y"
			{fareType = new TicketType(TicketType.CONCESSION);
			System.out.println("Your ticket type is "+"Concession");}
		else
			{fareType = new TicketType(TicketType.FULLFARE);
			System.out.println("Your ticket type is "+"Full Fare");}
		// update this next line so that it displays name of stations, not station numbers
		//System.out.println("Ticket requested from " + departSt + " to " + arriveSt + " at " + hourDepart);
		//System.out.println("Ticket requested from " + newTicket.getService().allStationNames[departSt+1].getName() + " to " +newTicket.getService().allStationNames[arriveSt+1].getName()  + " at " + hourDepart);
		System.out.println("Ticket requested from " + allServices[departSt-1].allStationNames[departSt-1].getName() + " to " +allServices[arriveSt-1].allStationNames[arriveSt-1].getName()  + " at " + hourDepart+":00");
		
		
		newTicket = createTicket(departSt,arriveSt,fareType, hourDepart);
		/*
		 * if(fareType.fareType==1) {
		 * newTicket.ticketPrice=newTicket.issueFullPriceTicket(); } else {
		 * newTicket.ticketPrice=newTicket.issueConcessionTicket(); }
		 */
		newTicket.print();
	}


	private Ticket createTicket(int departSt, int arriveSt, TicketType fareType, int departureTime) {
		// first work out service details for this trip
		TrainService aService;
		Ticket t = null ;
		double price;
		
		
		System.out.println("Enter 1 for standard service, 2 for sleeper service : ");
		int ans = input.nextInt();
		if (ans==1) {
			aService = new StandardService(departSt, arriveSt, departureTime);
			
		}
		else {
			aService = new SleeperService(departSt, arriveSt, departureTime);
		}
			
		/*
		 * price=aService.getTicketPrice(); t.setTicketPrice(price);
		 */
		
		// work out fare for this service
		System.out.println("Enter 1 for Economy seat, 2 for First Class seat : ");
		ans = input.nextInt();
		if (ans==1) {
			t = new EconomyClassTicket(aService, fareType);
			
		}
		else {
			t = new FirstClassTicket(aService, fareType);
		}
		
		price=t.getTicketPrice();
		System.out.println("The price is:"+"гд"+price);
		return t;
	}

	@Overload
	public Ticket createTicket(int departSt, int arriveSt, TicketType fareType, int departureTime, boolean sleeper, boolean firstClass) {
		TrainService aService;
		Ticket t;
		double price;
		
		if (sleeper)
			aService = new SleeperService(departSt, arriveSt, departureTime);
		else
			aService = new StandardService(departSt, arriveSt, departureTime); //use  getTicketPrice()
		
		if (firstClass)
			t = new FirstClassTicket(aService, fareType);
		else
			t = new EconomyClassTicket(aService, fareType);
		price=t.getTicketPrice();
		System.out.println("The price is:"+"гд"+price);
		return t;
	}


}
