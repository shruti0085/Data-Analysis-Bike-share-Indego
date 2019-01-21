import java.util.ArrayList;
import java.util.Calendar;
/**
 * DataAnalysisStation analyzes station data 
 * @author shruti
 *
 */
public class DataAnalysisStation {
ArrayList<Station> stationData;


/**
 * Creates a constructor of DataAnalysisStation	
 * @param stationData: ArrayList of station objects
 */
	DataAnalysisStation(ArrayList<Station> stationData){
		this.stationData = stationData;
		
	}
	
/**
 * Method to get number of active or inactive station in Q2 of 2018
 * @param status: status of station
 * @return activeStat: number of station active/inactive in Q2
 */
	public int numOfActiveOrInactiveStations(String status) {
		int activeStat = 0;
		boolean checkStatus;

		if(status.equals("Active")) {
			 checkStatus = true;
		}
		else {
		     checkStatus = false;
		}
		for(Station st :stationData) {
			boolean statusStation = st.isStatus();
			if(statusStation == checkStatus) {
				activeStat++;	
					}
				}	
		return activeStat;
	}
	
	/**
	 * Method to get number of still active/inactive stations with go live date in year specified by argument	
	 * @param year: year of go live date
	 * @param status: status of station
	 * @return activeYear: no of  still active/inactive stations with go live date in given year
	 */
	public int getActiveInYear(int year, String status) {
		int activeYear = 0;
		boolean checkStatus;
		for(Station sa: stationData) {
			Calendar liveDate = sa.getCalLive();
			int liveYear = liveDate.get(Calendar.YEAR);
			if(status.equals("Active")) {
				 checkStatus = true;
			}
			else {
			     checkStatus = false;
			}
			boolean statStatus = sa.isStatus();
			if(liveYear == year && checkStatus == statStatus) {
				activeYear++;

			}
		}
		return activeYear;
		
	}
	
	
}
