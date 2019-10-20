package myTicketManagementSystem;
/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public class MainDriver {

	public static void main(String[] args) {
		RailManager m = new RailManager();
		m.setUpData(); // load in data of all services available
		m.getData();
		m.sellTickets(); // text based testing method
		
	}

}
