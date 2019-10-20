package myTicketManagementSystem;
/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TicketTest {

	TrainService standardServiceZones1;
	TrainService sleeperServiceZones7;
	TicketType concessionTicketType;
	TicketType fullFareTicketType;
	
	@BeforeClass         //Run before all the test begin(1)
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass			 //Run after all the test(4)
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Before				//Run before every test(2)
	public void setUp() throws Exception {
		standardServiceZones1 = new StandardService("Central", "Paramatta", "10:00");
		sleeperServiceZones7 = new SleeperService("ByronBay", "Central", "20:00");
		concessionTicketType = new TicketType(TicketType.CONCESSION);
		fullFareTicketType = new TicketType(TicketType.FULLFARE);
	}

	@After				//Run after every test(3)
	public void tearDown() throws Exception {
	
	}

	@Test
	public final void testGetService() {
		/*
		 * double h=standardServiceZones1.getTicketPrice(); System.out.println(h);
		 */
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetTicketPriceFirstClassConcessionZone1() {  // TODO create more thorough test cases
		Ticket t = new FirstClassTicket(standardServiceZones1, concessionTicketType);
		// first class ticket has 25% surcharge added
		// 1 zone of travel is charged at default min ticket price
		// concession fare is 10% discount
		// standard service min ticketprice is 25.0
		// expect this ticket to be (25.0 * 1) * 1.25 * 0.9
		double resultExpected = 25.0 *1 * 1.25 * 0.9;
		//System.out.println("result expected " + resultExpected);
		//System.out.println("actual ticket price issued " + t.getTicketPrice());
		assertEquals("Checking first class concession standard ticket 1 zone ", resultExpected, t.getTicketPrice(), 0.01);
	}

	@Test
	public final void testIssueConcessionTicket() {
		//"Checking if the faretype is correct"
		assertEquals(concessionTicketType.fareType,0);
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testIssueFullPriceTicket() {
		assertEquals(fullFareTicketType.fareType,1);
		fail("Not yet implemented"); // TODO
	}

}
