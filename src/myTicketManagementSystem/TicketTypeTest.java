package myTicketManagementSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketTypeTest {

	@Test
	public final void testIssueConcessionTicket() {
		//"Checking if the faretype is correct"
		assertEquals(new TicketType(TicketType.CONCESSION).fareType,0);
		 // TODO
	}

	@Test
	public final void testIssueFullPriceTicket() {
		assertEquals(new TicketType(TicketType.FULLFARE).fareType,1);
		 // TODO
	}
}
