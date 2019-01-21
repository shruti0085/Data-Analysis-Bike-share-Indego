import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
/**
 * Checker tests  and implements all our classes and methods associated with them 
 * to analyze and print Indego station and trip data
 * @author Dell1
 *
 */
public class Checker {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
	
       // create different objects
		StationReader sr = new StationReader("indego-stations-2018-8-3.csv");
		TripReader tnr = new TripReader("indego-trips-2018-q2.csv");
		DataAnalysisStationTrip statTrip = new DataAnalysisStationTrip(sr.readStationFile(), tnr.readTripFile());
		DataAnalysisStation st = new DataAnalysisStation(sr.readStationFile());
        
		// tests methods
		
		//1. How many Active stations were there in the second quarter of 2018? 
		System.out.println("The no of active stations inQ2 2018:"+ st.numOfActiveOrInactiveStations("Active"));
		
		//2. How many stations that had a Go-Live Date in 2017 are still Active? 
	    System.out.println("The no stations that are still active:"+ st.getActiveInYear(2017, "Active"));
	    
	    //3. How many trips originated at Amtrak 30th Street Station?
	    System.out.println("The no of trips from amtrak:" + statTrip.getTripsFromStation("Amtrak 30th Street Station"));
		
	    //4. What was the most popular month for walk ups?
	    System.out.println("The most popular months for walkup:"+ statTrip.getMostPassTypeMonth("Walk-up"));
	    
	    //5. What is the average duration of a bike rental?
	    System.out.println("The average duration of rental:" + statTrip.averageDuration());
	    
	    //6. How many trips started and completed between 10am and 1pm? 
	    System.out.println("The no of trips between 10 and 1pm:" + statTrip.getTripsbetweenSlot(10,13)) ;

	    //7.Wildcard: Which is the most popular start station?
	    System.out.println("The most popular station is:" + statTrip.getPopularStartStation());
    
	    
	    //Report Printing to file
        BikeReportPrinter brp = new BikeReportPrinter(statTrip);
	    brp.createBikeReport("BikeStationReport.txt");
	    
	    
        //EXTRA CREDIT
	    
	   //1.Find all number of pairs of stations close to each other
		System.out.println("No of stations close to each other are:" + statTrip.getNumPairsOfCloseStations(0.02));
	  
		//2.What is the least popular end station?Considering stations from station data
	   	System.out.println("The least popular endStation:" + statTrip.getLeastPopularEndStation());
	   	
		//2.What is the least popular end station? Considering stations from only trip data
		System.out.println("The least popular endStation2:" + statTrip.getLeastEndPopularStation());
		
		//3.Wildcard: How many trips have duration less that 10 min?
	    System.out.println("No. of trips with duration less that 10 min:" + statTrip.getNumTripsWithDurLess(10));
	}
}
