/**
 * 
 * @author shruti
 * NewReportData represents station data to be printed out
 */
public class NewReportData {
	private int statId;
	private String statName;
	private int totalTrips;
	private double avgDur;
	private double maxDur;
	private int oneWayTrips;
	private int diffStartEnd;
	
	/**
	 * Creates a constructor of NewReportData
	 * @param statId: station ID
	 * @param statName: station name
	 * @param totalTrips: total trips originated from that station
	 * @param avgDur : average duration of trips taken from that station
	 * @param maxDur : maximum duration of trip taken from that station
	 * @param oneWayTrips: number of one way trips taken from that station
	 * @param diffStartEnd: difference between no of trips that started and
	 *  that ended at the station
	 */
	
	public NewReportData(int statId, String statName, int totalTrips, 
			double avgDur, double maxDur, int oneWayTrips, int diffStartEnd){
		this.statId = statId;
		this.statName = statName;
		this.totalTrips = totalTrips;
		this.avgDur = avgDur;
		this.maxDur = maxDur;
		this.oneWayTrips = oneWayTrips;
		this.diffStartEnd = diffStartEnd;
	}
/**
 * Method to get station Id
 * @return statId :station id
 */
	public int getStatId() {
		return statId;
	}
/**
 * Method to set station Id
 * @param statId: station id
 */
	public void setStatId(int statId) {
		this.statId = statId;
	}
/**
 * Method to get name of the station
 * @return station name
 */
	public String getStatName() {
		return statName;
	}
/**
 * Method to set station name
 * @param statName: station name
 */
	public void setStatName(String statName) {
		this.statName = statName;
	}
/**
 * Method to get total trips from the station
 * @return totalTrips: total trips
 */
	public int getTotalTrips() {
		return totalTrips;
	}
/**
 * Method to set total trips from the station
 * @param totalTrips: total trips
 */
	public void setTotalTrips(int totalTrips) {
		this.totalTrips = totalTrips;
	}
/**
 * Method to get average duration of trips
 * @return avgDur: average duration
 */
	public double getAvgDur() {
		return avgDur;
	}
/**
 * Method to set average duration of trips
 * @param avgDur: average duration
 */
	public void setAvgDur(double avgDur) {
		this.avgDur = avgDur;
	}
/**
 * Method to get maximum duration of trips
 * @return maxDur: max duration
 */
	public double getMaxDur() {
		return maxDur;
	}
/**
 * Method to set maximum duration of trips
 * @param maxDur: maximum duration
 */
	public void setMaxDur(double maxDur) {
		this.maxDur = maxDur;
	}
/**
 * Method to get total no of one way trips
 * @return oneWayTrips: total one way trips
 */
	public int getOneWayTrips() {
		return oneWayTrips;
	}
/**
 * Method to set number of one way trips
 * @param oneWayTrips
 */
	public void setOneWayTrips(int oneWayTrips) {
		this.oneWayTrips = oneWayTrips;
	}
/**
 * Method to get difference between no. of trips that started from and ended
 * at the station
 * @return diffStartEnd: difference between the start and end trips
 */
	public int getDiffStartEnd() {
		return diffStartEnd;
	}
/**
 * Method to set difference between no. of start and end trips
 * @param diffStartEnd
 */
	public void setDiffStartEnd(int diffStartEnd) {
		this.diffStartEnd = diffStartEnd;
	}

}
