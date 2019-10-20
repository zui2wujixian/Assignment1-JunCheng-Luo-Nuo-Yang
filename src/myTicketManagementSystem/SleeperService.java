package myTicketManagementSystem;
/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */

/**
 * Sleeper services are priced differently to the standard Train Service. 
 * The price is increased by a factor of 0.9 on the saved price
 * Also, the minimum price set for a Sleeper is higher than for standard train service
 */

public class SleeperService extends TrainService {

	
	public SleeperService(String departStation, String arriveStation, String departureTime) {  //departure Time is the time to go
		super(departStation, arriveStation, departureTime);
	}
	
	@Overload
	public SleeperService(int departStationNo, int arriveStationNo, int departTime) {
		super(TrainService.allStationNames[departStationNo-1].getName(), 
				TrainService.allStationNames[arriveStationNo-1].getName(), Integer.toString(departTime));//(Integer.toString(departTime))make the departTime's datatype from int to String  
	}


	

	
	@Override
	public 	double getTicketPrice() {
		
		double sleeperPrice=super.zonesTravelled*15+50;
		sleep="sleeper service";
		firstprice=sleeperPrice;
		return sleeperPrice;//OK update this so that it calls super.getTicketPrice and then adds a surcharge
	}
	
	
}
