package myTicketManagementSystem;
/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */

public abstract class TrainService {
	
	
	// static attributes to share with all TrainServices
	// constants
	static final double MINSERVICECOST = 15.00;   
	// list of stations stored in an array - should change to an ArrayList for more flexibility 
	// remove dummy Station data here and write a new method to setup all stations based on file input
	static Station[] allStationNames = {new Station(1, "Central",1), 
									new Station(2, "Paramatta",1),
									new Station(3, "Penrith", 2),
									new Station(4,"Lithgow",3),
									new Station(5, "Orange",4), 
									new Station(6, "Bathurst",4), 
									new Station(7, "Newcastle",3),
									new Station(8, "CoffsHarbour",4),
									new Station(9, "ByronBay", 4)};
				
	
	// attributes for all Train Services
	int zonesTravelled = 1;  // default assumption one zone travelled, should calculate this
	int departureStationNumber; // index value for station in allStationNames list£¨jing guo de zhan shu£©
	int arrivalStationNumber;
	String departureTime;
	String sleep;
	double firstprice;
	
	// constructor
	public TrainService(String departStation, String arriveStation, String departureTime) {
		this.setUpStationData("StationInputFile.txt"); // not yet implemented(shang wei shi shi)
		this.setDepartStation(departStation);
		this.setArriveStation(arriveStation);
		this.setDepartureTime(departureTime);
		this.setZonesTravelled();
	}
	
	private void setZonesTravelled() {
		//OK update this to calculate how many zones are travelled from Depart Station to Arrive Station
		if(arrivalStationNumber==departureStationNumber)
		{this.zonesTravelled=0; 
		}
		else {
		int zones=Math.abs(arrivalStationNumber-departureStationNumber)+1;  //absolute value(jue dui zhi)
		/* System.out.println("servicezones:"+zones); */
		this.zonesTravelled=zones; 
		}
		// todo update this
		
	}

	private void setDepartureTime(String _departureTime) {
		this.departureTime = _departureTime;
		
	}

	private void setArriveStation(String arriveStation) {
		//OK todo: search in the train station list for this station arriveStation and find it's index value
		for(int i=0;i<allStationNames.length;i++)
		{
			if(allStationNames[i].getName()==arriveStation) {
				this.arrivalStationNumber=allStationNames[i].getstationNo();
				
				break;
			}
		}
		
	}

	@Override
	public String toString() {
		return "TrainService [departureStationNumber=" + departureStationNumber
				+ ", arrivalStationNumber=" + arrivalStationNumber + ", departureTime=" + departureTime + "]";
	}

	private void setDepartStation(String departStation) {
		//OK todo: search in the train station list for this station arriveStation and find it's index value
		for(int i=0;i<allStationNames.length;i++)
		{
			if(allStationNames[i].getName()==departStation) {
				this.departureStationNumber=allStationNames[i].getstationNo();
				break;
			}
		}
		  // change this to be the index value of the correct station
				
	}
	

	// methods for Train Services
	public double getTicketPrice() {
		
		
		return firstprice;//NOT YET default price is minimum price
		// should change this so that the price is increased if more zones are travelled
	}

	public int getZonesTravelled() {
		// need to look at departure station and arrival station and see how many zones are travelled
		// then update zonesTravelled
		// need to have a mechanism for finding or storing number of zones travelled
		return zonesTravelled;
	}
	
	private void setUpStationData(String fname) {
		
		
		
		// TODO finish this method to load station details from file named fname
		// open scanner on file fname to read in Station details into an ArrayList allStations to replace the array allStationNames
		// loop to read in Station data - station name on one line, zone number on next line, until EOF
		
	}
	
	public void information() {
		System.out.println("Depart Station is");
		
	}
	
}
