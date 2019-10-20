package myTicketManagementSystem;
/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public class StandardService extends TrainService {

	
	public StandardService(String departStation, String arriveStation, String departureTime) {
		super(departStation, arriveStation, departureTime);
	}
	
	@Overload
	public StandardService(int departStationNo, int arriveStationNo, int departTime) {
		super(TrainService.allStationNames[departStationNo-1].getName(), 
				TrainService.allStationNames[arriveStationNo-1].getName(), Integer.toString(departTime));//(Integer.toString(departTime))make the departTime's datatype from int to String  
	}

	@Override
	public 	double getTicketPrice() {
		
		double standardCost=super.zonesTravelled*15;
		
		sleep="standard service";
		firstprice=standardCost;
		return standardCost;//OK update this so that it calls super.getTicketPrice and then adds a surcharge
	}
}
