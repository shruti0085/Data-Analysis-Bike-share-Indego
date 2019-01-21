import java.util.Calendar;
/**
 * 
 * @author Shruti
 * Station class represents every station in the Indego station dataset.
 */
public class Station {
	private int stationId;
	private String stationName;
	private String liveDate;
	private boolean status;
	private Calendar calLive;
/**
 * Creates a constructor of station	
 * @param stationId: stationID
 * @param stationName : name of the station
 * @param liveDate : Go live Date of the station
 * @param calLive : representation of Date using Calendar class
 * @param status : status -Active/Inactive status of station
 */
	public Station(int stationId, String stationName, String liveDate, Calendar calLive, boolean status){
		this.stationId = stationId;
		this.stationName = stationName;
		this.liveDate = liveDate;
		this.status = status;
		this.calLive = calLive;
	}
	
	/**
	 * to String method to check stations
	 */

	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", stationName=" + stationName + ", liveDate=" + liveDate
				+ ", status=" + status + ", calLive=" + calLive + "]";
	}

  
/**
 * Method to get Calendar representation of Go live date
 * @return calLive: Go live date in Calendar representation
 */
	public Calendar getCalLive() {
		return calLive;
	}

/**
 * Method to set calendar representation for Go live date of station	
 * @param calLive:Go live date in Calendar representation
 */
	public void setCalLive(Calendar calLive) {
		this.calLive = calLive;
	}
/**
 * Method to get station Id
 * @return stationId
 */
	public int getStationId() {
		return stationId;
	}
/**
 * Method to set stationId
 * @param stationId
 */
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
/**
 * Method to get stationName
 * @return stationName
 */
	public String getStationName() {
		return stationName;
	}
/**
 * Method to set stationName
 * @param stationName
 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
/**
 * Method to get Go live Date
 * @return go Live Date
 */
	public String getLiveDate() {
		return liveDate;
	}
/**
 * Method to set Go live Date	
 * @param liveDate
 */

	public void setLiveDate(String liveDate) {
		this.liveDate = liveDate;
	}
/**
 * Method to get status of station	
 * @return status, true for active and false for inactive
 */

	public boolean isStatus() {
		return status;
	}
/**
 * Method to set status of station
 * @param status
 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}
