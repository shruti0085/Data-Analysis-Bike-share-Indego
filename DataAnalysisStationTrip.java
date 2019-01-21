import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
/**
 * DataAnalysisStationTrip analyzes data of station and trip objects
 * @author Dell1
 *
 */
public class DataAnalysisStationTrip {
	ArrayList<Station> stationData;
	ArrayList<Trip> tripData;
	ArrayList<NewReportData> reportData;
	
/**
 * Creates a constructor of DataAnalysisStationTrip which initializes
 *  an ArrayList of NewReportData	
 * @param stationData: ArrayList of station objects
 * @param tripData: ArrayList of trip objects
 */
		
	public DataAnalysisStationTrip(ArrayList<Station> stationData, ArrayList<Trip> tripData){
			this.stationData = stationData;
			this.tripData = tripData;
			reportData = new ArrayList<>();
		
		}
/**
 * Method to calculate number of trips from a station	
 * @return countStat: number of trips from the station
 * @param statName: station name
 */	
	
	public int getTripsFromStation(String statName){
		int statId = 0;
		int countStat = 0;
		for(Station su: stationData) {
			String sName = su.getStationName();
			if(sName.equals(statName)){
				statId = su.getStationId();
				for(Trip t: tripData) {
		    	int tripStationId = t.getStartStat();
		    	   if(tripStationId == statId) {
		    		countStat++;
			}
		}
		}
		}
		return countStat;
	}
/**
 * Method to get the most popular station	
 * @return popStatName: name of most popular station
 */
	public String getPopularStartStation() {
		int popStat = stationData.get(0).getStationId();
		String popStatName = stationData.get(0).getStationName();
		int maxTrip = 0;
		int maxCount=0;
		
		for(Station sv: stationData) {
			int tripCount = 0;
			int currStat = sv.getStationId();
			String currStatName = sv.getStationName();
		    for(Trip tq: tripData) {
			   int nStat = tq.getStartStat();
			   if(currStat == nStat) {
				   tripCount++;
			   }
		}
		    if(tripCount>maxCount) {
		    	maxCount = tripCount;
		    	popStat = currStat;
		    	popStatName =  currStatName;
		    }
		    
		}
		return popStatName;
	}
		
/**
 * Method to get month with the most no of given passHolderType	
 * @param passType: pass holder type
 * @return popularMonth:month with maximum instances of given passHolder
 */

	public Month getMostPassTypeMonth(String passType) {
		ArrayList<Integer> passTypeList =  new ArrayList<Integer>();
		for(Trip t : tripData) {
			if(t.getPassHolderType().equals(passType)) {
			   Calendar calS = t.getCalStart();
			   int month = calS.get(Calendar.MONTH);
			   passTypeList.add(month);
			   
			}
			}
		
		
		int count = 0;
		int maxCount = 1;
		int popularMonth = passTypeList.get(0);
		int prevMonth = passTypeList.get(0);
		for(int i = 1; i<passTypeList.size();i++) {
			if(prevMonth == (passTypeList.get(i))) {
					count++;	
				}
			else {
				if(count > maxCount) {
					popularMonth = passTypeList.get(i-1);
					maxCount = count;
				}
				count = 0;
				prevMonth = passTypeList.get(i);
			}
			
			}
		Month popularMonthName = Month.of(popularMonth);
		return popularMonthName;
		}
/**
 * Method to get average Duration of bike rental	
 * @return  averageDur:average duration
 */
	
	public double averageDuration() {
		double averageDur = 0;
		double totalDur = 0;			
		for(Trip ta: tripData) {
			int dur = ta.getDuration();
			totalDur = totalDur + dur;
			
		}
	    averageDur = totalDur/(tripData.size());
	   return averageDur;
	}
/**
 * Method to get number of trips between start and end hour	
 * @return countTrip:number of trips in the slot
 * @param start: start hour
 * @param end: end hour
 */

	public int getTripsbetweenSlot(int start, int end) {
		int countTrip = 0;
		for(Trip te:tripData) {
			Calendar timeStart = te.getCalStart();
			Calendar timeEnd = te.getCalEnd();
			int startHour = timeStart.get(Calendar.HOUR_OF_DAY);
			int endHour = timeEnd.get(Calendar.HOUR_OF_DAY);
			int startDay = timeStart.get(Calendar.DAY_OF_MONTH);
			int endDay = timeEnd.get(Calendar.DAY_OF_MONTH);
			int startMonth = timeStart.get(Calendar.MONTH)+1;
			int endMonth = timeEnd.get(Calendar.MONTH)+1;

			if (startHour >= start && endHour < end && startDay == endDay && startMonth == endMonth) {
				countTrip ++;
				
			}
		}
		return countTrip;
	}
 /**
  * Creates the station report to be printed
  * @return ArrayList of NewReportData
  */
	public ArrayList<NewReportData> getStationReport() {
	ArrayList<NewReportData> rd =  new ArrayList<>();
	NewReportData ns;
	
	for(Station sn: stationData) {
		int statId = sn.getStationId();
		String statName = sn.getStationName();
		int countTrips = 0;
		int countEndTrips = 0;
		double totalDur= 0;
		int maxDur =0; 
		int no1Trips = 0;
		double avgDur = 0;
		for(Trip t: tripData) {
			int tripStationId = t.getStartStat();
			int tripEndStationId = t.getEndStat();
			if(tripStationId == statId) {
				countTrips++;	
				int dur = t.getDuration();
				if(dur>maxDur) {
					maxDur = dur;
					
				}
				totalDur = totalDur + dur;
				if(t.getTripRoute().equals("One Way")){
					no1Trips++;
				}
			}
			if(tripEndStationId == statId) {
				countEndTrips++;
			}
		}
		if(countTrips == 0) {
			avgDur = 0;}
			else {
				avgDur = totalDur/countTrips;
				
			}
		
		ns = new NewReportData(statId, statName, countTrips, avgDur,
				maxDur, no1Trips,countTrips-countEndTrips);
	
		rd.add(ns);
	}

	return rd;
	
	
}
/**
 * Method to get the least popular end station,by looking at station and trip data
 * @return leastStat: station ID of station with least no of trips
 */
	public String getLeastPopularEndStation() {
		int leastStat = stationData.get(0).getStationId();
		String leastStatName = stationData.get(0).getStationName();
		int leastTrip = 1000;
		
		for(Station sv: stationData) {
			int leastCount = 0;
			int currStat = sv.getStationId();
			String currStatName = sv.getStationName();
		    for(Trip tq: tripData) {
			   int lStat = tq.getEndStat();
			   if(currStat == lStat) {
				   leastCount++;
			   }
		}
		    if(leastCount<leastTrip) {
		        leastTrip = leastCount;
		    	leastStat = currStat;
		    	leastStatName =  currStatName;
		    }
		    
		}
		return leastStatName;
	}
/**
 * Method to check and compute which two stations are close to each other	
 * @return countPairs: no of station close to each other
 */
	public int getNumPairsOfCloseStations(double lessVal) {
		int countPairs = 0;
		ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
		for(Trip ty: tripData) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<Integer> c = new ArrayList<Integer>();
			double startLat = ty.getStartLat();
			double startLong = ty.getStartLong();
			double endLat = ty.getEndLat();
			double endLong = ty.getEndLong();
			double diffLat = Math.abs(startLat - endLat);
			double diffLong = Math.abs(startLong - endLong);
			double avgDiff = (diffLat + diffLong)/2;
			a.add(ty.getStartStat());
			a.add(ty.getEndStat());
			c.add(ty.getEndStat());
			c.add(ty.getStartStat());
			if(avgDiff < lessVal) {
				if(!(b.contains(a)|| b.contains(c))) {
				countPairs++;
				b.add(a);
			}
			
		}
		}
		return countPairs;
	}
/**
 * Method to get the least popular end station among all end stations from trip data only
 * @return leastEndStatName: name of least popular end station
 */
public String getLeastEndPopularStation() {
	int leastEndStat = stationData.get(0).getStationId();
	String leastEndStatName = stationData.get(0).getStationName();
	int leastEndTrip = 1000;
	int leastVal = 10;
	ArrayList<Integer> statList = new ArrayList<Integer>();
	HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	for(Trip tq: tripData) {
		int lStat = tq.getEndStat();
		if(hmap.containsKey(lStat)) {
			int value = hmap.get(lStat);
			hmap.put(lStat, value+1);
		}
		else {
			hmap.put(lStat, 1);
		
	}
	}
	for(Integer k: hmap.keySet()) {
		int val = hmap.get(k);
		if(val<leastVal) {
	        leastVal = val;
	    	leastEndStat = k;
	    	
	    }
	    
	}
	for(Station sy: stationData) {
		if(leastEndStat == sy.getStationId()) {
			leastEndStatName = sy.getStationName();
		}
	}
	return leastEndStatName;
	
}
/**
 * Method to get trips with duration less than specified time
 * @param time: duration time
 * @return countDur: number of trips with duration less than given time
 */
public int getNumTripsWithDurLess(int time) {
	int countDur =0;
	for(Trip th: tripData) {
		int tempDur = th.getDuration();
		if(tempDur<=time) {
			countDur++;
		}
	}
	return countDur;
}
}
